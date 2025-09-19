package com.harry.quickstart.services.impl;

import com.harry.quickstart.services.GreenPrinter;

public class SpanishGreenPrinter implements GreenPrinter {
    @Override
    public String print() {
        return toString();
    }

    @Override
    public String toString() {
        return "verde";
    }
}
