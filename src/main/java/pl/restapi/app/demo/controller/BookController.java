package pl.restapi.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.restapi.app.demo.model.Book;
import pl.restapi.app.demo.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("books")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @PostMapping("books")
    public Book addBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @PutMapping("books/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn, @RequestBody Book book){
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);

        if (optionalBook.isPresent()){
            optionalBook.get().setAuthor(book.getAuthor());
            optionalBook.get().setTitle(book.getTitle());
            optionalBook.get().setIsbn(book.getIsbn());
            return new ResponseEntity<>(bookRepository.save(optionalBook.get()), HttpStatus.OK); //200
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
    }

    @DeleteMapping("books/{isbn}")
    public ResponseEntity<Book> deleteBook(@PathVariable String isbn){

        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);

        if (optionalBook.isPresent()){
            bookRepository.delete(optionalBook.get());
            return new ResponseEntity<>(HttpStatus.OK); //200
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
    }
}
