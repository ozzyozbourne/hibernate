package org.example.store;

import lombok.val;
import org.example.pojo.Book;
import org.example.pojo.Chapter;
import org.example.pojo.Publisher;

import java.util.List;

public class BookStoreClient {

    private final BookStoreService bookStoreService = new BookStoreService();


    public void persistANewBook(){
        val publisher = new Publisher("MANN", "Manning Publications co");
        val chapters = List.of(new Chapter("Intro to Hibernate", 1), new Chapter("JPA deep dive", 2));
        val book = new Book("2342353454523", "JAVA Persistance A deep dive", publisher, chapters);
        bookStoreService.persist(book);
    }

}
