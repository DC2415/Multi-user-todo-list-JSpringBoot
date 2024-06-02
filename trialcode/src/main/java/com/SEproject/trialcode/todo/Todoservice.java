package com.SEproject.trialcode.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class Todoservice {
private static List<Todo> todos=new ArrayList<>();
private static int todoscount=0;
static
{
	todos.add(new Todo(++todoscount,"rohan","aws",LocalDate.now().plusYears(1),false));
	todos.add(new Todo(++todoscount,"rohan","azure",LocalDate.now().plusYears(2),false));
	todos.add(new Todo(++todoscount,"rohan","placed",LocalDate.now().plusYears(3),false));
}
public List<Todo> findbyusername(String username)
{   Predicate<? super Todo> predicate=todo -> todo.getUsername().equalsIgnoreCase(username);
	return todos.stream().filter(predicate).toList();
}
public void addtodo(String username,String description,LocalDate targetdate,boolean done)
{
	Todo todo=new Todo(++todoscount,username,description,targetdate,done);
	todos.add(todo);
}
public void deletebyid(int id)
{
	Predicate<? super Todo> predicate=todo -> todo.getId()==id;
	todos.removeIf(predicate);
}
public Todo findById(int id) {
	
	Predicate<? super Todo> predicate=todo -> todo.getId()==id;
	Todo todo=todos.stream().filter(predicate).findFirst().get();
	return todo;
}
public void updateTodo(@Valid Todo todo) {
	
	 deletebyid(todo.getId());
	 todos.add(todo);
	
}
}
