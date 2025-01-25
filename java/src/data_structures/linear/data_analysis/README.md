# Data Structures Performance Analysis

This project compares the performance of various Java data structures by measuring the time taken for common operations.

## Data Structures Analyzed

1. ArrayList
2. Vector
3. HashTable
4. HashSet
5. HashMap
6. LinkedHashSet
7. LinkedHashMap
8. LinkedList
9. TreeSet
10. TreeMap

## Operations Measured

- **Add**: Time taken to insert elements
- **Search**: Time taken to find elements
- **Remove**: Time taken to delete elements
- **Sort**: Time taken to sort elements

## Implementation Details

### Classes

1. **NumberCruncher.java**
   - Main class that runs the performance tests
   - Generates random test data
   - Measures and reports execution times for each operation
   - Uses nanosecond precision for timing measurements

2. **DataType.java**
   - Utility class that provides a common interface for all data structures
   - Implements add, remove, contains, and sort operations
   - Handles type-specific operations for each data structure

## Usage

```bash
javac data_structures/linear/data_analysis/*.java
java data_structures.linear.data_analysis.NumberCruncher
```

## Output Format

The program outputs timing results in nanoseconds for each operation:

```
------------------------
ArrayList Add Time:
        [time in nanoseconds]
------------------------
ArrayList Search Time:
        [time in nanoseconds]
------------------------
ArrayList Remove Time:
        [time in nanoseconds]
------------------------
ArrayList Sort Time:
        [time in nanoseconds]
------------------------
ArrayList Total Time:
        [total time in nanoseconds]
```

This format repeats for each data structure, allowing for easy comparison of performance characteristics.