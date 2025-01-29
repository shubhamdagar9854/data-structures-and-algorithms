"""
Quick Sort Algorithm Implementation
Author: Bjorn Melin
Date: 1/28/2025

Quick Sort is a divide-and-conquer algorithm that selects a pivot element 
and partitions the array into two sub-arrays, according to whether they 
are less than or greater than the pivot. The sub-arrays are then sorted 
recursively.

Time Complexity:
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n^2)

Space Complexity: O(log n)
"""

from typing import List

def quick_sort(arr: List[int]) -> List[int]:
    """
    Sorts an array of integers using the Quick Sort algorithm.

    Args:
        arr (List[int]): The list of integers to be sorted.

    Returns:
        List[int]: The sorted list of integers.
    """
    if len(arr) <= 1:
        return arr

    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]

    return quick_sort(left) + middle + quick_sort(right)
