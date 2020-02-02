package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private BookstoreService bookstoreService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            
            System.out.println("\nAdd author with books  ...");
            bookstoreService.addAuthorWithBooks();

            System.out.println("\nRemove a book of an author...");
            bookstoreService.removeBookOfAuthor();
            
            System.out.println("\nRemove all book of an author...");
            bookstoreService.removeAllBooksOfAuthor();
        };
    }
}
/*
 *How To Programmatically Setup Flyway And PostgreSQL DataSource

Note: For production, don't rely on hibernate.ddl-auto (or counterparts) to export schema DDL to the database. Simply remove (disable) hibernate.ddl-auto or set it to validate. Rely on Flyway or Liquibase.

Description: This application is a kickoff for setting Flyway and PostgreSQL DataSource programmatically.

Key points:

for Maven, in pom.xml, add the Flyway dependency
remove (disable) spring.jpa.hibernate.ddl-auto or set it to validate
configure DataSource and Flyway programmatically
 */
