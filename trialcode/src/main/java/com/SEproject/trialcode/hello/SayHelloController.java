package com.SEproject.trialcode.hello;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@SessionAttributes("username")
public class SayHelloController {
	

@RequestMapping(value="/",method = RequestMethod.GET)
public String SayHelloJsp(ModelMap model)
{ 
	model.put("username",getLoggedinusername());
   
	return "welcome";
}
public String getLoggedinusername()
{
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	return authentication.getName();
}

}
