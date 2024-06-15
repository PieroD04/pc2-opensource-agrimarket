package com.agrimarket.platform.u202210749.inventories.rest;

import com.agrimarket.platform.u202210749.inventories.domain.model.queries.GetEquipmentByIdQuery;
import com.agrimarket.platform.u202210749.inventories.domain.services.EquipmentCommandService;
import com.agrimarket.platform.u202210749.inventories.domain.services.EquipmentQueryService;
import com.agrimarket.platform.u202210749.inventories.rest.resources.CreateEquipmentResource;
import com.agrimarket.platform.u202210749.inventories.rest.resources.EquipmentResource;
import com.agrimarket.platform.u202210749.inventories.rest.transform.CreateEquipmentCommandFromResourceAssembler;
import com.agrimarket.platform.u202210749.inventories.rest.transform.EquipmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Equipment Controller
 * <p>
 *     This class is responsible for handling the HTTP requests related to the Equipment entity.
 *     It provides endpoints for creating Equipment.
 *     It also provides a method for getting a specific Equipment by its ID.
 * </p>
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
@RestController
@RequestMapping(value="/api/v1/equipment", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Equipment", description = "Equipment Endpoints")
public class EquipmentsController {
    private final EquipmentCommandService equipmentCommandService;
    private final EquipmentQueryService equipmentQueryService;

    public EquipmentsController(EquipmentCommandService equipmentCommandService, EquipmentQueryService equipmentQueryService) {
        this.equipmentCommandService = equipmentCommandService;
        this.equipmentQueryService = equipmentQueryService;
    }

    /**
     * GetEquipment
     * <p>
     *     This method returns the Equipment with the given ID.
     *     If the Equipment is not found, it returns a 404 response.
     * </p>
     * @param equipmentId ID of the Equipment to get
     * @return ResponseEntity with the Equipment if found, or 404 if not found
     */
    public ResponseEntity<EquipmentResource> getEquipment(Long equipmentId)
    {
        var getEquipmentByIdQuery = new GetEquipmentByIdQuery(equipmentId);
        var equipment = equipmentQueryService.handle(getEquipmentByIdQuery);
        if (equipment.isEmpty()) return ResponseEntity.notFound().build();
        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return ResponseEntity.ok(equipmentResource);
    }

    /**
     * CreateEquipment
     * <p>
     *     This endpoint creates a new Equipment with the data in the request body.
     *     If the Equipment is created successfully, it returns a 201 response with the created Equipment.
     *     If the Equipment is not created, it returns a 400 response.
     * </p>
     * @param resource CreateEquipmentResource with the data to create the Equipment from the request body
     * @return ResponseEntity with the created Equipment if created, or 400 if not created
     */
    @Operation(summary="Create a new Equipment", description="Create a new Equipment with the input data in the request body and return the created Equipment.")
    @PostMapping
    public ResponseEntity<EquipmentResource> createEquipment(@RequestBody CreateEquipmentResource resource) {
        var createEquipmentCommand = CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var equipment = equipmentCommandService.handle(createEquipmentCommand);
        if(equipment.isEmpty()) return ResponseEntity.badRequest().build();
        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);
    }
}
