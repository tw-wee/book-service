package com.wee.mapper;

import com.google.common.collect.Lists;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

public class BaseMapper {
    protected final MapperFactory mapperFactory;

    protected BaseMapper() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    protected void register(Class<?> typeA, Class<?> typeB) {
        mapperFactory.classMap(typeA, typeB).byDefault().register();
    }

    public <T> T map(Object source, Class<T> targetType) {
        return mapperFactory.getMapperFacade().map(source, targetType);
    }

    public <T> List<T> mapList(List<? extends Object> sources, Class<T> targetType) {
        return Lists.transform(sources, input -> map(input, targetType));
    }

}
