package com.agrimarket.platform.u202210749.inventories.internal.queryservices;


import com.agrimarket.platform.u202210749.inventories.domain.model.aggregates.Equipment;
import com.agrimarket.platform.u202210749.inventories.domain.model.queries.GetEquipmentByIdQuery;
import com.agrimarket.platform.u202210749.inventories.domain.services.EquipmentQueryService;
import com.agrimarket.platform.u202210749.inventories.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentQueryServiceImpl implements EquipmentQueryService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentQueryServiceImpl(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }
    @Override
    public Optional<Equipment> handle(GetEquipmentByIdQuery query){
        return equipmentRepository.findById(query.equipmentId());
    }

}
