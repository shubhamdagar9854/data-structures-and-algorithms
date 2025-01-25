package algorithms.sorting.insertion_sort;

import algorithms.common.Cargo;
import java.util.ArrayList;

public class InsertionSort {
    /**
     * Sorts an ArrayList of Cargo objects using Insertion Sort
     * Time Complexity: O(n^2)
     * 
     * @param items ArrayList to sort
     * @return time taken in nanoseconds
     */
    public static long sort(ArrayList<Cargo> items) {
        long start = System.nanoTime();

        for (int curr = 1; curr < items.size(); curr++) {
            Cargo key = items.get(curr);
            int j = curr - 1;

            while (j >= 0 && items.get(j).compareTo(key) > 0) {
                items.set(j + 1, items.get(j));
                j = j - 1;
            }
            items.set(j + 1, key);
        }

        return System.nanoTime() - start;
    }

    public static boolean isSorted(ArrayList<Cargo> items) {
        for (int i = 1; i < items.size(); i++) {
            if (items.get(i - 1).compareTo(items.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }
}
