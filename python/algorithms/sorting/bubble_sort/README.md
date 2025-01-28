# Bubble Sort Algorithm

## Table of Contents
- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction
Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.

## Algorithm Explanation
1. Start at the beginning of the list.
2. Compare the first two elements.
3. If the first element is greater than the second, swap them.
4. Move to the next pair of elements and repeat step 3.
5. Continue this process until the end of the list.
6. Repeat the entire process for the remaining unsorted elements until the list is sorted.

## Pseudocode
```
procedure bubbleSort(A: list of sortable items)
    n := length(A)
    repeat
        swapped := false
        for i := 1 to n-1 inclusive do
            if A[i-1] > A[i] then
                swap(A[i-1], A[i])
                swapped := true
            end if
        end for
        n := n - 1
    until not swapped
end procedure
```

## Time and Space Complexity
- **Best Case:** O(n) when the array is already sorted
- **Average Case:** O(n^2)
- **Worst Case:** O(n^2)
- **Space Complexity:** O(1)

## Mermaid Diagram
```mermaid
graph TD
    A[Start] --> B[Initialize n to length of list]
    B --> C[Repeat until no swaps]
    C --> D[Set swapped to false]
    D --> E[For i from 1 to n-1]
    E --> F{A[i-1] > A[i]?}
    F -- Yes --> G[Swap A[i-1] and A[i]]
    G --> H[Set swapped to true]
    F -- No --> I[Continue]
    H --> I
    I --> J[Decrease n by 1]
    J --> C
    C --> K[End]
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
To use the Bubble Sort algorithm, follow these steps:
1. Import the `bubble_sort` function from the `bubble_sort` module.
2. Pass the list of integers to be sorted as an argument to the `bubble_sort` function.
3. The function will return the sorted list of integers.

```python
from bubble_sort import bubble_sort

arr = [64, 34, 25, 12, 22, 11, 90]
sorted_arr = bubble_sort(arr)
print("Sorted array is:", sorted_arr)
```
