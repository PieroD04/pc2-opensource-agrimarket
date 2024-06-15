package com.agrimarket.platform.u202210749.inventories.domain.model.valueobjects;

import jakarta.persistence.Column;

/**
 * Value Object EquipmentDescription
 * <p>
 *     This class represents the description of an equipment.
 *     Its represented as a TEXT column in the database because it can be longer than 255 characters.
 * </p>
 * @param description The description of the equipment. It cannot be null or empty and cannot be longer than 350 characters.
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public record EquipmentDescription(@Column(columnDefinition = "TEXT") String description) {
    /**
     * Constructor
     * @param description The description of the equipment. It cannot be null or empty and cannot be longer than 350 characters.
     */
    public EquipmentDescription {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("The description of the equipment cannot be null or empty");
        }

        if (description.length() > 350) {
            throw new IllegalArgumentException("The description of the equipment cannot be longer than 350 characters");
        }
    }

    /**
     * Default constructor
     */
    public EquipmentDescription(){
        this("");
    }
}
