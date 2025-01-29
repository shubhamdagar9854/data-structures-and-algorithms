import pytest
from python.algorithms.sorting.bubble_sort.bubble_sort import bubble_sort

def test_bubble_sort_empty():
    """Test bubble sort with an empty list."""
    assert bubble_sort([]) == []

def test_bubble_sort_single_element():
    """Test bubble sort with a single element list."""
    assert bubble_sort([1]) == [1]

def test_bubble_sort_sorted():
    """Test bubble sort with an already sorted list."""
    assert bubble_sort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]

def test_bubble_sort_reverse_sorted():
    """Test bubble sort with a reverse sorted list."""
    assert bubble_sort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]

def test_bubble_sort_duplicates():
    """Test bubble sort with a list containing duplicates."""
    assert bubble_sort([3, 1, 2, 3, 1]) == [1, 1, 2, 3, 3]

def test_bubble_sort_large_dataset():
    """Test bubble sort with a large dataset."""
    large_list = list(range(1000, 0, -1))
    sorted_list = list(range(1, 1001))
    assert bubble_sort(large_list) == sorted_list
