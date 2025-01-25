# Contributing Guidelines 🤝

Thank you for considering contributing to our Data Structures and Algorithms repository! This document outlines the guidelines for contributing to this project.

## Table of Contents
- [Code of Conduct](#code-of-conduct)
- [How Can I Contribute?](#how-can-i-contribute)
- [Style Guidelines](#style-guidelines)
- [Pull Request Process](#pull-request-process)
- [Development Setup](#development-setup)

## Code of Conduct
This project and everyone participating in it are governed by our Code of Conduct. By participating, you are expected to uphold this code.

## How Can I Contribute?

### Implementing New Algorithms or Data Structures
1. Check if the implementation already exists
2. Follow the established project structure
3. Include comprehensive tests
4. Add proper documentation
5. Update the respective language's README.md

### Improving Existing Implementations
- Optimize performance
- Enhance documentation
- Add more test cases
- Fix bugs

### Adding New Language Implementations
1. Create a new directory for the language
2. Follow the established project structure
3. Include language-specific README.md
4. Implement core data structures and algorithms
5. Add comprehensive tests
6. Update main README.md with language support

## Style Guidelines

### General Guidelines
- Write clear, readable code
- Include time and space complexity analysis
- Document public interfaces thoroughly
- Follow language-specific conventions

### Java
- Follow Oracle's Java Code Conventions
- Use PascalCase for class names
- Use camelCase for methods and variables
- Maximum line length: 100 characters
- Include JavaDoc comments

### Python
- Follow PEP 8 guidelines
- Use snake_case for functions and variables
- Use PascalCase for class names
- Include type hints (Python 3.8+)
- Follow Google docstring style

## Pull Request Process

1. Fork the repository
2. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Make your changes:
   - Follow style guidelines
   - Add/update tests
   - Update documentation
4. Commit your changes:
   ```bash
   git commit -m "feat: add binary search implementation in Java"
   ```
5. Push to your fork:
   ```bash
   git push origin feature/your-feature-name
   ```
6. Create a Pull Request

### Commit Message Format
Follow conventional commits:
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `test`: Adding or updating tests
- `refactor`: Code refactoring
- `style`: Code style changes

Example:
```
feat(java): add quick sort implementation

- Add QuickSort.java with generic type support
- Include comprehensive test cases
- Update documentation with time complexity analysis
```

## Development Setup

### Java
```bash
cd java
./gradlew build
./gradlew test
```

### Python
```bash
cd python
python -m venv venv
source venv/bin/activate  # or `venv\Scripts\activate` on Windows
pip install -r requirements.txt
pytest
```

## Testing Guidelines

### Required Tests
- Edge cases (empty input, single element, etc.)
- Random input
- Large datasets
- Performance benchmarks

### Example Test Structure
```python
def test_binary_search():
    # Setup
    arr = [1, 2, 3, 4, 5]
    
    # Edge cases
    assert binary_search([], 1) == -1
    assert binary_search([1], 1) == 0
    
    # Normal cases
    assert binary_search(arr, 3) == 2
    assert binary_search(arr, 5) == 4
    
    # Not found cases
    assert binary_search(arr, 6) == -1
```

---

Thank you for contributing to our project! 🎉