package io.github.artimerek.logic;

import io.github.artimerek.TaskConfigurationProperties;
import io.github.artimerek.model.ProjectRepository;
import io.github.artimerek.model.TaskGroup;
import io.github.artimerek.model.TaskGroupRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProjectServiceTest {

    @Test
    @DisplayName("should throw IllegalStateException when configured to allow just 1 group and the other undone group exists")
    void createGroup_noMultipleGroupsConfig_And_undoneGroupExists_throwsIllegalStateException() {
        //given
        var mockGroupRepository = mock(TaskGroupRepository.class);
        when(mockGroupRepository.existsByDoneIsFalseAndAndProject_Id(anyInt())).thenReturn(true);
        //and
        TaskConfigurationProperties mocConfig = configurationReturning(false);
        //system under test
        var toTest = new ProjectService(null, mockGroupRepository, mocConfig);

        //when
        var exception = catchThrowable(() ->toTest.createGroup(LocalDateTime.now(),0));
        // then
        assertThat(exception)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("one undone group");


        }
        @Test
        @DisplayName("should throw IllegalArgumentException when configuration ok and no projects for a given id")
        void createGroup_configurationOk_And_noProjects_throwsIllegalArgumentException() {
            //given
            var mockRepository = mock(ProjectRepository.class);
            when(mockRepository.findById(anyInt())).thenReturn(Optional.empty());
            //and
            TaskConfigurationProperties mocConfig = configurationReturning(true);
            //system under test
            var toTest = new ProjectService(mockRepository, null, mocConfig);

            //when
            var exception = catchThrowable(() ->toTest.createGroup(LocalDateTime.now(),0));
            // then
            assertThat(exception)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("id not found");


        }

    private TaskConfigurationProperties configurationReturning(boolean result) {
        var mockTemplate = mock(TaskConfigurationProperties.Template.class);
        when(mockTemplate.isAllowMultipleTasks()).thenReturn(result);
        var mocConfig = mock(TaskConfigurationProperties.class);
        when(mocConfig.getTemplate()).thenReturn(mockTemplate);
        return mocConfig;
    }


}

