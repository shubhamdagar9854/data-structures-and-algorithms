# Linear Search Algorithm

## Table of Contents

- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction

Linear Search is the simplest searching algorithm that finds a target value by checking each element in a list sequentially until a match is found or the end of the list is reached. While not the most efficient, it works on both sorted and unsorted lists.

## Algorithm Explanation

1. Start from the first element of the list
2. Compare the current element with the target value
3. If the current element matches the target, return its index
4. If not, move to the next element
5. Repeat steps 2-4 until either:
   - The target is found (return its index)
   - The end of the list is reached (return -1)

## Pseudocode

```
procedure linear_search(A: list of elements, target: element to find)
    for i from 0 to length(A)-1 do
        if A[i] = target then
            return i
    return -1
```

## Time and Space Complexity

- **Best Case:** O(1) - When the target is at the first position
- **Average Case:** O(n) - When the target is in the middle
- **Worst Case:** O(n) - When the target is at the last position or not present
- **Space Complexity:** O(1) - Only a constant amount of extra space is used

## Mermaid Diagram

```mermaid
graph TD
    A[Start] --> B[Initialize i = 0]
    B --> C{i < length of list?}
    C -- Yes --> D{A[i] = target?}
    D -- Yes --> E[Return i]
    D -- No --> F[i = i + 1]
    F --> C
    C -- No --> G[Return -1]
    E --> H[End]
    G --> H
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

To use the linear search algorithm, follow these steps:

1. Import the linear search function from the module
2. Call the function with your list and target value

```python
from linear_search import linear_search

arr = [64, 34, 25, 12, 22, 11, 90]
target = 22
result = linear_search(arr, target)
print(f"Element {target} found at index: {result}")
```

### Additional Notes

- Works on both sorted and unsorted lists
- Simple to implement and understand
- No preprocessing required
- Best for small lists or lists that are searched infrequently
- Good when the target is likely to be at the beginning of the list
- Inefficient for large datasets compared to other search algorithms
