package com.dolomanji.category.api;

import com.dolomanji.Category;
import com.dolomanji.api.CategoriesApiDelegate;
import com.dolomanji.category.domain.CategoryEntity;
import com.dolomanji.category.mapper.CategoryMapper;
import com.dolomanji.category.service.CategoryService;
import com.dolomanji.common.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CategoriesApiDelegateImpl implements CategoriesApiDelegate {

    private final CategoryService service;

    private final CategoryMapper mapper;

    @Override
    public Category createCategory(final Category category) {
        log.info("Starting to save category: {}", category);

        final CategoryEntity categoryEntity = service.save(mapper.mapTo(category));

        log.info("Successfully saved category: {}", categoryEntity);

        return category;
    }

    @Override
    public Object deleteCategory(final String name) {
        log.info("Starting to delete category: {}", name);

        final CategoryEntity categoryEntity = service.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("category", "name", name));

        return service.delete(categoryEntity);
    }

    @Override
    public List<Category> getCategories() {
        return service.findAll()
                .stream()
                .map(mapper::mapFrom)
                .toList();
    }

    @Override
    public Category getCategory(final String name) {
        return service.findByName(name)
                .map(mapper::mapFrom)
                .orElseThrow(() -> new EntityNotFoundException("category", "name", name));
    }
}
