package com.example.design.factory;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document... Loading content layout and styles.");
    }

    @Override
    public void close() {
        System.out.println("Closing Word Document... Saving draft changes.");
    }
}
