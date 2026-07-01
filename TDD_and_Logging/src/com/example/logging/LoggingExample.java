package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        System.out.println("=== Testing SLF4J and Logback Logging ===");
        
        logger.info("Application starting up...");
        logger.debug("Debugging configuration settings...");
        logger.warn("This is a WARNING log message.");
        logger.error("This is an ERROR log message.");
        
        System.out.println("Logs generated. Check console outputs and 'app.log' file.");
    }
}
