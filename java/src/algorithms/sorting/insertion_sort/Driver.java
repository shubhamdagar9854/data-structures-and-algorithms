package algorithms.sorting.insertion_sort;

import java.util.Random;

/**
 * Driver used to test Insertion Sort Function
 * Implements Insertion Sort Using an Array of Integers and Tests Operation
 * Times
 * 2/1/19
 * 
 * @author bjornmelin
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ################################# CODE FOR PROJECT BEGINS HERE
        // ##############################################

        /**
         * Main loop that runs entire Insertion Sort test program 10 times
         */
        for (int count = 0; count < 10; count++) {
            System.out.println("======================= TEST RUN NUMER " + (count + 1) + " ======================="); // Print
                                                                                                                      // statement
                                                                                                                      // to
                                                                                                                      // seperate
                                                                                                                      // test
                                                                                                                      // results
            for (int i = 0; i < 10; i++) // Loop that is used to run insertion sort on 10 arrays of random ints of size
                                         // 10
            {
                // Creates and sorts the array
                int[] temp = createRandomIntArray(10);
                insertionSort(temp);
                // Upon the last iteration, ratio/constant for operation time is computed and
                // printed
                if (i == 9) {
                    System.out
                            .println("\n\nAVERAGE NUMBER OF OPERATIONS NEEDED TO SORT AN ARRAY OF RANDOM INTS OF SIZE "
                                    + temp.length + " IS:\t\t" + counter / 10);
                    // Average ops and ratio are added to their corresponding arrays at the index
                    // that the count of main loop is on
                    ops10[count] = counter / 10;
                    ratio1[count] = computeRatio(counter, temp.length);
                }
            }
            // After each dif. sized arrays are sorted and stats are extracted, universal
            // counter is reset for the next dif. sized arrays
            counter = 0;

            for (int i = 0; i < 10; i++) // Loop that is used to run insertion sort on 10 arrays of random ints of size
                                         // 100
            {
                // Creates and sorts the array
                int[] temp = createRandomIntArray(100);
                insertionSort(temp);
                // Upon the last iteration, ratio/constant for operation time is computed and
                // printed
                if (i == 9) {
                    System.out
                            .println("\n\nAVERAGE NUMBER OF OPERATIONS NEEDED TO SORT AN ARRAY OF RANDOM INTS OF SIZE "
                                    + temp.length + " IS:\t\t" + counter / 10);
                    // Average ops and ratio are added to their corresponding arrays at the index
                    // that the count of main loop is on
                    ops100[count] = counter / 10;
                    ratio2[count] = computeRatio(counter, temp.length);
                }
            }
            counter = 0;

            for (int i = 0; i < 10; i++) // Loop that is used to run insertion sort on 10 arrays of random ints of size
                                         // 1000
            {
                // Creates and sorts the array
                int[] temp = createRandomIntArray(1000);
                insertionSort(temp);
                // Upon the last iteration, ratio/constant for operation time is computed and
                // printed
                if (i == 9) {
                    System.out
                            .println("\n\nAVERAGE NUMBER OF OPERATIONS NEEDED TO SORT AN ARRAY OF RANDOM INTS OF SIZE "
                                    + temp.length + " IS:\t\t" + counter / 10);
                    // Average ops and ratio are added to their corresponding arrays at the index
                    // that the count of main loop is on
                    ops1000[count] = counter / 10;
                    ratio3[count] = computeRatio(counter, temp.length);
                }
            }
            counter = 0;

            for (int i = 0; i < 10; i++) // Loop that is used to run insertion sort on 10 arrays of random ints of size
                                         // 10000
            {
                // Creates and sorts the array
                int[] temp = createRandomIntArray(10000);
                insertionSort(temp);
                // Upon the last iteration, ratio/constant for operation time is computed and
                // printed
                if (i == 9) {
                    System.out
                            .println("\n\nAVERAGE NUMBER OF OPERATIONS NEEDED TO SORT AN ARRAY OF RANDOM INTS OF SIZE "
                                    + temp.length + " IS:\t\t" + counter / 10);
                    // Average ops and ratio are added to their corresponding arrays at the index
                    // that the count of main loop is on
                    ops10000[count] = counter / 10;
                    ratio4[count] = computeRatio(counter, temp.length);
                }
            }
            counter = 0;

            // Upon the last iteration of the outer loop, finds the average of
            // ratios/constants and operations for each dif. sized array
            if (count == 9) {
                // Doubles used to store the sums of all elements in each ratio array
                double totalRatio10 = 0;
                double totalRatio100 = 0;
                double totalRatio1000 = 0;
                double totalRatio10000 = 0;
                // Ints used to store the sums of all elements in each ops array
                int totalOps10 = 0;
                int totalOps100 = 0;
                int totalOps1000 = 0;
                int totalOps10000 = 0;

                // Loop used to sum all 10 elements from each ratio array and ops array
                for (int i = 0; i < 10; i++) {
                    totalRatio10 += ratio1[i];
                    totalRatio100 += ratio2[i];
                    totalRatio1000 += ratio3[i];
                    totalRatio10000 += ratio4[i];
                    totalOps10 += ops10[i];
                    totalOps100 += ops100[i];
                    totalOps1000 += ops1000[i];
                    totalOps10000 += ops10000[i];
                }
                // The below lines print out the average ratios/constants and verage operations
                // taken for each dif. sized array
                System.out.println("AVERAGE RATIO FOR ARRAY OF SIZE 10:\t" + (totalRatio10 / 10));
                System.out.println("AVERAGE RATIO FOR ARRAY OF SIZE 100:\t" + (totalRatio100 / 10));
                System.out.println("AVERAGE RATIO FOR ARRAY OF SIZE 1000:\t" + (totalRatio1000 / 10));
                System.out.println("AVERAGE RATIO FOR ARRAY OF SIZE 10000:\t" + (totalRatio10000 / 10) + "\n\n");
                System.out.println("AVERAGE OPERATIONS TO SORT AN ARRAY OF SIZE 10:\t\t" + (totalOps10 / 10));
                System.out.println("AVERAGE OPERATIONS TO SORT AN ARRAY OF SIZE 100:\t" + (totalOps100 / 10));
                System.out.println("AVERAGE OPERATIONS TO SORT AN ARRAY OF SIZE 1000:\t" + (totalOps1000 / 10));
                System.out.println("AVERAGE OPERATIONS TO SORT AN ARRAY OF SIZE 10000:\t" + (totalOps10000 / 10));
            }
        }

    }

    // ################################# SUPPLEMENTARY METHODS & VARIABLES
    // ##############################################

    /**
     * Creates 4 arrays that store integers holding values for the av number of
     * operations performed
     * from each run for each dif sized array
     * Used in main method to compute average ops
     */
    private static int[] ops10 = new int[10];
    private static int[] ops100 = new int[10];
    private static int[] ops1000 = new int[10];
    private static int[] ops10000 = new int[10];

    /**
     * Creates 4 arrays that store doubles holding the ratio values from each run
     * for each dif sized array
     * Used in the main method to compute average ratios/constants
     */
    private static double[] ratio1 = new double[10];
    private static double[] ratio2 = new double[10];
    private static double[] ratio3 = new double[10];
    private static double[] ratio4 = new double[10];

    /**
     * Method used to create an array of random integers
     * 
     * @param size int denoting the desired size of the array
     * @return array of integers in unsorted order
     */
    public static int[] createRandomIntArray(int size) {
        int[] answer = new int[size];
        Random generator = new Random();
        for (int index = 0; index < answer.length; index++) {
            answer[index] = generator.nextInt(100) + 1;
        }
        return answer;
    }

    /**
     * Insertion Sort method which is called on in the main method
     * 
     * @param unsorted An array of integers in random order
     * @return An array of integers which contains the same elements as the unsorted
     *         array
     *         but in sorted order.
     */
    public static int[] insertionSort(int[] unsorted) {
        int count = 0; // int used to keep track of the number of operations performed locally
        // Loop for considering every element in the array
        for (int j = 1; j < unsorted.length; j++) {
            int key = unsorted[j]; // int denoting that element in the unsorted array to sort
            int i = j - 1;
            count = count + 3; // 3 operations done each time the loop reaches here, at the for, and for each
                               // int
            counter += 3; // 3 operations added to universal counter also

            // moves elements of unsorted[0...j-1], greater than the key one index to the
            // right/ahead
            // before iteration of loop, unsorted[0...j-1] is already sorted
            while (i >= 0 && unsorted[i] > key) {
                unsorted[i + 1] = unsorted[i];
                i = i - 1;
                count = count + 4; // 2 ops for while comparisons and 2 ops for comparisons in loop
                counter += 4; // 2 ops added to universal counter also
            }
            unsorted[i + 1] = key;
            count = count + 1; // 1 op added for new key assignment
            counter += 1; // 1 op added to universal counter also
        }
        return unsorted;
    }

    /**
     * Universal counter used to track the total number of operations performed in
     * all 10 sorts
     * Used so that we can calculate the average num of operations needed for
     * insertion sort
     * for each dif sized array of random ints
     */
    private static int counter = 0;

    /**
     * Method used to calculate the ratio/constant for run times of each different
     * sized array
     * 
     * @param actualOpCount int denoting the number of operations actually taken for
     *                      insertion sort
     * @param arraySize     int denoting the number of operations that should be
     *                      taken for insertion sort at 0(n^2) time
     * @return double denoting the ratio/constant for operation time
     */
    private static double computeRatio(int actualOpCount, int arraySize) {
        int nSquared = (arraySize * arraySize);
        double adjActualOps = actualOpCount / 10.0;
        double ratio = adjActualOps / nSquared;
        System.out.println("\nRATIO B/W ACTUAL AND EXPECTED OPERATIONS FOR "
                + "AN ARRAY OF SIZE " + arraySize + " IS:\t\t\t\t" + ratio + "\n\n");
        return ratio;
    }

}