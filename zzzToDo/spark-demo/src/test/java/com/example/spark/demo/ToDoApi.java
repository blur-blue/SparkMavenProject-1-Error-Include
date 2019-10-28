package com.example.spark.demo;

import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class TodoApi {
        public static void api() {
            TodoService todoService = new TodoService();
            JsonTransformer jsonTransformer = new JsonTransformer();

            path("/api", () -> {
                path("/todo", () -> {
                    post("", (request, response) -> {
                        String json = request.body();
                        Todo todo = jsonTransformer.fromJson(json, Todo.class);
                        return todoService.create(todo);
                    }, jsonTransformer);
                    get("/:todoId", (request, response) -> {
                        return todoService.find(request.params(":todoId"));
                    }, jsonTransformer);
                    put("/:todoId", (request, response) -> {
                        String json = request.body();
                        Todo todo = jsonTransformer.fromJson(json, Todo.class);
                        todo.setTodoId(request.params(":todoId"));
                        return todoService.update(todo);
                    }, jsonTransformer);
                    delete("/:todoId", (request, response) -> {
                        todoService.delete(request.params(":todoId"));
                        return success();
                    }, jsonTransformer);
                });
            });
        }
        private static Map<String, String> success() {
            Map<String, String> map = new HashMap<String, String>();
            map.put("result", "success!");
            return map;
        }
}

