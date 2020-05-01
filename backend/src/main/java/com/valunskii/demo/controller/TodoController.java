package com.valunskii.demo.controller;

import com.valunskii.demo.entity.TodoEntity;
import com.valunskii.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoEntity> getAllCourses() {
        return todoService.findAll();
    }

    @GetMapping("{id}")
    public TodoEntity getCourse(@PathVariable long id) {
        return todoService.findById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable long id) {

        TodoEntity course = todoService.deleteById(id);

        if (course != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoEntity> updateCourse(@PathVariable long id, @RequestBody TodoEntity todo) {
        return new ResponseEntity<>(todoService.save(todo), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody TodoEntity todo) {

        TodoEntity createdTodo = todoService.save(todo);

        // Location
        // Get current resource url
        /// {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
