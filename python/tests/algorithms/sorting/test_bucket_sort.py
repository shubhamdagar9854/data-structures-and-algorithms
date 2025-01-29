import pytest
from python.algorithms.sorting.bucket_sort.bucket_sort import bucket_sort

def test_bucket_sort_empty():
    """
    Test bucket sort with an empty list.
    """
    assert bucket_sort([]) == []

def test_bucket_sort_single_element():
    """
    Test bucket sort with a single element list.
    """
    assert bucket_sort([1]) == [1]

def test_bucket_sort_sorted():
    """
    Test bucket sort with an already sorted list.
    """
    assert bucket_sort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]

def test_bucket_sort_reverse_sorted():
    """
    Test bucket sort with a reverse sorted list.
    """
    assert bucket_sort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]

def test_bucket_sort_duplicates():
    """
    Test bucket sort with a list containing duplicates.
    """
    assert bucket_sort([3, 1, 2, 3, 1]) == [1, 1, 2, 3, 3]

def test_bucket_sort_large_dataset():
    """
    Test bucket sort with a large dataset.
    """
    large_list = list(range(1000, 0, -1))
    sorted_list = list(range(1, 1001))
    assert bucket_sort(large_list) == sorted_list
