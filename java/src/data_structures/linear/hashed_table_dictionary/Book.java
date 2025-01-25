package data_structures.linear.hashed_table_dictionary;

/**
 * Book Object
 * 
 * @author bjornmelin
 */
public class Book implements Comparable<Book> {

    private String title;
    private int pageCount;
    private int wordCount;

    /**
     * Default COnstructor for Book Object
     */
    public Book() {
        setTitle("Undefined");
        setPageCount(-1);
        setWordCount(-1);
    }

    /**
     * Full parameter constructor for Book Object
     * Used in the driver to add Books to the Hashed Table Book Dictionary
     * 
     * @param bookTitle String denoting the title of the Book
     * @param page      int denoting the page count of the book
     * @param word      int denoting the word count of the book
     */
    public Book(String bookTitle, int page, int word) {
        title = bookTitle;
        pageCount = page;
        wordCount = word;
    }

    /**
     * Calculates how enjoyable the book is based on page count
     * 
     * @return enjoyment level based on pages
     */
    public int calculateEnjoyment() {
        return pageCount / 50;
    }

    /**
     * HashCode method added to Book so it generates hash Code based on the Books
     * title
     * 
     * @return hash code for the book based on title
     */
    @Override
    public int hashCode() {
        return (title.hashCode());
    }

    /**
     * Sets the Book's Title
     * 
     * @param inTitle String to set the Title as
     */
    public void setTitle(String inTitle) {
        title = inTitle;
    }

    /**
     * Sets the Book's Page Title
     * 
     * @param inPageCount Number to set the Page Count
     */
    public void setPageCount(int inPageCount) {
        if (inPageCount > 0) {
            pageCount = inPageCount;
        }
    }

    /**
     * Sets the Book's Page Count
     * 
     * @param inWordCount Number to set the Word Count
     */
    public void setWordCount(int inWordCount) {
        if (inWordCount > 0) {
            wordCount = inWordCount;
        }
    }

    /**
     * Returns the Book's Title
     * 
     * @return Number of Pages
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the Book's Page Count
     * 
     * @return Number of Pages in the Book
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Returns the Book's Word Count
     * 
     * @return Number of Words in the Book
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Returns a String describing the Book
     * 
     * @return String describing the Book
     */
    public String toString() {
        return "Book{" + "title=" + title + ", pageCount=" + pageCount + ", wordCount=" + wordCount + ", joy="
                + calculateEnjoyment() + '}';
    }

    @Override
    public int compareTo(Book o) {
        return this.getWordCount() - o.getWordCount();
    }
}