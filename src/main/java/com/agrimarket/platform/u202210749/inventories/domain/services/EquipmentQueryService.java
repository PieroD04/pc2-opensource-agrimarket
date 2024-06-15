package com.agrimarket.platform.u202210749.inventories.domain.services;


import com.agrimarket.platform.u202210749.inventories.domain.model.aggregates.Equipment;
import com.agrimarket.platform.u202210749.inventories.domain.model.queries.GetEquipmentByIdQuery;

import java.util.Optional;

/**
 * EquipmentQueryService
 * <p>
 *     This interface defines the contract for the EquipmentQueryService.
 *     It provides a method to handle the {@link GetEquipmentByIdQuery} query.
 * </p>
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public interface EquipmentQueryService {
    Optional<Equipment> handle(GetEquipmentByIdQuery query);
}
