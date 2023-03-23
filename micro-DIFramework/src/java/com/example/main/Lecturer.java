package com.example.main;

import com.example.main.di.annotation.InjectByType;
import com.example.main.di.annotation.InjectRandomInt;

import javax.annotation.PostConstruct;

public class Lecturer {
    @InjectByType
    private Lecture lecture;
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Slideshow slideshow;
    @InjectRandomInt(min = 1, max = 100)
    private int repeat;

    @PostConstruct
    public void init() {
        for(int i = 0; i < repeat; i++)
            speaker.speak("hello world!");
    }

    public void readLecture() {
        lecture.getSlides().forEach(
                slide -> {
                    slideshow.show(slide.getText());
                    speaker.speak(slide.getComment());
                }
        );
    }

}
