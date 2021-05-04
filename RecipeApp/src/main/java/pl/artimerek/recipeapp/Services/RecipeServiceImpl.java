package pl.artimerek.recipeapp.Services;

import org.springframework.stereotype.Service;
import pl.artimerek.recipeapp.Domain.Recipe;
import pl.artimerek.recipeapp.Repos.RecipeRepo;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepo recipeRepository;

    public RecipeServiceImpl(RecipeRepo recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}