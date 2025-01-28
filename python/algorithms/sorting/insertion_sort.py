"""
Insertion Sort Algorithm Implementation
Author: Bjorn Melin
Date: 1/28/2025

Insertion Sort is a simple comparison-based sorting algorithm. It builds the final 
sorted array one item at a time. It is much less efficient on large lists than more 
advanced algorithms such as quicksort, heapsort, or merge sort.

Time Complexity:
- Best Case: O(n) when the array is already sorted
- Average Case: O(n^2)
- Worst Case: O(n^2)

Space Complexity: O(1)
"""

from typing import List

def insertion_sort(arr: List[int]) -> List[int]:
    """
    Sorts an array of integers using the Insertion Sort algorithm.

    Args:
        arr (List[int]): The list of integers to be sorted.

    Returns:
        List[int]: The sorted list of integers.
    """
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key
    return arr
