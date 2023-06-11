package com.dolomanji.menu.service;

import com.dolomanji.menu.domain.MenuEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 */
public interface MenuService {
    /**
     *
     * @param menu
     * @return
     */
    MenuEntity save(final MenuEntity menu);

    /**
     *
     * @return
     */
    List<MenuEntity> findAll();

    /**
     *
     * @param identifier
     * @return
     */
    Optional<MenuEntity> findByIdentifier(final UUID identifier);

    boolean deleteByEntity(MenuEntity menu);
}
