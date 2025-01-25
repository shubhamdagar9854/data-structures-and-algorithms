# Elevator Simulation Implementation

A Java implementation that simulates an elevator system in an office building, handling both day and night shift workers while tracking worker frustration levels.

## Overview

This implementation simulates an elevator system in a 5-story office building (floors 0-4) that serves both day shift and night shift workers. The simulation runs in two modes:

1. **Morning Mode**: Night shift workers leave while day shift workers arrive
2. **Night Mode**: Day shift workers leave while night shift workers arrive

## Implementation Details

### Data Structures Used

- **Queue**: Used to represent each floor's waiting area (implemented with `LinkedList`)
- **Stack**: Used for the elevator itself (custom implementation)
- **Array**: Used to organize the building's floors

### Classes

1. **ElevatorRider**

   - Represents an individual worker
   - Tracks:
     - Employee number
     - Frustration level
     - Target floor
     - Home floor

2. **Elevator**

   - Implements a stack-based elevator using a linked structure
   - Features:
     - Maximum capacity of 20 riders
     - Frustration tracking for riders
     - Basic elevator operations (push, pop, peek)

3. **Driver**
   - Controls the simulation
   - Implements both morning and night modes
   - Tracks and reports statistics

### UML Diagram

A UML diagram showing the relationships between classes can be found at [docs/UML.png](docs/UML.png)

## Simulation Details

### Morning Mode

- 350 day shift workers arriving
- 16 night shift workers leaving
- Workers distributed across floors:
  - Floor 4: 110 workers
  - Floor 3: 75 workers
  - Floor 2: 65 workers
  - Floor 1: 100 workers

### Night Mode

- 16 night shift workers arriving
- 350 day shift workers leaving
- Similar floor distribution but reversed direction

## Frustration System

The implementation includes a frustration tracking system:

- Riders' frustration increases when the elevator stops
- The system calculates:
  - Individual frustration levels
  - Average frustration by shift
  - Overall average frustration

## Usage

To run the simulation:

```bash
# Navigate to the src directory
cd java/src

# Compile
javac data_structures/linear/elevator/*.java

# Run
java data_structures.linear.elevator.Driver
```

## Performance Characteristics

### Space Complexity

- Building: O(F) where F is number of floors
- Workers: O(N) where N is total number of workers
- Elevator: O(M) where M is max capacity

### Time Complexity

- Adding/Removing from elevator: O(1)
- Floor operations: O(1)
- Complete simulation: O(N \* F) where N is number of workers and F is number of floors

## Design Decisions

1. **Stack-Based Elevator**: Chosen for efficient LIFO operations
2. **Queue-Based Floors**: Natural fit for FIFO waiting lines
3. **Frustration System**: Added to measure system efficiency
4. **Modular Design**: Separates concerns between riders, elevator, and simulation control

## Output

The simulation provides detailed output including:

- Number of workers on each floor
- Elevator movements
- Delivery statistics
- Frustration levels (individual and aggregate)
