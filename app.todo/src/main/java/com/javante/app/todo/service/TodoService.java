package com.javante.app.todo.service;

import java.util.List;

import com.javante.app.todo.model.Todo;

public interface TodoService {
	
	public List<Todo> getAllTodos();
	
	public Todo getTodo(int id);
	
	public Todo updateTodo(Todo todo);
	
	public int createTodo(Todo todo);
	
	public boolean deleteTodo(int todoId);
	
	public boolean selectedTodo(List<Todo> todos);

}
