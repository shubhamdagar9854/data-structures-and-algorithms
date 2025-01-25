# Deque and Priority Queue Implementation

This implementation demonstrates the functionality of two important data structures:

1. Deque (Double-ended Queue)
2. Priority Queue

## Overview

### Deque

A deque (double-ended queue) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail). This implementation uses Java's built-in `Deque` interface with a `LinkedList` implementation.

Demonstrated operations:

- `peekFirst()` - View the first element
- `peekLast()` - View the last element
- `addLast()` - Add element to the end
- `removeFirst()` - Remove element from the front
- `push()` - Add element to the front
- `pop()` - Remove element from the front
- `removeLast()` - Remove element from the end

### Priority Queue

A priority queue is an abstract data type similar to a regular queue but where elements have "priorities" associated with them. In a priority queue, elements with high priority are served before elements with low priority.

This implementation uses Java's `PriorityQueue` class with a custom `Package` class that implements `Comparable` to handle priorities.

Demonstrated operations:

- `peek()` - View the highest priority element
- `add()` - Add element with priority
- `remove()` - Remove the highest priority element

## Implementation Details

### Package Class

The `Package` class implements `Comparable` and is used to store elements with priorities in the priority queue. Each package has:

- `data`: The actual value stored
- `priority`: The priority level (lower numbers indicate higher priority)

The `compareTo` method is implemented to sort packages based on their priority, ensuring that packages with lower priority numbers (higher priority) are served first.

## Example Usage

### Compiling and Running

```bash
# Navigate to the src directory
cd java/src

# Compile
javac data_structures/linear/deque_priority_queue/*.java

# Run
java data_structures.linear.deque_priority_queue.Driver
```

### Sample Output

The program demonstrates:

1. Deque Operations:

   ```
   CREATING DEQUE TO RUN THROUGH LECTURE 13 COMMANDS
   PEEKING FRONT OF DEQUE:
   null

   ENQUEUED 7 TO END OF DEQUE:
   [7]
   ...
   ```

2. Priority Queue Operations:

   ```
   CREATING PRIORITY QUEUE TO RUN THROUGH LECTURE 13 COMMANDS
   PEEKING THE HEAD OF PRIORITY QUEUE:
   null

   ENQUEUED 7,2 INTO THE PRIORITY QUEUE:
   [{7, 2}]
   ...
   ```

## Performance

### Deque Operations (LinkedList Implementation)

- `peekFirst()`, `peekLast()`: O(1)
- `addLast()`, `removeLast()`: O(1)
- `push()`, `pop()`: O(1)
- `removeFirst()`: O(1)

### Priority Queue Operations

- `peek()`: O(1)
- `add()`: O(log n)
- `remove()`: O(log n)

Where n is the number of elements in the queue.
