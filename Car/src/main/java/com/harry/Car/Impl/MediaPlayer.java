package com.harry.Car.Impl;

import com.harry.Car.Media;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MediaPlayer implements Media {
    @Override
    public void play() {
        System.out.println("Playing media");
    }

    @Override
    public void next() {
        System.out.println("Next media");
    }

    @Override
    public void pause() {
        System.out.println("Pausing media");
    }

    @Override
    public void previous() {
        System.out.println("Previous media");
    }
}
