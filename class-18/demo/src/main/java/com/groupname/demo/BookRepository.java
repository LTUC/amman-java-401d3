package com.groupname.demo;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    Iterable<Book> findAllByTitle(String title);
//    Iterable<Book> findAllByBookAuthor(Author author);
}
