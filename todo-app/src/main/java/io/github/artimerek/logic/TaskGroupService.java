package io.github.artimerek.logic;

import io.github.artimerek.TaskConfigurationProperties;
import io.github.artimerek.model.TaskGroup;
import io.github.artimerek.model.TaskGroupRepository;
import io.github.artimerek.model.TaskRepository;
import io.github.artimerek.model.projection.GroupReadModel;
import io.github.artimerek.model.projection.GroupWriteModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskGroupService {
    private TaskGroupRepository repository;
    private TaskRepository taskRepository;
    private TaskConfigurationProperties config;

    public TaskGroupService(TaskGroupRepository repository, TaskRepository taskRepository, TaskConfigurationProperties config) {
        this.repository = repository;
        this.taskRepository = taskRepository;
        this.config = config;
    }

    public GroupReadModel createGroup(GroupWriteModel source){
        TaskGroup result = repository.save(source.toGroup());
        return new GroupReadModel(result);
    }
    public List<GroupReadModel> readAll(){
        return repository.findAll()
                .stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(int groupId){
       if(taskRepository.existsByDoneIsFalseAndAndGroup_Id(groupId)){
           throw new IllegalStateException("Group has undone tasks. Done all the tasks first");
       }
       TaskGroup result = repository.findById(groupId)
               .orElseThrow(() -> new IllegalArgumentException("TaskGroup with given id not found"));
       result.setDone(!result.isDone());
    }
}