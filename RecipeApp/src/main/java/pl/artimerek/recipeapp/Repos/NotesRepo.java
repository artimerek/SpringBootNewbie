package pl.artimerek.recipeapp.Repos;

import org.springframework.data.repository.CrudRepository;
import pl.artimerek.recipeapp.Domain.Notes;

public interface NotesRepo extends CrudRepository <Notes, Long> {
}
