package com.valunskii.demo.service;

import com.valunskii.demo.entity.TodoEntity;
import com.valunskii.demo.repo.TodoRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;


    public List<TodoEntity> findAll() {
        return todoRepo.findAll();
    }

    public TodoEntity findById(Integer id) {
        return todoRepo.findById(id).get();
    }

    public TodoEntity save(TodoEntity todo) {
        return todoRepo.save(todo);
    }

    public TodoEntity update(TodoEntity existedTodo, TodoEntity newTodo) {
        BeanUtils.copyProperties(newTodo, existedTodo, "id");
        return todoRepo.save(existedTodo);
    }

    public void delete(TodoEntity todo) {
        todoRepo.delete(todo);
    }

}
