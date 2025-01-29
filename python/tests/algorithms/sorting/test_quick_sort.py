import pytest
from python.algorithms.sorting.quick_sort.quick_sort import quick_sort

def test_quick_sort_empty():
    """
    Test quick sort with an empty list.
    """
    assert quick_sort([]) == []

def test_quick_sort_single_element():
    """
    Test quick sort with a single element list.
    """
    assert quick_sort([1]) == [1]

def test_quick_sort_sorted():
    """
    Test quick sort with an already sorted list.
    """
    assert quick_sort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]

def test_quick_sort_reverse_sorted():
    """
    Test quick sort with a reverse sorted list.
    """
    assert quick_sort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]

def test_quick_sort_duplicates():
    """
    Test quick sort with a list containing duplicates.
    """
    assert quick_sort([3, 1, 2, 3, 1]) == [1, 1, 2, 3, 3]

def test_quick_sort_large_dataset():
    """
    Test quick sort with a large dataset.
    """
    large_list = list(range(1000, 0, -1))
    sorted_list = list(range(1, 1001))
    assert quick_sort(large_list) == sorted_list
