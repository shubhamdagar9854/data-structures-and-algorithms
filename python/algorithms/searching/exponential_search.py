from typing import List, Any

def binary_search(arr: List[Any], target: Any, left: int, right: int) -> int:
    """
    Perform a binary search on the given sorted list to find the target element.

    Args:
        arr (List[Any]): The sorted list to search through.
        target (Any): The element to search for.
        left (int): The starting index of the sublist to search.
        right (int): The ending index of the sublist to search.

    Returns:
        int: The index of the target element if found, otherwise -1.

    Time Complexity:
        Best Case: O(1) - When the target is at the middle position.
        Average Case: O(log n) - When the target is somewhere in the list.
        Worst Case: O(log n) - When the target is at the last position or not present.

    Space Complexity: O(1) - Only a constant amount of extra space is used.
    """
    while left <= right:
        mid = left + (right - left) // 2

        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return -1

def exponential_search(arr: List[Any], target: Any) -> int:
    """
    Perform an exponential search on the given sorted list to find the target element.

    Args:
        arr (List[Any]): The sorted list to search through.
        target (Any): The element to search for.

    Returns:
        int: The index of the target element if found, otherwise -1.

    Time Complexity:
        Best Case: O(1) - When the target is at the first position.
        Average Case: O(log n) - When the target is somewhere in the list.
        Worst Case: O(log n) - When the target is at the last position or not present.

    Space Complexity: O(1) - Only a constant amount of extra space is used.
    """
    if arr[0] == target:
        return 0

    n = len(arr)
    i = 1
    while i < n and arr[i] <= target:
        i *= 2

    return binary_search(arr, target, i // 2, min(i, n - 1))
