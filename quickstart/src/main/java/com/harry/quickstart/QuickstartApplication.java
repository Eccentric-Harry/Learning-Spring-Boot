package com.harry.quickstart;

import com.harry.quickstart.services.ColorPrinter;
import com.harry.quickstart.services.impl.ColorPrinterImpl;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class QuickstartApplication implements CommandLineRunner {

    private ColorPrinter colorPrinter;
    public QuickstartApplication(ColorPrinter colorPrinter){
        this.colorPrinter = colorPrinter;
    }
	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}
    @Override
    public void run(String... args){
        log.info(colorPrinter.print());
    }
}
