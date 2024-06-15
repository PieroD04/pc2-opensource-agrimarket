package com.agrimarket.platform.u202210749.inventories.rest.transform;

import com.agrimarket.platform.u202210749.inventories.domain.model.aggregates.Equipment;
import com.agrimarket.platform.u202210749.inventories.rest.resources.EquipmentResource;

public class EquipmentResourceFromEntityAssembler {
    public static EquipmentResource toResourceFromEntity(Equipment entity){
        return new EquipmentResource(
                entity.getId(),
                entity.name(),
                entity.getCategory().getId(),
                entity.description(),
                entity.referenceImageUrl()
        );
    }
}
