package pl.artimerek.recipeapp.Services;

import pl.artimerek.recipeapp.Domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}