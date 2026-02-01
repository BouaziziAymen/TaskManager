package com.infor.taskmanager.service;

import com.infor.taskmanager.dto.TaskDto;
import com.infor.taskmanager.mapper.TaskMapper;
import com.infor.taskmanager.model.Priority;
import com.infor.taskmanager.model.Task;
import com.infor.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
public Page<TaskDto> getTasks(Priority priority, Pageable pageable){
    if(priority!=null){
        return taskRepository.findByPriority(priority,pageable).map(taskMapper::toDto);
    }
    return taskRepository.findAll(pageable).map(taskMapper::toDto);
}

    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
