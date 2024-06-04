Cоздать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA. Требуется реализовать следующие функции:

-Добавление задачи.
-Просмотр всех задач.
-Просмотр задач по статусу (например, "завершена", "в процессе", "не начата").
-Изменение статуса задачи.
-Удаление задачи.

Структура задачи(класс Task):
- ID (автоинкрементное)(тип Long)
- Описание (не может быть пустым)(тип String)
- Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
- Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)