# Binary Search Algorithm

## Table of Contents

- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction

Binary Search is an efficient algorithm for finding a target value within a sorted array. It works by repeatedly dividing the search interval in half, making it much faster than linear search for large datasets.

## Algorithm Explanation

1. Start with a sorted array
2. Find the middle element of the array
3. If the target value is equal to the middle element, return its index
4. If the target value is less than the middle element, repeat the search on the left half
5. If the target value is greater than the middle element, repeat the search on the right half
6. Continue this process until the target is found or determined to be not in the array

## Pseudocode

```
procedure binary_search(A: sorted array, target: element to find)
    left := 0
    right := length(A) - 1

    while left ≤ right do
        mid := left + (right - left) // 2

        if A[mid] = target then
            return mid
        else if A[mid] < target then
            left := mid + 1
        else
            right := mid - 1

    return -1  // Element not found
```

## Time and Space Complexity

- **Best Case:** O(1) - When the target is at the middle position
- **Average Case:** O(log n) - When the target is somewhere in the list
- **Worst Case:** O(log n) - When the target is at the end or not present
- **Space Complexity:** O(1) - Only a constant amount of extra space is used

## Mermaid Diagram

```mermaid
graph TD
    A[Start] --> B[Initialize left = 0, right = length - 1]
    B --> C{left ≤ right?}
    C -- Yes --> D[Calculate mid = left + (right - left) // 2]
    D --> E{A[mid] = target?}
    E -- Yes --> F[Return mid]
    E -- No --> G{A[mid] < target?}
    G -- Yes --> H[left = mid + 1]
    G -- No --> I[right = mid - 1]
    H --> C
    I --> C
    C -- No --> J[Return -1]
    F --> K[End]
    J --> K
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

To use the binary search algorithm, follow these steps:

1. Import the binary search function from the module
2. Make sure your list is sorted
3. Call the function with your sorted list and target value

```python
from binary_search import binary_search

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
target = 7
result = binary_search(arr, target)
print(f"Element {target} found at index: {result}")
```
