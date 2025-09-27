package com.harry.LiftSimulator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiftSimulatorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiftSimulatorApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("LiftSimulatorApplication started");
    }
}
