package com.harry.quickstart.services.impl;

import com.harry.quickstart.services.BluePrinter;

public class EnglishBluePrinter implements BluePrinter {

    @Override
    public String toString() {
        String color = "Blue";
        return "This is " + color + " printer";
    }

    @Override
    public String print(){
        return toString();
    }
}
