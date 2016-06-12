package com.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.beans.InvalidUserException;
import com.beans.LoginBean;

@Controller
@RequestMapping(value="/Login.spring")
@SessionAttributes("date")
public class LoginController
{
	@ModelAttribute("date")
	public String getDate()
	{
		System.out.println("*****getDate called");
		return new Date().toString();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		System.out.println("****binder : " + binder);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String forwardToIndex()
	{
		return "redirect:login.jsp";
	}
	@ExceptionHandler(InvalidUserException.class)
	public String processInvalidUserException()
	{
		return "error";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processCredentials(@ModelAttribute("loginBean")LoginBean loginBean,SessionStatus status)
	{
		String message = "Invalid Credentials";
		String userId = loginBean.getUserId();
		String password = loginBean.getPassword();
		
		if(userId != "" && userId.length() >=5 && userId.length() >=5)
		{
			if(userId.equals(password))
			{
				message = "Welcome " + userId + " !!!";
			}
		}
		else
			throw new InvalidUserException();
		loginBean.setMessage(message);
		status.setComplete();
		return "results";
	}
	
/*	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processCredentials(@RequestParam("userId")String userId,@RequestParam("password")String password)
	{
		String message = "Invalid Credentials";
		
		if(userId != "" && userId.length() >=5 && userId.length() >=5)
		{
			if(userId.equals(password))
			{
				message = "Welcome " + userId + " !!!";
			}
		}
		return new ModelAndView("results","message",message);
	}*/
}
