# Stack and Queue Elevator Implementation

A Java implementation demonstrating the use of Stack and Queue data structures to simulate an elevator system for moving boxes between floors.

## Overview

The project simulates a building with 5 floors (numbered 0-4) and an elevator system that moves boxes between floors. Each box has a target destination floor, and the elevator's task is to efficiently deliver all boxes to their respective floors.

## Implementation Details

### Data Structures Used

- **Queue**: Represents each floor of the building, holding boxes waiting to be moved
- **Stack**: Represents the elevator, following LIFO (Last In, First Out) principle
- **Array**: Used to organize the queues for each floor

### Classes

1. **MovingBox.java**

   - Represents a box to be moved
   - Properties:
     - referenceNumber: Unique identifier for each box
     - floor: Target floor for delivery

2. **Driver.java**
   - Contains the main simulation logic
   - Creates a building with 5 floors
   - Generates 100 boxes with random destination floors
   - Implements elevator logic using Stack and Queue operations

## Algorithm

The elevator system follows these rules:

1. Maximum capacity of 20 boxes
2. If elevator is empty, it looks for a floor with waiting boxes
3. When stopping at a floor:
   - Unloads all boxes
   - Checks each box:
     - If it's at its target floor, marks as delivered
     - If not, loads it back into the elevator
4. Continues until all boxes are delivered to their target floors

## Usage

Compile and run the Driver class to start the simulation:

```bash
javac data_structures/linear/stack_queue_elevator/Driver.java data_structures/linear/stack_queue_elevator/MovingBox.java
java data_structures.linear.stack_queue_elevator.Driver
```

The program will output:

- Initial building setup
- Number of boxes on first floor
- Target floors for each box
- Delivery progress updates
- Final completion message

## Time Complexity

- Box Creation: O(n) where n is the number of boxes
- Delivery Process: O(n \* f) where:
  - n is the number of boxes
  - f is the number of floors
