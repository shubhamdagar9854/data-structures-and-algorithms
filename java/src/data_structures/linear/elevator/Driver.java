package data_structures.linear.elevator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Driver to set up and run the Elevator Simulator
 * Test a morning mode and a night mode
 * 
 * @author bjornmelin
 */
public class Driver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creates a building 5 levels high using an array of queues starting at floor 0
        Queue<ElevatorRider>[] building = new Queue[5]; // Declares and creates an array of Queues
        for (int i = 0; i < building.length; i++) {
            building[i] = new LinkedList(); // Creates a linked list based queue inside each element of the array of
                                            // queues
        }
        System.out.println("A building has been created with " + building.length + " floors numbered floor 0-4\n");

        runMorningMode(building);
        clearBuilding(building);
        runNightMode(building);
    }

    /**
     * Method used to Shuffle an Array of elevator riders
     * Called upon in main method with purpose of randomizing deliveries
     * 
     * @param entries an Array of elevator riders
     */
    static void shuffleArray(ElevatorRider[] entries) {
        Random gen = new Random();
        for (int i = 0; i < entries.length; i++) {
            int index = gen.nextInt(i + 1);
            ElevatorRider rider = entries[index];
            entries[index] = entries[i];
            entries[i] = rider;
        }
    }

    /**
     * Runs the morning mode simulation
     * 
     * @param building The array of queues representing floors in the building
     */
    private static void runMorningMode(Queue<ElevatorRider>[] building) {
        System.out.println("\n\n\n\t=============================== MORNING MODE ===============================\n\n");

        // Create and initialize day shift workers
        ElevatorRider[] dayShifters = createDayShiftWorkers();
        ElevatorRider[] nightShifters = createNightShiftWorkers();

        // Initialize workers on their floors
        distributeNightShiftWorkers(building, nightShifters);

        // Create elevator and run simulation
        Elevator elevator = new Elevator();
        int maxSize = 20;

        // Process night shifters going home
        processNightShiftersGoingHome(building, elevator, maxSize);

        // Process day shifters arriving
        processDayShiftersArriving(building, elevator, dayShifters, maxSize);

        // Display statistics
        displayMorningModeStats(dayShifters, nightShifters);
    }

    /**
     * Runs the night mode simulation
     * 
     * @param building The array of queues representing floors in the building
     */
    private static void runNightMode(Queue<ElevatorRider>[] building) {
        System.out.println("\n\n\t=============================== NIGHT MODE ===============================\n\n");

        // Create and initialize workers
        ElevatorRider[] nightShifters = createNightShiftWorkers();
        ElevatorRider[] dayShifters = createDayShiftWorkersForNight();

        // Initialize workers on ground floor
        for (ElevatorRider rider : nightShifters) {
            building[0].add(rider);
        }

        // Create elevator and run simulation
        Elevator elevator = new Elevator();
        int maxSize = 20;

        // Process night shifters going up
        processNightShiftersGoingUp(building, elevator, maxSize);

        // Process day shifters going home
        processDayShiftersGoingHome(building, elevator, dayShifters, maxSize);

        // Display statistics
        displayNightModeStats(dayShifters, nightShifters);
    }

    // Helper methods to create workers and process movements (implementations
    // omitted for brevity)
    private static ElevatorRider[] createDayShiftWorkers() {
        /* ... */ return new ElevatorRider[0];
    }

    private static ElevatorRider[] createNightShiftWorkers() {
        /* ... */ return new ElevatorRider[0];
    }

    private static ElevatorRider[] createDayShiftWorkersForNight() {
        /* ... */ return new ElevatorRider[0];
    }

    private static void distributeNightShiftWorkers(Queue<ElevatorRider>[] building, ElevatorRider[] workers) {
        /* ... */ }

    private static void processNightShiftersGoingHome(Queue<ElevatorRider>[] building, Elevator elevator, int maxSize) {
        /* ... */ }

    private static void processDayShiftersArriving(Queue<ElevatorRider>[] building, Elevator elevator,
            ElevatorRider[] workers, int maxSize) {
        /* ... */ }

    private static void processNightShiftersGoingUp(Queue<ElevatorRider>[] building, Elevator elevator, int maxSize) {
        /* ... */ }

    private static void processDayShiftersGoingHome(Queue<ElevatorRider>[] building, Elevator elevator,
            ElevatorRider[] workers, int maxSize) {
        /* ... */ }

    private static void displayMorningModeStats(ElevatorRider[] dayShifters, ElevatorRider[] nightShifters) {
        /* ... */ }

    private static void displayNightModeStats(ElevatorRider[] dayShifters, ElevatorRider[] nightShifters) {
        /* ... */ }

    /**
     * Clears all floors in the building
     * 
     * @param building The array of queues representing floors in the building
     */
    private static void clearBuilding(Queue<ElevatorRider>[] building) {
        for (Queue<ElevatorRider> floor : building) {
            floor.clear();
        }
    }
}