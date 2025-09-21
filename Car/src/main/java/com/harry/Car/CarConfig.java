package com.harry.Car;

import com.harry.Car.Impl.ElectricEngine;
import com.harry.Car.Impl.PowerEngine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {
    @Bean
    public Engine electricEngine() {
        return new ElectricEngine();
    }
    @Bean
    public Engine powerEngine() {
        return new PowerEngine();
    }

    @Bean
    public FinalCar finalCar(@Qualifier("powerEngine") Engine engine) {
        return new FinalCar(engine);
    }
}
