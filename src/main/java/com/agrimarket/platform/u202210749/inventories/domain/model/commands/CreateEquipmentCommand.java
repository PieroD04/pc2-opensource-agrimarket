package com.agrimarket.platform.u202210749.inventories.domain.model.commands;

/**
 * CreateEquipmentCommand
 * <p>
 *     Command to create an equipment with the given name, category, description and reference image URL.
 * </p>
 * @param name The name of the equipment.
 * @param categoryId The ID of the category to which the equipment belongs.
 * @param description The description of the equipment.
 * @param referenceImageUrl The URL of the reference image of the equipment.
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public record CreateEquipmentCommand(String name, Long categoryId, String description, String referenceImageUrl) {
}
