# Exponential Search Algorithm

## Table of Contents

- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction

Exponential Search is a searching algorithm that works on sorted arrays by finding a range where the target element might be present and then performing binary search within that range. It is particularly useful when searching in unbounded or infinite arrays.

## Algorithm Explanation

1. Start with a sorted array
2. If the first element is the target, return 0
3. Find range for binary search by repeatedly doubling the index (1, 2, 4, 8, ...)
4. When an element greater than the target is found, we have our range
5. Perform binary search between i/2 and i, where i is the current position
6. Return the result of the binary search

## Pseudocode

```
procedure exponential_search(A: sorted array, target: element to find)
    if A[0] = target then
        return 0

    i := 1
    while i < length(A) and A[i] ≤ target do
        i := i * 2

    return binary_search(A, target, i/2, min(i, length(A)-1))
```

## Time and Space Complexity

- **Best Case:** O(1) - When the target is at the first position
- **Average Case:** O(log n) - When the target is somewhere in the list
- **Worst Case:** O(log n) - When the target is at the last position or not present
- **Space Complexity:** O(1) - Only a constant amount of extra space is used

## Mermaid Diagram

```mermaid
graph TD
    A[Start] --> B{A[0] = target?}
    B -- Yes --> C[Return 0]
    B -- No --> D[Initialize i = 1]
    D --> E{i < length AND A[i] ≤ target?}
    E -- Yes --> F[i = i * 2]
    F --> E
    E -- No --> G[Perform binary search from i/2 to min(i, length-1)]
    G --> H[Return binary search result]
    C --> I[End]
    H --> I
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

To use the exponential search algorithm, follow these steps:

1. Import the exponential search function from the module
2. Make sure your list is sorted
3. Call the function with your sorted list and target value

```python
from exponential_search import exponential_search

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
target = 7
result = exponential_search(arr, target)
print(f"Element {target} found at index: {result}")
```
