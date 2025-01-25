package data_structures.linear.hashed_table_dictionary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Hash Table Dictionary used to store Book Objects
 * 
 * @author bjornmelin
 */
public class HashedTableBook {

    private LinkedList<Book>[] data;

    /**
     * Constructor for Hashed Table Book Dictionary
     */
    public HashedTableBook() {
        // 1 Intantiate the array of Linked Lists
        data = new LinkedList[31];
        // 2 Create each empty Linked List
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<Book>();
        }
    }

    /**
     * toString method for HashTableBook
     * 
     * @return String denoting the indices and contents of the indices in the Hashed
     *         Table Book Dictionary
     */
    public String toString() {
        String output = "Printing HashTableBook\n";
        for (int i = 0; i < data.length; i++) {
            output += "\tIndex " + i + ":\t" + data[i] + "\n\n";
        }
        return output;
    }

    /**
     * Add method for Hashed Table Book
     * 
     * @param value Book Object to be added to the Hashed Table
     */
    public void add(Book value) {
        // 1 Find the bucket/index... Use our hashcode!
        int targetIndex = (Math.abs(value.hashCode())) % data.length;
        // 2 Insert entry into data
        data[targetIndex].add(value);
    }

    /**
     * Get method for Hashed Table Book
     * 
     * @param targetTitle The title we are looking for
     * @return ArrayList denoting all occurrences of the target Book in the Hashed
     *         Table
     */
    public ArrayList<Book> get(String targetTitle) {
        // Calculate hashCode of target
        int code = (Math.abs(targetTitle.hashCode())) % data.length;
        Iterator<Book> listing = data[code].iterator();
        ArrayList<Book> matches = new ArrayList<>();
        while (listing.hasNext()) {
            Book target = listing.next();
            if (target.getTitle().equals(targetTitle))
                matches.add(target);
        }
        return matches;
    }
}