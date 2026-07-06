package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Loading Spring Context (XML + Annotations) ===");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("=== Spring Context Loaded Successfully ===\n");

        // 1. Test XML-Configured Beans (Exercises 1, 2, 7)
        System.out.println("--- Testing XML Configured BookService (with Constructor & Setter DI) ---");
        BookService xmlService = (BookService) context.getBean("xmlBookService");
        xmlService.addBook("Spring in Action (XML)");
        System.out.println("Books in XML Repository: " + xmlService.listBooks());
        System.out.println();

        // 2. Test Annotation-Configured Beans (Exercise 6)
        System.out.println("--- Testing Annotation Configured BookService (with Component Scan & @Autowired) ---");
        BookService annotationService = context.getBean(BookService.class);
        annotationService.addBook("Design Patterns (Annotation)");
        System.out.println("Books in Annotation Repository: " + annotationService.listBooks());
        System.out.println();

        System.out.println("=== All Spring Core & Maven Exercises Completed Successfully ===");
    }
}
