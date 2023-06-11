package com.dolomanji.category.service;

import com.dolomanji.category.domain.CategoryEntity;
import com.dolomanji.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<CategoryEntity> findByName(final String name) {
        return repository.findCategoryEntityByName(name);
    }

    @Override
    public CategoryEntity save(final CategoryEntity categoryEntityCandidate) {
        return repository.save(categoryEntityCandidate);
    }

    @Override
    public boolean delete(final CategoryEntity category) {
        repository.delete(category);
        return true;
    }
}
