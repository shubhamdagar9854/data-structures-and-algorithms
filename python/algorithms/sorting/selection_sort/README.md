# Selection Sort Algorithm

## Table of Contents

- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction

Selection Sort is a simple comparison-based sorting algorithm. It divides the input list into two parts: the sublist of items already sorted, which is built up from left to right at the front (left) of the list, and the sublist of items remaining to be sorted that occupy the rest of the list. Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element to the right.

## Algorithm Explanation

1. Start with the first element of the list.
2. Find the smallest element in the unsorted sublist.
3. Swap the smallest element with the first element of the unsorted sublist.
4. Move the boundary of the sorted sublist one element to the right.
5. Repeat steps 2-4 until the entire list is sorted.

## Pseudocode

```
procedure selectionSort(A: list of sortable items)
    n := length(A)
    for i := 0 to n-1 do
        minIndex := i
        for j := i+1 to n-1 do
            if A[j] < A[minIndex] then
                minIndex := j
            end if
        end for
        swap(A[i], A[minIndex])
    end for
end procedure
```

## Time and Space Complexity

- **Best Case:** O(n^2)
- **Average Case:** O(n^2)
- **Worst Case:** O(n^2)
- **Space Complexity:** O(1)

## Mermaid Diagram

```mermaid
graph TD
    A[Start] --> B[Initialize n to length of list]
    B --> C[For i from 0 to n-1]
    C --> D[Set minIndex to i]
    D --> E[For j from i+1 to n-1]
    E --> F{A[j] < A[minIndex]?}
    F -- Yes --> G[Set minIndex to j]
    F -- No --> H[Continue]
    G --> H
    H --> I[Swap A[i] and A[minIndex]]
    I --> C
    C --> J[End]
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

To use the Selection Sort algorithm, follow these steps:

1. Import the `selection_sort` function from the `selection_sort` module.
2. Pass the list of integers to be sorted as an argument to the `selection_sort` function.
3. The function will return the sorted list of integers.

```python
from selection_sort import selection_sort

arr = [64, 34, 25, 12, 22, 11, 90]
sorted_arr = selection_sort(arr)
print("Sorted array is:", sorted_arr)
```
