package com.agrimarket.platform.u202210749.inventories.domain.model.valueobjects;

/**
 * Value Object EquipmentImage
 * <p>
 *     This class represents the image of an equipment.
 *     It is used to store the reference URL of the image.
 *     The URL is required and cannot be null.
 * </p>
 * @param referenceImageUrl The URL of the reference image of the equipment
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public record EquipmentImage(String referenceImageUrl) {
    /**
     * Constructor
     * @param referenceImageUrl The URL of the reference image of the equipment
     */
    public EquipmentImage {
        if (referenceImageUrl == null) {
            throw new IllegalArgumentException("The reference image URL is required");
        }
    }

    /**
     * Default constructor
     */
    public EquipmentImage(){
        this("");
    }
}
