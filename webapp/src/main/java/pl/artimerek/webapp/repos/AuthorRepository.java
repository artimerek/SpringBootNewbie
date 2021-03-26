package pl.artimerek.webapp.repos;

import org.springframework.data.repository.CrudRepository;
import pl.artimerek.webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
