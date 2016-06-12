package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.LoginBean;

//@Controller
@RequestMapping(value="/Login2.spring/*")
public class LoginController2
{
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String processIndex()
	{
		return "login";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String processCredentials(@ModelAttribute("loginBean") LoginBean loginBean,BindingResult bindingResult)
	{
		new LoginBeanValidator().validate(loginBean, bindingResult);
		if(bindingResult.hasErrors())
		{
			System.out.println(bindingResult.getModel());
		}
		return "result2";
	}
}
