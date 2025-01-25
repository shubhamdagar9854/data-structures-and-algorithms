package data_structures.linear.linked_list;

/**
 * A class that implements a list of objects using a Single Linked List
 * 
 * @author bjornmelin
 * @param <T> Type of Object to Store in List
 */
public class SingleLinkedList<T> implements ListInterface<T> {
    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;

    /**
     * Default Constructor for a Single Linked List
     */
    public SingleLinkedList() {
        initializeDataFields();
    } // end default constructor

    @Override
    public void clear() {
        initializeDataFields();
    } // end clear

    @Override
    public void add(T newEntry) // OutOfMemoryError possible
    {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
        } else // Add to end of non-empty list
        {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode); // Make last node reference new node
        } // end if

        numberOfEntries++;
    } // end add

    @Override
    public void add(int newPosition, T newEntry) {
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);

            if (newPosition == 1) // Case 1
            {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else // Case 2: list is not empty
            { // and newPosition > 1
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            } // end if

            numberOfEntries++;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    } // end add

    @Override
    public T remove(int givenPosition) {
        T result = null; // Return value

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();

            if (givenPosition == 1) // Case 1: Remove first entry
            {
                result = firstNode.getData(); // Save entry to be removed
                firstNode = firstNode.getNextNode(); // Remove entry
            } else // Case 2: Not first entry
            {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData(); // Save entry to be removed
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter); // Remove entry
            } // end if

            numberOfEntries--; // Update count
            return result; // Return removed entry
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        }
    } // end remove

    @Override
    public T replace(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();

            Node desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        }
    } // end replace

    @Override
    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            return getNodeAt(givenPosition).getData();
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        }
    } // end getEntry

    @Override
    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        result = copy(result, currentNode, index);

        return result;
    } // end toArray

    /**
     * This method recursively copies data from the linked list to an Array
     * 
     * @param newArray Array which will eventually contain the elements in the list
     * @param curr     Node pointing to the current spot in the list
     * @param index    value for where we are in the list
     * @return The updated array which now contains all the elements in the list
     */
    private T[] copy(T[] newArray, Node curr, int index) {
        if (index == numberOfEntries) {
            return newArray;
        }

        newArray = copy(newArray, curr.getNextNode(), index + 1);
        newArray[index] = curr.getData();
        return newArray;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        if (find(anEntry, currentNode) != null)
            found = true;

        return found;
    } // end contains

    /**
     * Recursively find a given data entry
     * 
     * @param entry Data to find
     * @param curr  Current node to look at
     * @return the Data we found (or a null if not found)
     */
    private T find(T entry, Node curr) {
        if (curr == null)
            return null;

        if (entry.equals(curr.getData()))
            return curr.getData();

        return find(entry, curr.getNextNode());
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    } // end getLength

    @Override
    public boolean isEmpty() {
        boolean result;

        if (numberOfEntries == 0) // Or getLength() == 0
        {
            assert firstNode == null;
            result = true;
        } else {
            assert firstNode != null;
            result = false;
        } // end if

        return result;
    } // end isEmpty

    // Initializes the class's data fields to indicate an empty list.
    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    } // end initializeDataFields

    /**
     * Recursively retrieve a given data entry
     * 
     * @param index Position to retrieve
     * @param curr  Current node to look at
     * @return the Data we found (or a null if not found)
     */
    private Node find(int count, int index, Node curr) {
        if (curr == null)
            return null;
        count++;
        if (count == index)
            return curr;

        return find(count, index, curr.getNextNode());
    }

    // Returns a reference to the node at a given position.
    // Precondition: The chain is not empty;
    // 1 <= givenPosition <= numberOfEntries.
    private Node getNodeAt(int givenPosition) {
        assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
        Node currentNode = firstNode;

        // Traverse the chain to locate the desired node
        // (skipped if givenPosition is 1)
        currentNode = find(0, givenPosition, currentNode);

        assert currentNode != null;
        return currentNode;
    } // end getNodeAt

    @Override
    public void reverseData() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void circleTest() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private class Node {
        private T data; // Entry in list
        private Node next; // Link to next node

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData() {
            return data;
        } // end getData

        private void setData(T newData) {
            data = newData;
        } // end setData

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    } // end Node
} // end SingleLinkedList