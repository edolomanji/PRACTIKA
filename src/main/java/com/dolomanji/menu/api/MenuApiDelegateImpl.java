package com.dolomanji.menu.api;

import com.dolomanji.Menu;
import com.dolomanji.api.MenusApiDelegate;
import com.dolomanji.common.exception.EntityNotFoundException;
import com.dolomanji.menu.domain.MenuEntity;
import com.dolomanji.menu.mapper.MenuMapper;
import com.dolomanji.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuApiDelegateImpl implements MenusApiDelegate {
    private final MenuService service;

    private final MenuMapper mapper;

    @Override
    public Menu createMenuItem(final Menu menu) {
        log.info("Starting to save menu: {}", menu);

        final MenuEntity categoryEntity = service.save(mapper.mapTo(menu));

        log.info("Successfully saved category: {}", categoryEntity);

        menu.setIdentifier(categoryEntity.getIdentifier());

        return menu;
    }

    @Override
    public List<Menu> getMenuItems() {
        return service.findAll().stream().map(mapper::mapFrom).toList();
    }

    @Override
    public Menu getSpecificMenuItem(final UUID identifier) {
        return service.findByIdentifier(identifier).map(mapper::mapFrom).orElseThrow(() -> new EntityNotFoundException("menu", "identifier", identifier.toString()));
    }

    @Override
    public Object delete(UUID identifier) {
        final MenuEntity menu = service.findByIdentifier(identifier)
                .orElseThrow(() -> new EntityNotFoundException("menu", "identifier", identifier.toString()));

        return service.deleteByEntity(menu);
    }

}
