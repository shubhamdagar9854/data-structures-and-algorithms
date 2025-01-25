package data_structures.linear.linked_list;

/**
 * A recursive implementation of a circular singly linked list using nodes.
 * This list maintains a circular reference where the last node points back
 * to the first node. All core operations are implemented recursively.
 *
 * <p>
 * The class implements the ListInterface and provides standard list operations:
 * <ul>
 * <li>Add/remove entries at any position</li>
 * <li>Replace entries</li>
 * <li>Check for entry containment</li>
 * <li>Convert to array</li>
 * <li>Full circular traversal testing</li>
 * </ul>
 *
 * @param <T> Type of elements to be stored in the list
 * @author bjornmelin
 * @see ListInterface
 */
public class RecursiveCircularLinkedList<T> implements ListInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    /**
     * Constructs an empty recursive circular linked list.
     * Initializes firstNode to null and numberOfEntries to 0.
     */
    public RecursiveCircularLinkedList() {
        initializeDataFields();
    }

    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Adds a new entry to the end of this list. Entries currently in the list are
     * unaffected. The list's size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    @Override
    public void add(T newEntry) {
        if (isEmpty()) {
            firstNode = new Node(newEntry);
            firstNode.setNextNode(firstNode); // Point to itself in circular list
        } else {
            addRecursive(firstNode, newEntry, firstNode);
        }
        numberOfEntries++;
    }

    /**
     * Recursively finds the last node and adds newEntry after it.
     * 
     * @param current   The current node being examined
     * @param newEntry  The element to add to the list
     * @param firstNode Reference to the first node for circular check
     */
    private void addRecursive(Node current, T newEntry, Node firstNode) {
        if (current.getNextNode() == firstNode) {
            Node newNode = new Node(newEntry);
            current.setNextNode(newNode);
            newNode.setNextNode(firstNode);
        } else {
            addRecursive(current.getNextNode(), newEntry, firstNode);
        }
    }

    /**
     * Adds a new entry at a specified position within this list. Entries originally
     * at and after the specified position are moved one position further down the
     * list.
     * The list's size is increased by 1.
     *
     * @param newPosition An integer that specifies the desired position of the new
     *                    entry.
     * @param newEntry    The object to be added as a new entry.
     * @throws IndexOutOfBoundsException if {@code newPosition} is less than 1 or
     *                                   greater than {@code getLength() + 1}.
     */
    @Override
    public void add(int newPosition, T newEntry) {
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            if (isEmpty()) {
                firstNode = new Node(newEntry);
                firstNode.setNextNode(firstNode);
            } else if (newPosition == 1) {
                Node lastNode = findLastNodeRecursive(firstNode, firstNode);
                Node newNode = new Node(newEntry);
                newNode.setNextNode(firstNode);
                firstNode = newNode;
                lastNode.setNextNode(firstNode);
            } else {
                addRecursive(firstNode, newPosition, 1, newEntry, firstNode);
            }
            numberOfEntries++;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    }

    /**
     * Recursively traverses to the insertion point and adds the new entry.
     * 
     * @param current    The current node being examined
     * @param position   Target position for insertion
     * @param currentPos Current position in traversal
     * @param newEntry   Element to be added
     * @param firstNode  Reference to first node for circular maintenance
     */
    private void addRecursive(Node current, int position, int currentPos, T newEntry, Node firstNode) {
        if (currentPos == position - 1) {
            Node newNode = new Node(newEntry);
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
        } else {
            addRecursive(current.getNextNode(), position, currentPos + 1, newEntry, firstNode);
        }
    }

    /**
     * Removes the entry at a given position from this list. Entries originally
     * after the specified position are moved one position closer to the beginning.
     *
     * @param givenPosition An integer that indicates the position of the entry to
     *                      be removed.
     * @return A reference to the removed entry.
     * @throws IndexOutOfBoundsException if {@code givenPosition} is less than 1 or
     *                                   greater than {@code getLength()}.
     */
    @Override
    public T remove(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            T result;
            if (numberOfEntries == 1) {
                result = firstNode.getData();
                firstNode = null;
            } else if (givenPosition == 1) {
                result = firstNode.getData();
                Node lastNode = findLastNodeRecursive(firstNode, firstNode);
                firstNode = firstNode.getNextNode();
                lastNode.setNextNode(firstNode);
            } else {
                result = removeRecursive(firstNode, givenPosition, 1);
            }
            numberOfEntries--;
            return result;
        }
        throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    }

    /**
     * Recursively traverses to the removal point and removes the entry.
     * 
     * @param current    The current node being examined
     * @param position   Position of node to remove
     * @param currentPos Current position in traversal
     * @return The data from the removed node
     */
    private T removeRecursive(Node current, int position, int currentPos) {
        if (currentPos == position - 1) {
            T result = current.getNextNode().getData();
            current.setNextNode(current.getNextNode().getNextNode());
            return result;
        }
        return removeRecursive(current.getNextNode(), position, currentPos + 1);
    }

    /**
     * Recursively finds the last node in the list.
     * 
     * @param current   The current node being examined
     * @param firstNode Reference to first node for circular check
     * @return The last node in the list
     */
    private Node findLastNodeRecursive(Node current, Node firstNode) {
        if (current.getNextNode() == firstNode)
            return current;
        return findLastNodeRecursive(current.getNextNode(), firstNode);
    }

    /** Removes all entries from this list. */
    @Override
    public void clear() {
        initializeDataFields();
    }

    /**
     * Replaces the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of the entry to
     *                      be replaced.
     * @param newEntry      The object that will replace the entry at the given
     *                      position.
     * @return The original entry that was replaced.
     * @throws IndexOutOfBoundsException if {@code givenPosition} is less than 1 or
     *                                   greater than {@code getLength()}.
     */
    @Override
    public T replace(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return replaceRecursive(firstNode, givenPosition, 1, newEntry);
        }
        throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    }

    /**
     * Recursively traverses to the replacement point and replaces the entry.
     * 
     * @param current    The current node being examined
     * @param position   Position of node to replace
     * @param currentPos Current position in traversal
     * @param newEntry   New data to replace existing data
     * @return The original data that was replaced
     */
    private T replaceRecursive(Node current, int position, int currentPos, T newEntry) {
        if (currentPos == position) {
            T oldEntry = current.getData();
            current.setData(newEntry);
            return oldEntry;
        }
        return replaceRecursive(current.getNextNode(), position, currentPos + 1, newEntry);
    }

    /**
     * Retrieves the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of the desired
     *                      entry.
     * @return A reference to the indicated entry.
     * @throws IndexOutOfBoundsException if {@code givenPosition} is less than 1 or
     *                                   greater than {@code getLength()}.
     */
    @Override
    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return getEntryRecursive(firstNode, givenPosition, 1);
        }
        throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    }

    /**
     * Recursively traverses to the desired position and retrieves the entry.
     * 
     * @param current    The current node being examined
     * @param position   Desired position to retrieve
     * @param currentPos Current position in traversal
     * @return The data at the desired position
     */
    private T getEntryRecursive(Node current, int position, int currentPos) {
        if (currentPos == position) {
            return current.getData();
        }
        return getEntryRecursive(current.getNextNode(), position, currentPos + 1);
    }

    /**
     * Retrieves all entries that are in this list in the order in which they occur
     * in the list.
     *
     * @return A newly allocated array of all the entries in the list. If the list
     *         is empty, the returned array is empty.
     */
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        if (!isEmpty()) {
            toArrayRecursive(firstNode, result, 0, firstNode);
        }
        return result;
    }

    /**
     * Recursively copies list elements to an array.
     * 
     * @param current   The current node being examined
     * @param array     The array to copy elements into
     * @param index     Current index in the array
     * @param firstNode Reference to first node for circular check
     */
    private void toArrayRecursive(Node current, T[] array, int index, Node firstNode) {
        if (index == numberOfEntries)
            return;
        array[index] = current.getData();
        if (current.getNextNode() != firstNode) {
            toArrayRecursive(current.getNextNode(), array, index + 1, firstNode);
        }
    }

    /**
     * Sees whether this list contains a given entry.
     *
     * @param anEntry The object that is the desired entry.
     * @return True if the list contains {@code anEntry}, or false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        if (isEmpty())
            return false;
        return containsRecursive(firstNode, anEntry, firstNode);
    }

    /**
     * Recursively searches for an entry in the list.
     * 
     * @param current   The current node being examined
     * @param entry     The entry to search for
     * @param firstNode Reference to first node for circular check
     * @return true if entry is found, false otherwise
     */
    private boolean containsRecursive(Node current, T entry, Node firstNode) {
        if (current.getData().equals(entry))
            return true;
        if (current.getNextNode() == firstNode)
            return false;
        return containsRecursive(current.getNextNode(), entry, firstNode);
    }

    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currently in the list.
     */
    @Override
    public int getLength() {
        return numberOfEntries;
    }

    /**
     * Sees whether this list is empty.
     *
     * @return True if the list is empty, or false if not.
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Operation is not supported in Circular Singly Linked List.
     *
     * @throws UnsupportedOperationException if the operation is not supported.
     */
    @Override
    public void reverseData() {
        throw new UnsupportedOperationException("Circular Linked List does not support reverse operation.");
    }

    /**
     * FOR DEMONSTRATION PURPOSES ONLY - Tests and prints the circular nature of the
     * list by traversing it twice the number of entries.
     */
    @Override
    public void circleTest() {
        if (!isEmpty()) {
            System.out.println("We are testing the values to see if it is a circular loop.");
            System.out.println("Starting at the first node, we will loop through twice.");
            circleTestRecursive(firstNode, 0);
        }
    }

    /**
     * Recursively traverses the list twice to demonstrate circularity.
     * 
     * @param current The current node being examined
     * @param count   Number of nodes visited so far
     */
    private void circleTestRecursive(Node current, int count) {
        if (count >= numberOfEntries * 2)
            return;
        System.out.println("\tPresent Node Data:\t" + current.getData());
        circleTestRecursive(current.getNextNode(), count + 1);
    }

    /**
     * Returns a string representation of this list.
     *
     * @return A formatted string showing the position and data of each entry in the
     *         list.
     */
    @Override
    public String toString() {
        if (isEmpty())
            return "Data in the list(0):\n";
        return "Data in the list(" + getLength() + "):\n" +
                toStringRecursive(firstNode, 1, firstNode);
    }

    /**
     * Recursively builds a string representation of the list.
     * 
     * @param current   The current node being examined
     * @param position  Current position in the list
     * @param firstNode Reference to first node for circular check
     * @return Formatted string of list entries
     */
    private String toStringRecursive(Node current, int position, Node firstNode) {
        if (position > numberOfEntries)
            return "";
        return "\t" + position + ":\t" + current.getData() + "\n" +
                toStringRecursive(current.getNextNode(), position + 1, firstNode);
    }

    /**
     * Node class for the circular linked list implementation.
     * Each node contains data and a reference to the next node.
     */
    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }

        private T getData() {
            return data;
        }

        private void setData(T newData) {
            data = newData;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }
}
