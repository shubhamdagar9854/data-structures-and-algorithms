package data_structures.linear.linked_list;

/**
 * A recursive implementation of a Single Linked List
 *
 * @author bjornmelin
 * @param <T> Type of Object to Store in List
 */
public class RecursiveSingleLinkedList<T> implements ListInterface<T> {
    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;

    /**
     * Default constructor for RecursiveSingleLinkedList.
     * Initializes an empty list.
     */
    public RecursiveSingleLinkedList() {
        initializeDataFields();
    }

    // Initializes the class's data fields to indicate an empty list.
    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    /**
     * Adds a new entry to the end of this list.
     * Entries currently in the list are unaffected.
     * The list's size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    public void add(T newEntry) {
        firstNode = addRecursive(firstNode, newEntry);
        numberOfEntries++;
    }

    /**
     * Recursively adds a new entry to the end of the list.
     *
     * @param current  The current node being processed in the recursion.
     * @param newEntry The object to be added as a new entry.
     * @return The updated node, which is the current node if not at the end, or a
     *         new node if current is null.
     */
    private Node addRecursive(Node current, T newEntry) {
        if (current == null) {
            return new Node(newEntry);
        }
        if (current.getNextNode() == null) {
            current.setNextNode(new Node(newEntry));
            return current;
        }
        current.setNextNode(addRecursive(current.getNextNode(), newEntry));
        return current;
    }

    @Override
    /**
     * Adds a new entry at a specified position within this list.
     * Entries originally at and after the specified position are shifted down the
     * list.
     * The list's size is increased by 1.
     *
     * @param newPosition An integer that specifies the desired position of the new
     *                    entry.
     * @param newEntry    The object to be added as a new entry.
     * @throws IndexOutOfBoundsException if the given position is out of range.
     */
    public void add(int newPosition, T newEntry) {
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            firstNode = addRecursive(firstNode, newPosition, 1, newEntry);
            numberOfEntries++;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    }

    /**
     * Recursively adds a new entry at a specified position.
     *
     * @param current    The current node being processed in the recursion.
     * @param position   The desired position for the new entry.
     * @param currentPos The current position in the list during recursion.
     * @param newEntry   The object to be added.
     * @return The updated node, which may be a new node if adding at the beginning.
     */
    private Node addRecursive(Node current, int position, int currentPos, T newEntry) {
        if (position == 1) {
            Node newNode = new Node(newEntry);
            newNode.setNextNode(current);
            return newNode;
        }
        if (currentPos == position - 1) {
            Node newNode = new Node(newEntry);
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
            return current;
        }
        current.setNextNode(addRecursive(current.getNextNode(), position, currentPos + 1, newEntry));
        return current;
    }

    @Override
    /**
     * Removes the entry at a given position from this list.
     * Entries originally after the given position are shifted up.
     * The list's size is decreased by 1.
     *
     * @param givenPosition An integer that indicates the position of the entry to
     *                      be
     *                      removed.
     * @return A reference to the removed entry or null if list was empty.
     * @throws IndexOutOfBoundsException if the given position is out of range.
     */
    public T remove(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Object[] result = new Object[1]; // To store removed value
            firstNode = removeRecursive(firstNode, givenPosition, 1, result);
            numberOfEntries--;
            @SuppressWarnings("unchecked")
            T removedEntry = (T) result[0];
            return removedEntry;
        }
        throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    }

    /**
     * Recursively removes an entry at a given position.
     *
     * @param current    The current node being processed.
     * @param position   The position of the entry to remove.
     * @param currentPos The current position during recursion.
     * @param result     An array to store the removed entry.
     * @return The updated node after removal.
     */
    private Node removeRecursive(Node current, int position, int currentPos, Object[] result) {
        if (position == 1) {
            result[0] = current.getData();
            return current.getNextNode();
        }
        if (currentPos == position - 1) {
            result[0] = current.getNextNode().getData();
            current.setNextNode(current.getNextNode().getNextNode());
            return current;
        }
        current.setNextNode(removeRecursive(current.getNextNode(), position, currentPos + 1, result));
        return current;
    }

    @Override
    /**
     * Removes all entries from this list.
     */
    public void clear() {
        initializeDataFields();
    }

    @Override
    /**
     * Replaces the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of the entry to
     *                      be
     *                      replaced.
     * @param newEntry      The object that will replace the entry at the given
     *                      position.
     * @return The original entry that was replaced.
     * @throws IndexOutOfBoundsException if the given position is out of range.
     */
    public T replace(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Object[] result = new Object[1];
            replaceRecursive(firstNode, givenPosition, 1, newEntry, result);
            @SuppressWarnings("unchecked")
            T replacedEntry = (T) result[0];
            return replacedEntry;
        }
        throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    }

    /**
     * Recursively replaces the entry at a given position.
     *
     * @param current    The current node.
     * @param position   The position to replace.
     * @param currentPos Current position in recursion.
     * @param newEntry   The new entry to replace with.
     * @param result     Array to store the replaced entry.
     */
    private void replaceRecursive(Node current, int position, int currentPos, T newEntry, Object[] result) {
        if (currentPos == position) {
            result[0] = current.getData();
            current.setData(newEntry);
            return;
        }
        replaceRecursive(current.getNextNode(), position, currentPos + 1, newEntry, result);
    }

    @Override
    /**
     * Retrieves the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of the desired
     *                      entry.
     * @return A reference to the indicated entry or null if list was empty.
     * @throws IndexOutOfBoundsException if the given position is out of range.
     */
    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return getEntryRecursive(firstNode, givenPosition, 1);
        }
        throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    }

    /**
     * Recursively retrieves the entry at a given position.
     *
     * @param current    The current node.
     * @param position   The position to retrieve.
     * @param currentPos Current position in recursion.
     * @return The entry at the given position.
     */
    private T getEntryRecursive(Node current, int position, int currentPos) {
        if (currentPos == position) {
            return current.getData();
        }
        return getEntryRecursive(current.getNextNode(), position, currentPos + 1);
    }

    @Override
    /**
     * Retrieves all entries that are in this list in the order in which they occur
     * in the list.
     *
     * @return A newly allocated array of all the entries in the list. If the list
     *         is empty, the returned array is empty.
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        Object[] result = new Object[numberOfEntries];
        toArrayRecursive(firstNode, result, 0);
        return (T[]) result;
    }

    /**
     * Recursively populates an array with the list's entries.
     *
     * @param current The current node.
     * @param array   The array to populate.
     * @param index   The current index in the array.
     */
    private void toArrayRecursive(Node current, Object[] array, int index) {
        if (current == null)
            return;
        array[index] = current.getData();
        toArrayRecursive(current.getNextNode(), array, index + 1);
    }

    @Override
    /**
     * Sees whether this list contains a given entry.
     *
     * @param anEntry The object that is the desired entry.
     * @return True if the list contains anEntry, or false if not.
     */
    public boolean contains(T anEntry) {
        return containsRecursive(firstNode, anEntry);
    }

    /**
     * Recursively checks if the list contains a given entry.
     *
     * @param current The current node.
     * @param entry   The entry to search for.
     * @return True if the entry is found, false otherwise.
     */
    private boolean containsRecursive(Node current, T entry) {
        if (current == null)
            return false;
        T currentData = current.getData();
        if (currentData != null && currentData.equals(entry))
            return true;
        return containsRecursive(current.getNextNode(), entry);
    }

    @Override
    /**
     * Gets the length of this list.
     *
     * @return An integer that represents the number of entries currently in the
     *         list.
     */
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    /**
     * Sees whether this list is empty.
     *
     * @return True if the list is empty, or false if not.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    /**
     * Returns a string representation of the list data in reverse order.
     * 
     * @return A string containing the list data in reverse order.
     */
    public void reverseData() {
        if (!isEmpty()) {
            StringBuilder result = new StringBuilder();
            result.append("List data in reverse order: ");
            reverseDataRecursive(firstNode, result);
            System.out.println(result.toString().trim());
        }
    }

    /**
     * Recursive helper method to build reversed list data string.
     *
     * @param current The current node.
     * @param result  The StringBuilder to accumulate the reversed data.
     */
    private void reverseDataRecursive(Node current, StringBuilder result) {
        if (current == null)
            return;
        reverseDataRecursive(current.getNextNode(), result);
        result.append(current.getData()).append(" ");
    }

    @Override
    /**
     * Unsupported operation for Single Linked List.
     * 
     * @throws UnsupportedOperationException always
     */
    public void circleTest() {
        throw new UnsupportedOperationException("Single Linked List does not support circle test.");
    }

    /**
     * Inner class Node for RecursiveSingleLinkedList.
     * Represents a node in the single linked list.
     */
    private class Node {
        private T data;
        private Node next;

        /**
         * Constructor for Node with data.
         *
         * @param dataPortion The data to be stored in the node.
         */
        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }

        /**
         * Constructor for Node with data and next node.
         *
         * @param dataPortion The data to be stored in the node.
         * @param nextNode    The next node in the list.
         */
        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        /**
         * Gets the data of this node.
         *
         * @return The data stored in the node.
         */
        private T getData() {
            return data;
        }

        /**
         * Sets the data of this node.
         *
         * @param newData The new data to be stored in the node.
         */
        private void setData(T newData) {
            data = newData;
        }

        /**
         * Gets the next node.
         *
         * @return The next node in the list.
         */
        private Node getNextNode() {
            return next;
        }

        /**
         * Sets the next node.
         *
         * @param nextNode The node to be set as the next node.
         */
        private void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }
}
