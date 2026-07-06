package com.example.design.singleton;

/**
 * Logger class implementing the Singleton Design Pattern.
 * Thread-safe implementation using double-checked locking.
 */
public class Logger {
    // Private static instance of the logger class
    private static volatile Logger instance;

    // Private constructor to prevent instantiation from other classes
    private Logger() {
        System.out.println("Logger Initialized.");
    }

    // Public static method to get the instance of the Logger class
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("[SYSTEM LOG]: " + message);
    }
}
