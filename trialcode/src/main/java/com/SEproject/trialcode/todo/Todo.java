package com.SEproject.trialcode.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
@Entity
public class Todo {
	
	public Todo()
	{
		
	}
@Id
@GeneratedValue
private int id;
private String username;
@Size(min=5,message="Please enter atleast 5 characters")
private String description;
@Future(message="date should be in future")
private LocalDate targetdate;
private boolean done;
public Todo(int id, String username, String description, LocalDate targetdate, boolean done) {
	super();
	this.id = id;
	this.username = username;
	this.description = description;
	this.targetdate = targetdate;
	this.done = done;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public LocalDate getTargetdate() {
	return targetdate;
}
public void setTargetdate(LocalDate targetdate) {
	this.targetdate = targetdate;
}
public boolean isDone() {
	return done;
}
public void setDone(boolean done) {
	this.done = done;
}
@Override
public String toString() {
	return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetdate=" + targetdate
			+ ", done=" + done + "]";
}

}
