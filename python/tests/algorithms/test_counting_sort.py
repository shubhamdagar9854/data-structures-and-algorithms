import pytest
from algorithms.sorting.counting_sort import counting_sort

def test_counting_sort_empty():
    """
    Test counting sort with an empty list.
    """
    assert counting_sort([]) == []

def test_counting_sort_single_element():
    """
    Test counting sort with a single element list.
    """
    assert counting_sort([1]) == [1]

def test_counting_sort_sorted():
    """
    Test counting sort with an already sorted list.
    """
    assert counting_sort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]

def test_counting_sort_reverse_sorted():
    """
    Test counting sort with a reverse sorted list.
    """
    assert counting_sort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]

def test_counting_sort_duplicates():
    """
    Test counting sort with a list containing duplicates.
    """
    assert counting_sort([3, 1, 2, 3, 1]) == [1, 1, 2, 3, 3]

def test_counting_sort_large_dataset():
    """
    Test counting sort with a large dataset.
    """
    large_list = list(range(1000, 0, -1))
    sorted_list = list(range(1, 1001))
    assert counting_sort(large_list) == sorted_list
