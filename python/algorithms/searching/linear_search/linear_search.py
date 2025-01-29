def linear_search(arr, target):
    """
    Perform a linear search on the given list to find the target element.

    Args:
        arr (list): The list to search through.
        target: The element to search for.

    Returns:
        int: The index of the target element if found, otherwise -1.

    Time Complexity:
        Best Case: O(1) - When the target is at the first position.
        Average Case: O(n) - When the target is somewhere in the middle.
        Worst Case: O(n) - When the target is at the last position or not present.

    Space Complexity: O(1) - Only a constant amount of extra space is used.
    """
    for index, element in enumerate(arr):
        if element == target:
            return index
    return -1
