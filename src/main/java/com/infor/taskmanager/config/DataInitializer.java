package com.infor.taskmanager.config;

import com.infor.taskmanager.model.Priority;
import com.infor.taskmanager.model.Task;
import com.infor.taskmanager.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(TaskRepository taskRepository) {
        return args -> {

            for (int i = 0; i < 50; i++) {
                Task task = Task.builder().title("Task " + i).description("Description for task " + i)
                        .priority(i % 3 == 0 ? Priority.HIGH : (i % 2 == 0 ? Priority.MEDIUM : Priority.LOW))
                        .build();

                taskRepository.save(task);
            }
        };
    }
}
