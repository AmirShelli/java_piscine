package com.example.main.di.configuration;


import com.example.main.di.ObjectConfigurator;
import com.example.main.di.ObjectFactory;
import com.example.main.di.annotation.InjectByType;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;

@RequiredArgsConstructor
public class InjectByTypeObjectConfigurator implements ObjectConfigurator {
    private final ObjectFactory factory;

    @Override
    public void configure(Object t) throws ReflectiveOperationException {
        Field[] fields = t.getClass().getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                field.set(t, factory.createObject(field.getType()));
            }
        }
    }
}
