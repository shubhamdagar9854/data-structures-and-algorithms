# Hash Table Implementation Guide

## Overview

A hash table is a data structure that implements an associative array abstract data type, a structure that can map keys to values. A hash table uses a hash function to compute an index into an array of buckets or slots, from which the desired value can be found.

## Key Components

### 1. Hash Function

- Takes a key as input
- Outputs an integer (hash code)
- Should distribute values evenly
- Should be deterministic (same input = same output)
- Should be fast to compute

### 2. Collision Resolution

Common strategies include:

#### Chaining

- Each bucket contains a list of entries
- Multiple items can exist in same bucket
- Implemented using LinkedList, ArrayList, etc.
- Example: Our HashedTableBook implementation

#### Open Addressing

- When collision occurs, probe for next empty slot
- Linear probing: check next slot
- Quadratic probing: check slot + n^2
- Double hashing: use second hash function

## Implementation Considerations

1. **Initial Size**

   - Should be prime number (reduces collisions)
   - Consider load factor (items/buckets)
   - Example: Our implementation uses 31

2. **Hash Function Quality**

   - Should distribute values evenly
   - Minimize collisions
   - Balance between speed and distribution

3. **Resizing**
   - Monitor load factor
   - Typically resize when load > 0.75
   - Rehash all items to new size

## Code Structure

```java
public class HashTable<K,V> {
    private Entry<K,V>[] buckets;
    private int size;

    private static class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;  // For chaining
    }

    public void put(K key, V value) {
        int index = hash(key);
        // Handle collision
        // Add entry
    }

    public V get(K key) {
        int index = hash(key);
        // Find and return value
    }

    private int hash(K key) {
        // Convert key to index
    }
}
```

## Best Practices

1. **Hash Function**

   - Use built-in hashCode() when available
   - XOR bits for combining multiple fields
   - Consider domain-specific needs

2. **Collision Handling**

   - Choose based on expected data
   - Chaining: good for unknown data size
   - Open addressing: good for fixed size

3. **Error Handling**
   - Check for null keys
   - Handle duplicate keys
   - Validate input parameters

## Common Uses

1. **Caching**

   - Quick lookups
   - Session storage
   - Database query results

2. **De-duplication**

   - Finding unique items
   - Removing duplicates
   - Set implementation

3. **Symbol Tables**
   - Compiler symbol tables
   - Environment variables
   - Configuration settings

## Performance

### Time Complexity

- Average case:
  - Insert: O(1)
  - Delete: O(1)
  - Search: O(1)
- Worst case (many collisions):
  - All operations: O(n)

### Space Complexity

- O(n) where n is number of items
- Additional overhead for:
  - Empty buckets
  - Collision chain pointers

## Testing Strategies

1. **Basic Operations**

   - Add/get single items
   - Update existing items
   - Remove items

2. **Edge Cases**

   - Empty table
   - Single item
   - Full table
   - Null keys/values

3. **Collision Handling**
   - Multiple items same bucket
   - Delete from collision chain
   - Update in collision chain

## Example (from our implementation)

```java
// Creating hash table
HashedTableBook library = new HashedTableBook();

// Adding items
library.add(new Book("Data Structures", 565, 100000));
library.add(new Book("Algorithms", 432, 80000));

// Handling collisions
// If two books hash to same index, they're added to same bucket's LinkedList

// Retrieving items
ArrayList<Book> results = library.get("Data Structures");

// Note: Our implementation allows multiple books with same title
// They'll be stored in same bucket due to title-based hashing
```

## Additional Resources

1. Books:

   - Introduction to Algorithms (CLRS)
   - Data Structures and Algorithm Analysis in Java

2. Online:

   - [Hash Tables on Wikipedia](https://en.wikipedia.org/wiki/Hash_table)
   - [Java HashMap source code](https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/HashMap.java)

3. Related Topics:
   - Perfect hashing
   - Consistent hashing
   - Bloom filters
