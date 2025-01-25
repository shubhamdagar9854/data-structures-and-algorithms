# Hashed Table Dictionary Implementation

A Java implementation of a Hashed Table Dictionary data structure that stores Book objects. This implementation uses chaining for collision resolution by maintaining an array of LinkedLists.

## Features

- Fixed-size hash table with 31 buckets
- Chaining for collision resolution using LinkedLists
- Book objects as values with title-based hashing
- Support for duplicate book titles

## Structure

The implementation consists of three main classes:

1. `HashedTableBook.java` - The hash table implementation
2. `Book.java` - The Book class representing the values stored in the hash table
3. `Driver.java` - Example usage and testing

## API

### HashedTableBook

- `HashedTableBook()` - Creates a new hash table with 31 buckets
- `void add(Book value)` - Adds a book to the hash table
- `ArrayList<Book> get(String targetTitle)` - Retrieves all books with the given title
- `String toString()` - Returns a string representation of the hash table

### Book

- `Book()` - Creates a default book
- `Book(String title, int pageCount, int wordCount)` - Creates a book with specified properties
- Various getters and setters for title, page count, and word count
- `int calculateEnjoyment()` - Calculates an enjoyment score based on page count
- `int hashCode()` - Generates a hash code based on the book's title

## Usage Example

```java
HashedTableBook library = new HashedTableBook();

// Adding books
library.add(new Book("Data Structures", 565, 100000));
library.add(new Book("Algorithms", 432, 80000));

// Retrieving books by title
ArrayList<Book> results = library.get("Data Structures");
```

## Implementation Details

The hash table uses chaining for collision resolution, where each bucket contains a LinkedList of Book objects. When adding a book:

1. The book's title is used to generate a hash code
2. The hash code is mapped to a bucket index using modulo
3. The book is added to the LinkedList at that index

When retrieving books by title:

1. The title is used to generate a hash code
2. The hash code is mapped to a bucket index using modulo
3. The LinkedList at that index is searched for matching titles
4. All matching books are returned in an ArrayList

## Time Complexity

- Add: O(1) average case, O(n) worst case
- Get: O(1) average case, O(n) worst case
  where n is the number of items in the bucket

## Space Complexity

O(n) where n is the total number of books stored
