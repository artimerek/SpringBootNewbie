package pl.artimerek.webapp.repos;

import org.springframework.data.repository.CrudRepository;
import pl.artimerek.webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
