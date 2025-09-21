package com.harry.Car.Impl;

import com.harry.Car.Break;

public class CarBreak implements Break {
    @Override
    public void apply() {
        System.out.println("Applying breaks");
    }

    @Override
    public void release() {
        System.out.println("Releasing breaks");
    }
}
