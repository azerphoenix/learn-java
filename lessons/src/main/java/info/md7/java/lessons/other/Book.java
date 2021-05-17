package info.md7.java.lessons.other;


public class Book {

    private String bookName;
    private String bookAuthor;
    private int year;

    public Book(String bookName, String bookAuthor, int year) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.year = year;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", year=" + year +
                '}';
    }
}
