package com.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.beans.LoginBean;

//@Controller
@RequestMapping(value="/Login.spring")
@SessionAttributes(value={"loginBean","date"})
public class LoginController3 
{
	//@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processCredentials(@RequestParam("userName") String userName,@RequestParam("password") String password)
	{
		String message = "Invalid credentials";
		if(userName != ""  && password != "")
		{
			if(userName.equals(password))
				message = "Hi " + userName + "!!";
		}
		return new ModelAndView("result","message",message);
	}

	@RequestMapping(method=RequestMethod.GET)
	public String processGet()
	{
		return "login";
	}
	
	//@RequestMapping(method=RequestMethod.POST)
	public String processCredentials2(@RequestParam("userName") String userName,@RequestParam("password") String password,HttpSession session)
	{
		System.out.println(session);
		String message = "Invalid credentials";
		if(userName != ""  && password != "")
		{
			if(userName.equals(password))
				message = "Hi " + userName + "!!";
		}
		session.setAttribute("message",message);
		return "result";
	}
	
	//@RequestMapping(method=RequestMethod.POST)
	public String processCredentials3(@RequestParam("userName") String userName,@RequestParam("password") String password,HttpServletRequest request)
	{
		String message = "Invalid credentials";
		if(userName != ""  && password != "")
		{
			if(userName.equals(password))
				message = "Hi " + userName + "!!";
		}
		request.setAttribute("message",message);
		return "result";
	}
	//@RequestMapping(method=RequestMethod.POST)
	//@ResponseBody
	public String processCredentials4(@RequestParam("userName") String userName,@RequestParam("password") String password)
	{
		String message = "Invalid credentials";
		if(userName != ""  && password != "")
		{
			if(userName.equals(password))
				message = "Hi " + userName + "!!";
		}
		
		return message;
	}
	@RequestMapping(method=RequestMethod.POST)
	public String processCredentials5(/*@ModelAttribute("loginBean") */LoginBean loginBean)
	{
		System.out.println("******processCredentials5");
		String message = "Invalid credentials";
		if(loginBean.getUserId() != ""  && loginBean.getPassword() != "")
		{
			if(loginBean.getUserId().equals(loginBean.getPassword()))
				message = "Hi " + loginBean.getUserId() + "!!";
		}
		loginBean.setMessage(message);
		return "redirect:result.jsp";
	}
	@ModelAttribute("date")
	public String getDateTime()
	{
		System.out.println("******getDateTime");
		return "Date is " + new Date(); 
	}
	
	@ModelAttribute("loginBean")
	public LoginBean getLoginBean()
	{
		return new LoginBean(); 
	}
}
