package algorithms.sorting.merge_sort;

import algorithms.common.Cargo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {
    /**
     * Sorts an ArrayList of Cargo objects using Merge Sort
     * Time Complexity: O(n log n)
     * 
     * @param items ArrayList to sort
     * @return time taken in nanoseconds
     */
    public static long sort(ArrayList<Cargo> items) {
        long start = System.nanoTime();

        ArrayList<Cargo> sorted = mergeSort(items);
        // Copy sorted items back to original list
        for (int i = 0; i < items.size(); i++) {
            items.set(i, sorted.get(i));
        }

        return System.nanoTime() - start;
    }

    private static ArrayList<Cargo> mergeSort(ArrayList<Cargo> items) {
        if (items.size() <= 1) {
            return items;
        }

        int mid = items.size() / 2;
        List<Cargo> left = new LinkedList<>(items.subList(0, mid));
        List<Cargo> right = new LinkedList<>(items.subList(mid, items.size()));

        return merge(mergeSort(new ArrayList<>(left)),
                mergeSort(new ArrayList<>(right)));
    }

    private static ArrayList<Cargo> merge(ArrayList<Cargo> left, ArrayList<Cargo> right) {
        ArrayList<Cargo> merged = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex++));
        }

        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex++));
        }

        return merged;
    }

    /**
     * Verify if the ArrayList is properly sorted
     * 
     * @param items ArrayList to check
     * @return true if sorted, false otherwise
     */
    public static boolean isSorted(ArrayList<Cargo> items) {
        if (items == null || items.isEmpty() || items.size() == 1) {
            return true;
        }

        for (int i = 1; i < items.size(); i++) {
            if (items.get(i - 1).compareTo(items.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }
}
