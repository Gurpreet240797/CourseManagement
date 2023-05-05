package com.CourseManagement.Management.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        return todos;
    }

    public void addTodo(String description, String username) {
        todos.add(new Todo(++id, username, description, LocalDate.now().plusYears(1), false));
    }
}
