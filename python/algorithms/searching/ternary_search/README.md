# Ternary Search Algorithm

## Table of Contents

- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction

Ternary Search is a divide-and-conquer algorithm that works on sorted arrays by dividing the search interval into three parts, rather than two as in binary search. While it has a higher constant factor than binary search, it can be more efficient in certain scenarios.

## Algorithm Explanation

1. Start with a sorted array
2. Divide the array into three parts using two mid points:
   - mid1 = left + (right - left) / 3
   - mid2 = right - (right - left) / 3
3. Compare target with elements at mid1 and mid2
4. If target matches either mid point, return that index
5. If target is less than mid1, search in first third
6. If target is greater than mid2, search in last third
7. Otherwise, search in middle third
8. Repeat until element is found or determined to be not in the array

## Pseudocode

```
procedure ternary_search(A: sorted array, target: element to find)
    left := 0
    right := length(A) - 1

    while left ≤ right do
        third := (right - left) / 3
        mid1 := left + third
        mid2 := right - third

        if A[mid1] = target then
            return mid1
        if A[mid2] = target then
            return mid2

        if target < A[mid1] then
            right := mid1 - 1
        else if target > A[mid2] then
            left := mid2 + 1
        else
            left := mid1 + 1
            right := mid2 - 1

    return -1
```

## Time and Space Complexity

- **Best Case:** O(1) - When the target is at one of the mid points
- **Average Case:** O(log₃ n) - When the target is somewhere in the list
- **Worst Case:** O(log₃ n) - When the target is at the edges or not present
- **Space Complexity:** O(1) - Only a constant amount of extra space is used

## Mermaid Diagram

```mermaid
graph TD
    A[Start] --> B[Initialize left and right]
    B --> C{left ≤ right?}
    C -- Yes --> D[Calculate mid1 and mid2]
    D --> E{A[mid1] = target?}
    E -- Yes --> F[Return mid1]
    E -- No --> G{A[mid2] = target?}
    G -- Yes --> H[Return mid2]
    G -- No --> I{target < A[mid1]?}
    I -- Yes --> J[Search in first third]
    I -- No --> K{target > A[mid2]?}
    K -- Yes --> L[Search in last third]
    K -- No --> M[Search in middle third]
    J --> C
    L --> C
    M --> C
    C -- No --> N[Return -1]
    F --> O[End]
    H --> O
    N --> O
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

To use the ternary search algorithm, follow these steps:

1. Import the ternary search function from the module
2. Make sure your list is sorted
3. Call the function with your sorted list and target value

```python
from ternary_search import ternary_search

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
target = 7
result = ternary_search(arr, target)
print(f"Element {target} found at index: {result}")
```

### Additional Notes

- More comparisons per iteration than binary search
- Can be more efficient when data is uniformly distributed
- Good for finding maximum or minimum in unimodal functions
- Works best on large, sorted datasets
- Requires the array to be sorted before searching
