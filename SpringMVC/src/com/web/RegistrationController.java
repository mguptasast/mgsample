package com.web;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;

import com.beans.DateEditor;
import com.beans.RegistrationBean;

@Controller
@RequestMapping(value="/Register.spring")
public class RegistrationController 
{
	@RequestMapping(method=RequestMethod.POST)
	public String processRegistration(@ModelAttribute RegistrationBean regBean)
	{
		System.out.println("---- " + regBean.getName());
		System.out.println("---- " + regBean.getDob());
		return "registerResults";
	}
	@InitBinder
	public void convert(WebDataBinder binder)
	{
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
}
