package data_structures.linear.linked_list;

/**
 * A recursive implementation of a Circular Double Linked List.
 *
 * This class implements a circular doubly linked list using recursion. It
 * supports adding,
 * removing, replacing, getting entries, converting to array, checking for
 * containment, and
 * clearing the list. It also includes methods for testing the circular nature
 * of the list and
 * reversing the data for demonstration purposes.
 *
 * @param <T> Type of Object to Store in List
 * @author bjornmelin
 */
public class RecursiveCircularDoubleLinkedList<T> implements ListInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    /** Default constructor to create an empty RecursiveCircularDoubleLinkedList. */
    public RecursiveCircularDoubleLinkedList() {
        initializeDataFields();
    }

    /** Initializes the class data fields to default values. */
    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Adds a new entry to the end of this list. Entries currently in the list are
     * unaffected. The
     * list's size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    @Override
    public void add(T newEntry) {
        if (isEmpty()) {
            firstNode = new Node(newEntry);
            firstNode.setNextNode(firstNode);
            firstNode.setPreviousNode(firstNode);
        } else {
            addRecursive(firstNode, newEntry, firstNode);
        }
        numberOfEntries++;
    }

    /**
     * Adds a new entry recursively to the end of the circular doubly linked list.
     *
     * @param current   The current node being processed in the recursion.
     * @param newEntry  The new entry to add.
     * @param firstNode The first node of the list, used to detect the end of the
     *                  list.
     */
    private void addRecursive(Node current, T newEntry, Node firstNode) {
        if (current.getNextNode() == firstNode) {
            Node newNode = new Node(newEntry);
            current.setNextNode(newNode);
            newNode.setPreviousNode(current);
            newNode.setNextNode(firstNode);
            firstNode.setPreviousNode(newNode);
        } else {
            addRecursive(current.getNextNode(), newEntry, firstNode);
        }
    }

    /**
     * Adds a new entry at a specified position within this list. Entries originally
     * at and after
     * the specified position are moved one position further down the list. The
     * list's size is
     * increased by 1.
     *
     * @param newPosition An integer that specifies the desired position of the new
     *                    entry.
     * @param newEntry    The object to be added as a new entry.
     * @throws IndexOutOfBoundsException if {@code newPosition} is less than 1 or
     *                                   greater than
     *                                   {@code getLength() + 1}.
     */
    @Override
    public void add(int newPosition, T newEntry) {
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            if (isEmpty()) {
                firstNode = new Node(newEntry);
                firstNode.setNextNode(firstNode);
                firstNode.setPreviousNode(firstNode);
            } else if (newPosition == 1) {
                Node lastNode = findLastNodeRecursive(firstNode, firstNode);
                Node newNode = new Node(newEntry);
                newNode.setNextNode(firstNode);
                newNode.setPreviousNode(lastNode);
                firstNode.setPreviousNode(newNode);
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
     * Adds a new entry at a given position recursively.
     *
     * @param current    The current node being processed.
     * @param position   The position where the new entry should be added.
     * @param currentPos The current position in the list during recursion.
     * @param newEntry   The new entry to be added.
     * @param firstNode  The first node of the list.
     */
    private void addRecursive(Node current, int position, int currentPos, T newEntry, Node firstNode) {
        if (currentPos == position - 1) {
            Node newNode = new Node(newEntry);
            newNode.setNextNode(current.getNextNode());
            newNode.setPreviousNode(current);
            current.getNextNode().setPreviousNode(newNode);
            current.setNextNode(newNode);
        } else {
            addRecursive(current.getNextNode(), position, currentPos + 1, newEntry, firstNode);
        }
    }

    /**
     * Removes the entry at a given position from this list. Entries originally
     * after the specified
     * position are moved one position closer to the beginning.
     *
     * @param givenPosition An integer that indicates the position of the entry to
     *                      be removed.
     * @return A reference to the removed entry, or null if either the list was
     *         empty, {@code
     *     givenPosition} is invalid.
     * @throws IndexOutOfBoundsException if {@code givenPosition} is less than 1 or
     *                                   greater than
     *                                   {@code getLength()}.
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
                firstNode.setPreviousNode(lastNode);
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
     * Removes an entry at a given position recursively.
     *
     * @param current    The current node being processed.
     * @param position   The position of the entry to be removed.
     * @param currentPos The current position in the list during recursion.
     * @return The removed entry.
     */
    private T removeRecursive(Node current, int position, int currentPos) {
        if (currentPos == position - 1) {
            T result = current.getNextNode().getData();
            current.setNextNode(current.getNextNode().getNextNode());
            current.getNextNode().setPreviousNode(current);
            return result;
        }
        return removeRecursive(current.getNextNode(), position, currentPos + 1);
    }

    /**
     * Finds the last node in the circular doubly linked list recursively.
     *
     * @param current   The current node being processed.
     * @param firstNode The first node of the list.
     * @return The last node of the list.
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
     *                                   greater than
     *                                   {@code getLength()}.
     */
    @Override
    public T replace(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return replaceRecursive(firstNode, givenPosition, 1, newEntry);
        }
        throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    }

    /**
     * Replaces an entry at a given position recursively.
     *
     * @param current    The current node being processed.
     * @param position   The position of the entry to be replaced.
     * @param currentPos The current position in the list during recursion.
     * @param newEntry   The new entry to replace with.
     * @return The replaced entry.
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
     *                                   greater than
     *                                   {@code getLength()}.
     */
    @Override
    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return getEntryRecursive(firstNode, givenPosition, 1);
        }
        throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    }

    /**
     * Gets an entry at a given position recursively.
     *
     * @param current    The current node being processed.
     * @param position   The position of the entry to retrieve.
     * @param currentPos The current position in the list during recursion.
     * @return The entry at the given position.
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
     *         is empty, the
     *         returned array is empty.
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
     * Converts the list to an array recursively.
     *
     * @param current   The current node being processed.
     * @param array     The array to store the list entries.
     * @param index     The current index in the array.
     * @param firstNode The first node of the list.
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
     * Checks if the list contains a given entry recursively.
     *
     * @param current   The current node being processed.
     * @param entry     The entry to search for.
     * @param firstNode The first node of the list.
     * @return True if the entry is found, false otherwise.
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
     * FOR DEMONSTRATION PURPOSES ONLY - Traverses and prints the data in reverse
     * order using the
     * doubly linked nature of the list.
     *
     * @throws UnsupportedOperationException if the operation is not supported.
     */
    @Override
    public void reverseData() {
        if (!isEmpty()) {
            Node lastNode = findLastNodeRecursive(firstNode, firstNode);
            System.out.println("The last item on the list is " + lastNode.getData());
            System.out.println("Moving down the nodes in the list in reverse order: ");
            reverseDataRecursive(lastNode, numberOfEntries);
        }
    }

    /**
     * Recursively traverses and prints the list data in reverse order.
     *
     * @param current   The current node being processed.
     * @param remaining The number of remaining nodes to process.
     */
    private void reverseDataRecursive(Node current, int remaining) {
        if (remaining <= 0)
            return;
        System.out.println("\tPresent Node Data:\t" + current.getData());
        reverseDataRecursive(current.getPreviousNode(), remaining - 1);
    }

    /**
     * FOR DEMONSTRATION PURPOSES ONLY - Tests and prints the circular nature of the
     * list by
     * traversing it twice the number of entries.
     *
     * @throws UnsupportedOperationException if the operation is not supported.
     */
    @Override
    public void circleTest() {
        if (!isEmpty()) {
            System.out.println("We are testing the values to see if it is a circular loop.");
            System.out.println("Starting at the last node, we will loop backwards 2 times.");
            Node lastNode = findLastNodeRecursive(firstNode, firstNode);
            circleTestRecursive(lastNode, 0);
        }
    }

    /**
     * Recursively tests the circular nature of the list by traversing it twice.
     *
     * @param current The current node being processed.
     * @param count   The current count of nodes traversed.
     */
    private void circleTestRecursive(Node current, int count) {
        if (count >= numberOfEntries * 2)
            return;
        System.out.println("\tPresent Node Data:\t" + current.getData());
        circleTestRecursive(current.getPreviousNode(), count + 1);
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
     * @param current   The current node being processed.
     * @param position  The current position in the list.
     * @param firstNode The first node of the list.
     * @return A string representation of the list from the current position.
     */
    private String toStringRecursive(Node current, int position, Node firstNode) {
        if (position > numberOfEntries)
            return "";
        return "\t" + position + ":\t" + current.getData() + "\n" +
                toStringRecursive(current.getNextNode(), position + 1, firstNode);
    }

    /**
     * Private inner class for creating nodes in the circular doubly linked list.
     */
    private class Node {
        private T data;
        private Node next;
        private Node previous;

        /**
         * Constructs a new node with the given data.
         *
         * @param dataPortion The data to store in this node.
         */
        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
            previous = null;
        }

        /**
         * Gets the data stored in this node.
         *
         * @return The data stored in this node.
         */
        private T getData() {
            return data;
        }

        /**
         * Sets the data stored in this node.
         *
         * @param newData The new data to store.
         */
        private void setData(T newData) {
            data = newData;
        }

        /**
         * Gets the next node in the list.
         *
         * @return The next node.
         */
        private Node getNextNode() {
            return next;
        }

        /**
         * Sets the next node in the list.
         *
         * @param nextNode The node to set as next.
         */
        private void setNextNode(Node nextNode) {
            next = nextNode;
        }

        /**
         * Gets the previous node in the list.
         *
         * @return The previous node.
         */
        private Node getPreviousNode() {
            return previous;
        }

        /**
         * Sets the previous node in the list.
         *
         * @param previousNode The node to set as previous.
         */
        private void setPreviousNode(Node previousNode) {
            previous = previousNode;
        }
    }
}
