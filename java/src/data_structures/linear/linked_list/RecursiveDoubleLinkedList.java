package data_structures.linear.linked_list;

/**
 * A recursive implementation of a Double Linked List
 *
 * @author bjornmelin
 * @param <T> Type of Object to Store in List
 */
public class RecursiveDoubleLinkedList<T> implements ListInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    /**
     * Default constructor for RecursiveDoubleLinkedList.
     * Initializes an empty list.
     */
    public RecursiveDoubleLinkedList() {
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
        if (isEmpty()) {
            firstNode = new Node(newEntry);
        } else {
            addRecursive(firstNode, newEntry);
        }
        numberOfEntries++;
    }

    /**
     * Recursively adds a new entry to the end of the list.
     *
     * @param current  The current node being processed in the recursion.
     * @param newEntry The object to be added as a new entry.
     */
    private void addRecursive(Node current, T newEntry) {
        if (current.getNextNode() == null) {
            Node newNode = new Node(newEntry);
            current.setNextNode(newNode);
            newNode.setPreviousNode(current);
        } else {
            addRecursive(current.getNextNode(), newEntry);
        }
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
            if (newPosition == 1) {
                Node newNode = new Node(newEntry);
                newNode.setNextNode(firstNode);
                if (firstNode != null) {
                    firstNode.setPreviousNode(newNode);
                }
                firstNode = newNode;
            } else {
                addRecursive(firstNode, newPosition, 1, newEntry);
            }
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
     */
    private void addRecursive(Node current, int position, int currentPos, T newEntry) {
        if (currentPos == position - 1) {
            Node newNode = new Node(newEntry);
            newNode.setNextNode(current.getNextNode());
            newNode.setPreviousNode(current);
            if (current.getNextNode() != null) {
                current.getNextNode().setPreviousNode(newNode);
            }
            current.setNextNode(newNode);
        } else {
            addRecursive(current.getNextNode(), position, currentPos + 1, newEntry);
        }
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
            T result;
            if (givenPosition == 1) {
                result = firstNode.getData();
                firstNode = firstNode.getNextNode();
                if (firstNode != null) {
                    firstNode.setPreviousNode(null);
                }
            } else {
                result = removeRecursive(firstNode, givenPosition, 1);
            }
            numberOfEntries--;
            return result;
        }
        throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    }

    /**
     * Recursively removes an entry at a given position.
     *
     * @param current    The current node being processed.
     * @param position   The position of the entry to remove.
     * @param currentPos The current position during recursion.
     * @return The removed entry.
     */
    private T removeRecursive(Node current, int position, int currentPos) {
        if (currentPos == position - 1) {
            T result = current.getNextNode().getData();
            current.setNextNode(current.getNextNode().getNextNode());
            if (current.getNextNode() != null) {
                current.getNextNode().setPreviousNode(current);
            }
            return result;
        }
        return removeRecursive(current.getNextNode(), position, currentPos + 1);
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
            return replaceRecursive(firstNode, givenPosition, 1, newEntry);
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
     * @return The original entry that was replaced.
     */
    private T replaceRecursive(Node current, int position, int currentPos, T newEntry) {
        if (currentPos == position) {
            T oldEntry = current.getData();
            current.setData(newEntry);
            return oldEntry;
        }
        return replaceRecursive(current.getNextNode(), position, currentPos + 1, newEntry);
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
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        toArrayRecursive(firstNode, result, 0);
        return result;
    }

    /**
     * Recursively populates an array with the list's entries.
     *
     * @param current The current node.
     * @param array   The array to populate.
     * @param index   The current index in the array.
     */
    private void toArrayRecursive(Node current, T[] array, int index) {
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
        if (current.getData().equals(entry))
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
     * Prints the reversed data of this list. (Recursive implementation)
     * Not actually reversing the list, just printing in reverse order.
     */
    public void reverseData() {
        if (!isEmpty()) {
            Node lastNode = findLastNodeRecursive(firstNode);
            System.out.println("The last item on the list is " + lastNode.getData());
            System.out.println("Moving down the nodes in the list in reverse order: ");
            reverseDataRecursive(lastNode);
            System.out.println();
        }
    }

    /**
     * Recursively finds the last node in the list.
     *
     * @param current The current node.
     * @return The last node of the list.
     */
    private Node findLastNodeRecursive(Node current) {
        if (current.getNextNode() == null)
            return current;
        return findLastNodeRecursive(current.getNextNode());
    }

    /**
     * Recursively prints the data of the list in reverse order, starting from the
     * last node.
     *
     * @param current The current node, initially the last node.
     */
    private void reverseDataRecursive(Node current) {
        if (current == null)
            return;
        System.out.println("\tPresent Node Data:\t" + current.getData());
        reverseDataRecursive(current.getPreviousNode());
    }

    @Override
    /**
     * Unsupported operation for Double Linked List.
     * 
     * @throws UnsupportedOperationException always
     */
    public void circleTest() {
        throw new UnsupportedOperationException("Double Linked List does not support circle test.");
    }

    /**
     * Returns a string representation of this list.
     *
     * @return A formatted string showing all entries in the list.
     */
    public String toString() {
        return "Data in the list(" + getLength() + "):\n" + toStringRecursive(firstNode, 1);
    }

    /**
     * Recursively builds a string representation of the list.
     *
     * @param current  The current node.
     * @param position The current position in the list.
     * @return A string representation of the current node and the rest of the list.
     */
    private String toStringRecursive(Node current, int position) {
        if (current == null)
            return "";
        return "\t" + position + ":\t" + current.getData() + "\n"
                + toStringRecursive(current.getNextNode(), position + 1);
    }

    /**
     * Inner class Node for RecursiveDoubleLinkedList.
     * Represents a node with data, next, and previous node references.
     */
    private class Node {
        private T data;
        private Node next;
        private Node previous;

        /**
         * Constructor for Node with data.
         *
         * @param dataPortion The data to be stored in the node.
         */
        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
            previous = null;
        }

        /**
         * Constructor for Node with data, next, and previous nodes.
         *
         * @param dataPortion  The data to be stored in the node.
         * @param nextNode     The next node in the list.
         * @param previousNode The previous node in the list.
         */
        private Node(T dataPortion, Node nextNode, Node previousNode) {
            data = dataPortion;
            next = nextNode;
            previous = previousNode;
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

        /**
         * Gets the previous node.
         *
         * @return The previous node in the list.
         */
        private Node getPreviousNode() {
            return previous;
        }

        /**
         * Sets the previous node.
         *
         * @param previousNode The node to be set as the previous node.
         */
        private void setPreviousNode(Node previousNode) {
            previous = previousNode;
        }
    }
}
