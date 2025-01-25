package data_structures.linear.hashed_table_dictionary;

/**
 * Tests Hashed Table Dictionary for Book Objects
 * 
 * @author bjornmelin
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create a new HashedTableBook
        HashedTableBook myData = new HashedTableBook();
        System.out.println(myData); // print out empty HashedTableBook to be sure it has the correct size

        // Testing add method for HashedTableBook
        System.out.println("Adding 10 Books:\n");
        myData.add(new Book("Data Structures", 565, 100000));
        myData.add(new Book("Algorithms", 432, 80000));
        myData.add(new Book("Bjorns Book of Fun", 100, 30000));
        myData.add(new Book("Computer Science", 667, 75000));
        myData.add(new Book("Abstract Algebra", 324, 40000));
        myData.add(new Book("Graph Theory", 245, 25000));
        myData.add(new Book("Linear Algebra", 525, 62000));
        myData.add(new Book("Multi Variable Calulus", 874, 132000));
        myData.add(new Book("Multi Variable Calulus", 874, 132000));
        myData.add(new Book("Midwest Skiing", 195, 12000));
        myData.add(new Book("Sports", 55, 10000));
        System.out.println(myData);

        // Test get method for HashedTableBook
        System.out.println("Can we find Sports? " + myData.get("Sports")); // Search for "Sports" in the Hashed Table
        System.out.println("Can we find Cooking? " + myData.get("Cooking")); // Search for a Book not in the Hashed
                                                                             // Table
        System.out.println("Can we find Multi Variable Calculus? " + myData.get("Multi Variable Calulus")); // Search
                                                                                                            // for a
                                                                                                            // Book with
                                                                                                            // the same
                                                                                                            // name in
                                                                                                            // Hashed
                                                                                                            // Table
    }
}