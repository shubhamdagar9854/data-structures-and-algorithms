package data_structures.linear.elevator;

/**
 * Elevator used to move Elevator Rider Objects
 * Using a LinkedStack
 * 
 * @author bjornmelin
 */
public class Elevator {

    private int numberOfEntries;
    private Node top;

    /**
     * Default constructor for elevator
     */
    public Elevator() {
        numberOfEntries = 0;
        top = null;
    }

    /**
     * Node class used to denote entries in the list
     */
    private class Node {
        // Local variables for node data and next node
        ElevatorRider data;
        Node next;
    }

    /**
     * To String method for Elevator
     * 
     * @return String denoting the Elevators information
     */
    public String toString() {
        String output = "PRINTING ELEVATOR:\n";
        Node curr = top;
        while (curr != null) {
            output += "\t" + curr.data + "\n";
            curr = curr.next;
        }
        output += "Current size is: " + size() + "\n";
        return output;
    }

    /**
     * Raises the frustration of an Elevator Rider (Node)
     */
    public void raiseFrustration() {
        Node curr = top;
        if (isEmpty()) {
            // If elevator is empty, do nothing
        }
        while (curr != null) // While top Node is not null
        {
            // Loop to raise riders on elevators frustration
            curr.data.RaiseFrustraion(); // Calls on raise frustration method in Elevator Rider Class to raise
                                         // frustration by 1
            curr = curr.next;
        }
    }

    /**
     * Pushes a new person into the elevator and makes them the new top person (in
     * front)
     * 
     * @param entry Elevator Rider to be added to the elevator
     */
    public void push(ElevatorRider entry) {
        Node newNode = new Node();
        newNode.data = entry;
        newNode.next = top;
        top = newNode;
        numberOfEntries++;
    }

    /**
     * Removes the first person in the Elevator (in front)
     * 
     * @return the Elevator Rider that was removed from the elevator
     */
    public ElevatorRider pop() {
        if (isEmpty())
            return null;
        ElevatorRider temp = top.data;
        top.data = null;
        top = top.next;
        numberOfEntries--;
        return temp;
    }

    /**
     * Peeks to see what's on top of the elevator (in front)
     * 
     * @return The Elevator rider that is in front of the elevator
     */
    public ElevatorRider peek() {
        // 2 cases, 1 if empty 1 if not empty
        if (isEmpty())
            return null;
        return top.data; // Checks to see whats on top
    }

    /**
     * Current number of people on the elevator
     * 
     * @return int denoting the current number of people in the elevator
     */
    public int size() {
        return numberOfEntries;
    }

    /**
     * Checks to see if the elevator is empty
     * 
     * @return boolean: true if empty, false otherwise
     */
    public boolean isEmpty() {
        if (numberOfEntries == 0)
            return true;
        return false;
    }

    /**
     * Clears all people from the elevator
     */
    public void clear() {
        numberOfEntries = 0;
    }
}