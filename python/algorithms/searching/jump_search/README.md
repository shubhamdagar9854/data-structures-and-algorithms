# Jump Search Algorithm

## Table of Contents

- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction

Jump Search is a searching algorithm designed for sorted arrays that works by skipping a fixed number of elements and then performing a linear search. The optimal jump size is √n, where n is the length of the list.

## Algorithm Explanation

1. Start with a sorted array
2. Set the step size as √n, where n is the array length
3. Jump through the array using the step size until an element greater than the target is found
4. Once found, perform a linear search in the previous block
5. If the element is found, return its index, otherwise return -1

## Pseudocode

```
procedure jump_search(A: sorted array, target: element to find)
    n := length(A)
    step := floor(√n)
    prev := 0

    while A[min(step, n) - 1] < target do
        prev := step
        step := step + floor(√n)
        if prev >= n then
            return -1

    while A[prev] < target do
        prev := prev + 1
        if prev = min(step, n) then
            return -1

    if A[prev] = target then
        return prev

    return -1
```

## Time and Space Complexity

- **Best Case:** O(1) - When the target is at the first position
- **Average Case:** O(√n) - When the target is somewhere in the list
- **Worst Case:** O(√n) - When the target is at the last position or not present
- **Space Complexity:** O(1) - Only a constant amount of extra space is used

## Mermaid Diagram

```mermaid
graph TD
    A[Start] --> B[Calculate step size √n]
    B --> C[Initialize prev = 0]
    C --> D{A[min(step, n) - 1] < target?}
    D -- Yes --> E[prev = step]
    E --> F[step += √n]
    F --> G{prev >= n?}
    G -- Yes --> H[Return -1]
    G -- No --> D
    D -- No --> I{A[prev] < target?}
    I -- Yes --> J[prev += 1]
    J --> K{prev = min(step, n)?}
    K -- Yes --> L[Return -1]
    K -- No --> I
    I -- No --> M{A[prev] = target?}
    M -- Yes --> N[Return prev]
    M -- No --> O[Return -1]
    H --> P[End]
    L --> P
    N --> P
    O --> P
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

To use the jump search algorithm, follow these steps:

1. Import the jump search function from the module
2. Make sure your list is sorted
3. Call the function with your sorted list and target value

```python
from jump_search import jump_search

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
target = 7
result = jump_search(arr, target)
print(f"Element {target} found at index: {result}")
```

### Additional Notes

- Works best on sorted arrays
- Optimal jump size is √n
- More efficient than linear search
- Less efficient than binary search for most cases
- Good for searching in arrays stored in external memory or on disk
