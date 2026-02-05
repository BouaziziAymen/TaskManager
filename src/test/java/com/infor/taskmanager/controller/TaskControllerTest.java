package com.infor.taskmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infor.taskmanager.controller.TaskController;
import com.infor.taskmanager.mapper.TaskMapper;
import com.infor.taskmanager.service.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TaskService service;

    @MockitoBean
    private TaskMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Should return 200 OK when fetching tasks")
    void shouldReturnOkWhen() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}