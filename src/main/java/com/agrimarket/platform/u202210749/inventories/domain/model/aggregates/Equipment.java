package com.agrimarket.platform.u202210749.inventories.domain.model.aggregates;


import com.agrimarket.platform.u202210749.inventories.domain.model.commands.CreateEquipmentCommand;
import com.agrimarket.platform.u202210749.inventories.domain.model.entities.Category;
import com.agrimarket.platform.u202210749.inventories.domain.model.valueobjects.EquipmentDescription;
import com.agrimarket.platform.u202210749.inventories.domain.model.valueobjects.EquipmentImage;
import com.agrimarket.platform.u202210749.inventories.domain.model.valueobjects.EquipmentName;
import com.agrimarket.platform.u202210749.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Equipment Aggregate
 * <p>
 *     It's an aggregate that represents equipment for the inventories bounded context.
 *     It has a name, a description, a reference image url and a category.
 *     It also has an id, a creation date and a last modification date from the AuditableAbstractAggregateRoot.
 *     It has a relation with the category ManyToOne.
 * </p>
 * @see Category
 * @see AuditableAbstractAggregateRoot
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
@Entity
@Getter
public class Equipment extends AuditableAbstractAggregateRoot<Equipment> {
    @ManyToOne
    @JoinColumn(nullable = false, name = "category_id")
    private Category category;

    @Embedded
    private EquipmentName name;
    @Embedded
    private EquipmentDescription description;
    @Embedded
    private EquipmentImage referenceImageUrl;

    /**
     * Default constructor
     */
    public Equipment() {}

    /**
     * Constructor with command and category
     * @param command Command that has the data to create equipment with primitive data types
     * @param category Category that the equipment belongs to
     */
    public Equipment(CreateEquipmentCommand command, Category category) {
        this.name = new EquipmentName(command.name());
        this.description = new EquipmentDescription(command.description());
        this.referenceImageUrl = new EquipmentImage(command.referenceImageUrl());
        this.category = category;
    }

    /**
     * Getter for name
     * @return String with the name of the equipment
     */
    public String name() {
        return name.name();
    }

    /**
     * Getter for description
     * @return String with the description of the equipment
     */
    public String description() {
        return description.description();
    }

    /**
     * Getter for referenceImageUrl
     * @return String with the reference image url of the equipment
     */
    public String referenceImageUrl() {
        return referenceImageUrl.referenceImageUrl();
    }

}
