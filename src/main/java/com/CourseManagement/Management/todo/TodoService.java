package com.CourseManagement.Management.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static int id = 0;
    private static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(++id, "Gurpreet Singh",
                "Learn Spring Boot", LocalDate.now().plusYears(1), false));

        todos.add(new Todo(++id, "Gurpreet Singh",
                "Learn React", LocalDate.now().plusYears(2), false));

        todos.add(new Todo(++id, "Gurpreet Singh",
                "Learn Docker", LocalDate.now().plusYears(3), false));
    }


    public List<Todo> findByUsername(String username) {
        Predicate<Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String description, String username, LocalDate targetDate) {
        todos.add(new Todo(++id, username, description, targetDate, false));
    }

    public void deleteTodo(int id) {
        Predicate<Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findTodoById (int id) {
        Predicate<Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteTodo(todo.getId());
        todos.add(todo);
    }
}
