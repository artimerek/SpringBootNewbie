package io.github.artimerek.adapter;

import io.github.artimerek.model.Project;
import io.github.artimerek.model.ProjectRepository;
import io.github.artimerek.model.TaskGroup;
import io.github.artimerek.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {
    @Override
    @Query("select distinct p from Project p join fetch p.steps")
    List<Project> findAll();
}
