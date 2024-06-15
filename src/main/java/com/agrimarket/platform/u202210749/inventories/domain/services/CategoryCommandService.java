package com.agrimarket.platform.u202210749.inventories.domain.services;

import com.agrimarket.platform.u202210749.inventories.domain.model.commands.CreateCategoryCommand;
import com.agrimarket.platform.u202210749.inventories.domain.model.entities.Category;

import java.util.Optional;

/**
 * CategoryCommandService
 * <p>
 *     This interface defines the contract for the service that handles commands related to categories.
 *     It provides a method to handle the {@link CreateCategoryCommand} command.
 * </p>
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public interface CategoryCommandService {
    Optional<Category> handle(CreateCategoryCommand command);
}
