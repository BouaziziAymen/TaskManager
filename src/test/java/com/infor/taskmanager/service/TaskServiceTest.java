package com.infor.taskmanager.service;

import com.infor.taskmanager.dto.TaskDto;
import com.infor.taskmanager.mapper.TaskMapper;
import com.infor.taskmanager.model.Priority;
import com.infor.taskmanager.model.Task;
import com.infor.taskmanager.repository.TaskRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @Mock
    private TaskMapper taskMapper;

    @InjectMocks
    private TaskService service;

    @Test
    @DisplayName("Should  successfully")
    void shouldSuccessfully() {
        // Given
        var priority = Priority.HIGH;
        var pageable = PageRequest.of(0, 10);
        var list = List.of(Task.builder().priority(Priority.HIGH).title("Test task 1").build());
        BDDMockito.given(repository.findByPriority(priority, pageable)).willReturn(new PageImpl<>(list, pageable, list.size()));
        BDDMockito.given(taskMapper.toDto(any(Task.class)))
                .willAnswer(invocation -> {
                    Task source = invocation.getArgument(0);
                    return TaskDto.builder().title(source.getTitle()).build();
                });

        // When
        var result = service.getTasks(Priority.HIGH, PageRequest.of(0, 10));

        // Then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getContent().get(0).getTitle()).isEqualTo("Test task 1");
    }
}