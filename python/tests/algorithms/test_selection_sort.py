import pytest
from algorithms.sorting.selection_sort import selection_sort

def test_selection_sort_empty():
    """Test selection sort with an empty list."""
    assert selection_sort([]) == []

def test_selection_sort_single_element():
    """Test selection sort with a single element list."""
    assert selection_sort([1]) == [1]

def test_selection_sort_sorted():
    """Test selection sort with an already sorted list."""
    assert selection_sort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]

def test_selection_sort_reverse_sorted():
    """Test selection sort with a reverse sorted list."""
    assert selection_sort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]

def test_selection_sort_duplicates():
    """Test selection sort with a list containing duplicates."""
    assert selection_sort([3, 1, 2, 3, 1]) == [1, 1, 2, 3, 3]

def test_selection_sort_large_dataset():
    """Test selection sort with a large dataset."""
    large_list = list(range(1000, 0, -1))
    sorted_list = list(range(1, 1001))
    assert selection_sort(large_list) == sorted_list
