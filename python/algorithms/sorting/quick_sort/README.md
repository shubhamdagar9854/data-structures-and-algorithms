# Quick Sort Algorithm

## Table of Contents
- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction
Quick Sort is a divide-and-conquer algorithm that selects a pivot element and partitions the array into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively.

## Algorithm Explanation
1. Select a pivot element from the array.
2. Partition the array into two sub-arrays:
   - Elements less than the pivot
   - Elements greater than the pivot
3. Recursively sort the sub-arrays.
4. Combine the sorted sub-arrays and the pivot to produce the final sorted array.

## Pseudocode
```
procedure quickSort(A: list of sortable items)
    if length(A) <= 1 then
        return A
    end if
    pivot := A[length(A) // 2]
    left := [x in A if x < pivot]
    middle := [x in A if x == pivot]
    right := [x in A if x > pivot]
    return quickSort(left) + middle + quickSort(right)
end procedure
```

## Time and Space Complexity
- **Best Case:** O(n log n)
- **Average Case:** O(n log n)
- **Worst Case:** O(n^2)
- **Space Complexity:** O(log n)

## Mermaid Diagram
```mermaid
graph TD
    A[Start] --> B[If length(A) <= 1, return A]
    B --> C[Select pivot element]
    C --> D[Partition array into left, middle, right]
    D --> E[Recursively sort left and right]
    E --> F[Combine sorted sub-arrays and pivot]
    F --> G[Return the sorted array]
    G --> H[End]
```

## Testing Results
| Test Case                | Input                | Expected Output       | Actual Output         |
|--------------------------|----------------------|-----------------------|-----------------------|
| Empty List               | []                   | []                    | []                    |
| Single Element           | [1]                  | [1]                   | [1]                   |
| Already Sorted           | [1, 2, 3, 4, 5]      | [1, 2, 3, 4, 5]       | [1, 2, 3, 4, 5]       |
| Reverse Sorted           | [5, 4, 3, 2, 1]      | [1, 2, 3, 4, 5]       | [1, 2, 3, 4, 5]       |
| Duplicates               | [3, 1, 2, 3, 1]      | [1, 1, 2, 3, 3]       | [1, 1, 2, 3, 3]       |
| Large Dataset            | [1000, 999, ..., 1]  | [1, 2, ..., 1000]     | [1, 2, ..., 1000]     |

## Usage Guide
To use the Quick Sort algorithm, follow these steps:
1. Import the `quick_sort` function from the `quick_sort` module.
2. Pass the list of integers to be sorted as an argument to the `quick_sort` function.
3. The function will return the sorted list of integers.

```python
from quick_sort import quick_sort

arr = [64, 34, 25, 12, 22, 11, 90]
sorted_arr = quick_sort(arr)
print("Sorted array is:", sorted_arr)
```
