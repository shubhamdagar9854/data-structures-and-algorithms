package algorithms.searching.binary_search;

import algorithms.common.Cargo;
import java.util.ArrayList;
import java.util.Random;

/**
 * Driver class for demonstrating the Binary Search algorithm.
 * 
 * @author bjornmelin
 * @version 1.0
 * @since 2025-01-25
 */
public class Driver {
    /**
     * Main method to test the Binary Search implementation.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        ArrayList<Cargo> items = generateTestData(10);
        System.out.println("Unsorted list:");
        printList(items);

        // Sort the list for binary search
        items.sort((c1, c2) -> Double.compare(c1.getTonnage(), c2.getTonnage()));
        System.out.println("\nSorted list:");
        printList(items);

        // Test search
        Cargo target = items.get(5);
        System.out.println("\n\nSearching for: " + target);
        long timeTaken = BinarySearch.search(items, target);
        System.out.println("Found: " + BinarySearch.search(items, target));
        System.out.println("Time taken: " + timeTaken + " nanoseconds");
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