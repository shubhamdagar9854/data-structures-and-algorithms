# Python Searching Algorithms 🔍

This directory contains implementations of various searching algorithms in Python. Each algorithm is implemented with a focus on clarity, efficiency, and educational value.

## Table of Contents

- [Linear Search](linear_search/)
- [Binary Search](binary_search/)
- [Jump Search](jump_search/)
- [Interpolation Search](interpolation_search/)
- [Exponential Search](exponential_search/)
- [Fibonacci Search](fibonacci_search/)
- [Ternary Search](ternary_search/)
- [Hash-based Search](hash_based_search/)

## Algorithm Comparison

| Algorithm     | Time Complexity (Best) | Time Complexity (Average) | Time Complexity (Worst) | Space Complexity | Sorted Required? |
| ------------- | ---------------------- | ------------------------- | ----------------------- | ---------------- | ---------------- |
| Linear Search | O(1)                   | O(n)                      | O(n)                    | O(1)             | No               |
| Binary Search | O(1)                   | O(log n)                  | O(log n)                | O(1)             | Yes              |
| Jump Search   | O(1)                   | O(√n)                     | O(√n)                   | O(1)             | Yes              |
| Interpolation | O(1)                   | O(log log n)              | O(n)                    | O(1)             | Yes              |
| Exponential   | O(1)                   | O(log n)                  | O(log n)                | O(1)             | Yes              |
| Fibonacci     | O(1)                   | O(log n)                  | O(log n)                | O(1)             | Yes              |
| Ternary       | O(1)                   | O(log₃ n)                 | O(log₃ n)               | O(1)             | Yes              |
| Hash-based    | O(1)                   | O(1)                      | O(1)                    | O(n)             | No               |

## Choosing the Right Algorithm

Each searching algorithm has its strengths and ideal use cases:

### Linear Search

- Best for small lists or unsorted data
- Simple to implement
- No preprocessing required
- Good when data is randomly accessed

### Binary Search

- Excellent for sorted arrays
- Very efficient for large datasets
- Requires sorted data
- Most commonly used search algorithm

### Jump Search

- Good for sorted arrays
- Works well with data that allows for "jumping" ahead
- Better than linear search, worse than binary search
- Good for searching on disk/external memory

### Interpolation Search

- Excellent for uniformly distributed sorted arrays
- Can be much faster than binary search
- Poor performance on non-uniform distributions
- Complex implementation

### Exponential Search

- Good for unbounded/infinite arrays
- Useful when element is closer to the beginning
- Combines binary search efficiency
- Works well with bounded arrays too

### Fibonacci Search

- Uses Fibonacci numbers for efficient division
- Good for sorted arrays
- Uses only addition/subtraction
- Useful in systems where multiplication/division is expensive

### Ternary Search

- Divides array into three parts
- Good for finding maximum/minimum in unimodal functions
- More comparisons per iteration than binary search
- Can be more efficient in some cases

### Hash-based Search

- Constant time complexity
- Requires extra space
- Best when frequent searches needed
- No sorting required

## Performance Notes

- For small datasets (n < 100), the overhead of complex algorithms might make simple linear search more efficient
- Binary search is generally the most practical choice for sorted data
- Hash-based search is ideal when memory is not a constraint and frequent searches are needed
- For very large datasets, consider the cache-friendliness of the algorithm
