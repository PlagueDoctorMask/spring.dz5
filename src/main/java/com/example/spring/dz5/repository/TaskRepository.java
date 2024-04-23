package com.example.spring.dz5.repository;

import com.example.spring.dz5.domain.Task;
import com.example.spring.dz5.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByStatus(TaskStatus taskStatus);

    Task update(Task task);


}
