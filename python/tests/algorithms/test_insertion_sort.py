import pytest
from algorithms.sorting.insertion_sort import insertion_sort

def test_insertion_sort_empty():
    """
    Test insertion sort with an empty list.
    """
    assert insertion_sort([]) == []

def test_insertion_sort_single_element():
    """
    Test insertion sort with a single element list.
    """
    assert insertion_sort([1]) == [1]

def test_insertion_sort_sorted():
    """
    Test insertion sort with an already sorted list.
    """
    assert insertion_sort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]

def test_insertion_sort_reverse_sorted():
    """
    Test insertion sort with a reverse sorted list.
    """
    assert insertion_sort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]

def test_insertion_sort_duplicates():
    """
    Test insertion sort with a list containing duplicates.
    """
    assert insertion_sort([3, 1, 2, 3, 1]) == [1, 1, 2, 3, 3]

def test_insertion_sort_large_dataset():
    """
    Test insertion sort with a large dataset.
    """
    large_list = list(range(1000, 0, -1))
    sorted_list = list(range(1, 1001))
    assert insertion_sort(large_list) == sorted_list
