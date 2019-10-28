package com.example.spark.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TodoService {

    private Map<String, Todo> store = new HashMap<String, Todo>();

    public Todo find(String todoId) {
        return store.get(todoId);
    }

    public void delete(String todoId) {
        store.remove(todoId);
        System.out.println("delete todoId : " + todoId);
    }

    public Todo update(Todo todo) {
        Todo updatedTodo = store.get(todo.getTodoId());
        if (updatedTodo != null) {
            updatedTodo.setTodoTitle(todo.getTodoTitle());
            updatedTodo.setFinished(todo.isFinished());
        }
        return updatedTodo;
    }

    public Todo create(Todo todo) {
        String todoId = UUID.randomUUID().toString();
        Todo registeredTodo = new Todo(todoId, todo.getTodoTitle(), new Date(),
                false);
        store.put(todoId, registeredTodo);
        System.out.println("registeredTodo : " + registeredTodo);
        return registeredTodo;
    }
}