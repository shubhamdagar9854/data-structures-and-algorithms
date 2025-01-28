# Insertion Sort Algorithm

## Table of Contents
- [Introduction](#introduction)
- [Algorithm Explanation](#algorithm-explanation)
- [Pseudocode](#pseudocode)
- [Time and Space Complexity](#time-and-space-complexity)
- [Mermaid Diagram](#mermaid-diagram)
- [Testing Results](#testing-results)
- [Usage Guide](#usage-guide)

## Introduction
Insertion Sort is a simple comparison-based sorting algorithm. It builds the final 
sorted array one item at a time. It is much less efficient on large lists than more 
advanced algorithms such as quicksort, heapsort, or merge sort.

## Algorithm Explanation
1. Start with the first element of the list.
2. Compare the current element with the elements in the sorted sublist.
3. Shift all elements in the sorted sublist that are greater than the current element 
   to the right.
4. Insert the current element into its correct position in the sorted sublist.
5. Move to the next element and repeat steps 2-4 until the entire list is sorted.

## Pseudocode
```
procedure insertionSort(A: list of sortable items)
    for i := 1 to length(A) - 1 do
        key := A[i]
        j := i - 1
        while j >= 0 and A[j] > key do
            A[j + 1] := A[j]
            j := j - 1
        end while
        A[j + 1] := key
    end for
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
    A[Start] --> B[For i from 1 to length(A)-1]
    B --> C[Set key to A[i]]
    C --> D[Set j to i-1]
    D --> E{j >= 0 and A[j] > key?}
    E -- Yes --> F[Set A[j+1] to A[j]]
    F --> G[Decrement j by 1]
    G --> E
    E -- No --> H[Set A[j+1] to key]
    H --> B
    B --> I[End]
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
To use the Insertion Sort algorithm, follow these steps:
1. Import the `insertion_sort` function from the `insertion_sort` module.
2. Pass the list of integers to be sorted as an argument to the `insertion_sort` 
   function.
3. The function will return the sorted list of integers.

```python
from insertion_sort import insertion_sort

arr = [64, 34, 25, 12, 22, 11, 90]
sorted_arr = insertion_sort(arr)
print("Sorted array is:", sorted_arr)
```
