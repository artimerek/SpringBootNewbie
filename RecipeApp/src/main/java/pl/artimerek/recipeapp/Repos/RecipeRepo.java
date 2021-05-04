package pl.artimerek.recipeapp.Repos;

import org.springframework.data.repository.CrudRepository;
import pl.artimerek.recipeapp.Domain.Recipe;

import java.util.Optional;


public interface RecipeRepo extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByDescription(String description);


}
