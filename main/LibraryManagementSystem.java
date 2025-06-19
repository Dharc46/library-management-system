package main;

import model.Book;
import model.User;
import service.LibraryService;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHệ thống quản lý thư viện");
            System.out.println("1. Thêm sách");
            System.out.println("2. Sửa sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Tìm kiếm sách theo tiêu đề");
            System.out.println("5. Tìm kiếm sách theo tác giả");
            System.out.println("6. Mượn sách");
            System.out.println("7. Trả sách");
            System.out.println("8. Hiển thị tất cả sách");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1:
                    System.out.print("Nhập tiêu đề: ");
                    String title = scanner.nextLine();
                    System.out.print("Nhập tác giả: ");
                    String author = scanner.nextLine();
                    System.out.print("Nhập năm xuất bản: ");
                    int year = scanner.nextInt();
                    Book book = new Book(0, title, author, year, true);
                    libraryService.addBook(book);
                    System.out.println("Thêm sách thành công!");
                    break;
                case 2:
                    System.out.print("Nhập ID sách cần sửa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tiêu đề mới: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Nhập tác giả mới: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Nhập năm xuất bản mới: ");
                    int newYear = scanner.nextInt();
                    Book updatedBook = new Book(id, newTitle, newAuthor, newYear, true);
                    libraryService.updateBook(updatedBook);
                    System.out.println("Sửa sách thành công!");
                    break;
                case 3:
                    System.out.print("Nhập ID sách cần xóa: ");
                    int deleteId = scanner.nextInt();
                    libraryService.deleteBook(deleteId);
                    System.out.println("Xóa sách thành công!");
                    break;
                case 4:
                    System.out.print("Nhập tiêu đề cần tìm: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> booksByTitle = libraryService.searchBooksByTitle(searchTitle);
                    booksByTitle.forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Nhập tác giả cần tìm: ");
                    String searchAuthor = scanner.nextLine();
                    List<Book> booksByAuthor = libraryService.searchBooksByAuthor(searchAuthor);
                    booksByAuthor.forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("Nhập ID sách: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên người mượn: ");
                    String userName = scanner.nextLine();
                    User user = new User(0, userName);
                    libraryService.borrowBook(bookId, user);
                    System.out.println("Mượn sách thành công!");
                    break;
                case 7:
                    System.out.print("Nhập ID sách: ");
                    int returnBookId = scanner.nextInt();
                    libraryService.returnBook(returnBookId);
                    System.out.println("Trả sách thành công!");
                    break;
                case 8:
                    List<Book> allBooks = libraryService.getAllBooks();
                    allBooks.forEach(System.out::println);
                    break;
                case 9:
                    System.out.println("Tạm biệt!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}