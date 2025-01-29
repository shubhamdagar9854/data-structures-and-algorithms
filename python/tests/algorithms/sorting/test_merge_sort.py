import pytest
from python.algorithms.sorting.merge_sort.merge_sort import merge_sort

def test_merge_sort_empty():
    """
    Test merge sort with an empty list.
    """
    assert merge_sort([]) == []

def test_merge_sort_single_element():
    """
    Test merge sort with a single element list.
    """
    assert merge_sort([1]) == [1]

def test_merge_sort_sorted():
    """
    Test merge sort with an already sorted list.
    """
    assert merge_sort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]

def test_merge_sort_reverse_sorted():
    """
    Test merge sort with a reverse sorted list.
    """
    assert merge_sort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]

def test_merge_sort_duplicates():
    """
    Test merge sort with a list containing duplicates.
    """
    assert merge_sort([3, 1, 2, 3, 1]) == [1, 1, 2, 3, 3]

def test_merge_sort_large_dataset():
    """
    Test merge sort with a large dataset.
    """
    large_list = list(range(1000, 0, -1))
    sorted_list = list(range(1, 1001))
    assert merge_sort(large_list) == sorted_list
