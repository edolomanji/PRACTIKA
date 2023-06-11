package com.dolomanji.category.service;

import com.dolomanji.category.domain.CategoryEntity;

import java.util.List;
import java.util.Optional;

/**
 * TODO: adjust javaDoc
 */
public interface CategoryService {

    /**
     *
     * @return
     */
    List<CategoryEntity> findAll();

    /**
     *
     * @param name
     * @return
     */
    Optional<CategoryEntity> findByName(final String name);

    /**
     *
     * @param categoryEntityCandidate
     * @return
     */
    CategoryEntity save(final CategoryEntity categoryEntityCandidate);

    boolean delete(CategoryEntity category);
}
