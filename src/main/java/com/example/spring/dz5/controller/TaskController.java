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


    /**
     * Получение всех имеющихся задач
     * @return - список задач
     */
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    /**
     * Получение задачи по id из запроса
     * @param id - id требуемой задачи
     * @return - Требуемая задача
     */
    @GetMapping("/id")
    public Task getById(@RequestParam Long id){
        return taskService.getById(id);
    }

    /**
     * Получение задач по статусу выполения из запроса
     * @param taskStatus - статус выполнения требуемых задач
     * @return - список задач соответствующих статусу
     */
    @GetMapping("/status")
    public List<Task> getByStatus(@RequestParam TaskStatus taskStatus){
        return taskService.getByStatus(taskStatus);
    }


    /**
     * Обновления статуса выполнения задачи
     * @param id - id из запроса задачи, у которой надо поменять статус выполнения
     * @param taskStatus - статус выполнения, который нужно поставить вменсто имеющегося
     * @return - Задача с обновлённым статусом
     */
    @PutMapping("/status/{id}/{taskStatus}")
    public Task setNewTaskStatus(@PathVariable Long id, @PathVariable TaskStatus taskStatus){
        return taskService.setNewStatus(taskService.getById(id), taskStatus);
    }

    /**
     * Создание задачи
     * @param task - данные о задачи из тела запроса
     */
    @PostMapping("/create")
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);
    }

    /**
     * Удаление задачи по её Id
     * @param id - id задачи, которую надо удалить
     */
    @DeleteMapping("/delete")
    public void deleteTask(@RequestParam Long id){
        taskService.deleteTask(id);
    }

    /**
     * Обновление задачи
     * @param id - id задачи, которую надо обновить
     * @param task - задача из тела запроса, которую надо поставить вместо имеющейся
     * @return - обновлённая задача
     */
    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

}
