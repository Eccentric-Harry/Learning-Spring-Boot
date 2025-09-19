package com.harry.quickstart.services.impl;

import com.harry.quickstart.services.RedPrinter;

public class SpanishRedPrinter implements RedPrinter {
    @Override
    public String toString(){
        return "rojo";
    }

    @Override
    public String print(){
        return toString();
    }
}
