# Max Heap Implementation

This is a Java implementation of a Max Heap data structure that stores Cargo objects. A max heap is a complete binary tree where each parent node is greater than or equal to its children.

## Components

### Cargo.java

- Represents cargo items with destination and tonnage information
- Implements Comparable interface to enable heap ordering based on tonnage
- Includes tracking number for unique identification

### Heap.java

- Interface defining the required operations for a heap data structure
- Specifies methods for adding/removing elements, checking containment, and traversal

### MaxHeap.java

- Implementation of the Heap interface using a node-based max heap structure
- Uses an ArrayList to maintain node references for efficient operations
- Includes methods for:
  - Adding new cargo (bubbling up)
  - Removing root (bubbling down)
  - Tree traversals (inorder, preorder, postorder)
  - Searching for specific cargo items

### Driver.java

- Demonstrates the functionality of the max heap implementation
- Tests adding and removing elements
- Shows heap rebalancing after operations

## Usage Example

```java
MaxHeap myHeap = new MaxHeap();

// Add cargo items
myHeap.add(new Cargo("Destination1", 10.5));
myHeap.add(new Cargo("Destination2", 15.2));

// Remove highest priority item (root)
Cargo highestPriority = myHeap.removeRoot();

// Check if item exists
boolean exists = myHeap.contains(new Cargo("Destination1", 10.5));

// Print heap traversals
System.out.println(myHeap);
```

## Implementation Details

The max heap maintains the following properties:

- Parent nodes always have higher or equal tonnage compared to their children
- The tree is kept complete (filled left to right)
- Node positions are tracked using an ArrayList for O(1) access
- Adding and removing elements have O(log n) complexity

## Time Complexity

- Add: O(log n)
- Remove Root: O(log n)
- Contains: O(n)
- Space Complexity: O(n)

Where n is the number of elements in the heap.
