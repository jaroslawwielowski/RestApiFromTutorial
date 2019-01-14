package pl.restapi.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.restapi.app.demo.model.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);
}
