package com.example.main.di.configuration;

import com.example.main.di.ObjectConfigurator;
import com.example.main.di.ObjectFactory;
import com.example.main.di.annotation.InjectRandomInt;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class InjectRandomIntObjectConfigurator implements ObjectConfigurator {
//    private final ObjectFactory factory;

    @Override
    public void configure(Object t) throws ReflectiveOperationException {
        Class<?> type = t.getClass();
        Set<Field> allFields = ReflectionUtils.getAllFields(type);
        for (Field field : allFields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if(annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int value = ThreadLocalRandom.current().nextInt();
                field.setAccessible(true);
                field.set(t, value);
            }
        }
    }
}
