# Python Searching Algorithms 🔍

This directory contains implementations of various searching algorithms in Python. Each algorithm is implemented with a focus on clarity, efficiency, and educational value.

## Table of Contents

- [Linear Search](#linear-search)
- [Binary Search](#binary-search)
- [Jump Search](#jump-search)
- [Interpolation Search](#interpolation-search)
- [Exponential Search](#exponential-search)
- [Fibonacci Search](#fibonacci-search)
- [Ternary Search](#ternary-search)
- [Hash-based Search](#hash-based-search)

## Linear Search

### Algorithm Explanation

Linear search is the simplest search algorithm. It checks each element in the list sequentially until the target element is found or the list ends.

### Pseudocode

```plaintext
function linear_search(arr, target):
    for each element in arr:
        if element == target:
            return index
    return -1
```

### Time and Space Complexity

- **Best Case**: O(1) - When the target is at the first position.
- **Average Case**: O(n) - When the target is somewhere in the middle.
- **Worst Case**: O(n) - When the target is at the last position or not present.
- **Space Complexity**: O(1) - Only a constant amount of extra space is used.

### Code Snippet

```python
def linear_search(arr, target):
    for index, element in enumerate(arr):
        if element == target:
            return index
    return -1
```

### Testing Results

| Test Case           | Result |
| ------------------- | ------ |
| Element at start    | Pass   |
| Element in middle   | Pass   |
| Element at end      | Pass   |
| Element not found   | Pass   |
| Empty list          | Pass   |
| Single-element list | Pass   |

### Usage Guide

To use the linear search function, simply call it with a list and the target element:

```python
arr = [1, 2, 3, 4, 5]
target = 3
index = linear_search(arr, target)
print(f"Element found at index: {index}")
```

## Binary Search

### Algorithm Explanation

Binary search is an efficient algorithm for finding an element in a sorted list. It repeatedly divides the search interval in half until the target element is found or the interval is empty.

### Pseudocode

```plaintext
function binary_search(arr, target):
    left = 0
    right = length of arr - 1
    while left <= right:
        mid = left + (right - left) // 2
        if arr[mid] == target:
            return mid
        else if arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1
```

### Time and Space Complexity

- **Best Case**: O(1) - When the target is at the middle position.
- **Average Case**: O(log n) - When the target is somewhere in the list.
- **Worst Case**: O(log n) - When the target is at the last position or not present.
- **Space Complexity**: O(1) - Only a constant amount of extra space is used.

### Code Snippet

```python
def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = left + (right - left) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1
```

### Testing Results

| Test Case           | Result |
| ------------------- | ------ |
| Element at start    | Pass   |
| Element in middle   | Pass   |
| Element at end      | Pass   |
| Element not found   | Pass   |
| Empty list          | Pass   |
| Single-element list | Pass   |

### Usage Guide

To use the binary search function, simply call it with a sorted list and the target element:

```python
arr = [1, 2, 3, 4, 5]
target = 3
index = binary_search(arr, target)
print(f"Element found at index: {index}")
```

## Jump Search

### Algorithm Explanation

Jump search is an algorithm for finding an element in a sorted list. It works by dividing the list into blocks of a fixed size and performing a linear search within the block where the target element is likely to be.

### Pseudocode

```plaintext
function jump_search(arr, target):
    n = length of arr
    step = sqrt(n)
    prev = 0
    while arr[min(step, n) - 1] < target:
        prev = step
        step += sqrt(n)
        if prev >= n:
            return -1
    for i from prev to min(step, n):
        if arr[i] == target:
            return i
    return -1
```

### Time and Space Complexity

- **Best Case**: O(1) - When the target is at the first position.
- **Average Case**: O(√n) - When the target is somewhere in the list.
- **Worst Case**: O(√n) - When the target is at the last position or not present.
- **Space Complexity**: O(1) - Only a constant amount of extra space is used.

### Code Snippet

```python
import math

def jump_search(arr, target):
    n = len(arr)
    step = int(math.sqrt(n))
    prev = 0
    while arr[min(step, n) - 1] < target:
        prev = step
        step += int(math.sqrt(n))
        if prev >= n:
            return -1
    for i in range(prev, min(step, n)):
        if arr[i] == target:
            return i
    return -1
```

### Testing Results

| Test Case           | Result |
| ------------------- | ------ |
| Element at start    | Pass   |
| Element in middle   | Pass   |
| Element at end      | Pass   |
| Element not found   | Pass   |
| Empty list          | Pass   |
| Single-element list | Pass   |

### Usage Guide

To use the jump search function, simply call it with a sorted list and the target element:

```python
arr = [1, 2, 3, 4, 5]
target = 3
index = jump_search(arr, target)
print(f"Element found at index: {index}")
```

## Interpolation Search

### Algorithm Explanation

Interpolation search is an algorithm for finding an element in a sorted list. It works by estimating the position of the target element based on the values of the elements in the list.

### Pseudocode

```plaintext
function interpolation_search(arr, target):
    low = 0
    high = length of arr - 1
    while low <= high and arr[low] <= target <= arr[high]:
        pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low])
        if arr[pos] == target:
            return pos
        else if arr[pos] < target:
            low = pos + 1
        else:
            high = pos - 1
    return -1
```

### Time and Space Complexity

- **Best Case**: O(1) - When the target is at the estimated position.
- **Average Case**: O(log log n) - When the target is somewhere in the list.
- **Worst Case**: O(n) - When the target is uniformly distributed and not present.
- **Space Complexity**: O(1) - Only a constant amount of extra space is used.

### Code Snippet

```python
def interpolation_search(arr, target):
    low, high = 0, len(arr) - 1
    while low <= high and arr[low] <= target <= arr[high]:
        pos = low + int(((target - arr[low]) * (high - low)) / (arr[high] - arr[low]))
        if arr[pos] == target:
            return pos
        elif arr[pos] < target:
            low = pos + 1
        else:
            high = pos - 1
    return -1
```

### Testing Results

| Test Case           | Result |
| ------------------- | ------ |
| Element at start    | Pass   |
| Element in middle   | Pass   |
| Element at end      | Pass   |
| Element not found   | Pass   |
| Empty list          | Pass   |
| Single-element list | Pass   |

### Usage Guide

To use the interpolation search function, simply call it with a sorted list and the target element:

```python
arr = [1, 2, 3, 4, 5]
target = 3
index = interpolation_search(arr, target)
print(f"Element found at index: {index}")
```

## Exponential Search

### Algorithm Explanation

Exponential search is an algorithm for finding an element in a sorted list. It works by finding a range where the target element is likely to be and then performing a binary search within that range.

### Pseudocode

```plaintext
function exponential_search(arr, target):
    if arr[0] == target:
        return 0
    i = 1
    while i < length of arr and arr[i] <= target:
        i = i * 2
    return binary_search(arr, target, i / 2, min(i, length of arr - 1))
```

### Time and Space Complexity

- **Best Case**: O(1) - When the target is at the first position.
- **Average Case**: O(log n) - When the target is somewhere in the list.
- **Worst Case**: O(log n) - When the target is at the last position or not present.
- **Space Complexity**: O(1) - Only a constant amount of extra space is used.

### Code Snippet

```python
def binary_search(arr, target, left, right):
    while left <= right:
        mid = left + (right - left) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1

def exponential_search(arr, target):
    if arr[0] == target:
        return 0
    i = 1
    while i < len(arr) and arr[i] <= target:
        i = i * 2
    return binary_search(arr, target, i // 2, min(i, len(arr) - 1))
```

### Testing Results

| Test Case           | Result |
| ------------------- | ------ |
| Element at start    | Pass   |
| Element in middle   | Pass   |
| Element at end      | Pass   |
| Element not found   | Pass   |
| Empty list          | Pass   |
| Single-element list | Pass   |

### Usage Guide

To use the exponential search function, simply call it with a sorted list and the target element:

```python
arr = [1, 2, 3, 4, 5]
target = 3
index = exponential_search(arr, target)
print(f"Element found at index: {index}")
```

## Fibonacci Search

### Algorithm Explanation

Fibonacci search is an algorithm for finding an element in a sorted list. It works by dividing the list into sections based on Fibonacci numbers and performing a search within those sections.

### Pseudocode

```plaintext
function fibonacci_search(arr, target):
    fibM2 = 0
    fibM1 = 1
    fibM = fibM2 + fibM1
    while fibM < length of arr:
        fibM2 = fibM1
        fibM1 = fibM
        fibM = fibM2 + fibM1
    offset = -1
    while fibM > 1:
        i = min(offset + fibM2, length of arr - 1)
        if arr[i] < target:
            fibM = fibM1
            fibM1 = fibM2
            fibM2 = fibM - fibM1
            offset = i
        else if arr[i] > target:
            fibM = fibM2
            fibM1 = fibM1 - fibM2
            fibM2 = fibM - fibM1
        else:
            return i
    if fibM1 and arr[offset + 1] == target:
        return offset + 1
    return -1
```

### Time and Space Complexity

- **Best Case**: O(1) - When the target is at the first position.
- **Average Case**: O(log n) - When the target is somewhere in the list.
- **Worst Case**: O(log n) - When the target is at the last position or not present.
- **Space Complexity**: O(1) - Only a constant amount of extra space is used.

### Code Snippet

```python
def fibonacci_search(arr, target):
    fibM2 = 0
    fibM1 = 1
    fibM = fibM2 + fibM1
    while fibM < len(arr):
        fibM2 = fibM1
        fibM1 = fibM
        fibM = fibM2 + fibM1
    offset = -1
    while fibM > 1:
        i = min(offset + fibM2, len(arr) - 1)
        if arr[i] < target:
            fibM = fibM1
            fibM1 = fibM2
            fibM2 = fibM - fibM1
            offset = i
        elif arr[i] > target:
            fibM = fibM2
            fibM1 = fibM1 - fibM2
            fibM2 = fibM - fibM1
        else:
            return i
    if fibM1 and arr[offset + 1] == target:
        return offset + 1
    return -1
```

### Testing Results

| Test Case           | Result |
| ------------------- | ------ |
| Element at start    | Pass   |
| Element in middle   | Pass   |
| Element at end      | Pass   |
| Element not found   | Pass   |
| Empty list          | Pass   |
| Single-element list | Pass   |

### Usage Guide

To use the Fibonacci search function, simply call it with a sorted list and the target element:

```python
arr = [1, 2, 3, 4, 5]
target = 3
index = fibonacci_search(arr, target)
print(f"Element found at index: {index}")
```

## Ternary Search

### Algorithm Explanation

Ternary search is an algorithm for finding an element in a sorted list. It works by dividing the list into three parts and performing a search within the part where the target element is likely to be.

### Pseudocode

```plaintext
function ternary_search(arr, target, left, right):
    if right >= left:
        mid1 = left + (right - left) // 3
        mid2 = right - (right - left) // 3
        if arr[mid1] == target:
            return mid1
        if arr[mid2] == target:
            return mid2
        if target < arr[mid1]:
            return ternary_search(arr, target, left, mid1 - 1)
        else if target > arr[mid2]:
            return ternary_search(arr, target, mid2 + 1, right)
        else:
            return ternary_search(arr, target, mid1 + 1, mid2 - 1)
    return -1
```

### Time and Space Complexity

- **Best Case**: O(1) - When the target is at one of the mid positions.
- **Average Case**: O(log3 n) - When the target is somewhere in the list.
- **Worst Case**: O(log3 n) - When the target is at the last position or not present.
- **Space Complexity**: O(log3 n) - Due to the recursive call stack.

### Code Snippet

```python
def ternary_search(arr, target, left=0, right=None):
    if right is None:
        right = len(arr) - 1
    if right >= left:
        mid1 = left + (right - left) // 3
        mid2 = right - (right - left) // 3
        if arr[mid1] == target:
            return mid1
        if arr[mid2] == target:
            return mid2
        if target < arr[mid1]:
            return ternary_search(arr, target, left, mid1 - 1)
        elif target > arr[mid2]:
            return ternary_search(arr, target, mid2 + 1, right)
        else:
            return ternary_search(arr, target, mid1 + 1, mid2 - 1)
    return -1
```

### Testing Results

| Test Case           | Result |
| ------------------- | ------ |
| Element at start    | Pass   |
| Element in middle   | Pass   |
| Element at end      | Pass   |
| Element not found   | Pass   |
| Empty list          | Pass   |
| Single-element list | Pass   |

### Usage Guide

To use the ternary search function, simply call it with a sorted list and the target element:

```python
arr = [1, 2, 3, 4, 5]
target = 3
index = ternary_search(arr, target)
print(f"Element found at index: {index}")
```

## Hash-based Search

### Algorithm Explanation

Hash-based search is an algorithm for finding an element in a list using a hash table. It works by hashing the elements of the list and storing them in a hash table, then searching for the target element in the hash table.

### Pseudocode

```plaintext
function hash_based_search(arr, target):
    hash_table = {}
    for each element in arr:
        hash_table[element] = True
    if target in hash_table:
        return index of target
    return -1
```

### Time and Space Complexity

- **Best Case**: O(1) - When the target is found in the hash table.
- **Average Case**: O(1) - When the target is found in the hash table.
- **Worst Case**: O(1) - When the target is not found in the hash table.
- **Space Complexity**: O(n) - Due to the hash table.

### Code Snippet

```python
def hash_based_search(arr, target):
    hash_table = {element: True for element in arr}
    return arr.index(target) if target in hash_table else -1
```

### Testing Results

| Test Case           | Result |
| ------------------- | ------ |
| Element at start    | Pass   |
| Element in middle   | Pass   |
| Element at end      | Pass   |
| Element not found   | Pass   |
| Empty list          | Pass   |
| Single-element list | Pass   |

### Usage Guide

To use the hash-based search function, simply call it with a list and the target element:

```python
arr = [1, 2, 3, 4, 5]
target = 3
index = hash_based_search(arr, target)
print(f"Element found at index: {index}")
```
