package com.library.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final List<String> books = new ArrayList<>();

    public BookRepository() {
        // Adding sample books
        books.add("Effective Java");
        books.add("Clean Code");
        books.add("Design Patterns");
    }

    public void save(String bookTitle) {
        books.add(bookTitle);
        System.out.println("Repository: Saved book - " + bookTitle);
    }

    public List<String> findAll() {
        System.out.println("Repository: Fetching all books");
        return books;
    }
}
