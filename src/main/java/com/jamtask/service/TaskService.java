package com.jamtask.service;

import org.springframework.stereotype.Service;

import com.jamtask.entity.Task;
import com.jamtask.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
}
