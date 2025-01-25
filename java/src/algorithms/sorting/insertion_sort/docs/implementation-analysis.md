# Insertion Sort Implementation Analysis

This document provides a detailed analysis of the insertion sort implementation and verification of its Θ(n²) time complexity through empirical testing.

## Methodology

Four different array sizes were chosen for testing:

| Array Size (n) | Expected Operations (n²) |
| -------------- | ------------------------ |
| 10             | 100                      |
| 100            | 10,000                   |
| 1,000          | 1,000,000                |
| 10,000         | 100,000,000              |

These sizes were specifically chosen because their squares (n²) produce easily interpretable results for analysis.

## Implementation Testing

The testing methodology involved:

1. Sorting 10 arrays of each size using insertion sort
2. Tracking operations with:
   - Local counter for individual array sorts
   - Universal counter for averaging operations across 10 sorts
3. Running the entire test suite 10 times to analyze variation
4. Computing ratios between actual and expected Θ(n²) operations
5. Storing and averaging results using dedicated arrays:
   - 4 arrays for ratio storage (one per input size)
   - 4 arrays for operation count storage (one per input size)

## Results

Here are the averaged results across all test runs:

### Average Ratios (Actual/Expected Operations)

| Array Size | Average Ratio |
| ---------- | ------------- |
| 10         | 1.2644        |
| 100        | 1.006604      |
| 1,000      | 0.99172592    |
| 10,000     | 0.99031949    |

### Average Operations Performed

| Array Size | Expected (n²) | Actual Operations | Difference |
| ---------- | ------------- | ----------------- | ---------- |
| 10         | 100           | 126               | +26        |
| 100        | 10,000        | 10,065            | +65        |
| 1,000      | 1,000,000     | 991,725           | -8,275     |
| 10,000     | 100,000,000   | 99,031,948        | -968,052   |

## Analysis

### Constant Value Behavior

A key observation is that as array size increases, the constant value influencing the operations decreases:

- Size 10: constant well above 1 (1.2644)
- Size 10,000: constant slightly below 1 (0.9903)

### Time Complexity Equation

This variation in constants can be explained by the full time complexity equation:

```
c₁n² + c₂n + c₃
```

Where:

- c₁, c₂, c₃ are constants
- n is the input size

For smaller values of n (10 or 100):

- The terms c₂n and c₃ have significant impact
- Results in higher ratios relative to n²

For larger values of n (1,000 or 10,000):

- The c₁n² term dominates
- c₂n and c₃ become negligible
- Results in ratios closer to 1

## Conclusion

The implementation demonstrates strong evidence of Θ(n²) time complexity:

1. Operational counts closely match theoretical n² values
2. Ratio variations are explained by constant factors
3. As n increases, ratios converge toward 1
4. Constants become less influential with larger inputs

This aligns with theoretical expectations where:

- Constants are ignored in asymptotic analysis
- Θ(n²) represents the dominant growth factor
- Implementation matches theoretical complexity

The empirical results validate that this implementation achieves the expected Θ(n²) time complexity of insertion sort, with variations attributable to the standard constant factors present in any real implementation.
