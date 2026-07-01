package com.example.algo.search;

public class SearchAlgorithms {

    /**
     * Linear Search implementation.
     * Time Complexity:
     * - Best Case: O(1) (target is at index 0)
     * - Average Case: O(N)
     * - Worst Case: O(N) (target is at the end or not present)
     */
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Binary Search implementation.
     * Assumes the array is sorted by productId.
     * Time Complexity:
     * - Best Case: O(1) (target is at the middle index on first iteration)
     * - Average Case: O(log N)
     * - Worst Case: O(log N)
     */
    public static Product binarySearch(Product[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
