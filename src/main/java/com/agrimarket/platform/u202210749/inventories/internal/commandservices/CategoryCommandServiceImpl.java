package com.agrimarket.platform.u202210749.inventories.internal.commandservices;

import com.agrimarket.platform.u202210749.inventories.domain.model.commands.CreateCategoryCommand;
import com.agrimarket.platform.u202210749.inventories.domain.model.entities.Category;
import com.agrimarket.platform.u202210749.inventories.domain.services.CategoryCommandService;
import com.agrimarket.platform.u202210749.inventories.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {
    private final CategoryRepository categoryRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> handle(CreateCategoryCommand command) {
        var category = new Category(command);
        try{
            categoryRepository.save(category);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while saving category: " + e.getMessage());
        }
        return Optional.of(category);
    }

}
