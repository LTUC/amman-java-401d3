package com.groupname.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    // Add entity
    // get entity (returns one author)
    // get all entities (returns all authors)
    // delete entity (delete one author)
    // delete all entities (delete all authors
    // edit entity (edit an author)

    //@PostMapping("/add-author")   -> should be post, just using get for speed
    @GetMapping("/add-author")
    public void addAuthor(/* an object , a group of arguments*/){
        Author author = new Author("Dan Brown");
        authorRepository.save(author);
    }

    @GetMapping("/authors/{id}")
    public void getAuthorById(@PathVariable(value="id") Integer id, Model m){
        Author author = authorRepository.findById(id).get();
        m.addAttribute("author", author);
        // return template ...
    }

    @GetMapping("/authors")
    public void getAllAuthors(Model m){
        m.addAttribute("authors", authorRepository.findAll());
        // return template
    }



}
