package pl.artimerek.webapp.repos;

import org.springframework.data.repository.CrudRepository;
import pl.artimerek.webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
