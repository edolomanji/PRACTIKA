package com.dolomanji.common.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EntityNotFoundException extends CommonException {

    private final String entityName;

    private final String searchCriteria;

    private final String searchData;

    @Override
    public String getMessage() {
        return String.format("%s with %s : '%s' doesn't exist", entityName, searchCriteria, searchData);
    }

    @Override
    public String getField() {
        return searchCriteria;
    }
}
