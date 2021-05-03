package pl.artimerek.recipeapp.Repos;

import org.springframework.data.repository.CrudRepository;
import pl.artimerek.recipeapp.Domain.Recipe;


public interface RecipeRepo extends CrudRepository<Recipe, Long> {


}
