package algorithms.searching.binary_search;

import algorithms.common.Cargo;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Binary Search algorithm
 */
public class BinarySearch {
    /**
     * Performs binary search on a sorted ArrayList of Cargo objects
     * Time Complexity: O(log n)
     * 
     * @param items  sorted ArrayList to search in
     * @param target Cargo object to search for
     * @return time taken in nanoseconds
     */
    public static long search(ArrayList<Cargo> items, Cargo target) {
        long start = System.nanoTime();
        binarySearcher(items, 0, items.size() - 1, target);
        return System.nanoTime() - start;
    }

    /**
     * Performs binary search on multiple targets
     * 
     * @param items   sorted ArrayList to search in
     * @param targets ArrayList of Cargo objects to search for
     * @return time taken in nanoseconds
     */
    public static long searchMultiple(ArrayList<Cargo> items, ArrayList<Cargo> targets) {
        long start = System.nanoTime();
        for (Cargo target : targets) {
            binarySearcher(items, 0, items.size() - 1, target);
        }
        return System.nanoTime() - start;
    }

    /**
     * Helper method that implements the recursive binary search
     * 
     * @param items  sorted ArrayList to search in
     * @param first  starting index
     * @param last   ending index
     * @param target Cargo object to find
     * @return true if found, false otherwise
     */
    private static boolean binarySearcher(ArrayList<Cargo> items, int first, int last, Cargo target) {
        if (first > last) {
            return false;
        }

        int mid = first + (last - first) / 2;
        int comparison = target.compareTo(items.get(mid));

        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            return binarySearcher(items, first, mid - 1, target);
        } else {
            return binarySearcher(items, mid + 1, last, target);
        }
    }
}