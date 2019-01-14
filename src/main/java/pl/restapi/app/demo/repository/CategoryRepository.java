package pl.restapi.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.restapi.app.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
