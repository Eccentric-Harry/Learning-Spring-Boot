package com.harry.quickstart.config;

import com.harry.quickstart.services.BluePrinter;
import com.harry.quickstart.services.ColorPrinter;
import com.harry.quickstart.services.GreenPrinter;
import com.harry.quickstart.services.RedPrinter;
import com.harry.quickstart.services.impl.ColorPrinterImpl;
import com.harry.quickstart.services.impl.EnglishBluePrinter;
import com.harry.quickstart.services.impl.EnglishGreenPrinter;
import com.harry.quickstart.services.impl.EnglishRedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfig {

    @Bean
    public BluePrinter bluePrinter() {
        return new EnglishBluePrinter();
    }

    @Bean
    public GreenPrinter greenPrinter() {
        return new EnglishGreenPrinter();
    }

    @Bean
    public RedPrinter redPrinter(){
        return new EnglishRedPrinter();
    }
    @Bean
    public ColorPrinter colorPrinter(BluePrinter bluePrinter,RedPrinter redPrinter, GreenPrinter greenPrinter){
        return new ColorPrinterImpl(bluePrinter,redPrinter, greenPrinter);
    }
}
