package com.agrimarket.platform.u202210749.inventories.rest.transform;

import com.agrimarket.platform.u202210749.inventories.domain.model.commands.CreateEquipmentCommand;
import com.agrimarket.platform.u202210749.inventories.rest.resources.CreateEquipmentResource;

public class CreateEquipmentCommandFromResourceAssembler {
    public static CreateEquipmentCommand toCommandFromResource(CreateEquipmentResource resource){
        return new CreateEquipmentCommand(
                resource.name(),
                resource.categoryId(),
                resource.description(),
                resource.referenceImageUrl()
        );
    }
}
