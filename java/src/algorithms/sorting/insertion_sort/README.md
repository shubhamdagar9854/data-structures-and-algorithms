# Insertion Sort Implementation

This directory contains a Java implementation of the insertion sort algorithm that tests whether the implementation runs in Θ(n²) time as expected.

## Overview

The implementation performs insertion sort on arrays of random integers of different sizes (10, 100, 1000, and 10,000) and analyzes the number of operations performed to verify the Θ(n²) time complexity.

## Features

- Implementation of classic insertion sort algorithm
- Automated testing with arrays of varying sizes (10, 100, 1000, 10000)
- Operation counting to analyze actual performance
- Ratio calculation between actual operations and theoretical n² operations
- Multiple test runs (10) to get average performance metrics
- Random test data generation

## Implementation Details

The code has several key components:

### Insertion Sort Algorithm

The `insertionSort()` method implements the classic insertion sort algorithm:

1. Iterate through array starting from index 1
2. For each element (key), compare with previous elements
3. Shift larger elements right to make space for key
4. Place key in correct position
5. Track operations performed for complexity analysis

### Performance Analysis

The implementation:

- Counts basic operations (comparisons, assignments)
- Tracks operations across multiple array sizes
- Calculates ratios between actual operations and n²
- Averages results across 10 test runs
- Reports detailed statistics for analysis

### Testing Framework

The main method provides comprehensive testing:

- 10 complete test runs
- Tests on 4 different array sizes
- Random data generation
- Statistics collection and averaging
- Detailed output of results

## Time Complexity Analysis

The code verifies insertion sort's Θ(n²) time complexity by:

1. Counting actual operations performed
2. Computing ratio: actual_ops / n²
3. Testing multiple array sizes
4. Running multiple trials
5. Averaging results

If the algorithm runs in Θ(n²) time, the ratio of actual operations to n² should be relatively constant across different array sizes.

## Example Output Format

```
======================= TEST RUN NUMBER 1 =======================

AVERAGE NUMBER OF OPERATIONS NEEDED TO SORT AN ARRAY OF RANDOM INTS OF SIZE 10 IS:     [value]
RATIO B/W ACTUAL AND EXPECTED OPERATIONS FOR AN ARRAY OF SIZE 10 IS:                   [value]

...

AVERAGE RATIO FOR ARRAY OF SIZE 10:     [value]
AVERAGE RATIO FOR ARRAY OF SIZE 100:    [value]
AVERAGE RATIO FOR ARRAY OF SIZE 1000:   [value]
AVERAGE RATIO FOR ARRAY OF SIZE 10000:  [value]

AVERAGE OPERATIONS TO SORT AN ARRAY OF SIZE 10:      [value]
AVERAGE OPERATIONS TO SORT AN ARRAY OF SIZE 100:     [value]
AVERAGE OPERATIONS TO SORT AN ARRAY OF SIZE 1000:    [value]
AVERAGE OPERATIONS TO SORT AN ARRAY OF SIZE 10000:   [value]
```

The consistency of the ratio values across different array sizes helps verify the Θ(n²) complexity.
