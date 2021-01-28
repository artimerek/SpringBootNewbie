package io.github.artimerek.logic;

import io.github.artimerek.TaskConfigurationProperties;
import io.github.artimerek.model.ProjectRepository;
import io.github.artimerek.model.TaskGroupRepository;
import io.github.artimerek.model.TaskRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogicConfiguration {
    @Bean
    ProjectService projectService(ProjectRepository repository, TaskGroupRepository taskGroupRepository,
                           TaskConfigurationProperties config
    ){
        return new ProjectService(repository, taskGroupRepository, config);
    }

    @Bean
    TaskGroupService taskGroupService(TaskGroupRepository taskGroupRepository,
                                      @Qualifier("sqlTaskRepository") TaskRepository taskRepository){
        return new TaskGroupService(taskGroupRepository,taskRepository);
    }
}
