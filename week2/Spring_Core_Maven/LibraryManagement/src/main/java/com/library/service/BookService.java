package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    // Constructor Injection (Exercise 7)
    public BookService() {
        System.out.println("BookService: Created with default constructor");
    }

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Instantiated via constructor injection");
    }

    // Setter Injection (Exercise 2 and 7)
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via setter");
    }

    public void addBook(String title) {
        System.out.println("Service: Adding book - " + title);
        bookRepository.save(title);
    }

    public List<String> listBooks() {
        System.out.println("Service: Retrieving book list");
        return bookRepository.findAll();
    }
}
