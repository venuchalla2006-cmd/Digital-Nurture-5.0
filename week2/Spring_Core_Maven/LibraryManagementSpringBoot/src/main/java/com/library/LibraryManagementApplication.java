package com.library;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
        System.out.println("=== Library Management Spring Boot Application Started Successfully ===");
    }

    // Seed sample database data
    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            repository.save(new Book(null, "Spring Boot in Action", "Craig Walls"));
            repository.save(new Book(null, "Clean Architecture", "Robert C. Martin"));
            System.out.println("Seeded database with sample books.");
        };
    }
}
