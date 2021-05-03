package pl.artimerek.recipeapp.Repos;

import org.springframework.data.repository.CrudRepository;
import pl.artimerek.recipeapp.Domain.Unit;

public interface UnitRepo extends CrudRepository<Unit,Long> {
}
