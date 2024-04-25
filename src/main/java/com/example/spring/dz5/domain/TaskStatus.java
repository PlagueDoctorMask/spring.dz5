package com.example.spring.dz5.domain;

import lombok.Getter;

/**
 * Перечисление возможных статусов выполнения задачи
 */
@Getter
public enum TaskStatus {
    NOT_STARTED, IN_PROGRESS, COMPLETED;
}
