package io.github.artimerek.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskGroupRepository {
    List<TaskGroup> findAll();

    Optional<TaskGroup> findById(Integer id);

    TaskGroup save(TaskGroup entity);

    Page<TaskGroup> findAll(Pageable page);

    boolean existsByDoneIsFalseAndAndProject_Id(Integer projectId);

    boolean existsByDoneIsFalseAndProject_Id(int projectId);

    boolean existsByDoneIsFalseAndProject_Id(Integer projectId);
}
