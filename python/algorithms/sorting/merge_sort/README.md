# Merge Sort Algorithm

## Table of Contents

- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction

Merge Sort is a divide-and-conquer algorithm that divides the input array into two halves, recursively sorts them, and then merges the sorted halves to produce the final sorted array.

## Algorithm Explanation

1. Divide the input array into two halves.
2. Recursively sort each half.
3. Merge the two sorted halves to produce the final sorted array.

## Pseudocode

```
procedure mergeSort(A: list of sortable items)
    if length(A) <= 1 then
        return A
    end if
    mid := length(A) // 2
    left := mergeSort(A[0:mid])
    right := mergeSort(A[mid:length(A)])
    return merge(left, right)
end procedure

procedure merge(left: list of sortable items, right: list of sortable items)
    result := empty list
    while left is not empty and right is not empty do
        if left[0] <= right[0] then
            append left[0] to result
            remove left[0] from left
        else
            append right[0] to result
            remove right[0] from right
        end if
    end while
    append remaining items of left to result
    append remaining items of right to result
    return result
end procedure
```

## Time and Space Complexity

- **Best Case:** O(n log n)
- **Average Case:** O(n log n)
- **Worst Case:** O(n log n)
- **Space Complexity:** O(n)

## Mermaid Diagram

```mermaid
graph TD
    A[Start] --> B[If length(A) <= 1, return A]
    B --> C[Divide A into two halves]
    C --> D[Recursively sort each half]
    D --> E[Merge the two sorted halves]
    E --> F[Return the merged sorted array]
    F --> G[End]
```

## Testing Results

| Test Case      | Input               | Expected Output   | Actual Output     |
| -------------- | ------------------- | ----------------- | ----------------- |
| Empty List     | []                  | []                | []                |
| Single Element | [1]                 | [1]               | [1]               |
| Already Sorted | [1, 2, 3, 4, 5]     | [1, 2, 3, 4, 5]   | [1, 2, 3, 4, 5]   |
| Reverse Sorted | [5, 4, 3, 2, 1]     | [1, 2, 3, 4, 5]   | [1, 2, 3, 4, 5]   |
| Duplicates     | [3, 1, 2, 3, 1]     | [1, 1, 2, 3, 3]   | [1, 1, 2, 3, 3]   |
| Large Dataset  | [1000, 999, ..., 1] | [1, 2, ..., 1000] | [1, 2, ..., 1000] |

## Usage Guide

To use the Merge Sort algorithm, follow these steps:

1. Import the `merge_sort` function from the `merge_sort` module.
2. Pass the list of integers to be sorted as an argument to the `merge_sort` function.
3. The function will return the sorted list of integers.

```python
from merge_sort import merge_sort

arr = [64, 34, 25, 12, 22, 11, 90]
sorted_arr = merge_sort(arr)
print("Sorted array is:", sorted_arr)
```
