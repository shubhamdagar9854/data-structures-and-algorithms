# Python Implementations 🐍

> Clean and efficient implementations of data structures and algorithms in Python, emphasizing readability and Pythonic design patterns.

## Table of Contents
- [Requirements](#requirements)
- [Setup](#setup)
- [Project Structure](#project-structure)
- [Testing](#testing)
- [Style Guide](#style-guide)
- [Documentation](#documentation)

## 🔧 Requirements
- Python 3.8 or higher
- pytest (testing framework)
- black (code formatter)
- mypy (optional static type checking)

## 📦 Setup

```bash
# Navigate to Python directory
cd python

# Create virtual environment
python -m venv venv

# Activate virtual environment
# On Windows:
venv\Scripts\activate
# On Unix or MacOS:
source venv/bin/activate

# Install dependencies
pip install -r requirements.txt

# Run tests
pytest

# Format code
black .

# Type checking (optional)
mypy .
```

## 📁 Project Structure

```plaintext
python/
├── algorithms/
│   ├── sorting/
│   │   ├── quick_sort.py
│   │   ├── merge_sort.py
│   │   └── heap_sort.py
│   ├── searching/
│   │   ├── binary_search.py
│   │   └── linear_search.py
│   └── graph/
│       ├── dfs.py
│       └── bfs.py
├── data_structures/
│   ├── linear/
│   │   ├── linked_list.py
│   │   ├── stack.py
│   │   └── queue.py
│   ├── trees/
│   │   ├── binary_tree.py
│   │   └── avl_tree.py
│   └── graphs/
│       └── graph.py
├── tests/
│   ├── algorithms/
│   └── data_structures/
├── requirements.txt
└── setup.py
```

## ✅ Testing
All implementations include comprehensive unit tests using pytest:

```python
def test_quick_sort_random_array():
    """Test quicksort with a random array of integers."""
    arr = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
    expected = [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9]
    
    assert quick_sort(arr) == expected
```

## 📝 Style Guide
- Follow PEP 8 guidelines
- Use snake_case for functions and variables
- Use PascalCase for class names
- Include type hints (Python 3.8+)
- Maximum line length: 88 characters (Black default)

Example:
```python
from typing import Generic, TypeVar, Optional

T = TypeVar('T')

class BinarySearchTree(Generic[T]):
    """
    Implements a generic Binary Search Tree data structure.
    
    Attributes:
        root: The root node of the tree
    """
    
    def __init__(self) -> None:
        self.root: Optional[Node[T]] = None
    
    def insert(self, element: T) -> bool:
        """
        Insert a new element into the tree.
        
        Args:
            element: The element to insert
            
        Returns:
            bool: True if insertion was successful
            
        Raises:
            ValueError: If element is None
        """
        if element is None:
            raise ValueError("Element cannot be None")
        # Implementation details...
```

## 📚 Documentation

### Common Operations Complexity

| Data Structure | Access | Search | Insertion | Deletion |
|---------------|---------|---------|------------|----------|
| List | O(1) | O(n) | O(n) | O(n) |
| Dict | N/A | O(1) | O(1) | O(1) |
| Set | N/A | O(1) | O(1) | O(1) |
| Binary Search Tree | O(log n) | O(log n) | O(log n) | O(log n) |

### Implementation Notes
- Emphasis on Pythonic implementations
- Type hints used throughout the codebase
- Generator patterns used where appropriate
- Context managers implemented where relevant
- Comprehensive docstrings following Google style

### Performance Tips
- Using `collections` for specialized data structures
- Leveraging built-in Python functions
- List comprehensions over explicit loops
- Proper use of generators for memory efficiency

---
For more details, check the [main documentation](../README.md).