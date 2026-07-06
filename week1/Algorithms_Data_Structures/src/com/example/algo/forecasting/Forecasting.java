package com.example.algo.forecasting;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculates future values recursively.
 */
public class Forecasting {

    /**
     * Recursive calculation of Future Value.
     * Formula: FV = PV * (1 + growthRate)^years
     * Time Complexity: O(N) where N is the number of years.
     * Space Complexity: O(N) due to recursion stack depth.
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case
        if (years == 0) {
            return presentValue;
        }
        // Recursive case
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Memoization table to cache computed growth factors for each year
    private static final Map<Integer, Double> growthFactorCache = new HashMap<>();

    /**
     * Optimized recursive calculation using memoization to prevent redundant calculations
     * if multiple scenarios check the same year projections.
     */
    public static double calculateFutureValueMemoized(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        
        if (growthFactorCache.containsKey(years)) {
            return presentValue * growthFactorCache.get(years);
        }

        // Compute growth factor recursively
        double previousFactor = calculateFutureValueMemoized(1.0, growthRate, years - 1);
        double currentFactor = previousFactor * (1 + growthRate);
        
        growthFactorCache.put(years, currentFactor);
        
        return presentValue * currentFactor;
    }
}
