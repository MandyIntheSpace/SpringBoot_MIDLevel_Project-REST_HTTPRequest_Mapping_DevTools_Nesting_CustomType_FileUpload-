package com.example.rest.bootrestbook.Services;

import com.example.rest.bootrestbook.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private static List<Book> list = new ArrayList<>();
    static {
        list.add(new Book(12, "Java programming", "F1Soft Internationals"));
        list.add(new Book(13, "Python programming", "Mandip Timsina"));
        list.add(new Book(14, "JavaScript programming", "Joel Khakda"));

    }
    public List<Book> getAllBooks() {
        return list;
    }
    public Book getBookById(int id) {
        Book book = null;
        for (Book b : list) {
            if (b.getId() == id) {
                book = b;
                break;
            }
            else {
                return null;
            }
        }
        return book;
    }

    public Book addBook(Book book) {
        list.add(book);
        return book;
    }
//    public Book deleteBook(int id) {
//        Book book = null;
//        for (Book b : list) {
//            if (b.getId() == id) {
//                System.out.println("Got the id");
//                book = b;
//                System.out.println(b);
//                break;
//            }
//            else {
//                return null;
//            }
//        }
//        return book;
//    }

    public void deleteBook(int id) {
        list = list.stream().filter(book -> {
            if (book.getId() != id) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
    }


//    public Book updateBook (Book book, int bookId) {
//        for (Book b : list) {
//            if (b.getId() == bookId) {
//                b.setAuthor(book.getAuthor());
//                b.setTitle(book.getTitle());
//                return b;
//            }
//        }
//        return book;
//    }

    public void updateBook(Book book, int bookId) {
        list = list.stream().map(e -> {
            if (e.getId() == bookId) {
                e.setTitle(book.getTitle());
                e.setAuthor(book.getAuthor());
            }
            return e;
        }).collect(Collectors.toList());
    }


}
