package com.agrimarket.platform.u202210749.inventories.internal.commandservices;

import com.agrimarket.platform.u202210749.inventories.domain.exceptions.CategoryNotFoundException;
import com.agrimarket.platform.u202210749.inventories.domain.model.aggregates.Equipment;
import com.agrimarket.platform.u202210749.inventories.domain.model.commands.CreateEquipmentCommand;
import com.agrimarket.platform.u202210749.inventories.domain.services.EquipmentCommandService;
import com.agrimarket.platform.u202210749.inventories.repositories.CategoryRepository;
import com.agrimarket.platform.u202210749.inventories.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {
    private final EquipmentRepository equipmentRepository;
    private final CategoryRepository categoryRepository;
    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository, CategoryRepository categoryRepository){
        this.equipmentRepository = equipmentRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Optional<Equipment> handle(CreateEquipmentCommand command) {
        if(equipmentRepository.existsByName_Name(command.name())){
            throw new IllegalArgumentException("Equipment with name: " + command.name() + " already exists");
        }

        var category = categoryRepository.findById(command.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException(command.categoryId()));

        var equipment = new Equipment(command, category);

        try{
            equipmentRepository.save(equipment);
         } catch (Exception e){
            throw new IllegalArgumentException("Error while saving equipment: " + e.getMessage());
        }
        return Optional.of(equipment);
    }

}
