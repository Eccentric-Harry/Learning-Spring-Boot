package com.harry.Car;

import com.harry.Car.Impl.CarBreak;
import com.harry.Car.Impl.ElectricEngine;
import com.harry.Car.Impl.MediaPlayer;
import org.springframework.stereotype.Component;

@Component

public class FinalCar {
    private final Engine engine;
    private final Media media;
    private final Break carBreak;

    public FinalCar(){
        engine = new ElectricEngine();
        media = new MediaPlayer();
        carBreak = new CarBreak();
    }

    public FinalCar(Engine engine){
        this.engine = engine;
        media = new MediaPlayer();
        carBreak = new CarBreak();
    }
    public void start(){
        engine.start();
    }
    public void stop(){
        engine.stop();
    }
    public void playMedia(){
        media.play();
    }
    public void pauseMedia(){
        media.pause();
    }
    public void nextMedia() {
        media.next();
    }
    public void previousMedia() {
        media.previous();
    }
    public void applyBreak(){
        carBreak.apply();
    }
    public void releaseBreak(){
        carBreak.release();
    }
}
