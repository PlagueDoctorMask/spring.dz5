package com.example.spring.dz5.service;


import com.example.spring.dz5.domain.Task;
import com.example.spring.dz5.domain.TaskStatus;
import com.example.spring.dz5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService{

    private final TaskRepository taskRepository;

    //Выдаёт список всех существующих задач
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    /**
     * Добавляет задачу в базу
     * @param task - задача, которую надо добавить
     */
    public void addTask(Task task){
        task.setDescription(task.getDescription());
        task.setTaskStatus(task.getTaskStatus());
        task.setCreationDate(LocalDateTime.now());
        taskRepository.save(task);
    }


    /**
     * Удаляет задачу
     * @param id - id задачи, которую надо удалить
     */
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }


    /**
     * Находит задачу по id
     * @param id - id необходимой задачи
     * @return - задача с введённым id или null в случае отсутсвтия такой задачи
     */
    public Task getById(Long id){
        return taskRepository.findById(id).orElse(null);
    }


    /**
     * Находит задачи по статусу
     * @param taskStatus - статус задач, которые надо найти
     * @return - список с задачами, которые соответствуют введённому статусу
     */
    public List<Task> getByStatus(TaskStatus taskStatus){
        return taskRepository.findAll().stream().filter(task -> task.getTaskStatus() == taskStatus).toList();
    }


    /**
     * Обновляет статус у задачи
     * @param task - задачу, у которой надо обновить статус
     * @param taskStatus - статус, который надо поставить вместо имеющегося
     * @return - задача с обновлённым статусом
     */
    public Task setNewStatus(Task task, TaskStatus taskStatus){
        Task newTask = getById(task.getId());
        newTask.setTaskStatus(taskStatus);
        addTask(newTask);
        return newTask;
    }


    /**
     * Обновляет задачу
     * @param id - id задачи, которую надо обновить
     * @param task - задача, которую надо подставить вместо имеющейся
     * @return - обновлённая задача или ошибка с текстом об отсутсвии задачи с таким id
     */
    public Task updateTask(Long id, Task task){
        Task oldTask = taskRepository.findById(id).orElse(null);
        if (oldTask!= null){
            oldTask.setDescription(task.getDescription());
            oldTask.setTaskStatus(task.getTaskStatus());
            addTask(oldTask);
            return oldTask;
        }else{
            throw new IllegalArgumentException("No such task");
        }
    }

}
