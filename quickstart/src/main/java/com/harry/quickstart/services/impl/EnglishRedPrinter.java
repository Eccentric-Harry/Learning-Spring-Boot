package com.harry.quickstart.services.impl;

import com.harry.quickstart.services.RedPrinter;

public class EnglishRedPrinter implements RedPrinter {
    @Override
    public String toString() {
        return "This is Red printer";
    }

    @Override
    public String print() {
        return toString();
    }
}
