package com.infor.taskmanager.repository;

import com.infor.taskmanager.model.Priority;
import com.infor.taskmanager.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    Page<Task> findByPriority(Priority priority, Pageable pageable);
}
