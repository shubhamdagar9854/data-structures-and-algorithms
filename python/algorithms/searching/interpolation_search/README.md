# Interpolation Search Algorithm

## Table of Contents

- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction

Interpolation Search is an improved variant of binary search that works efficiently on uniformly distributed sorted arrays. Instead of always choosing the middle element for comparison, it makes an intelligent guess based on the target value's likely position.

## Algorithm Explanation

1. Start with a sorted array with uniformly distributed values
2. Calculate the probable position using the formula:
   ```
   pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low])
   ```
3. If the element at pos is the target, return its position
4. If the element is smaller than target, search in the right half
5. If the element is larger than target, search in the left half
6. Repeat until element is found or determined to be not in the array

## Pseudocode

```
procedure interpolation_search(A: sorted array, target: element to find)
    low := 0
    high := length(A) - 1

    while low ≤ high and A[low] ≤ target ≤ A[high] do
        if low = high then
            if A[low] = target then
                return low
            return -1

        pos := low + ((target - A[low]) * (high - low)) / (A[high] - A[low])

        if A[pos] = target then
            return pos
        else if A[pos] < target then
            low := pos + 1
        else
            high := pos - 1

    return -1
```

## Time and Space Complexity

- **Best Case:** O(1) - When the target is at the estimated position
- **Average Case:** O(log log n) - When the elements are uniformly distributed
- **Worst Case:** O(n) - When the elements are not uniformly distributed
- **Space Complexity:** O(1) - Only a constant amount of extra space is used

## Mermaid Diagram

```mermaid
graph TD
    A[Start] --> B[Initialize low and high]
    B --> C{low ≤ high and target in range?}
    C -- Yes --> D[Calculate probable position]
    D --> E{A[pos] = target?}
    E -- Yes --> F[Return pos]
    E -- No --> G{A[pos] < target?}
    G -- Yes --> H[low = pos + 1]
    G -- No --> I[high = pos - 1]
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

To use the interpolation search algorithm, follow these steps:

1. Import the interpolation search function from the module
2. Make sure your list is sorted and uniformly distributed
3. Call the function with your sorted list and target value

```python
from interpolation_search import interpolation_search

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
target = 7
result = interpolation_search(arr, target)
print(f"Element {target} found at index: {result}")
```

### Additional Notes

- Works best on uniformly distributed sorted arrays
- Performance degrades when distribution is not uniform
- More efficient than binary search for uniformly distributed data
- Less reliable than binary search for non-uniform distributions
