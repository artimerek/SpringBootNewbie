package pl.artimerek.recipeapp.Repos;

import org.springframework.data.repository.CrudRepository;
import pl.artimerek.recipeapp.Domain.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {
}
