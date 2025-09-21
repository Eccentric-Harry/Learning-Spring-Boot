package com.harry.Car.Impl;

import com.harry.Car.Break;
import org.springframework.stereotype.Component;

@Component
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
