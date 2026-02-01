package com.infor.taskmanager.dto;

import com.infor.taskmanager.model.Priority;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Priority priority;
}
