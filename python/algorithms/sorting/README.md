# Python Sorting Algorithms 🔄

This directory contains implementations of various sorting algorithms in Python. Each algorithm is implemented with a focus on clarity, efficiency, and educational value.

## Table of Contents

- [Bubble Sort](bubble_sort/)
- [Selection Sort](selection_sort/)
- [Insertion Sort](insertion_sort/)
- [Merge Sort](merge_sort/)
- [Quick Sort](quick_sort/)
- [Heap Sort](heap_sort/)
- [Counting Sort](counting_sort/)
- [Radix Sort](radix_sort/)
- [Bucket Sort](bucket_sort/)
- [Tim Sort](tim_sort/)

## Algorithm Comparison

| Algorithm      | Time Complexity (Best) | Time Complexity (Average) | Time Complexity (Worst) | Space Complexity | Stable? | In-Place? |
| -------------- | ---------------------- | ------------------------- | ----------------------- | ---------------- | ------- | --------- |
| Bubble Sort    | O(n)                   | O(n²)                     | O(n²)                   | O(1)             | Yes     | Yes       |
| Selection Sort | O(n²)                  | O(n²)                     | O(n²)                   | O(1)             | No      | Yes       |
| Insertion Sort | O(n)                   | O(n²)                     | O(n²)                   | O(1)             | Yes     | Yes       |
| Merge Sort     | O(n log n)             | O(n log n)                | O(n log n)              | O(n)             | Yes     | No        |
| Quick Sort     | O(n log n)             | O(n log n)                | O(n²)                   | O(log n)         | No      | Yes       |
| Heap Sort      | O(n log n)             | O(n log n)                | O(n log n)              | O(1)             | No      | Yes       |
| Counting Sort  | O(n + k)               | O(n + k)                  | O(n + k)                | O(k)             | Yes     | No        |
| Radix Sort     | O(nk)                  | O(nk)                     | O(nk)                   | O(n + k)         | Yes     | No        |
| Bucket Sort    | O(n + k)               | O(n + k)                  | O(n²)                   | O(n + k)         | Yes     | No        |
| Tim Sort       | O(n)                   | O(n log n)                | O(n log n)              | O(n)             | Yes     | No        |

Where:

- n is the number of elements
- k is the range of possible values (for counting sort) or number of digits (for radix sort)

## Choosing the Right Algorithm

Each sorting algorithm has its strengths and ideal use cases:

### Bubble Sort

- Simple to implement
- Good for small datasets
- Good when array is nearly sorted
- Poor performance on large datasets

### Selection Sort

- Simple implementation
- Minimal memory usage
- Poor performance in all cases
- Useful when memory writes are expensive

### Insertion Sort

- Very efficient for small datasets
- Adaptive (efficient for data that's already mostly sorted)
- Stable sort algorithm
- Good for nearly sorted arrays

### Merge Sort

- Consistent O(n log n) performance
- Stable sort algorithm
- Requires extra memory
- Good for linked lists

### Quick Sort

- Best practical choice for arrays
- Good cache performance
- Unstable sort
- Poor performance on already sorted arrays

### Heap Sort

- In-place sorting
- No quadratic worst-case
- Not stable
- Poor cache performance

### Counting Sort

- Very efficient for small ranges
- Linear time complexity
- Requires extra memory
- Only works with positive integers

### Radix Sort

- Linear time complexity
- Stable sort
- Limited to integers/strings
- Uses extra memory

### Bucket Sort

- Good when input is uniformly distributed
- Can be very fast in practice
- Requires extra memory
- Poor when data is not uniformly distributed

### Tim Sort

- Python's built-in sort
- Hybrid of merge sort and insertion sort
- Very efficient on real-world data
- Complex implementation

## Performance Notes

- For small datasets (n < 50), simple algorithms like insertion sort may be more efficient due to low overhead
- For medium to large datasets, quicksort is often the best choice
- When stability is required, merge sort or Tim sort are good options
- For integer data with known ranges, counting sort or radix sort can be very efficient
- Consider memory constraints when choosing between algorithms
