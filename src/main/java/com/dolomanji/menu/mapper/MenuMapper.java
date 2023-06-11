package com.dolomanji.menu.mapper;

import com.dolomanji.Menu;
import com.dolomanji.category.domain.CategoryEntity;
import com.dolomanji.menu.domain.MenuEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface MenuMapper {

    MenuEntity mapTo(final Menu menu);


    Menu mapFrom(final MenuEntity menuEntity);

    Set<CategoryEntity> map(final List<String> categories);

    Set<String> map(final Set<CategoryEntity> categories);

    String map(final CategoryEntity categoryEntity);

    CategoryEntity map(final String name);

}
