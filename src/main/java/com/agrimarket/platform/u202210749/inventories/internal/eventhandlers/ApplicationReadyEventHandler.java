package com.agrimarket.platform.u202210749.inventories.internal.eventhandlers;

import com.agrimarket.platform.u202210749.inventories.domain.model.commands.CreateCategoryCommand;
import com.agrimarket.platform.u202210749.inventories.domain.model.queries.GetAllCategoriesQuery;
import com.agrimarket.platform.u202210749.inventories.domain.services.CategoryCommandService;
import com.agrimarket.platform.u202210749.inventories.domain.services.CategoryQueryService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ApplicationReadyEventHandler
 * <p>
 *     This class listens for the {@link ApplicationReadyEvent} and creates the default categories in the system if they
 *     do not exist.
 *     The default categories are "Tractors", "Harvesters" and "Irrigation Systems".
 * </p>
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
@Service
public class ApplicationReadyEventHandler {
    private final CategoryQueryService categoryQueryService;
    private final CategoryCommandService categoryCommandService;

    public ApplicationReadyEventHandler(CategoryQueryService categoryQueryService, CategoryCommandService categoryCommandService) {
        this.categoryQueryService = categoryQueryService;
        this.categoryCommandService = categoryCommandService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void on() {
        var categories = categoryQueryService.handle(new GetAllCategoriesQuery());
        if (categories.isEmpty()) {
            categoryCommandService.handle(new CreateCategoryCommand("Tractors"));
            categoryCommandService.handle(new CreateCategoryCommand("Harvesters"));
            categoryCommandService.handle(new CreateCategoryCommand("Irrigation Systems"));
            System.out.println("Created categories in the system successfully.");
        }
        else {
            System.out.println("Categories already exist in the system. Skipping creation.");
        }
    }
}
