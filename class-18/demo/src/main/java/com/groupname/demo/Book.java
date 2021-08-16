package com.groupname.demo;
import javax.persistence.*;
import java.util.List;

@Entity
// default table name will match class name
// @Table(name = "tableName")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private String author;
    private String title;
    @ManyToMany(mappedBy = "books")
    private List<Author> bookAuthors;

    public Book(){

    }

    public Book(List<Author> authors, String title) {
        this.bookAuthors = authors;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getBookAuthor() {
        return bookAuthors;
    }

    public void setBookAuthor(List<Author> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
}
