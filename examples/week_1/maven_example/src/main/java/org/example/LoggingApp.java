package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingApp {

    // create logger instance
    private static final Logger logger = LoggerFactory.getLogger(LoggingApp.class);

    public static void main(String[] args) {
        logger.info("=== Application Started ===");
        logger.info("Logging to file with rolling");

        // Simulate some work
        processOrder("ORD0001");
        processOrder("ORD0002");



    }

    private static void processOrder(String orderId){
        logger.info("Processing order: {}", orderId);

        // Simulate some work
        try{
            Thread.sleep(100);
            logger.debug("Order {} processed successfully", orderId);
        }catch(InterruptedException e){
            logger.error("Failed to process order {}", orderId, e);
            Thread.currentThread().interrupt();
        }
    }

}
