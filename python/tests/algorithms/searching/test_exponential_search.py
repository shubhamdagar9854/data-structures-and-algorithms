import pytest
from python.algorithms.searching.exponential_search import exponential_search

def test_exponential_search_found_start():
    arr = [1, 2, 3, 4, 5]
    target = 1
    assert exponential_search(arr, target) == 0

def test_exponential_search_found_middle():
    arr = [1, 2, 3, 4, 5]
    target = 3
    assert exponential_search(arr, target) == 2

def test_exponential_search_found_end():
    arr = [1, 2, 3, 4, 5]
    target = 5
    assert exponential_search(arr, target) == 4

def test_exponential_search_not_found():
    arr = [1, 2, 3, 4, 5]
    target = 6
    assert exponential_search(arr, target) == -1

def test_exponential_search_empty_list():
    arr = []
    target = 1
    assert exponential_search(arr, target) == -1

def test_exponential_search_single_element_found():
    arr = [1]
    target = 1
    assert exponential_search(arr, target) == 0

def test_exponential_search_single_element_not_found():
    arr = [1]
    target = 2
    assert exponential_search(arr, target) == -1
