# Heapsort Implementation

This is a Java implementation of the Heapsort algorithm that analyzes its runtime complexity. The program creates arrays of random integers (1-100 inclusive) of varying sizes and sorts them using Heapsort while counting operations to verify the theoretical Θ(n lg n) time complexity.

## Features

- Implementation of heapsort algorithm using a max heap
- Analysis of operation counts compared to theoretical expectations
- Test cases with arrays of different sizes (10 to 1,000,000 elements)
- Random integer array generation for testing
- Computation of actual vs expected operation ratios
- Detailed operation counting for performance analysis

## Algorithm Components

1. `heapSort` - Main sorting method that implements heapsort
2. `buildMaxHeap` - Converts input array into a max heap
3. `maxHeapify` - Maintains the max heap property
4. Helper methods:
   - `parent` - Gets parent node index
   - `left` - Gets left child index
   - `right` - Gets right child index

## Runtime Analysis

The program analyzes the runtime by:

- Counting basic operations (assignments, comparisons)
- Comparing actual operation count to theoretical n lg n
- Computing ratio between expected and actual operations
- Testing on different array sizes to verify scaling behavior

Test array sizes:

- 10 elements
- 100 elements
- 1,000 elements
- 10,000 elements
- 100,000 elements
- 1,000,000 elements

## Usage

```java
// Create and sort an array
int[] arr = createRandomIntArray(1000); // Creates array of 1000 random integers
int operations = heapSort(arr, arr.length);

// Run performance analysis
String results = testLooper(1000, 100); // Test array size 1000 with 100 trials
System.out.println(results);
```

## Output Format

For each array size tested, the program outputs:

1. Average number of operations needed to sort
2. Expected number of operations (n lg n)
3. Ratio between expected vs actual operations

Example output:

```
========================= PERFORMING HEAPSORT ON ARRAY OF SIZE 1000 =========================

AVERAGE NUMBER OF OPERATIONS NEEDED TO SORT AN ARRAY OF RANDOM INTS OF SIZE 1000 USING HEAPSORT IS: 15234.567

EXPECTED NUMBER OF OPERATIONS NEEDED TO SORT AN ARRAY OF RANDOM INTS OF SIZE 1000 USING HEAPSORT IS: 9965.784

RATIO BETWEEN EXPECTED V.S. ACTUAL OPERATIONS FOR SORTING AN ARRAY OF SIZE 1000 IS: 1.528
```

## Implementation Details

The implementation uses a max heap approach where:

- The largest element is always at the root
- For any node i:
  - Parent is at index (i/2)
  - Left child is at index (2i + 1)
  - Right child is at index (2i + 2)

Operation counting includes:

- Array accesses
- Variable assignments
- Comparisons
- Method calls
- Loop iterations

## Author

Bjorn Melin (2/21/19)
