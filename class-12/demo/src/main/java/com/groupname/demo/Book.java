package com.groupname.demo;
import javax.persistence.*;

@Entity
// default table name will match class name
// @Table(name = "tableName")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String title;

    public Book(){

    }

    public Book(String author, String title) {
        this();
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
