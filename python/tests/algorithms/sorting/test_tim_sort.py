import pytest
from python.algorithms.sorting.tim_sort.tim_sort import tim_sort

def test_tim_sort_empty():
    """
    Test Tim Sort with an empty list.
    """
    assert tim_sort([]) == []

def test_tim_sort_single_element():
    """
    Test Tim Sort with a single element list.
    """
    assert tim_sort([1]) == [1]

def test_tim_sort_sorted():
    """
    Test Tim Sort with an already sorted list.
    """
    assert tim_sort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]

def test_tim_sort_reverse_sorted():
    """
    Test Tim Sort with a reverse sorted list.
    """
    assert tim_sort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]

def test_tim_sort_duplicates():
    """
    Test Tim Sort with a list containing duplicates.
    """
    assert tim_sort([3, 1, 2, 3, 1]) == [1, 1, 2, 3, 3]

def test_tim_sort_large_dataset():
    """
    Test Tim Sort with a large dataset.
    """
    large_list = list(range(1000, 0, -1))
    sorted_list = list(range(1, 1001))
    assert tim_sort(large_list) == sorted_list
