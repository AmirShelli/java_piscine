package com.example.main;

import java.util.stream.Stream;

public interface Lecture {
    Stream<Slide> getSlides();
}
