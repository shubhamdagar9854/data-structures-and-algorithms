import pytest
from python.algorithms.searching.binary_search import binary_search, binary_search_recursive

def test_binary_search_found_start():
    arr = [1, 2, 3, 4, 5]
    target = 1
    assert binary_search(arr, target) == 0

def test_binary_search_found_middle():
    arr = [1, 2, 3, 4, 5]
    target = 3
    assert binary_search(arr, target) == 2

def test_binary_search_found_end():
    arr = [1, 2, 3, 4, 5]
    target = 5
    assert binary_search(arr, target) == 4

def test_binary_search_not_found():
    arr = [1, 2, 3, 4, 5]
    target = 6
    assert binary_search(arr, target) == -1

def test_binary_search_empty_list():
    arr = []
    target = 1
    assert binary_search(arr, target) == -1

def test_binary_search_single_element_found():
    arr = [1]
    target = 1
    assert binary_search(arr, target) == 0

def test_binary_search_single_element_not_found():
    arr = [1]
    target = 2
    assert binary_search(arr, target) == -1

def test_binary_search_recursive_found_start():
    arr = [1, 2, 3, 4, 5]
    target = 1
    assert binary_search_recursive(arr, target) == 0

def test_binary_search_recursive_found_middle():
    arr = [1, 2, 3, 4, 5]
    target = 3
    assert binary_search_recursive(arr, target) == 2

def test_binary_search_recursive_found_end():
    arr = [1, 2, 3, 4, 5]
    target = 5
    assert binary_search_recursive(arr, target) == 4

def test_binary_search_recursive_not_found():
    arr = [1, 2, 3, 4, 5]
    target = 6
    assert binary_search_recursive(arr, target) == -1

def test_binary_search_recursive_empty_list():
    arr = []
    target = 1
    assert binary_search_recursive(arr, target) == -1

def test_binary_search_recursive_single_element_found():
    arr = [1]
    target = 1
    assert binary_search_recursive(arr, target) == 0

def test_binary_search_recursive_single_element_not_found():
    arr = [1]
    target = 2
    assert binary_search_recursive(arr, target) == -1
