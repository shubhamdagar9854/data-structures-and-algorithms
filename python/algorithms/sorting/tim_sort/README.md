# Tim Sort Algorithm

## Table of Contents

- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction

Tim Sort is a hybrid sorting algorithm derived from merge sort and insertion sort. It is used in Python's built-in `sorted()` and `.sort()` methods. Tim Sort divides the array into small chunks called "runs" and sorts them using insertion sort, then merges the sorted runs using merge sort.

## Algorithm Explanation

1. Divide the array into small chunks called "runs".
2. Sort each run using insertion sort.
3. Merge the sorted runs using merge sort.

## Pseudocode

```
procedure timSort(A: list of sortable items)
    n := length(A)
    for i := 0 to n by MIN_RUN do
        insertionSort(A, i, min((i + MIN_RUN - 1), (n - 1)))
    end for
    size := MIN_RUN
    while size < n do
        for left := 0 to n by 2 * size do
            mid := min((n - 1), (left + size - 1))
            right := min((left + 2 * size - 1), (n - 1))
            if mid < right then
                merge(A, left, mid, right)
            end if
        end for
        size := size * 2
    end while
end procedure

procedure insertionSort(A: list of sortable items, left: int, right: int)
    for i := left + 1 to right do
        key := A[i]
        j := i - 1
        while j >= left and A[j] > key do
            A[j + 1] := A[j]
            j := j - 1
        end while
        A[j + 1] := key
    end for
end procedure

procedure merge(A: list of sortable items, left: int, mid: int, right: int)
    len1 := mid - left + 1
    len2 := right - mid
    leftPart := empty list
    rightPart := empty list
    for i := 0 to len1 do
        append A[left + i] to leftPart
    end for
    for i := 0 to len2 do
        append A[mid + 1 + i] to rightPart
    end for
    i := 0
    j := 0
    k := left
    while i < len1 and j < len2 do
        if leftPart[i] <= rightPart[j] then
            A[k] := leftPart[i]
            i := i + 1
        else
            A[k] := rightPart[j]
            j := j + 1
        end if
        k := k + 1
    end while
    while i < len1 do
        A[k] := leftPart[i]
        i := i + 1
        k := k + 1
    end while
    while j < len2 do
        A[k] := rightPart[j]
        j := j + 1
        k := k + 1
    end while
end procedure
```

## Time and Space Complexity

- **Best Case:** O(n)
- **Average Case:** O(n log n)
- **Worst Case:** O(n log n)
- **Space Complexity:** O(n)

## Mermaid Diagram

```mermaid
graph TD
    A[Start] --> B[Divide the array into small chunks called "runs"]
    B --> C[Sort each run using insertion sort]
    C --> D[Merge the sorted runs using merge sort]
    D --> E[End]
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

To use the Tim Sort algorithm, follow these steps:

1. Import the `tim_sort` function from the `tim_sort` module.
2. Pass the list of integers to be sorted as an argument to the `tim_sort` function.
3. The function will return the sorted list of integers.

```python
from tim_sort import tim_sort

arr = [64, 34, 25, 12, 22, 11, 90]
sorted_arr = tim_sort(arr)
print("Sorted array is:", sorted_arr)
```
