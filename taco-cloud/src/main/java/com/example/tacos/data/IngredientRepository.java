package com.example.tacos.data;

import org.springframework.data.repository.CrudRepository;
import com.example.tacos.Ingredient;

public interface IngredientRepository  extends  CrudRepository <Ingredient, String>{

}
