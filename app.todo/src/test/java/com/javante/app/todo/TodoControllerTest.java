package com.javante.app.todo;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javante.app.todo.controller.TodoController;
import com.javante.app.todo.model.Status;
import com.javante.app.todo.model.Todo;
import com.javante.app.todo.service.TodoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class TodoControllerTest {

	
	private MockMvc mock;

	@Mock
	private TodoServiceImpl service;
	
	@InjectMocks
	private TodoController controller;
	
	
	
	@Before
	public void setUp() throws Exception {
		mock = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void test() {
		int i = 0;
		Assertions.assertEquals(i, 0);
	}

	@Test
	@DirtiesContext
	public void addTodoTest() throws Exception {
		Todo todo = new Todo(99997, "Learning Unit Testing", new Date(), Status.ACTIVE, "soumya");
		HttpHeaders header = new HttpHeaders();
		header.set("location", "http://localhost:8181/todos/99997");
		
	    Mockito.when(service.addTodo(Mockito.any(Todo.class)))
		                            .thenReturn(todo);
		String json ="\r\n" + 
				"{"+
				"\"id\": 99997,\r\n" + 
				"\"description\": \"Learning Unit Testing\",\r\n" + 
				"\"targetDate\": \"2020-06-19T18:30:00.000+0000\",\r\n" + 
				"\"status\": \"ACTIVE\",\r\n" + 
				"\"userName\": \"soumya\"\r\n" + 
				"}";
		  MvcResult rs = mock.perform(post("/todos")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json))
				.andReturn();
		  
		  String string = rs.getResponse().getContentAsString();
		  ObjectMapper objectMapper = new ObjectMapper();
		  Todo td = objectMapper.readValue(string,Todo.class);
		  System.out.println("Todo --------------------------------"+td);
		  assertEquals(HttpStatus.CREATED.value(),rs.getResponse().getStatus());
		  
		  assertEquals("Learning Unit Testing",td.getDescription());
		  assertEquals(99997,td.getId());
		  assertEquals("http://localhost/todos/99997",rs.getResponse().getHeader("location"));
		  assertEquals("soumya",td.getUserName());
		  
		       // .andExpect(status().isCreated());
		        //.andExpect(jsonPath("$.description",Matchers.is("Learning Unit Testing")));
	}

	@Test
	@DirtiesContext
	public void getTodo() throws Exception {
		Todo todo = new Todo(99999, "Learning Unit Testing", new Date(), Status.ACTIVE, "soumya");
		Mockito.when(service.getTodo(Mockito.anyInt())).thenReturn(todo);
		RequestBuilder accept = MockMvcRequestBuilders.get("/todos/99999");
		mock.perform(accept).andExpect(status().isOk());

	}

	@Test
	public void helloTodoTest() throws Exception {
		Mockito.when(service.helloTodo()).thenReturn("Hello Todo");

		mock.perform(get("/todos/hello")).andExpect(status().isOk());
	}

}
