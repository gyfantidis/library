package library;

import java.util.Objects;

public abstract class Book {
    private String isbn;
    private String title;
    private int copyNumber =0;

    public Book(String isbn, String title, int copyNumber) {
        this.isbn = isbn;
        this.title = title;
        this.copyNumber = copyNumber;
    }

    public String getIsbn() {
        return new String(isbn);
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return new String(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(int copyNumber) {
        this.copyNumber = copyNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", copyNumber=" + copyNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (copyNumber != book.copyNumber) return false;
        if (!Objects.equals(isbn, book.isbn)) return false;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + copyNumber;
        return result;
    }
}
