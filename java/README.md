# Java Implementations 🚀

> Data structures and algorithms implemented in Java with a focus on clean code, performance, and thorough testing.

## Table of Contents

- [Requirements](#requirements)
- [Setup](#setup)
- [Project Structure](#project-structure)
- [Testing](#testing)
- [Style Guide](#style-guide)
- [Documentation](#documentation)

## 🔧 Requirements

- Java Development Kit (JDK) 17 or higher
- Gradle (build tool, wrapper included)
- JUnit 5 (testing framework)

## 📦 Setup

```bash
# Navigate to Java directory
cd java

# Build project using Gradle wrapper
./gradlew build

# Run tests
./gradlew test

# Generate documentation
./gradlew javadoc
```

## 📁 Project Structure

```plaintext
java/
├── src/
│   ├── algorithms/
│   │   ├── sorting/
│   │   │   ├── QuickSort.java
│   │   │   ├── MergeSort.java
│   │   │   └── HeapSort.java
│   │   ├── searching/
│   │   │   ├── BinarySearch.java
│   │   │   └── LinearSearch.java
│   │   └── graph/
│   │       ├── DFS.java
│   │       └── BFS.java
│   └── data_structures/
│       ├── linear/
│       │   ├── LinkedList.java
│       │   ├── Stack.java
│       │   └── Queue.java
│       ├── trees/
│       │   ├── BinaryTree.java
│       │   └── AVLTree.java
│       └── graphs/
│           └── Graph.java
└── tests/
    ├── algorithms/
    └── data_structures/
```

## ✅ Testing

All implementations include comprehensive unit tests using JUnit 5:

```java
@Test
void quickSort_sortRandomArray_returnsOrderedArray() {
    int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
    int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};

    QuickSort.sort(arr);

    assertArrayEquals(expected, arr);
}
```

## 📝 Style Guide

- Use PascalCase for class names
- Use camelCase for method names and variables
- Include JavaDoc comments for all public methods
- Follow Oracle's Java Code Conventions
- Maximum line length: 100 characters

Example:

```java
/**
 * Implements a generic Binary Search Tree data structure.
 *
 * @param <T> the type of elements stored in the tree
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    /**
     * Inserts a new element into the tree.
     *
     * @param element the element to insert
     * @return true if insertion was successful
     */
    public boolean insert(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        // Implementation details...
    }
}
```

## 📚 Documentation

### Common Operations Complexity

| Data Structure     | Access   | Search   | Insertion | Deletion |
| ------------------ | -------- | -------- | --------- | -------- |
| ArrayList          | O(1)     | O(n)     | O(n)      | O(n)     |
| LinkedList         | O(n)     | O(n)     | O(1)      | O(1)     |
| Binary Search Tree | O(log n) | O(log n) | O(log n)  | O(log n) |
| Hash Table         | N/A      | O(1)     | O(1)      | O(1)     |

### Implementation Notes

- All implementations are generic where applicable
- Thread-safety is documented where implemented
- Each data structure includes memory usage analysis
- Performance considerations are documented

---

For more details, check the [main documentation](../README.md).
