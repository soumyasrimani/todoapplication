package com.javante.app.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javante.app.todo.model.Todo;
import com.javante.app.todo.repo.TodoRepository;
@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoRepository repo;

	@Override
	public List<Todo> getAllTodos() {
		return repo.getAllTodos();
	}

	@Override
	public Todo updateTodo(Todo todo) {
		return repo.updateTodo(todo);
	}

	@Override
	public int createTodo(Todo todo) {
		return repo.createTodo(todo);
	}

	@Override
	public boolean deleteTodo(int todoId) {
		return repo.deleteTodo(todoId);
	}

	@Override
	public boolean selectedTodo(List<Todo> todos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Todo getTodo(int id) {
		return repo.getTodo(id);
	}

	public Todo addTodo(Todo todo) {
		return repo.addTodo(todo);
	}

	
	public String helloTodo()
	{
		return "Hello Todo";
	}
}
