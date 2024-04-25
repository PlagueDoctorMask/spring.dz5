package com.example.spring.dz5.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Сущность Задача
 * @id - id задачи
 * @description - тело задачи(описание)
 * @taskStatus - статус выполнения задачи
 * @creationDate - дата создания задачи
 *
 * Первое и последнее поле ставиться автоматически и не изменияется
 */


@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private TaskStatus taskStatus;

    @Column(nullable = false)
    private LocalDateTime creationDate;

}
