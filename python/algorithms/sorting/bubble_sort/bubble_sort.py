"""
Bubble Sort Algorithm Implementation
Author: Bjorn Melin
Date: 1/28/2025

Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, 
compares adjacent elements and swaps them if they are in the wrong order. 
The pass through the list is repeated until the list is sorted.

Time Complexity:
- Best Case: O(n) when the array is already sorted
- Average Case: O(n^2)
- Worst Case: O(n^2)

Space Complexity: O(1)
"""

from typing import List

def bubble_sort(arr: List[int]) -> List[int]:
    """
    Sorts an array of integers using the Bubble Sort algorithm.

    Args:
        arr (List[int]): The list of integers to be sorted.

    Returns:
        List[int]: The sorted list of integers.
    """
    n = len(arr)
    for i in range(n):
        swapped = False
        for j in range(0, n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swapped = True
        if not swapped:
            break
    return arr
