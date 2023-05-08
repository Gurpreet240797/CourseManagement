package com.CourseManagement.Management.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
        String username = getLoggedInUser();
        List<Todo> data = todoService.findByUsername(username);
        model.put("todos", data);
        model.addAttribute("name");
        return "listTodos";
    }

    @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
    public String addTodo(ModelMap model) {
        String username = getLoggedInUser();
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }


    @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedInUser();
        todoService.addTodo(todo.getDescription(), username, todo.getTargetDate());
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String updateTodoGET (@RequestParam int id, ModelMap model) {
        model.put("request", "delete");
        Todo todo = todoService.findTodoById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodoPOST(@Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.put("request", "delete");
            return "todo";
        }

        String username = getLoggedInUser();
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
