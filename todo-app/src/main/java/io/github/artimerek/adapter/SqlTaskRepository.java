package io.github.artimerek.adapter;

import io.github.artimerek.model.Task;
import io.github.artimerek.model.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
    @Override
    @Query(nativeQuery = true, value = "select  count (*) > 0 from tasks where id=:id")
    boolean existsById(@Param("id")Integer id);

    @Override
    boolean existsByDoneIsFalseAndAndGroup_Id(Integer groupId);
}
