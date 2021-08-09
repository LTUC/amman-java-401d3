package com.groupname.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/book")
    public String getBooks(Model model){
//        Book harryPotter = new Book(1,"J.K Rowlling", "Harry Potter and the prisoner of Azkaban");
//        Book digitalFortress = new Book(2, "Dan Brown","Digital Fortress");
//        List<Book> books = new ArrayList<Book>();
//        books.add(harryPotter);
//        books.add(digitalFortress);

        model.addAttribute("books",bookRepository.findAll());
        return "books.html";
    }

    // post request
    @GetMapping("/addbook") // this should be a post, we are just adding it as get to run the function without using a form
    public RedirectView addBook(){
        Book book = new Book("J.K Rowlling","Harry Potter and the prisoner of Azkaban");
        bookRepository.save(book);
        return new RedirectView("/book");
    }

}
