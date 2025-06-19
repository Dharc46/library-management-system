package service;

import dao.BookDAO;
import model.Book;
import model.User;

import java.util.List;

public class LibraryService {
    private BookDAO bookDAO = new BookDAO();

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookDAO.searchBooksByTitle(title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return bookDAO.searchBooksByAuthor(author);
    }

    public void borrowBook(int bookId, User user) {
        bookDAO.borrowBook(bookId, user);
    }

    public void returnBook(int bookId) {
        bookDAO.returnBook(bookId);
    }
}