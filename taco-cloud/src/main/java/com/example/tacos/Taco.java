package com.example.tacos;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min=5, message="Nazwa musi składać się min. z 5 liter")
    private String name;
    @Size(min=1, message="Taco musi przynajmniej zawierać jeden składnik")
    private List<String> ingredients;

}
