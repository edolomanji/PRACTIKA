package com.dolomanji.menu.service;

import com.dolomanji.category.domain.CategoryEntity;
import com.dolomanji.category.service.CategoryService;
import com.dolomanji.common.exception.EntityNotFoundException;
import com.dolomanji.menu.domain.MenuEntity;
import com.dolomanji.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository repository;

    private final CategoryService categoryService;

    @Override
    public MenuEntity save(final MenuEntity menu) {
        if (nonNull(menu.getCategories())) {
            for (CategoryEntity category : menu.getCategories()) {
                if (categoryService.findByName(category.getName()).isEmpty()) {
                    throw new EntityNotFoundException("category", "name", category.getName());
                }
            }
        }

        return repository.save(menu);
    }

    @Override
    public List<MenuEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<MenuEntity> findByIdentifier(final UUID identifier) {
        return repository.findById(identifier);
    }

    @Override
    public boolean deleteByEntity(MenuEntity menu) {
        repository.delete(menu);
        return true;
    }
}
