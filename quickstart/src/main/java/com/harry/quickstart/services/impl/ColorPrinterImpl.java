package com.harry.quickstart.services.impl;

import com.harry.quickstart.services.BluePrinter;
import com.harry.quickstart.services.ColorPrinter;
import com.harry.quickstart.services.GreenPrinter;
import com.harry.quickstart.services.RedPrinter;

public class ColorPrinterImpl implements ColorPrinter {
    private final RedPrinter redPrinter;

    private final BluePrinter bluePrinter;

    private final GreenPrinter greenPrinter;

    public ColorPrinterImpl( BluePrinter bluePrinter, RedPrinter redPrinter, GreenPrinter greenPrinter) {
//        this.bluePrinter = new EnglishBluePrinter();
//        this.redPrinter = new EnglishRedPrinter();
//        this.greenPrinter = new EnglishGreenPrinter();
        this.redPrinter = redPrinter;
        this.bluePrinter = bluePrinter;
        this.greenPrinter = greenPrinter;
    }

    @Override
    public String print() {
        return String.join(", ", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
    }
}