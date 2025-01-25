package algorithms.sorting.heapsort;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 * Heapsort Implementation.
 * This program implements heapsort by creating an array of random integers
 * ranging (1-100) inclusive, then sorting that array by implementation of
 * heapsort & helper methods. Keeping track of the operations performed by
 * each method during sorting, adding them all up and then comparing the number
 * of operations taken to what is expected.
 * 
 * @author Bjorn Melin
 *         2/21/19
 */
public class Driver {

    /**
     * Implements all of the programs methods in main by calling the
     * testLooper method
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Runs the test method for heapsort on arrays of sizes 10, 100,
         * 1000, 10000, 100000, and 1000000 filled with random ints (1-100)
         */
        System.out.println(testLooper(10, 100));
        System.out.println(testLooper(100, 100));
        System.out.println(testLooper(1000, 100));
        System.out.println(testLooper(10000, 100));
        System.out.println(testLooper(100000, 100));
        System.out.println(testLooper(1000000, 100));
    }

    /**
     * Method used to implement heapsort to sort an array of integers in
     * ascending order. Uses helper methods created to aid in sorting
     * 
     * @param A array of integers denoting the input array to be sorted
     * @param n int denoting the length of the input array of integers
     * @return int denoting the operation count after heapsort is finished
     */
    public static int heapSort(int[] A, int n) {
        // int used to count the total number of operations to perform heapsort
        int counter = 0;

        // increment count by buildMaxHeap return value, build max heap
        counter += buildMaxHeap(A, n);
        counter++; // add operation to count

        /**
         * loop extracts the max element one at a time from the heap and stores
         * value at the end of the array, then repeats on arr n-1 until sorted
         */
        for (int i = n - 1; i >= 1; i--) {
            // swaps root to the end of the array
            int temp = A[0];
            counter++; // add operation to count
            A[0] = A[i];
            counter++; // add operation to count
            A[i] = temp;
            counter++; // add operation to count
            // increment count by maxHeapify return value, max heapify
            // the now reduced heap (n-1 more each time)
            counter += maxHeapify(A, 0, i);
            counter++; // add operation to count
        }
        counter++; // Add 1 to count for failed for loop comparison
        return counter;
    }

    /**
     * Method used to create a max heap out of an inputted array of integers
     * 
     * @param A array of integers denoting the input array to be sorted
     * @param n int denoting the length of the input array of integers
     * @return int denoting the operation count of buildMaxHeap
     */
    public static int buildMaxHeap(int[] A, int n) {
        // int used to count the number of operations performed in this method
        int count = 0;

        /**
         * loop that builds the max heap, heapifying down from the middle
         * of the array so that when build, max value is first A[0]
         */
        for (int i = n / 2; i >= 0; i--) {
            // increment count by maxHeapify return value
            count += maxHeapify(A, i, n);
            count++; // add operation to count
        }
        count++; // increment count 1 for failed for comparison
        return count;
    }

    /**
     * Method used to place elements in their proper index in the array.
     * Uses parent and child methods to place elements in the correct locations.
     * Assumes that left and right subtrees are heapified, fixes the root
     * 
     * @param A array of integers denoting the input array to be sorted
     * @param i int denoting the index in the input array
     * @param n int denoting the length of the input array of integers
     * @return int denoting the operation count of maxHeapify
     */
    public static int maxHeapify(int[] A, int i, int n) {
        int count = 0; // counter used to keep track of operations

        // sets largest to node to i, gets left and right children
        // for the node at index i
        int largest = i;
        int l = left(i);
        int r = right(i);
        count += 3; // add 3 operations to count for above lines

        /**
         * 2 if statements below compare node at i to its left and
         * right children, finding the largest value
         */
        if (l < n && A[l] > A[largest]) {
            largest = l;
            count++; // add operation to count
        }
        count++; // Add 1 to count for failed if loop comparison
        if (r < n && A[r] > A[largest]) {
            largest = r; // add operation to count
            count++; // add operation to count
        }
        count++; // increment count 1 for failed if comparison

        /**
         * if largest value is no longer largest value, swaps with the child
         * with the largest value
         */
        if (largest != i) {
            // swaps with child node having larger value
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            // call max heapify on the child node
            maxHeapify(A, largest, n);
            count += 4; // add 4 operations to count for above lines
        }
        count++; // Add 1 to count for failed if comparison
        return count;
    }

    /**
     * Method used to get the index of an elements parent
     * 
     * @param i int denoting the index of the element to find the parent of
     * @return int denoting the index of the child indices parent
     */
    public static int parent(int i) {
        return i / 2;
    }

    /**
     * Method used to get the left child of an element
     * 
     * @param i int denoting the index of the element to find the left child of
     * @return int denoting the index of the parents left child
     */
    public static int left(int i) {
        return i * 2 + 1;
    }

    /**
     * Method used to get the right child of an element
     * 
     * @param i int denoting the index of the element to find the right child of
     * @return int denoting the index of the parents right child
     */
    public static int right(int i) {
        return i * 2 + 2;
    }

    /**
     * Method used to run the body of my testing
     * 
     * @param arrSize    int denoting desired size of the array to be sorted
     * @param numOfTests int denoting desired number of tests to be ran
     * @return String denoting the operations taken, expected operations,
     *         and a ratio b/w expected vs. actual operations taken.
     */
    public static String testLooper(int arrSize, int numOfTests) {
        String output = "========================= PERFORMING HEAPSORT ON ARRAY OF SIZE "
                + arrSize + " =========================\n";
        // counter used to store sum of all test runs operation counts
        int totalCounter = 0;

        /**
         * this loop runs the heapsort algorithm on an array of the input
         * size. It repeats this process for the desired amount of tests
         */
        for (int i = 0; i < numOfTests; i++) {
            int[] tempArr = createRandomIntArray(arrSize);
            totalCounter += heapSort(tempArr, tempArr.length);
            // Used the concat below to print out the array to double check that the arrays
            // were sorted
            // output += "\n\n" + Arrays.toString(tempArr);
        }

        // computes what the expected num of operations should be
        double expectedCount = (arrSize * (Math.log(arrSize) / Math.log(2)));
        // computes what the real average num of operations was to sort
        double real = totalCounter / numOfTests;
        // computes the ratio b/w the real and expected operation counts
        double ratio = real / expectedCount;

        // used to only display 3 decimal accuracy in output print
        DecimalFormat numberFormat = new DecimalFormat("#.000");

        // prints out the desired results from the values computed
        output += "\nAVERAGE NUMBER OF OPERATIONS NEEDED TO SORT AN ARRAY OF RANDOM INTS OF SIZE "
                + arrSize + " USING HEAPSORT IS:\t" + (numberFormat.format(real));
        output += "\n\nEXPECTED NUMBER OF OPERATIONS NEEDED TO SORT AN ARRAY OF RANDOM INTS OF SIZE "
                + arrSize + " USING HEAPSORT IS:\t" + (numberFormat.format(expectedCount));
        output += "\n\nRATIO BETWEEN EXPECTED V.S. ACTUAL OPERATIONS FOR SORTING AN ARRAY OF SIZE "
                + arrSize + " IS:\t\t\t" + (numberFormat.format(ratio));

        return output + "\n\n\n\n\n";
    }

    /**
     * Method used to create an array of random integers
     * 
     * @param size int denoting the desired size of the array
     * @return array of integers in unsorted order
     */
    public static int[] createRandomIntArray(int size) {
        int[] answer = new int[size];
        Random generator = new Random();
        // fills the answer array with random ints ranging from 1-100 inclusive
        for (int index = 0; index < answer.length; index++) {
            answer[index] = generator.nextInt(100) + 1;
        }
        return answer;
    }
}