package com.dolomanji.category.mapper;

import com.dolomanji.Category;
import com.dolomanji.category.domain.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryEntity mapTo(final Category category);

    Category mapFrom(final CategoryEntity categoryEntity);

}
