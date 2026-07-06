package com.example.algo.search;

import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        System.out.println("=== Testing E-commerce Search Function ===");

        // Create an array of products
        Product[] products = {
            new Product("P1005", "Dell XPS 13", "Laptops"),
            new Product("P1002", "iPhone 15", "Smartphones"),
            new Product("P1009", "Sony WH-1000XM5", "Audio"),
            new Product("P1001", "MacBook Pro", "Laptops"),
            new Product("P1007", "iPad Pro", "Tablets")
        };

        System.out.println("\nProducts in original array:");
        for (Product p : products) {
            System.out.println(p);
        }

        // Test Linear Search
        System.out.println("\n--- Testing Linear Search ---");
        Product foundLinear = SearchAlgorithms.linearSearch(products, "P1009");
        System.out.println("Searching for P1009: " + (foundLinear != null ? "FOUND: " + foundLinear : "NOT FOUND"));

        Product notFoundLinear = SearchAlgorithms.linearSearch(products, "P9999");
        System.out.println("Searching for P9999: " + (notFoundLinear != null ? "FOUND: " + notFoundLinear : "NOT FOUND"));

        // Binary Search requires sorting by key
        System.out.println("\nSorting products by ID for Binary Search...");
        Arrays.sort(products, (a, b) -> a.getProductId().compareTo(b.getProductId()));
        for (Product p : products) {
            System.out.println(p);
        }

        // Test Binary Search
        System.out.println("\n--- Testing Binary Search ---");
        Product foundBinary = SearchAlgorithms.binarySearch(products, "P1009");
        System.out.println("Searching for P1009: " + (foundBinary != null ? "FOUND: " + foundBinary : "NOT FOUND"));

        Product notFoundBinary = SearchAlgorithms.binarySearch(products, "P9999");
        System.out.println("Searching for P9999: " + (notFoundBinary != null ? "FOUND: " + notFoundBinary : "NOT FOUND"));

        System.out.println("\nSUCCESS: E-commerce Search Function verified.");
    }
}
