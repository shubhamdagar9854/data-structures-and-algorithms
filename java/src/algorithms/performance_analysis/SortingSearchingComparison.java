package algorithms.performance_analysis;

import algorithms.common.Cargo;
import algorithms.common.Cargo;
import algorithms.sorting.selection_sort.SelectionSort;
import algorithms.sorting.insertion_sort.InsertionSort;
import algorithms.sorting.quick_sort.QuickSort;
import algorithms.sorting.merge_sort.MergeSort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Comparative analysis of different sorting and searching algorithms
 */
public class SortingSearchingComparison {

    public static void main(String[] args) {
        // Generate test data
        ArrayList<Cargo> boxes = generateTestData(100000);

        // Clone arrays for different sorting algorithms
        ArrayList<Cargo> selection = cloneList(boxes);
        ArrayList<Cargo> insertion = cloneList(boxes);
        ArrayList<Cargo> quick = cloneList(boxes);
        ArrayList<Cargo> merge = cloneList(boxes);
        ArrayList<Cargo> collectionSort = cloneList(boxes);

        // Run and time sorting algorithms
        System.out.println("--- Sorting Algorithm Performance ---");
        System.out.println("Selection Sort: " + SelectionSort.sort(selection) + " ns");
        System.out.println("Insertion Sort: " + InsertionSort.sort(insertion) + " ns");
        System.out.println("Quick Sort:     " + QuickSort.sort(quick) + " ns");
        System.out.println("Merge Sort:     " + MergeSort.sort(merge) + " ns");
        System.out.println("Collections.sort(): " + timeCollectionsSort(collectionSort) + " ns");

        // Verify sorts
        System.out.println("\n--- Sorting Verification ---");
        System.out.println("Selection Sort valid: " + SelectionSort.isSorted(selection));
        System.out.println("Insertion Sort valid: " + InsertionSort.isSorted(insertion));
        System.out.println("Quick Sort valid:     " + QuickSort.isSorted(quick));
        System.out.println("Merge Sort valid:     " + MergeSort.isSorted(merge));
        System.out.println("Collections.sort valid: " + isSorted(collectionSort));
    }

    private static ArrayList<Cargo> generateTestData(int size) {
        Random rng = new Random();
        String[] places = { "Duluth", "St. Paul", "Minneapolis", "Rochester", "Bloomington" };
        ArrayList<Cargo> data = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            data.add(new Cargo(places[rng.nextInt(5)], rng.nextDouble() * 100));
        }
        return data;
    }

    private static ArrayList<Cargo> cloneList(ArrayList<Cargo> original) {
        return new ArrayList<>(original);
    }

    private static long timeCollectionsSort(ArrayList<Cargo> items) {
        long start = System.nanoTime();
        Collections.sort(items);
        return System.nanoTime() - start;
    }

    private static boolean isSorted(ArrayList<Cargo> items) {
        for (int i = 1; i < items.size(); i++) {
            if (items.get(i - 1).compareTo(items.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }
}