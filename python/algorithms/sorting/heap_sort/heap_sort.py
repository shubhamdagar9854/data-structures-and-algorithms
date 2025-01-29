"""
Heap Sort Algorithm Implementation
Author: Bjorn Melin
Date: 1/28/2025

Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure. 
It divides its input into a sorted and an unsorted region, and it iteratively shrinks the 
unsorted region by extracting the largest element and moving that to the sorted region.

Time Complexity:
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n log n)

Space Complexity: O(1)
"""

from typing import List

def heap_sort(arr: List[int]) -> List[int]:
    """
    Sorts an array of integers using the Heap Sort algorithm.

    Args:
        arr (List[int]): The list of integers to be sorted.

    Returns:
        List[int]: The sorted list of integers.
    """
    n = len(arr)

    # Build a maxheap
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # One by one extract elements
    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # swap
        heapify(arr, i, 0)

    return arr

def heapify(arr: List[int], n: int, i: int):
    """
    To heapify a subtree rooted with node i which is an index in arr[].
    n is size of heap.

    Args:
        arr (List[int]): The list of integers to be heapified.
        n (int): The size of the heap.
        i (int): The index of the root node of the subtree.
    """
    largest = i  # Initialize largest as root
    left = 2 * i + 1  # left = 2*i + 1
    right = 2 * i + 2  # right = 2*i + 2

    # See if left child of root exists and is greater than root
    if left < n and arr[i] < arr[left]:
        largest = left

    # See if right child of root exists and is greater than root
    if right < n and arr[largest] < arr[right]:
        largest = right

    # Change root, if needed
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # swap

        # Heapify the root.
        heapify(arr, n, largest)
