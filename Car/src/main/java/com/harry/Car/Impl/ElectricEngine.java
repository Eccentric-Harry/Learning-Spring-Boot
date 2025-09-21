package com.harry.Car.Impl;

import com.harry.Car.Engine;

public class ElectricEngine implements Engine {
    @Override
    public void type() {
        System.out.println("This is a generic engine.");
    }

    @Override
    public void start() {
        System.out.println("Electric engine started");
    }

    @Override
    public void stop() {
        System.out.println("Electric engine stopped");
    }
}
