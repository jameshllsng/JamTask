package com.jamtask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    @GetMapping("/tasks/new")
    public String showCreateForm() {
        return "tasks/form";
    }
}
