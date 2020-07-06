package com.javante.app.todo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javante.app.todo.model.Todo;
import com.javante.app.todo.model.TodoException;
import com.javante.app.todo.service.TodoServiceImpl;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "http://localhost:4242")
public class TodoController {

	@Autowired
	TodoServiceImpl service;

	@GetMapping(path = "/all")
	public List<Todo> getAllEntity() {
		return service.getAllTodos();
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<HttpStatus> deleteTodo(@PathVariable("id") int id) {
		boolean deleteTodo = service.deleteTodo(id);
		if (deleteTodo) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			throw new TodoException("Todo Not Found "+ id);
	}

	@PutMapping(path = "/update")
	public ResponseEntity<Todo> updateTodo(@RequestBody @Valid Todo todo) {
		Todo updateTodo = service.updateTodo(todo);
		return new ResponseEntity<>(updateTodo, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Todo> getTodo(@PathVariable("id") int id) {
		Todo todo = service.getTodo(id);

		if (todo != null) {
			return new ResponseEntity<>(todo, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Todo> createTodo(@RequestBody @Valid Todo todo) {
		Todo td = service.addTodo(todo);
		System.out.println("id ------------------"+td.getId());
		if (td.getId() != 0) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(td.getId())
					.toUri();
			System.out.println(uri);
			HttpHeaders header = new HttpHeaders();
			header.set("location", uri.toString());
		return new ResponseEntity<>(td,header,HttpStatus.CREATED);	
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping(path = "/hello")
	public ResponseEntity<String> helloTodo() {
		String todo = service.helloTodo();

		if (todo != null) {
			return new ResponseEntity<>(todo, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
