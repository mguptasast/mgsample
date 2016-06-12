package com.web;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.beans.LoginBean;

public class LoginBeanValidator implements Validator
{

	@Override
	public boolean supports(Class<?> cls) 
	{
		return cls.equals(LoginBean.class);
	}

	@Override
	public void validate(Object command, Errors errors) 
	{
		LoginBean bean = (LoginBean)command;
		if (bean.getUserId() == "")
			errors.reject("userName", "Invalid User Name");
	}
}
