package com.jamtask.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jamtask.entity.Task;
import com.jamtask.entity.TaskStatus;
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

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public Task updateTask(Long id, String title, String description, TaskStatus status, LocalDate dueDate) {
        Task task = findTaskById(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);
        task.setDueDate(dueDate);

        return taskRepository.save(task);
    }
}
