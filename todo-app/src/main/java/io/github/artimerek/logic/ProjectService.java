package io.github.artimerek.logic;

import io.github.artimerek.TaskConfigurationProperties;
import io.github.artimerek.model.*;
import io.github.artimerek.model.projection.GroupReadModel;
import io.github.artimerek.model.projection.GroupTaskWriteModel;
import io.github.artimerek.model.projection.GroupWriteModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

//@Service
public class ProjectService {

    private ProjectRepository repository;
    private TaskGroupRepository taskGroupRepository;
    private TaskConfigurationProperties config;
    private TaskGroupService service;


    public ProjectService(ProjectRepository repository, TaskGroupRepository taskGroupRepository,
                          TaskConfigurationProperties config, TaskGroupService service) {
        this.repository = repository;
        this.taskGroupRepository = taskGroupRepository;
        this.config = config;
        this.service = service;
    }

    public List<Project> readAll(){
        return repository.findAll();
    }

    public Project save(Project toSave){
        return repository.save(toSave);
    }

    public GroupReadModel createGroup(LocalDateTime deadline, int projectId){
        if(!config.getTemplate().isAllowMultipleTasks()  && taskGroupRepository.existsByDoneIsFalseAndAndProject_Id(projectId)) {
            throw new IllegalStateException("Only one undone group from project is allowed");
        }
        return repository.findById(projectId)
                .map(project -> {
                    var targetGroup = new GroupWriteModel();
                    targetGroup.setDescription(project.getDescription());
                    targetGroup.setTasks(
                            project.getSteps().stream()
                                    .map(projectStep -> {
                                                var task = new GroupTaskWriteModel();
                                                task.setDescription(projectStep.getDescription());
                                                task.setDeadline(  deadline.plusDays(projectStep.getDaysToDeadline()));
                                                return task;
                                       }
                                    ).collect(Collectors.toSet())
                    );
                    return service.createGroup(targetGroup);
                }).orElseThrow(() -> new IllegalArgumentException("Project with given id not found"));
    }

}
