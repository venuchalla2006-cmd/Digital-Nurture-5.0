package com.example.design.factory;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document... Rendering fonts and vectors in read-only mode.");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Document... Releasing page buffers.");
    }
}
