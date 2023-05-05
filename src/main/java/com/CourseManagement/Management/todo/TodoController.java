package com.CourseManagement.Management.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> data = todoService.findByUsername("Gurpreet Singh");
        model.put("todos", data);
        model.addAttribute("name");
        return "listTodos";
    }

    @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
    public String addTodo(ModelMap model) {
        String username = (String) model.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }


    @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, Todo todo) {
        String username = (String) model.get("name");
        todoService.addTodo(todo.getDescription(), username);
        return "redirect:list-todos";
    }
}
