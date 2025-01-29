"""
Merge Sort Algorithm Implementation
Author: Bjorn Melin
Date: 1/28/2025

Merge Sort is a divide-and-conquer algorithm that divides the input array into 
two halves, recursively sorts them, and then merges the sorted halves to produce 
the final sorted array.

Time Complexity:
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n log n)

Space Complexity: O(n)
"""

from typing import List


def merge_sort(arr: List[int]) -> List[int]:
    """
    Sorts an array of integers using the Merge Sort algorithm.

    Args:
        arr (List[int]): The list of integers to be sorted.

    Returns:
        List[int]: The sorted list of integers.
    """
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left_half = merge_sort(arr[:mid])
    right_half = merge_sort(arr[mid:])

    return merge(left_half, right_half)


def merge(left: List[int], right: List[int]) -> List[int]:
    """
    Merges two sorted lists into one sorted list.

    Args:
        left (List[int]): The left sorted list.
        right (List[int]): The right sorted list.

    Returns:
        List[int]: The merged sorted list.
    """
    sorted_list = []
    left_index, right_index = 0, 0

    while left_index < len(left) and right_index < len(right):
        if left[left_index] < right[right_index]:
            sorted_list.append(left[left_index])
            left_index += 1
        else:
            sorted_list.append(right[right_index])
            right_index += 1

    sorted_list.extend(left[left_index:])
    sorted_list.extend(right[right_index:])

    return sorted_list
