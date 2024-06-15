package com.agrimarket.platform.u202210749.inventories.internal.queryservices;

import com.agrimarket.platform.u202210749.inventories.domain.model.entities.Category;
import com.agrimarket.platform.u202210749.inventories.domain.model.queries.GetAllCategoriesQuery;
import com.agrimarket.platform.u202210749.inventories.domain.services.CategoryQueryService;
import com.agrimarket.platform.u202210749.inventories.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryQueryServiceImpl implements CategoryQueryService {
    private final CategoryRepository categoryRepository;

    public CategoryQueryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> handle(GetAllCategoriesQuery query) {
        return categoryRepository.findAll();
    }
}
