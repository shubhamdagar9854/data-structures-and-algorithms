# Fibonacci Search Algorithm

## Table of Contents

- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction

Fibonacci Search is a comparison-based searching algorithm that uses Fibonacci numbers to find a target value in a sorted array. It divides the array into unequal parts and uses these parts to determine which section of the array to search.

## Algorithm Explanation

1. Find the smallest Fibonacci number greater than or equal to array length
2. Set two Fibonacci numbers: fibM2 (M-2th number) and fibM1 (M-1th number)
3. While there are elements to be inspected:
   - Compare target with element at index min(offset + fibM2, n-1)
   - If target matches, return the index
   - If target is greater, move the Fibonacci numbers one position down
   - If target is smaller, move the Fibonacci numbers two positions down
4. If target is not found, return -1

## Pseudocode

```
procedure fibonacci_search(A: sorted array, target: element to find)
    fibM2 := 0
    fibM1 := 1
    fibM := fibM2 + fibM1

    while fibM < length(A) do
        fibM2 := fibM1
        fibM1 := fibM
        fibM := fibM2 + fibM1

    offset := -1

    while fibM > 1 do
        i := min(offset + fibM2, length(A) - 1)

        if A[i] < target then
            fibM := fibM1
            fibM1 := fibM2
            fibM2 := fibM - fibM1
            offset := i
        else if A[i] > target then
            fibM := fibM2
            fibM1 := fibM1 - fibM2
            fibM2 := fibM - fibM1
        else
            return i

    if fibM1 and A[offset + 1] = target then
        return offset + 1

    return -1
```

## Time and Space Complexity

- **Best Case:** O(1) - When the target is at the first position
- **Average Case:** O(log n) - When the target is somewhere in the list
- **Worst Case:** O(log n) - When the target is at the last position or not present
- **Space Complexity:** O(1) - Only a constant amount of extra space is used

## Mermaid Diagram

```mermaid
graph TD
    A[Start] --> B[Initialize Fibonacci numbers]
    B --> C[Find smallest Fibonacci > length]
    C --> D[Initialize offset = -1]
    D --> E{fibM > 1?}
    E -- Yes --> F[Calculate i = min(offset + fibM2, n-1)]
    F --> G{Compare A[i] with target}
    G -- Less than --> H[Move Fibonacci numbers down]
    G -- Greater than --> I[Move Fibonacci numbers down twice]
    G -- Equal --> J[Return i]
    H --> E
    I --> E
    E -- No --> K{Check last element}
    K -- Found --> L[Return offset + 1]
    K -- Not Found --> M[Return -1]
    J --> N[End]
    L --> N
    M --> N
```

## Testing Results

| Test Case         | Input          | Expected Output | Actual Output |
| ----------------- | -------------- | --------------- | ------------- |
| Element at start  | [1,2,3,4,5], 1 | 0               | 0             |
| Element in middle | [1,2,3,4,5], 3 | 2               | 2             |
| Element at end    | [1,2,3,4,5], 5 | 4               | 4             |
| Element not found | [1,2,3,4,5], 6 | -1              | -1            |
| Empty list        | [], 1          | -1              | -1            |
| Single element    | [1], 1         | 0               | 0             |

## Usage Guide

To use the Fibonacci search algorithm, follow these steps:

1. Import the Fibonacci search function from the module
2. Make sure your list is sorted
3. Call the function with your sorted list and target value

```python
from fibonacci_search import fibonacci_search

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
target = 7
result = fibonacci_search(arr, target)
print(f"Element {target} found at index: {result}")
```
