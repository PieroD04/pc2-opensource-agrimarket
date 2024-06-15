package com.agrimarket.platform.u202210749.inventories.domain.exceptions;

/**
 * CategoryNotFoundException
 * <p>
 *     Exception thrown when a category is not found
 *     by the provided id
 * </p>
 * @author Piero Gonzalo Delgado
 * @version 1.0
 */
public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Long aLong) {
        super("Category with id " + aLong + " not found");
    }
}
