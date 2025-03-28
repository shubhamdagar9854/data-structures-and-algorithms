# LinkedList Implementations

This module provides Java implementations of different types of linked list data structures, with both iterative and recursive approaches:

- Circular Double Linked List - A doubly linked list where the last node points back to the first node
- Circular Linked List - A singly linked list where the last node points back to the first node
- Double Linked List - A linked list where each node points to both next and previous nodes
- Single Linked List - A basic linked list where each node points only to the next node

Each type of linked list is implemented in two ways:

1. Iterative approach (CircularDoubleLinkedList.java, CircularLinkedList.java, DoubleLinkedList.java, SingleLinkedList.java)
2. Recursive approach (RecursiveCircularDoubleLinkedList.java, RecursiveCircularLinkedList.java, RecursiveDoubleLinkedList.java, RecursiveSingleLinkedList.java)

## Interface

All implementations follow the `ListInterface<T>` which defines standard list operations like:

- Adding elements (at end or specific position)
- Removing elements
- Replacing elements
- Retrieving elements
- Converting to array
- Checking for containment
- Getting length and checking if empty
- Reversing data (where supported)
- Testing for circularity (where supported)

## Usage

See the included Driver.java for example usage of each implementation. The Driver demonstrates both iterative and recursive implementations, allowing you to compare their behavior and performance characteristics.
