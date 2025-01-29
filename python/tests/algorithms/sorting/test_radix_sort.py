import pytest
from python.algorithms.sorting.radix_sort.radix_sort import radix_sort

def test_radix_sort_empty():
    """
    Test radix sort with an empty list.
    """
    assert radix_sort([]) == []

def test_radix_sort_single_element():
    """
    Test radix sort with a single element list.
    """
    assert radix_sort([1]) == [1]

def test_radix_sort_sorted():
    """
    Test radix sort with an already sorted list.
    """
    assert radix_sort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]

def test_radix_sort_reverse_sorted():
    """
    Test radix sort with a reverse sorted list.
    """
    assert radix_sort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]

def test_radix_sort_duplicates():
    """
    Test radix sort with a list containing duplicates.
    """
    assert radix_sort([3, 1, 2, 3, 1]) == [1, 1, 2, 3, 3]

def test_radix_sort_large_dataset():
    """
    Test radix sort with a large dataset.
    """
    large_list = list(range(1000, 0, -1))
    sorted_list = list(range(1, 1001))
    assert radix_sort(large_list) == sorted_list
