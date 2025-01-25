package data_structures.linear.bag;

/**
 * A demonstration of the class ResizableArrayBag. Tests Union, Intersection,
 * Difference, and Equals Methods
 * 
 * @author bjornmelin
 */
public class ResizableArrayBagDemo {
    public static void main(String[] args) {
        // Test ResizableArrayBag with an array of strings
        String[] inputArray = { "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };
        arrayToString(inputArray); // Prints out the contents of array 1
        BagInterface<String> aBag = new ResizableArrayBag<>(inputArray);

        String[] inputArray2 = { "F", "G", "H", "I", "T", "T", "U", "V", "W", "X", "Y", "Z", "A" };
        arrayToString(inputArray2);
        BagInterface<String> bBag = new ResizableArrayBag<>(inputArray2);

        // Testing the methods
        // Tests the equals method
        System.out.println("\nBags: aBag and bBag are equal: "
                + ((ResizableArrayBag<String>) aBag).equals((ResizableArrayBag<String>) bBag) + "\n\n");

        // Tests the union method
        System.out.println("Testing the union method: ");
        BagInterface<String> cBag = aBag.union(bBag);
        displayBag(cBag);
        System.out.println("\n\n");

        // Tests the intersection method
        System.out.println("Testing the intersection method: ");
        BagInterface<String> dBag = aBag.intersection(bBag);
        displayBag(dBag);
        System.out.println("\n\n");

        // Tests the difference method
        System.out.println("Testing the difference method: ");
        BagInterface<String> eBag = aBag.difference(bBag);
        displayBag(eBag);
        System.out.println("\n\n");

        // Tests other bag operations
        aBag.clear();
        testIsEmpty(aBag, true);

        System.out.println("Adding strings to the bag:");
        String[] contentsOfBag = { "A", "D", "B", "A", "C", "A", "D" };
        testAdd(aBag, contentsOfBag);

        testIsEmpty(aBag, false);
        String[] testStrings2 = { "A", "B", "C", "D", "Z" };
        testFrequency(aBag, testStrings2);
        testContains(aBag, testStrings2);

        // Removing strings
        String[] testStrings3 = { "", "B", "A", "C", "Z" };
        testRemove(aBag, testStrings3);

        System.out.println("\nClearing the bag:");
        aBag.clear();
        testIsEmpty(aBag, true);
        displayBag(aBag);
    }

    // Tests the method add.
    private static void testAdd(BagInterface<String> aBag, String[] content) {
        System.out.print("Adding to the bag: ");
        for (String item : content) {
            aBag.add(item);
            System.out.print(item + " ");
        }
        System.out.println();
        displayBag(aBag);
    }

    // Tests the two remove methods.
    private static void testRemove(BagInterface<String> aBag, String[] tests) {
        for (String aString : tests) {
            if (aString.equals("") || (aString == null)) {
                // Test remove()
                System.out.println("\nRemoving a string from the bag:");
                String removedString = aBag.remove();
                System.out.println("remove() returns " + removedString);
            } else {
                // Test remove(aString)
                System.out.println("\nRemoving \"" + aString + "\" from the bag:");
                boolean result = aBag.remove(aString);
                System.out.println("remove(\"" + aString + "\") returns " + result);
            }
            displayBag(aBag);
        }
    }

    // Tests the method isEmpty.
    private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult) {
        System.out.print("Testing isEmpty with ");
        if (correctResult) {
            System.out.println("an empty bag:");
        } else {
            System.out.println("a bag that is not empty:");
        }

        System.out.print("isEmpty finds the bag ");
        if (correctResult && aBag.isEmpty()) {
            System.out.println("empty: OK.");
        } else if (correctResult) {
            System.out.println("not empty, but it is empty: ERROR.");
        } else if (!correctResult && aBag.isEmpty()) {
            System.out.println("empty, but it is not empty: ERROR.");
        } else {
            System.out.println("not empty: OK.");
        }
        System.out.println();
    }

    // Tests the method getFrequencyOf.
    private static void testFrequency(BagInterface<String> aBag, String[] tests) {
        System.out.println("\nTesting the method getFrequencyOf:");
        for (String item : tests) {
            System.out.println("In this bag, the count of " + item
                    + " is " + aBag.getFrequencyOf(item));
        }
    }

    // Tests the method contains.
    private static void testContains(BagInterface<String> aBag, String[] tests) {
        System.out.println("\nTesting the method contains:");
        for (String item : tests) {
            System.out.println("Does this bag contain " + item
                    + "? " + aBag.contains(item));
        }
    }

    // Displays the bag.
    private static void displayBag(BagInterface<String> aBag) {
        System.out.println("The bag contains " + aBag.getCurrentSize()
                + " string(s), as follows:");
        Object[] bagArray = aBag.toArray();
        for (Object item : bagArray) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /**
     * Displays the values inputted into arrays
     * 
     * @param array : object[]
     */
    public static void arrayToString(Object[] array) {
        System.out.print("This array contains: \n");
        for (Object item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}