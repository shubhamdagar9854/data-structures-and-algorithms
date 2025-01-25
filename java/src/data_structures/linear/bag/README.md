# Resizable Array Bag Implementation

A generic bag implementation using a resizable array in Java. This implementation provides a collection that can hold items with no specific order and automatically grows as needed.

## Features

- Generic type support
- Dynamic resizing
- No duplicate elements allowed
- Set operations (union, intersection, difference)
- Standard collection operations (add, remove, contains, etc.)
- O(1) add operation (amortized)
- O(n) search operations

## Implementation Details

The bag is implemented using three main classes:

1. `BagInterface<T>` - The interface defining all bag operations
2. `ResizableArrayBag<T>` - The concrete implementation using a resizable array
3. `ResizableArrayBagDemo` - A demonstration class with usage examples

### Key Properties

- Initial capacity: 25 items
- Maximum capacity: 10,000 items
- Automatic doubling of capacity when full
- No duplicates allowed

### Supported Operations

- `add(T newEntry)`: Add a new item (no duplicates)
- `remove()`: Remove and return a random item
- `remove(T anEntry)`: Remove a specific item
- `clear()`: Remove all items
- `getCurrentSize()`: Get number of items
- `isEmpty()`: Check if bag is empty
- `getFrequencyOf(T anEntry)`: Count occurrences of an item
- `contains(T anEntry)`: Check if an item exists
- `toArray()`: Convert to array
- `union(BagInterface<T> anotherBag)`: Combine two bags
- `intersection(BagInterface<T> anotherBag)`: Get common items
- `difference(BagInterface<T> anotherBag)`: Get items in either bag but not both

## Usage Example

```java
// Create a bag with initial elements
String[] items = {"A", "B", "C", "D"};
BagInterface<String> bag = new ResizableArrayBag<>(items);

// Add items
bag.add("E"); // true if added, false if duplicate

// Check contents
System.out.println("Size: " + bag.getCurrentSize()); // 5
System.out.println("Contains 'A': " + bag.contains("A")); // true

// Remove items
String removed = bag.remove(); // Removes and returns any item
boolean wasRemoved = bag.remove("A"); // Removes specific item

// Set operations
BagInterface<String> bag2 = new ResizableArrayBag<>();
bag2.add("C");
bag2.add("D");
bag2.add("E");

BagInterface<String> union = bag.union(bag2);
BagInterface<String> intersection = bag.intersection(bag2);
BagInterface<String> difference = bag.difference(bag2);
```

## Time Complexity

| Operation | Average Case |
|-----------|-------------|
| add | O(1) |
| remove | O(1) |
| contains | O(n) |
| union | O(n) |
| intersection | O(n) |
| difference | O(n) |

Where n is the number of items in the bag.

## Testing

The `ResizableArrayBagDemo` class provides comprehensive tests for all bag operations including:
- Basic operations (add, remove, clear)
- Set operations (union, intersection, difference)
- Property tests (isEmpty, getCurrentSize)
- Search operations (contains, getFrequencyOf)