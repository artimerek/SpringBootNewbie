package io.github.artimerek.logic;

import io.github.artimerek.TaskConfigurationProperties;
import io.github.artimerek.model.ProjectRepository;
import io.github.artimerek.model.TaskGroupRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogicConfiguration {
    @Bean
    ProjectService service(ProjectRepository repository, TaskGroupRepository taskGroupRepository,
                           TaskConfigurationProperties config
    ){
        return new ProjectService(repository, taskGroupRepository, config);
    }
}
