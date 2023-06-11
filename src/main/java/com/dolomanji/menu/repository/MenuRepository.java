package com.dolomanji.menu.repository;

import com.dolomanji.menu.domain.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, UUID> {

    Optional<MenuEntity> findMenuEntityByName(final String name);

    boolean deleteByName(final String name);
}
