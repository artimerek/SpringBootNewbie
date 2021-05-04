package pl.artimerek.recipeapp.Repos;

import org.springframework.data.repository.CrudRepository;
import pl.artimerek.recipeapp.Domain.Unit;

import java.util.Optional;

public interface UnitRepo extends CrudRepository<Unit,Long> {

    Optional<Unit> findByDescription(String description);
}
