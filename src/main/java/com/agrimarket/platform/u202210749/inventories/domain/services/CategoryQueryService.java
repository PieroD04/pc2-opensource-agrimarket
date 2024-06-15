package com.agrimarket.platform.u202210749.inventories.domain.services;


import com.agrimarket.platform.u202210749.inventories.domain.model.entities.Category;
import com.agrimarket.platform.u202210749.inventories.domain.model.queries.GetAllCategoriesQuery;

import java.util.List;

/**
 * CategoryQueryService
 * <p>
 *     This interface defines the contract for the service that handles queries related to categories.
 *     It provides a method to handle the {@link GetAllCategoriesQuery} query.
 * </p>
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public interface CategoryQueryService {
    List<Category> handle(GetAllCategoriesQuery query);
}
