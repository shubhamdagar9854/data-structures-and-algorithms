package data_structures.trees.red_black_tree;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Red-Black Tree Implementation.
 * This program tests the RedBlackTree class by inserting a few different
 * instances of a large number of random numbers and making sure the height of
 * the RBT is still O(lg n). Also tests the RedBlackTree class by inserting a
 * few different instances of a large set of numbers in the worst case
 * configuration (in incr. order by value), making sure height is still O(lg n).
 * NOTE: // Lemma 13.1: A RBTree with n internal nodes has height
 * at most 2(lg(n+1))
 * 
 * @author Bjorn Melin
 *         4/12/19
 */
public class Driver {

    /**
     * Implements the bulk of this program for testing RedBlackTree Class by
     * calling on the 2 static methods created to run the test.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("#########################################"
                + "#################################################"
                + "###############");
        System.out.println("############### TESTING FOR AVERAGE CASE "
                + "INSERTION IN RBTREE TO BE SURE HEIGHT IS O(lg n) "
                + "###############");
        System.out.println("#########################################"
                + "#################################################"
                + "###############\n");

        /**
         * Runs the tester for inserting 1000, 10000, 100000, and 1000000
         * nodes whose values are random integers ranging between 1-1000000.
         */
        randomTester(10, 1000, 0, 1000000);
        randomTester(10, 10000, 0, 1000000);
        randomTester(10, 100000, 0, 1000000);
        randomTester(10, 1000000, 0, 1000000);

        System.out.println("\n\n#########################################"
                + "#################################################"
                + "###############");
        System.out.println("################ TESTING FOR WORST CASE "
                + "INSERTION IN RBTREE TO BE SURE HEIGHT IS O(lg n) "
                + "################");
        System.out.println("#########################################"
                + "#################################################"
                + "###############\n");

        /**
         * Runs the tester for inserting 1000, 10000, 100000, and 1000000
         * nodes whose values are numbers ranging from 0-(n-1) when (n-1) is the
         * number of nodes to insert - 1. These nodes are inserting in
         * increasing order to maintain worse case height.
         */
        worstCaseTester(10, 1000);
        worstCaseTester(10, 10000);
        worstCaseTester(10, 100000);
        worstCaseTester(10, 1000000);
    }

    /**
     * Method used to run the bulk of testing to find the height of a RBTree
     * under random, average-case conditions. Inserts a specified number of
     * nodes into an RBTree in which nodes contain a specified random int value
     * 
     * @param numTests      int denoting the number of times to run the test for
     *                      the height of the RBTree
     * @param nodesToInsert int denoting the number of nodes to insert into
     *                      the RBTree
     * @param randMin       int denoting the min value of the random number
     *                      generator
     * @param randMax       int denoting the max value of the random number
     *                      generator
     */
    public static void randomTester(int numTests, int nodesToInsert, int randMin, int randMax) {
        System.out.println("========================= INSERTING " + nodesToInsert +
                " RANDOM INTS RANGING BETWEEN " + randMin + "-" + randMax +
                " =========================\n");
        // counter used to store the sum of all test runs RBTree heights
        double heightCounter = 0;
        Random gen = new Random(); // random number generator is created
        /**
         * loop creates a new RBTree each iteration and inserts nodes,
         * printing out the height of the RBTree each iteration and adding the
         * height to the heightCounter
         */
        for (int i = 0; i < numTests; i++) {
            // Creates a new RBTree for each test run
            RedBlackTree rbt = new RedBlackTree();
            /**
             * loop which creates a new RBNode with a random int within the
             * inputted range as the RBNodes value and the color "RED",
             * the node is then inserted into the RBTree (rbt) created in the
             * outer loop, the loop runs 'nodesToInsert' times
             */
            for (int j = 0; j < nodesToInsert; j++) {
                // generates the value to be used in the RBNode
                int nodeValue = gen.nextInt(((randMax - randMin) + 1) + randMin);
                // creates a new RBNode to insert into rbt
                RedBlackTree.RBNode tempNode = rbt.new RBNode(nodeValue, "RED");
                // inserts the temp node into rbt
                RedBlackTree.rBInsert(rbt, tempNode);
            }
            int howHigh = rbt.getRoot().height(); // height must be 2*lg(n + 1)
            System.out.println("The Height of RBTree Number " + (i + 1) +
                    " After Insertion Is:\t\t" + howHigh);
            // increments the total height count by the current trees height
            heightCounter += howHigh;
            // Used to test the toString and some methods int the RBT Class
            // System.out.println(rbt.toString() + "\n");
        }

        // computes what the expected height of the RBTrees tested should be
        double expectedCount = (2 * ((Math.log(nodesToInsert) / Math.log(2)) + 1));
        // computes what the real average height of the RBtrees tested
        double real = heightCounter / numTests;
        // computes the ratio b/w the real and expected height of the RBTree's
        double ratio = real / expectedCount;

        // used to only display 3 decimal accuracy in output print
        DecimalFormat numberFormat = new DecimalFormat("#.000");

        // prints out the desired results from the values computed
        System.out.println("\nThe Average Height Of The RBTree Of Size " + nodesToInsert +
                " Is:\t\t\t\t" + numberFormat.format(real));
        System.out.println("The Expected Height Of The RBTree of Size " + nodesToInsert +
                " Is Less Than Or Equal To:\t" + numberFormat.format(expectedCount));
        String ratioMessage = "Ratio Between Expected v.s. Actual Height Of An "
                + "RBTree Of Size " + nodesToInsert + " Is:";

        // Code below is just for good formatting in output adds extra tab
        // when it is needed so all outputs line up nicely
        if (nodesToInsert < 10000) {
            ratioMessage += "\t\t" + numberFormat.format(ratio);
            System.out.println(ratioMessage);
        } else {
            ratioMessage += "\t" + numberFormat.format(ratio);
            System.out.println(ratioMessage);
        }
        /**
         * if the ratio b/w actual height and maximum allowable height is less
         * than or equal to 1, then the test passes or else it throws an error
         */
        if (ratio <= 1) {
            System.out.println("\n**THE HEIGHT OF THE RBTREE OF SIZE " + nodesToInsert +
                    " IS IN FACT LESS THAN OR EQUAL TO 2lg(n+1) AS EXPECTED**");
        } else {
            System.err.println("\n**THE HEIGHT OF THE RBTREE OF SIZE " + nodesToInsert +
                    " IS NOT LESS THAN OR EQUAL TO 2lg(n+1) AS EXPECTED**");
        }
        System.out.println("\n\n");
    }

    /**
     * Method used to run the bulk of testing to find the height of a RBTree
     * under worst-case conditions. Inserts a specified number of nodes into
     * an RBTree in which node contain a value ranging from 0-nodesToInsert.
     * 
     * @param numTests      int denoting the number of times to run the test for
     *                      the height of the RBTree
     * @param nodesToInsert int denoting the number of nodes to insert into
     *                      the RBTree
     */
    public static void worstCaseTester(int numTests, int nodesToInsert) {
        System.out.println("========================= INSERTING "
                + nodesToInsert + " INTS IN WORST-CASE CONFIGURATION "
                + "=========================\n");
        // counter used to store the sum of all test runs RBTree heights
        double heightCounter = 0;
        /**
         * loop creates a new RBTree each iteration and inserts nodes,
         * printing out the height of the RBTree each iteration and adding the
         * height to the heightCounter
         */
        for (int i = 0; i < numTests; i++) {
            // Creates a new RBTree for each test run
            RedBlackTree rbt = new RedBlackTree();
            /**
             * loop which creates and inserts an RBNode containing a value (j)
             * and the color "BLACK" into the RBTree (rbt)
             */
            for (int j = 0; j < nodesToInsert; j++) {
                // creates a new RBNode to insert into rbt
                RedBlackTree.RBNode tempNode = rbt.new RBNode(j, "RED");
                // inserts the temp node into rbt
                RedBlackTree.rBInsert(rbt, tempNode);
            }
            int howHigh = rbt.getRoot().height(); // height must be 2*lg(n + 1)
            System.out.println("The Current Height of RBTree Number " + (i + 1)
                    + " Is:\t\t" + howHigh);
            // increments the total height count by the current trees height
            heightCounter += howHigh;
            // Used to test the toString and some methods int the RBT Class
            // System.out.println(rbt.toString() + "\n");
        }

        // computes what the expected height of the RBTrees tested should be
        double expectedCount = (2 * ((Math.log(nodesToInsert) / Math.log(2)) + 1));
        // computes what the real average height of the RBtrees tested
        double real = heightCounter / numTests;
        // computes the ratio b/w the real and expected height of the RBTree's
        double ratio = real / expectedCount;

        // used to only display 3 decimal accuracy in output print
        DecimalFormat numberFormat = new DecimalFormat("#.000");

        // prints out the desired results from the values computed
        System.out.println("\nThe Average Height Of The RBTree Of Size " + nodesToInsert +
                " Is:\t\t\t\t" + numberFormat.format(real));
        System.out.println("The Expected Height Of The RBTree of Size " + nodesToInsert +
                " Is Less Than Or Equal To:\t" + numberFormat.format(expectedCount));
        String ratioMessage = "Ratio Between Expected v.s. Actual Height Of An "
                + "RBTree Of Size " + nodesToInsert + " Is:";

        // Code below is just for good formatting in output adds extra tab
        // when it is needed so all outputs line up nicely
        if (nodesToInsert < 10000) {
            ratioMessage += "\t\t" + numberFormat.format(ratio);
            System.out.println(ratioMessage);
        } else {
            ratioMessage += "\t" + numberFormat.format(ratio);
            System.out.println(ratioMessage);
        }
        /**
         * if the ratio b/w actual height and maximum allowable height is less
         * than or equal to 1, then the test passes or else it throws an error
         */
        if (ratio <= 1) {
            System.out.println("\n**THE HEIGHT OF THE RBTREE OF SIZE " + nodesToInsert +
                    " IS IN FACT LESS THAN OR EQUAL TO 2lg(n+1) AS EXPECTED**");
        } else {
            System.err.println("\n**THE HEIGHT OF THE RBTREE OF SIZE " + nodesToInsert +
                    " IS NOT LESS THAN OR EQUAL TO 2lg(n+1) AS EXPECTED**");
        }
        System.out.println("\n\n");
    }
}