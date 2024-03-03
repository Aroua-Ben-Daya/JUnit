package books.to.read;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookShelf {
    private List<Book> books;

    public BookShelf() {
        this.books = new ArrayList<>();
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int numberOfBooks() {
        return books.size();
    }
    public void arrangeByTitle() {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }
}
