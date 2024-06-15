package com.agrimarket.platform.u202210749.inventories.domain.model.entities;

import com.agrimarket.platform.u202210749.inventories.domain.model.aggregates.Equipment;
import com.agrimarket.platform.u202210749.inventories.domain.model.commands.CreateCategoryCommand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

/**
 * Category entity
 * <p>
 *     It represents a category of equipment.
 *     It groups equipment by a common characteristic.
 * </p>
 * @see Equipment
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
@Getter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Equipment> equipments;

    /**
     * Default constructor
     */
    public Category() {
        name = "";
    }

    /**
     * Constructor with command
     * @param command Command to create a category with the name of the category
     */
    public Category(CreateCategoryCommand command) {
        this.name = command.name();
    }


}
