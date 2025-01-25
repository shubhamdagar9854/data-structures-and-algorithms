package data_structures.linear.elevator;

/**
 * Elevator Rider Object
 * 
 * @author bjornmelin
 */
public class ElevatorRider {

    private int employeeNumber; // Number assigned to each employee
    private int frustration; // Number assigned to denote frustration level of each rider
    private int targetFloor; // Floor that rider wants to get off on
    private int homeFloor; // Home floor, used for Night Mode to deliver Day Shifters

    /**
     * Default constructor for Elevator Rider
     */
    public ElevatorRider() {
        // Sets all variables to 0 (initializes them)
        employeeNumber = 0;
        frustration = 0;
        targetFloor = 0;
    }

    /**
     * toString method for Elevator Rider
     * 
     * @return String denoting Elevator Rider data
     */
    public String toString() {
        String output = "\t\t{ Employee Number: " + getEmployeeNumber() + "\tHome Floor: " + getHomeFloor()
                + "\tTarget Floor: " + getTargetFloor() + "\t   Frustration: " + getFrustration() + " }\n";
        return output;
    }

    /**
     * Set method for Employee Number
     * 
     * @param inEmployeeNumber int denoting the number being assigned to the
     *                         employee
     */
    public void setEmployeeNumber(int inEmployeeNumber) {
        employeeNumber = inEmployeeNumber;
    }

    /**
     * Get method for Employee Number
     * 
     * @return int denoting an employees assigned number
     */
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * Set method for Frustration level of an elevator rider
     * 
     * @param inFrustration int denoting an elevator riders frustration
     */
    public void setFrustration(int inFrustration) {
        frustration = inFrustration;
    }

    /**
     * Get method for Frustration
     * 
     * @return int denoting an elevator riders frustration level
     */
    public int getFrustration() {
        return frustration;
    }

    /**
     * Raises the Elevator Riders frustration by 1 when method is called
     */
    public void RaiseFrustraion() {
        frustration += 1;
    }

    /**
     * Set method for Target Floor
     * 
     * @param inTargetFloor int denoting the floor an elevator rider wants to get
     *                      off on
     */
    public void setTargetFloor(int inTargetFloor) {
        targetFloor = inTargetFloor;
    }

    /**
     * Get method for Target Floor
     * 
     * @return int denoting the target floor assigned to the elevator rider
     */
    public int getTargetFloor() {
        return targetFloor;
    }

    /**
     * Set method for Home Floor of Elevator Riders
     * 
     * @param inHomeFloor int denoting the home floor of an elevator rider
     */
    public void setHomeFloor(int inHomeFloor) {
        homeFloor = inHomeFloor;
    }

    /**
     * Get method for Home Floor
     * 
     * @return int denoting the home floor assigned to the elevator rider
     */
    public int getHomeFloor() {
        return homeFloor;
    }
}