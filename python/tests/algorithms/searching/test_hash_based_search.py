import pytest
from python.algorithms.searching.hash_based_search import hash_based_search

def test_hash_based_search_found_start():
    data = {1: 'a', 2: 'b', 3: 'c', 4: 'd', 5: 'e'}
    target = 1
    assert hash_based_search(data, target) == 'a'

def test_hash_based_search_found_middle():
    data = {1: 'a', 2: 'b', 3: 'c', 4: 'd', 5: 'e'}
    target = 3
    assert hash_based_search(data, target) == 'c'

def test_hash_based_search_found_end():
    data = {1: 'a', 2: 'b', 3: 'c', 4: 'd', 5: 'e'}
    target = 5
    assert hash_based_search(data, target) == 'e'

def test_hash_based_search_not_found():
    data = {1: 'a', 2: 'b', 3: 'c', 4: 'd', 5: 'e'}
    target = 6
    assert hash_based_search(data, target) is None

def test_hash_based_search_empty_dict():
    data = {}
    target = 1
    assert hash_based_search(data, target) is None

def test_hash_based_search_single_element_found():
    data = {1: 'a'}
    target = 1
    assert hash_based_search(data, target) == 'a'

def test_hash_based_search_single_element_not_found():
    data = {1: 'a'}
    target = 2
    assert hash_based_search(data, target) is None
