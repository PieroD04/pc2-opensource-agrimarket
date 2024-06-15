package com.agrimarket.platform.u202210749.inventories.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value Object EquipmentName
 * <p>
 *     Represents the name of an equipment
 * </p>
 * @param name The name of the equipment
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
@Embeddable
public record EquipmentName(String name) {
    /**
     * Constructor
     * @param name The name of the equipment
     *             It cannot be null or empty and cannot be longer than 80 characters.
     */
    public EquipmentName {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name of the equipment cannot be null or empty");
        }

        if (name.length() > 80) {
            throw new IllegalArgumentException("The name of the equipment cannot be longer than 80 characters");
        }
    }

    /**
     * Default constructor
     */
    public EquipmentName(){
        this("");
    }
}
