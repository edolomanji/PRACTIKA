package com.dolomanji.category.domain;

import com.dolomanji.menu.domain.MenuEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @Column(name = "identifier")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identifier;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    private Set<MenuEntity> menuEntitySet;
}
