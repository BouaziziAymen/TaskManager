package com.infor.taskmanager.controller;

import com.infor.taskmanager.model.Priority;
import com.infor.taskmanager.model.Task;
import com.infor.taskmanager.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository repository;
    public TaskController(TaskRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Task> getAllTasks(@RequestParam(required = false) Priority priority){
        if(priority!=null){
            return repository.findByPriority(priority);
        }
        return repository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return repository.save(task);
    }
}
