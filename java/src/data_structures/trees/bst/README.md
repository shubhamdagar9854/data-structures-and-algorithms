# Binary Search Tree Implementation

This implementation provides a basic Binary Search Tree (BST) data structure in Java that supports various tree operations.

## Features

* `add(int entry)` - Adds a new value to the BST (no duplicates allowed)
* `contains(int target)` - Checks if a value exists in the BST
* `remove(int target)` - Removes a value from the BST
* `clear()` - Removes all entries from the BST
* `rebalance()` - Rebalances the BST using in-order traversal and midpoint calculation
* Tree traversal methods:
  * `inorder()` - Left, Middle, Right traversal
  * `preorder()` - Middle, Left, Right traversal
  * `postorder()` - Left, Right, Middle traversal

## Implementation Details

The BST is implemented with the following characteristics:

* Uses a private Node class for tree structure
* Maintains no duplicate values
* Supports integer values
* Implements recursive algorithms for most operations
* Includes comprehensive traversal methods
* Features a rebalancing mechanism to optimize tree structure

## Usage Example

```java
BST myTree = new BST();
myTree.add(1);
myTree.add(2);
myTree.add(3);

// Check if value exists
boolean contains = myTree.contains(2); // returns true

// Remove a value
myTree.remove(2);

// Rebalance the tree
myTree.rebalance();
```

## Time Complexity

* Add: O(h) where h is the height of the tree
* Remove: O(h)
* Contains: O(h)
* Rebalance: O(n log n) where n is the number of nodes
* Tree traversals: O(n)

## Space Complexity

* Storage: O(n) where n is the number of nodes
* Rebalance operation: O(n) additional space for storing the sorted array