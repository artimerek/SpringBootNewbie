package pl.artimerek.recipeapp.Repos;

import org.springframework.data.repository.CrudRepository;
import pl.artimerek.recipeapp.Domain.Category;

import java.util.Optional;

public interface CategoryRepo extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
