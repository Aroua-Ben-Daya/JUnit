package books.to.read;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookShelfTest {
    private BookShelf bookShelf;

    @BeforeEach
    void setUp() {
        // Initialiser une nouvelle étagère avant chaque test
        bookShelf = new BookShelf();
    }

    @Test
    void emptyBookShelfWhenNoBookAdded() {
        assertTrue(bookShelf.isEmpty(), "L'étagère devrait être vide initialement.");
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        bookShelf.addBook("Harry Potter");
        bookShelf.addBook("Madame Bovary");
        
        assertEquals(2, bookShelf.numberOfBooks(), "L'étagère devrait contenir deux livres après avoir ajouté deux livres.");
    }
    @Test
    void emptyBookShelfWhenAddIsCalledWithoutBooks() {
        bookShelf.addBooks();

        assertTrue(bookShelf.isEmpty(), "L'étagère devrait rester vide si aucun livre n'est ajouté.");
    }

    @Test
    void booksReturnedFromBookShelfIsImmutableForClient() {
        bookShelf.addBooks("1984", "To Kill a Mockingbird");
        // Récupérer la liste de livres
        List<String> books = bookShelf.getBooks();

        // Essayer de modifier la liste récupérée
        assertThrows(UnsupportedOperationException.class, () -> books.add("Pride and Prejudice"),
                "La liste de livres renvoyée par l'étagère devrait être immuable.");
    }
    
    @Test
    void bookshelfArrangedByBookTitle() {
        bookShelf.addBook(new Book("Harry Potter", "J.K. Rowling", 1997));
        bookShelf.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        bookShelf.arrangeByTitle();

        List<Book> arrangedBooks = bookShelf.getBooks();
        assertEquals("Harry Potter", arrangedBooks.get(0).getTitle(), "Le premier livre devrait être 'Harry Potter'.");
        assertEquals("The Lord of the Rings", arrangedBooks.get(1).getTitle(), "Le deuxième livre devrait être 'The Lord of the Rings'.");
    }

    @Test
    void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
        Book book1 = new Book("Harry Potter", "J.K. Rowling", 1997);
        Book book2 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        bookShelf.addBook(book1);
        bookShelf.addBook(book2);
        bookShelf.arrangeByTitle();

        List<Book> arrangedBooks = bookShelf.getBooks();
        assertSame(book1, arrangedBooks.get(0), "Le premier livre devrait être 'Harry Potter' comme il a été ajouté en premier.");
        assertSame(book2, arrangedBooks.get(1), "Le deuxième livre devrait être 'The Lord of the Rings' comme il a été ajouté en second.");
    }
    
    
    
}
