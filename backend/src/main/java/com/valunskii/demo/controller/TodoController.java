package com.valunskii.demo.controller;

import com.valunskii.demo.entity.TodoEntity;
import com.valunskii.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public TodoEntity create(@RequestBody TodoEntity todo) {
       return todoService.save(todo);
    }

    @GetMapping
    public List<TodoEntity> retriveAll() {
        return todoService.findAll();
    }

    @GetMapping("{id}")
    public TodoEntity retrive(@PathVariable Integer id) {
        return todoService.findById(id);
    }

    @PutMapping("{id}")
    public TodoEntity update(@PathVariable("id") TodoEntity todo, @RequestBody TodoEntity newTodo) {
        return todoService.update(todo, newTodo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") TodoEntity todo) {
        todoService.delete(todo);
    }
}
