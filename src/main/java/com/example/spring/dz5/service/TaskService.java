package com.example.spring.dz5.service;


import com.example.spring.dz5.domain.Task;
import com.example.spring.dz5.domain.TaskStatus;
import com.example.spring.dz5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService{

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void addTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public Task getById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public Task getByStatus(TaskStatus taskStatus){
        return taskRepository.findByStatus(taskStatus);
    }

    public Task updateTask(Task task){
        return taskRepository.update(task);
    }

}
