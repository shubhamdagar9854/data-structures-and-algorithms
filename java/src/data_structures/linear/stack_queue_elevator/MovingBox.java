package data_structures.linear.stack_queue_elevator;

/**
 * This is a Moving Box Object
 * 
 * @author bjornmelin
 */
public class MovingBox {

    private int referenceNumber; // Reference number to the moving box
    private int floor; // Floor to be delivered to

    /**
     * Default constructor for Moving Box, initializes variables
     */
    public MovingBox() {
        referenceNumber = 0; // reference number for each moving box
        floor = 0;
    }

    /**
     * toString method for Moving Box Object
     * 
     * @return String denoting the floor number and reference number assigned to
     *         each Moving Box
     */
    public String toString() {
        String output = "\tThe floor that Moving Box number " + getReferenceNumber() + " wants to go to is floor: "
                + getFloor() + "\n";
        return output;
    }

    /**
     * Get method for Reference Number
     * 
     * @return int denoting the reference number for the moving box
     */
    public int getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Set method for Reference Number
     * 
     * @param inReferenceNumber int denoting the reference number to set to a moving
     *                          box
     */
    public void setReferenceNumber(int inReferenceNumber) {
        referenceNumber = inReferenceNumber;
    }

    /**
     * Get method for Floor
     * 
     * @return int denoting the floor the moving box will be delivered to
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Set method for Floor
     * 
     * @param inFloor int denoting the floor to deliver the moving box to
     */
    public void setFloor(int inFloor) {
        floor = inFloor;
    }
}