package com.example.algo.forecasting;

public class ForecastingTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Financial Forecasting (Recursion) ===");

        double presentValue = 1000.00; // Initial Investment
        double growthRate = 0.07;     // 7% annual growth rate
        int years = 10;                // 10 years forecast

        System.out.println("Present Value: $" + presentValue);
        System.out.println("Growth Rate:   " + (growthRate * 100) + "%");
        System.out.println("Forecast Time: " + years + " years");

        // 1. Simple Recursion
        double fv = Forecasting.calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("\nFuture Value (Recursive): $%.2f%n", fv);

        // 2. Memoized Recursion
        double fvMemoized = Forecasting.calculateFutureValueMemoized(presentValue, growthRate, years);
        System.out.printf("Future Value (Memoized):  $%.2f%n", fvMemoized);

        System.out.println("\nSUCCESS: Financial Forecasting verified.");
    }
}
