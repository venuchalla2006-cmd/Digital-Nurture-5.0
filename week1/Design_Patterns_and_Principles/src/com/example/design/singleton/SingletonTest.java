package com.example.design.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Pattern ===");
        
        // Retrieve two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Perform some logging
        logger1.log("Transaction started.");
        logger2.log("Transaction completed successfully.");

        // Check if both instances are the same
        if (logger1 == logger2) {
            System.out.println("SUCCESS: logger1 and logger2 refer to the SAME instance. Singleton pattern verified.");
        } else {
            System.out.println("FAILURE: logger1 and logger2 refer to DIFFERENT instances. Singleton pattern violated.");
        }
    }
}
