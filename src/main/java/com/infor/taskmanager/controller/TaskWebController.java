package com.infor.taskmanager.controller;

import com.infor.taskmanager.dto.TaskDto;
import com.infor.taskmanager.model.Priority;
import com.infor.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tasks-page")
@RequiredArgsConstructor
public class TaskWebController {
    private final TaskService taskService;
    @GetMapping
    public String listTasks(Model model, @RequestParam(required = false) Priority priority, @PageableDefault(size = 5)Pageable pageable){
        Page<TaskDto> taskPage = taskService.getTasks(priority,pageable);
        model.addAttribute("tasks",taskPage.getContent());
        model.addAttribute("page",taskPage);
        model.addAttribute("currentPriority",priority);
        return "tasks-list";
    }
}
