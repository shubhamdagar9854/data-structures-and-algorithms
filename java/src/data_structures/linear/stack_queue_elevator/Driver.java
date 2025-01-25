package data_structures.linear.stack_queue_elevator;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * Simple Elevator Driver to test Elevator and Building
 * 
 * @author bjornmelin
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creates a building 5 levels high using an array of queues starting at floor 0
        Queue<MovingBox>[] building = new Queue[5]; // Declares and creates an array of Queues
        for (int i = 0; i <= 4; i++) {
            building[i] = new LinkedList(); // Creates a linked list based queue inside each element of the array of
                                            // queues
        }
        System.out.println("A building has been created with " + building.length + " floors numbered floor 0-4\n");

        // Creates 100 moving boxes #1-100 w/ random destination floors (2-5) (1-4 to
        // fit into the building array) in on the first floor
        Random gen = new Random(); // Allows us to create random destination floors
        MovingBox[] boxes = new MovingBox[100];
        for (int i = 0; i <= 99; i++) {
            boxes[i] = new MovingBox();
            boxes[i].setReferenceNumber(i); // Sets reference number for e/ moving box 1-100 sequentially
            boxes[i].setFloor(gen.nextInt(4 - 1 + 1) + 1); // Sets the floor number b/w 1-4
            building[0].add(boxes[i]); // Adds each moving box to the first floor of the building
        }
        System.out.println(
                "The current number of Moving Boxes on floor 1 of the building is: \t" + building[0].size() + "\n");
        System.out.println(
                "------THE FLOOR NUMBER EACH BOX ON THE FIRST FLOOR WANTS TO GO TO IS: ------" + "\n" + building[0]);
        System.out.println("\n\n\n");

        // Uses a stack to move movingboxes between floors
        Stack<MovingBox> elevator = new Stack();
        int maxSize = 20; // Max amount of moving boxes on the elevator
        int delivered = 0;

        while (delivered < boxes.length) {
            int isPeople = 0; // int used to denote the floor in which there are people

            if (elevator.isEmpty()) // if elevator is empty, should go tofloor with moving boxes
            {
                for (int i = 0; i <= 4; i++) // Looks through 5 floors of building looking for one thats not empty
                {
                    if (building[i].peek() == null) // If peek returns null, then there are no people on the floor. Move
                                                    // to next floor
                    {
                        // Nothing happens if no people on the floor
                    } else // if peek does not return null, then the floor has people on it. Save that
                           // floor
                    {
                        isPeople = i; // If a floor has people on it, this shows that floor i has people
                    }
                }
            } else // If not empty, peek() and use top box destination
            {
                // Think of this line below as checking the floor the first person in an
                // elevator is going to
                elevator.peek().getFloor(); // Looks at the floor of the box on top of the stack and gets the floor its
                                            // going to
                isPeople = elevator.peek().getFloor(); // Tells elevator there should be people on the floor the first
                                                       // box is going to
                System.out.println("\n\n-------- NEXT FLOOR TO DELIVER TO: " + isPeople + " ---------");
                System.out.println("--- THE NUMBER OF BOXES ON ELEVATOR IS: " + elevator.size() + " ---");
            }

            /**
             * When the Elevator stops at a floor:
             */
            while (!elevator.isEmpty()) // While the elevator is not empty, dump all the boxes in the elevator out onto
                                        // that floor's queue
            {
                building[isPeople].add(elevator.pop()); // Goes to the floor the first box wants to go to and removes
                                                        // everyone from elevator onto that floor
            }

            // If box is on the correct floor, do NOT put it back on the elevator
            while (elevator.size() < maxSize && !building[isPeople].isEmpty()) // Fill elevator, loop pushes until the
                                                                               // elevator is FULL or queue for current
                                                                               // floor is empty
            {
                if (building[isPeople].peek().getFloor() == isPeople) {
                    System.out.println("\tMoving Box: " + building[isPeople].peek().getReferenceNumber()
                            + " has been DELIVERED to traget floor.");
                    building[isPeople].poll();
                    delivered++;
                } else {
                    System.out.println("\tPutting Moving Box: " + building[isPeople].peek().getReferenceNumber()
                            + " back onto the elevator.  There target floor is: "
                            + building[isPeople].peek().getFloor());
                    elevator.add(building[isPeople].poll()); // Removes people from the floor and adds them onto the
                                                             // elevator
                }
            }
        }
        System.out.println("\n\n-----ALL MOVING BOXES HAVE BEEN DELIVERED-----");
    }
}