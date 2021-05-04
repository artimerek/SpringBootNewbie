package pl.artimerek.recipeapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.artimerek.recipeapp.Domain.Ingredient;
import pl.artimerek.recipeapp.Domain.Recipe;
import pl.artimerek.recipeapp.Repos.CategoryRepo;
import pl.artimerek.recipeapp.Repos.RecipeRepo;
import pl.artimerek.recipeapp.Repos.UnitRepo;

import java.util.*;

@Controller
public class IndexController {

    private CategoryRepo categoryRepo;
    private UnitRepo unitRepo;
    private RecipeRepo recipeRepo;

    public IndexController(CategoryRepo categoryRepo, UnitRepo unitRepo, RecipeRepo recipeRepo) {
        this.categoryRepo = categoryRepo;
        this.unitRepo = unitRepo;
        this.recipeRepo = recipeRepo;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
//        System.out.println("test");

        List<Recipe> recipes = new ArrayList<>();
        recipeRepo.findAll().forEach(recipes::add);

    model.addAttribute("recipes",recipeRepo.findAll());

//    Optional<Recipe> ing = recipeRepo.findById(3l);
//    Recipe recipe= ing.get();
//    Set<Ingredient> ingredients = recipe.getIngredients();
//    model.addAttribute("recipes2",ingredients);








        return "index";
    }
}
