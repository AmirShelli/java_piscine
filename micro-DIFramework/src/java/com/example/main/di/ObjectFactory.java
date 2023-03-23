package com.example.main.di;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {
    private final Reflections scanner = new Reflections("com.example.main");
    private final List<ObjectConfigurator> configurators = new ArrayList<>();

    public ObjectFactory () {
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for(Class<? extends ObjectConfigurator> clazz : classes) {
            try {
                Constructor<? extends ObjectConfigurator> constructor = clazz.getConstructor(ObjectConfigurator.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> T createObject(Class<? extends T> type) throws ReflectiveOperationException {
        type = resolveImpl(type);
        T t = type.newInstance();

        configure(t);

        return t;
    }

    private <T> void configure(T t) throws ReflectiveOperationException {
        for (ObjectConfigurator configurator : configurators)
            configurator.configure(t);
    }

    private <T> Class<? extends T> resolveImpl(Class<? extends T> type){
        if(type.isInterface()) {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf((Class<T>) type);
            if(classes.size() != 1)
                System.out.println("can't configure the class " + type);
            type = classes.iterator().next();
        }
        return type;
    }


}
