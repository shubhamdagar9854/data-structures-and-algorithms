package algorithms.sorting.selection_sort;

import algorithms.common.Cargo;
import java.util.ArrayList;

/**
 * Implementation of Selection Sort algorithm
 */
public class SelectionSort {
    /**
     * Sorts an ArrayList of Cargo objects using Selection Sort
     * Time Complexity: O(n^2)
     * 
     * @param items ArrayList of Cargo objects to be sorted
     * @return time taken in nanoseconds
     */
    public static long sort(ArrayList<Cargo> items) {
        long start = System.nanoTime();

        // Loop through each position in the array
        for (int curr = 0; curr < items.size(); curr++) {
            // Find minimum value in unsorted portion
            int minIndex = curr;
            for (int minCheck = curr; minCheck < items.size(); minCheck++) {
                if (items.get(minCheck).compareTo(items.get(minIndex)) < 0) {
                    minIndex = minCheck;
                }
            }

            // Swap minimum value with current position
            Cargo temp = items.get(minIndex);
            items.set(minIndex, items.get(curr));
            items.set(curr, temp);
        }

        long end = System.nanoTime();
        return end - start;
    }

    /**
     * Verify if the ArrayList is properly sorted
     * 
     * @param items ArrayList to check
     * @return true if sorted, false otherwise
     */
    public static boolean isSorted(ArrayList<Cargo> items) {
        for (int i = 1; i < items.size(); i++) {
            if (items.get(i - 1).compareTo(items.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }
}
