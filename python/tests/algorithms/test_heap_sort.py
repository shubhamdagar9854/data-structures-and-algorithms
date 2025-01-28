import pytest
from algorithms.sorting.heap_sort import heap_sort

def test_heap_sort_empty():
    """
    Test heap sort with an empty list.
    """
    assert heap_sort([]) == []

def test_heap_sort_single_element():
    """
    Test heap sort with a single element list.
    """
    assert heap_sort([1]) == [1]

def test_heap_sort_sorted():
    """
    Test heap sort with an already sorted list.
    """
    assert heap_sort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]

def test_heap_sort_reverse_sorted():
    """
    Test heap sort with a reverse sorted list.
    """
    assert heap_sort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]

def test_heap_sort_duplicates():
    """
    Test heap sort with a list containing duplicates.
    """
    assert heap_sort([3, 1, 2, 3, 1]) == [1, 1, 2, 3, 3]

def test_heap_sort_large_dataset():
    """
    Test heap sort with a large dataset.
    """
    large_list = list(range(1000, 0, -1))
    sorted_list = list(range(1, 1001))
    assert heap_sort(large_list) == sorted_list
