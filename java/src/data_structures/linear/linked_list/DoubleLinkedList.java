package data_structures.linear.linked_list;

/**
 * A class that implements a list of objects using a Double Linked List
 * 
 * @author bjornmelin
 * @param <T> Type of Object to Store in List
 */
public class DoubleLinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    /**
     * Default Constructor for a Double Linked List
     */
    public DoubleLinkedList() {
        initializeDataFields();
    }

    // Initializes the class's data fields to indicate an empty list.
    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * toString method for Double Linked List
     * 
     * @return String denoting all values in the list
     */
    public String toString() {
        String output = "Data in the list(" + getLength() + "):\n";
        Node curr = firstNode;
        int i = 1;
        while (curr != null) {
            output += "\t" + (i) + ":\t" + curr.data + "\n";
            i++;
            curr = curr.next;
        }
        return output;
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.data = newEntry;
        Node curr = firstNode;
        newNode.next = null;

        if (firstNode == null) {
            newNode.previous = null;
            firstNode = newNode;
            numberOfEntries++;
            return;
        }
        while (curr.next != null) {
            curr = curr.next;
        }
        if (numberOfEntries == 1) {
            newNode.previous = firstNode;
        } else {
            newNode.previous = curr;
        }
        curr.next = newNode;
        numberOfEntries++;
    }

    @Override
    public void add(int newPosition, T newEntry) {
        if (newPosition >= numberOfEntries) {
            // Add to ending
            add(newEntry);
        } else if (newPosition <= 1) {
            // Add to the front
            Node newNode = new Node(newEntry);
            newNode.data = newEntry;
            newNode.next = firstNode;
            newNode.previous = null;
            firstNode.previous = newNode;
            firstNode = newNode;
            numberOfEntries++;
        } else {
            // Adding to the middle
            Node curr = firstNode;
            for (int i = 1; i < newPosition - 1; i++) {
                curr = curr.next;
            }
            Node newNode = new Node(newEntry);
            newNode.data = newEntry;
            newNode.next = curr.next;
            newNode.previous = curr;
            curr.next = newNode;
            curr = newNode;
            if (curr.next != null) {
                curr.next.previous = newNode;
            }
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
        // Have a valid position
        if (givenPosition == 1) {
            T temp = firstNode.data;
            firstNode = firstNode.next;
            if (numberOfEntries > 1) {
                firstNode.previous = null;
            }
            numberOfEntries--;
            return temp;
        }
        // Not removing the front
        Node curr = firstNode;
        for (int i = 1; i < givenPosition - 1; i++) {
            curr = curr.next;
        }
        T temp = curr.next.data;
        curr.next = curr.next.next;
        if (curr.next != null) {
            curr.next.previous = curr;
        }
        numberOfEntries--;
        return temp;
    }

    @Override
    public void clear() {
        initializeDataFields();
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        if (givenPosition <= 1) {
            T temp = firstNode.data;
            firstNode.data = newEntry;
            return temp;
        }
        if (givenPosition > numberOfEntries) {
            givenPosition = numberOfEntries;
        }
        Node curr = firstNode;
        for (int i = 1; i < givenPosition; i++) {
            curr = curr.next;
        }
        T temp = curr.data;
        curr.data = newEntry;
        return temp;
    }

    @Override
    public T getEntry(int givenPosition) {
        if (numberOfEntries <= 0) {
            return null;
        } else if (givenPosition <= numberOfEntries) {
            givenPosition = numberOfEntries;
        } else if (givenPosition <= 1) {
            givenPosition = 1;
        }
        Node curr = firstNode;
        for (int i = 1; i < givenPosition; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] output = (T[]) new Object[numberOfEntries];
        Node curr = firstNode;
        for (int i = 1; i < numberOfEntries; i++) {
            output[i] = curr.data;
            curr = curr.next;
        }
        return output;
    }

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
        Node curr = firstNode;
        for (int i = 1; i < numberOfEntries; i++) {
            curr = curr.next;
        }
        System.out.println("The last item on the list is " + curr.data);
        System.out.println("Moving down the nodes in the list in reverse order: ");
        for (int i = 0; i < numberOfEntries; i++) {
            System.out.println("Present Node Data: " + curr.data);
            curr = curr.previous;
        }
    }

    @Override
    public void circleTest() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private class Node {
        private T data;
        private Node next;
        private Node previous;

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
            previous = null;
        }

        private Node(T dataPortion, Node nextNode, Node previousNode) {
            data = dataPortion;
            next = nextNode;
            previous = previousNode;
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

        private Node getPreviousNode() {
            return previous;
        }

        private void setPreviousNode(Node previousNode) {
            previous = previousNode;
        }
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
        return find(count, index, curr.getNextNode());
    }

    private T find(T entry, Node curr) {
        if (curr == null)
            return null;
        if (entry.equals(curr.getData()))
            return curr.getData();
        return find(entry, curr.getNextNode());
    }
}