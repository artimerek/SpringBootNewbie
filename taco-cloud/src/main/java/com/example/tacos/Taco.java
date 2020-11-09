package com.example.tacos;


import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min=5, message="Nazwa musi składać się min. z 5 liter")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min=1, message="Taco musi przynajmniej zawierać jeden składnik")
    private List<String> ingredients;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

}
