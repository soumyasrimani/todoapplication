package com.javante.app.todo.repo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javante.app.todo.model.Status;
import com.javante.app.todo.model.Todo;

@Repository
@Transactional
public class TodoRepository {

	@Autowired
	EntityManager entityManager;

	public List<Todo> getAllTodos() {
		TypedQuery<Todo> createQuery = entityManager.createQuery("select t From Todo t", Todo.class);
		List<Todo> resultList = createQuery.getResultList();		
		return resultList;
	}

	public boolean deleteTodo(int id) {
		Optional<Todo> ofNullable = Optional.ofNullable(entityManager.find(Todo.class, id));
		if (ofNullable.isPresent()) {
			Todo todo = ofNullable.get();
			todo.setStatus(Status.DELETED);
			entityManager.merge(todo);
			return true;
		} else
			return false;
	}

	public Todo getTodo(int id) {
		Optional<Todo> ofNullable = Optional.ofNullable(entityManager.find(Todo.class, id));
		if (ofNullable.isPresent()) {
			Todo todo = ofNullable.get();
			return todo;
		} else
			throw new RuntimeException("Id Not found");
	}

	public int createTodo(Todo todo) {
		System.out.println(todo);
		entityManager.persist(todo);
		int id = todo.getId();
		return id;
	}

	public Todo updateTodo(Todo todo) {
		Todo merge = entityManager.merge(todo);
		return merge;
	}
	public Todo addTodo(Todo todo) {
		System.out.println(todo);
		entityManager.persist(todo);
		
		return todo;
	}

}
