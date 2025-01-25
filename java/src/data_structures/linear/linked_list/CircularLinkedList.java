package data_structures.linear.linked_list;

/**
 * A class that implements a list of objects using a Circular Linked List
 * 
 * @author bjornmelin
 * @param <T> Type of Object to Store in List
 */
public class CircularLinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    /**
     * Default constructor for Circular Linked List
     */
    public CircularLinkedList() {
        initializeDataFields();
    }

    // Initializes the class's data fields to indicate an empty list.
    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * toString method for Circular Linked List
     * 
     * @return String denoting all values in the list
     */
    public String toString() {
        String output = "Data in the list(" + getLength() + "):\n";
        Node curr = firstNode;
        for (int i = 1; i <= numberOfEntries; i++) {
            output += "\t" + (i) + ":\t" + curr.data + "\n";
            curr = curr.next;
        }
        return output;
    }

    @Override
    public void add(T newEntry) {
        // Find end of the list if the list is not empty
        if (firstNode == null) {
            Node newNode = new Node();
            newNode.data = newEntry;
            firstNode = newNode;
            newNode.next = firstNode;
            numberOfEntries++;
            return;
        }
        // If the list is not empty we need to find the end of the list
        Node curr = firstNode;
        for (int i = 1; i < numberOfEntries; i++) {
            curr = curr.next;
        }
        Node newNode = new Node();
        newNode.data = newEntry;
        newNode.next = firstNode;
        curr.next = newNode;
        numberOfEntries++;
    }

    @Override
    public void add(int newPosition, T newEntry) {
        if (newPosition > numberOfEntries) {
            // Add to ending
            add(newEntry);
        } else if (newPosition <= 1) {
            // Add to the front
            Node newNode = new Node();
            newNode.data = newEntry;
            newNode.next = firstNode;
            firstNode = newNode;
            numberOfEntries++;
        } else {
            // Adding to the middle
            Node curr = firstNode;
            for (int i = 1; i < newPosition - 1; i++) {
                curr = curr.next;
            }
            Node newNode = new Node();
            newNode.data = newEntry;
            newNode.next = curr.next;
            curr.next = newNode;
            numberOfEntries++;
        }
    }

    @Override
    public T remove(int givenPosition) {
        if (numberOfEntries == 0) {
            return null;
        }
        if (givenPosition >= numberOfEntries) {
            givenPosition = numberOfEntries;
        } else if (givenPosition <= 1) {
            givenPosition = 1;
        }
        if (givenPosition == 1) {
            Object temp = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
            return (T) temp;
        }
        Node curr = firstNode;
        for (int i = 1; i < givenPosition - 1; i++) {
            curr = curr.next;
        }
        Object temp = curr.next.data;
        curr.next = curr.next.next;
        numberOfEntries--;
        return (T) temp;
    }

    @Override
    public void clear() {
        initializeDataFields();
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        if (givenPosition <= 1) {
            Object temp = firstNode.data;
            firstNode.data = newEntry;
            return (T) temp;
        }
        if (givenPosition > numberOfEntries) {
            givenPosition = numberOfEntries;
        }
        Node curr = firstNode;
        for (int i = 1; i < givenPosition; i++) {
            curr = curr.next;
        }
        Object temp = curr.data;
        curr.data = newEntry;
        return (T) temp;
    }

    @Override
    public T getEntry(int givenPosition) {
        if (numberOfEntries <= 0) {
            return null;
        } else if (givenPosition >= numberOfEntries) {
            givenPosition = numberOfEntries;
        } else if (givenPosition <= 1) {
            givenPosition = 1;
        }
        Node curr = firstNode;
        for (int i = 1; i < givenPosition; i++) {
            curr = curr.next;
        }
        return (T) curr.data;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] output = (T[]) new Object[numberOfEntries];
        Node curr = firstNode;
        int i = 0;
        while (i != numberOfEntries) {
            output[i] = (T) curr.data;
            curr = curr.next;
            i++;
        }
        return output;
    }

    @Override
    public boolean contains(T anEntry) {
        Node curr = firstNode;
        while (curr != null) {
            for (int i = 1; i < numberOfEntries; i++) {
                if (curr.data == anEntry) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries <= 0;
    }

    @Override
    public void reverseData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void circleTest() {
        System.out.println("We are testing the values to see if it is a circular loop.");
        System.out.println("Starting at the first node, we will loop through twice.");
        Node curr = firstNode;
        for (int i = 0; i < numberOfEntries * 2; i++) {
            System.out.println("Present Node Data: " + curr.data);
            curr = curr.next;
        }
    }

    private class Node {
        T data;
        Node next;
    }

    private Node getNodeAt(int givenPosition) {
        assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
        Node currentNode = firstNode;
        currentNode = find(0, givenPosition, currentNode);
        assert currentNode != null;
        return currentNode;
    }

    private Node find(int count, int index, Node curr) {
        if (curr == null)
            return null;
        count++;
        if (count == index)
            return curr;
        return find(count, index, curr.next);
    }
}