package com.SEproject.trialcode.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoControllerjpa {
	
	
public TodoControllerjpa(TodoRepository todorepo) {
		super();
		
		this.todorepo=todorepo;
	}

private TodoRepository todorepo;
@RequestMapping("list-todos")
public String requestalltodos(ModelMap model)
 {  String username=getLoggedinusername(model); 
	List<Todo> todos=todorepo.findByUsername(username);
model.addAttribute("todos",todos);
	return "todolist";
}
private String getLoggedinusername(ModelMap model) {
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	return authentication.getName();
}
@RequestMapping(value="add-todo",method=RequestMethod.GET)
public String showNewTodoPage(ModelMap model)
{   Todo todo=new Todo(0,getLoggedinusername(model),"",LocalDate.now().plusYears(1), false);
   model.put("todo", todo);	
return "todo";
}
@RequestMapping(value="add-todo",method=RequestMethod.POST)
public String addNewTodoPage(ModelMap model,@Valid Todo todo,BindingResult result)        
{   if(result.hasErrors())
{
	return "todo";
}
String username=getLoggedinusername(model);
todo.setUsername(username);
     todorepo.save(todo);
	//todoservice.addtodo(getLoggedinusername(model),todo.getDescription(),todo.getTargetdate(), false);
	return "redirect:list-todos";
}
@RequestMapping(value="update-todo",method=RequestMethod.POST)
public String updateTodoPage(ModelMap model,@Valid Todo todo,BindingResult result)        
{   if(result.hasErrors())
{
	return "todo";
}
	String username=getLoggedinusername(model);
	todo.setUsername(username);
	todorepo.save(todo);
	//todoservice.updateTodo(todo);
	return "redirect:list-todos";
}
@RequestMapping("delete-todo")
public String deletealltodos(@RequestParam int id)
{   todorepo.deleteById(id);
	//todoservice.deletebyid(id);
	return "redirect:list-todos";
}
@RequestMapping(value="update-todo",method=RequestMethod.GET)
public String showUpdateTodo(@RequestParam int id,ModelMap model)
{   Todo todo=todorepo.findById(id).get();
    model.addAttribute("todo", todo);
	return "todo";
}
}
