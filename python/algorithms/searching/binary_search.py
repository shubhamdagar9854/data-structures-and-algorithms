def binary_search(arr, target):
    """
    Perform a binary search on the given sorted list to find the target element.

    Args:
        arr (list): The sorted list to search through.
        target: The element to search for.

    Returns:
        int: The index of the target element if found, otherwise -1.

    Time Complexity:
        Best Case: O(1) - When the target is at the middle position.
        Average Case: O(log n) - When the target is somewhere in the list.
        Worst Case: O(log n) - When the target is at the last position or not present.

    Space Complexity: O(1) - Only a constant amount of extra space is used.
    """
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


def binary_search_recursive(arr, target, left=0, right=None):
    """
    Perform a recursive binary search on the given sorted list to find the target element.

    Args:
        arr (list): The sorted list to search through.
        target: The element to search for.
        left (int): The starting index of the sublist to search.
        right (int): The ending index of the sublist to search.

    Returns:
        int: The index of the target element if found, otherwise -1.

    Time Complexity:
        Best Case: O(1) - When the target is at the middle position.
        Average Case: O(log n) - When the target is somewhere in the list.
        Worst Case: O(log n) - When the target is at the last position or not present.

    Space Complexity: O(log n) - Due to the recursive call stack.
    """
    if right is None:
        right = len(arr) - 1

    if left > right:
        return -1

    mid = left + (right - left) // 2

    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        return binary_search_recursive(arr, target, mid + 1, right)
    else:
        return binary_search_recursive(arr, target, left, mid - 1)
