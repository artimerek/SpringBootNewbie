package com.example.tacos.data;

import com.example.tacos.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends  CrudRepository <Taco, Long> {
}
