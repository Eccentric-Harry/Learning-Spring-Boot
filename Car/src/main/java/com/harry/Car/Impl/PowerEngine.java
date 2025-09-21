package com.harry.Car.Impl;

import com.harry.Car.Engine;
import org.springframework.beans.factory.annotation.Qualifier;


@Qualifier("powerEngine")
public class PowerEngine implements Engine {
    @Override
    public void type() {
        System.out.println("Power engine type");
    }

    @Override
    public void start() {
        System.out.println("Power engine start");
    }

    @Override
    public void stop() {
        System.out.println("Power engine stop");
    }
}
