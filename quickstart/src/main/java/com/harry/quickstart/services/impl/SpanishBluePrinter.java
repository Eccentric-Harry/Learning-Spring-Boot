package com.harry.quickstart.services.impl;

import com.harry.quickstart.services.BluePrinter;

public class SpanishBluePrinter implements BluePrinter {
    @Override
    public String toString(){
        return "Azul";
    }

    @Override
    public String print() {
        return toString();
    }
}
