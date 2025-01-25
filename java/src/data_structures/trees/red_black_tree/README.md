# Red-Black Tree Implementation

This is an implementation of a Red-Black Tree data structure in Java. A Red-Black Tree is a type of self-balancing binary search tree where each node has an extra bit for denoting the color of the node, either red or black. This coloring is used to ensure that the tree remains approximately balanced during insertions and deletions.

## Properties of Red-Black Trees

1. Every node is either red or black
2. The root is black
3. Every leaf (NIL) is black
4. If a node is red, then both its children are black
5. For each node, all simple paths from the node to descendant leaves contain the same number of black nodes

## Performance

- A Red-Black Tree with n internal nodes has height at most 2(lg(n+1))
- Basic operations (search, insert, delete) take O(log n) time in both average and worst case
- This implementation includes test cases that verify the height is maintained at O(lg n) even under:
  - Average case: Random insertions
  - Worst case: Sequential insertions in increasing order

## Implementation Details

The implementation consists of three main files:

### RedBlackTree.java

Contains the core Red-Black Tree implementation with the following key methods:

- `rBInsert`: Insert a node while maintaining Red-Black properties
- `rBDelete`: Delete a node while maintaining Red-Black properties
- `leftRotate`/`rightRotate`: Helper methods for tree balancing
- Standard BST operations (`rBTMinimum`, `rBTMaximum`, `rBTSearch`, etc.)

### Driver.java

Contains test cases that verify the Red-Black Tree's height remains logarithmic by:

- Testing with random insertions (average case)
- Testing with sequential insertions (worst case)
- Verifying height ≤ 2lg(n+1) property

### RBNode (Inner Class)

Represents a node in the Red-Black Tree with:

- Value
- Color (RED/BLACK)
- Parent, left child, and right child pointers
- Height calculation method

## Usage

```java
// Create a new Red-Black Tree
RedBlackTree rbt = new RedBlackTree();

// Create and insert a new node
RedBlackTree.RBNode node = rbt.new RBNode(5, "RED");
RedBlackTree.rBInsert(rbt, node);

// Search for a value
RBNode result = rbt.rBTSearch(rbt.getRoot(), 5);

// Find minimum/maximum values
RBNode min = rbt.rBTMinimum(rbt.getRoot());
RBNode max = rbt.rBTMaximum(rbt.getRoot());
```

## Testing

The Driver class includes comprehensive tests that:

1. Test average case performance by inserting 1000, 10000, 100000, and 1000000 random values
2. Test worst case performance by inserting 1000, 10000, 100000, and 1000000 sequential values
3. Verify that in all cases the tree height remains O(lg n)

To run the tests:

```java
java Driver.java
```

## References

This implementation follows the algorithms as presented in "Introduction to Algorithms" (CLRS) Chapter 13.
