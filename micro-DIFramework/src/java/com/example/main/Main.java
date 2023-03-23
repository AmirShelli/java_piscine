package com.example.main;

import com.example.main.di.ObjectFactory;

public class Main {
    public static void main(String[] args) {
        Lecturer lecturer = null;
        try {
            lecturer = new ObjectFactory().createObject(Lecturer.class);
            lecturer.readLecture();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
