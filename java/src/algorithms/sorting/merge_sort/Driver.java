package algorithms.sorting.merge_sort;

import algorithms.common.Cargo;
import java.util.ArrayList;
import java.util.Random;

/**
 * Driver class for demonstrating the Merge Sort algorithm.
 * 
 * @author bjornmelin
 * @version 1.0
 * @since 2025-01-25
 */
public class Driver {
    /**
     * Main method to test the Merge Sort implementation.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        ArrayList<Cargo> items = generateTestData(10);
        System.out.println("Before sorting:");
        printList(items);

        long timeTaken = MergeSort.sort(items);
        System.out.println("\nAfter sorting:");
        printList(items);
        System.out.println("\nTime taken: " + timeTaken + " nanoseconds");
        System.out.println("Is sorted: " + MergeSort.isSorted(items));
    }

    /**
     * Generates test data with random Cargo objects.
     * 
     * @param size Number of Cargo objects to generate
     * @return ArrayList of Cargo objects
     */
    private static ArrayList<Cargo> generateTestData(int size) {
        Random rng = new Random();
        String[] destinations = { "Seattle", "Portland", "San Francisco", "Los Angeles", "San Diego" };
        ArrayList<Cargo> data = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            data.add(new Cargo(destinations[rng.nextInt(destinations.length)], rng.nextDouble() * 100));
        }
        return data;
    }

    /**
     * Prints the contents of the ArrayList to the console.
     * 
     * @param list ArrayList to print
     */
    private static void printList(ArrayList<Cargo> list) {
        for (Cargo item : list) {
            System.out.println(item);
        }
    }
}
