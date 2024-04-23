package com.example.spring.dz5.controller;

import com.example.spring.dz5.domain.Task;
import com.example.spring.dz5.domain.TaskStatus;
import com.example.spring.dz5.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/id")
    public Task getById(@RequestParam Long id){
        return taskService.getById(id);
    }

    @GetMapping("/status")
    public Task getByStatus(@RequestParam TaskStatus taskStatus){
        return taskService.getByStatus(taskStatus);
    }

    @PostMapping("/create")
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);
    }

    @DeleteMapping("/delete")
    public void deleteTask(@RequestParam Long id){
        taskService.deleteTask(id);
    }

    @PutMapping("/update")
    public void updateTask(@RequestBody Task task){
        taskService.updateTask(task);
    }

}
