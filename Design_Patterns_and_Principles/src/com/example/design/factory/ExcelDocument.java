package com.example.design.factory;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document... Parsing cells, formulas, and worksheets.");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel Document... Autosaving cell state.");
    }
}
