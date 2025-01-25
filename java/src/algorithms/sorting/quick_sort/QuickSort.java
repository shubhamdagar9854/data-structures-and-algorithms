package algorithms.sorting.quick_sort;

import algorithms.common.Cargo;
import java.util.ArrayList;

/**
 * Implementation of Quick Sort algorithm
 */
public class QuickSort {
    /**
     * Sorts an ArrayList of Cargo objects using Quick Sort
     * Time Complexity: O(n log n) average case, O(n^2) worst case
     * 
     * @param items ArrayList of Cargo objects to be sorted
     * @return time taken in nanoseconds
     */
    public static long sort(ArrayList<Cargo> items) {
        long start = System.nanoTime();

        ArrayList<Cargo> sorted = quickSort(items);
        // Copy sorted items back to original list
        for (int i = 0; i < items.size(); i++) {
            items.set(i, sorted.get(i));
        }

        long end = System.nanoTime();
        return end - start;
    }

    /**
     * Recursive quick sort implementation
     * 
     * @param items ArrayList to sort
     * @return sorted ArrayList
     */
    private static ArrayList<Cargo> quickSort(ArrayList<Cargo> items) {
        if (items.size() <= 1) {
            return items;
        }

        ArrayList<Cargo> lessThan = new ArrayList<>();
        ArrayList<Cargo> greaterThan = new ArrayList<>();

        // Use last element as pivot
        Cargo pivot = items.get(items.size() - 1);

        // Partition elements
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i).compareTo(pivot) < 0) {
                lessThan.add(items.get(i));
            } else {
                greaterThan.add(items.get(i));
            }
        }

        // Recursively sort partitions
        lessThan = quickSort(lessThan);
        greaterThan = quickSort(greaterThan);

        // Combine results
        ArrayList<Cargo> sorted = new ArrayList<>();
        sorted.addAll(lessThan);
        sorted.add(pivot);
        sorted.addAll(greaterThan);

        return sorted;
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
