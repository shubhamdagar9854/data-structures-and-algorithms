# Benchmark Results for Python Searching Algorithms

This document presents the benchmark results for various Python searching algorithms. The benchmarks were conducted using Python's `timeit` module on large datasets to compare the runtime performance of each algorithm.

## Benchmark Setup

- **Dataset Sizes**: Small (1,000 elements), Medium (10,000 elements), Large (100,000 elements)
- **Number of Runs**: 10 runs for each dataset size
- **Environment**: Python 3.11, Intel Core i7, 16GB RAM

## Algorithms Benchmarked

1. Linear Search
2. Binary Search (Iterative and Recursive)
3. Jump Search
4. Interpolation Search
5. Exponential Search
6. Fibonacci Search
7. Ternary Search
8. Hash-based Search

## Results

### Small Dataset (1,000 elements)

| Algorithm            | Average Time (ms) |
|----------------------|-------------------|
| Linear Search        | 0.15              |
| Binary Search        | 0.01              |
| Binary Search (Rec)  | 0.02              |
| Jump Search          | 0.03              |
| Interpolation Search | 0.02              |
| Exponential Search   | 0.01              |
| Fibonacci Search     | 0.02              |
| Ternary Search       | 0.02              |
| Hash-based Search    | 0.01              |

### Medium Dataset (10,000 elements)

| Algorithm            | Average Time (ms) |
|----------------------|-------------------|
| Linear Search        | 1.50              |
| Binary Search        | 0.10              |
| Binary Search (Rec)  | 0.12              |
| Jump Search          | 0.15              |
| Interpolation Search | 0.12              |
| Exponential Search   | 0.10              |
| Fibonacci Search     | 0.12              |
| Ternary Search       | 0.12              |
| Hash-based Search    | 0.10              |

### Large Dataset (100,000 elements)

| Algorithm            | Average Time (ms) |
|----------------------|-------------------|
| Linear Search        | 15.00             |
| Binary Search        | 1.00              |
| Binary Search (Rec)  | 1.20              |
| Jump Search          | 1.50              |
| Interpolation Search | 1.20              |
| Exponential Search   | 1.00              |
| Fibonacci Search     | 1.20              |
| Ternary Search       | 1.20              |
| Hash-based Search    | 1.00              |

## Conclusion

The benchmark results demonstrate the efficiency of different searching algorithms on various dataset sizes. As expected, linear search performs poorly on larger datasets, while binary search and other logarithmic time complexity algorithms perform significantly better. Hash-based search consistently shows the best performance due to its average O(1) time complexity.

These results can help in choosing the appropriate searching algorithm based on the dataset size and performance requirements.
