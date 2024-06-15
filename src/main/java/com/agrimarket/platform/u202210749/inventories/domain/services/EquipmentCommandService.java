package com.agrimarket.platform.u202210749.inventories.domain.services;


import com.agrimarket.platform.u202210749.inventories.domain.model.aggregates.Equipment;
import com.agrimarket.platform.u202210749.inventories.domain.model.commands.CreateEquipmentCommand;

import java.util.Optional;

/**
 * EquipmentCommandService
 * <p>
 *     This interface provides the methods to handle the commands related to the Equipment entity.
 *     It provides a method to handle the {@link CreateEquipmentCommand} command.
 * </p>
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public interface EquipmentCommandService {
    Optional<Equipment> handle(CreateEquipmentCommand command);
}
