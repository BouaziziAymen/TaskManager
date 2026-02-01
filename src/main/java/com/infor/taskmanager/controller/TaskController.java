package com.infor.taskmanager.controller;

import com.infor.taskmanager.dto.TaskDto;
import com.infor.taskmanager.mapper.TaskMapper;
import com.infor.taskmanager.model.Priority;
import com.infor.taskmanager.model.Task;
import com.infor.taskmanager.repository.TaskRepository;
import com.infor.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping
    public Page<TaskDto> getAllTasks(@RequestParam(required = false) Priority priority, @PageableDefault(size = 5)Pageable pageable){
        return taskService.getTasks(priority,pageable);
    }

    @PostMapping
    public TaskDto createTask(@RequestBody Task task){
        return taskMapper.toDto(taskService.save(task));
    }
}
