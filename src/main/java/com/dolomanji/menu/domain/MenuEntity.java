package com.dolomanji.menu.domain;

import com.dolomanji.category.domain.CategoryEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "menu")
public class MenuEntity {

    @Id
    @Column(name = "identifier")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identifier;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    private Set<CategoryEntity> categories;

}
