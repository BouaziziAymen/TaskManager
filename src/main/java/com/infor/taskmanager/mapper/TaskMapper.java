package com.infor.taskmanager.mapper;

import com.infor.taskmanager.dto.TaskDto;
import com.infor.taskmanager.model.Task;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);
    List<TaskDto> toDtoList(List<Task> tasks);
    Task toEntity(TaskDto dto);
}
