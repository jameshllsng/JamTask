package com.jamtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamtask.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>  {

}
