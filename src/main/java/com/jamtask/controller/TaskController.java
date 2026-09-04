package com.jamtask.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jamtask.entity.Task;
import com.jamtask.entity.TaskStatus;
import com.jamtask.service.TaskService;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks/new")
    public String showCreateForm() {
        return "tasks/form";
    }

    @PostMapping("/tasks")
    public String createTask(@RequestParam String title, @RequestParam String description, @RequestParam TaskStatus status, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate) {
        Task task = new Task(title, description, status, dueDate);
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.findAllTasks());
        return "tasks/list";
    }
}
