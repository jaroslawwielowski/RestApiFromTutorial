package pl.restapi.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.restapi.app.demo.model.Book;
import pl.restapi.app.demo.repository.BookRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("books")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @PostMapping("books")
    public Book addBook(@RequestBody Book book){
        return bookRepository.save(book);
    }
}
