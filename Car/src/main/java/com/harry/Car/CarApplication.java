package com.harry.Car;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class CarApplication implements CommandLineRunner {

    private final FinalCar finalCar;
    public CarApplication(FinalCar finalCar) {
        this.finalCar = finalCar;
    }

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        finalCar.start();
        finalCar.stop();
        finalCar.playMedia();
    }
}
