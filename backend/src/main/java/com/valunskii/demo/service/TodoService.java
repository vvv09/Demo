package com.valunskii.demo.service;

import com.valunskii.demo.entity.TodoEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<TodoEntity> todos = new ArrayList<>();
    private static long idCounter = 0;

    static {
        todos.add(new TodoEntity(++idCounter, "Купить молока"));
        todos.add(new TodoEntity(++idCounter, "Заплатить за кваритру"));
        todos.add(new TodoEntity(++idCounter, "Погулять с собакой"));
        todos.add(new TodoEntity(++idCounter, "Позвонить парикмахеру"));
    }

    public List<TodoEntity> findAll() {
        return todos;
    }

    public TodoEntity save(TodoEntity todo) {
        if (todo.getId() == null) {
            todo.setId(++idCounter);
        } else {
            deleteById(todo.getId());
        }

        todos.add(todo);

        return todo;
    }

    public TodoEntity deleteById(long id) {
        TodoEntity todo = findById(id);

        if (todo == null) {
            return null;
        }

        if (todos.remove(todo)) {
            return todo;
        }

        return null;
    }

    public TodoEntity findById(long id) {
        for (TodoEntity todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }

        return null;
    }
}
