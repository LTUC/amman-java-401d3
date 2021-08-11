package com.groupname.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/book/{word}")
    public String getBooks(Model model, @RequestParam String word){
        Book harryPotter = new Book(1,"J.K Rowlling", "Harry Potter and the prisoner of Azkaban");
        Book digitalFortress = new Book(2, "Dan Brown","Digital Fortress");
        List<Book> books = new ArrayList<Book>();
        books.add(harryPotter);
        books.add(digitalFortress);

        model.addAttribute("books",books);
        return "books.html";
    }

}
