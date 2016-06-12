package com.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.beans.Person;
import com.dao.PersonsDao;

@Controller
@RequestMapping(value="/CreatePerson.spring")
public class CreatePersonController 
{
	@RequestMapping(method=RequestMethod.POST)
	public String storePerson(@ModelAttribute("person") Person person,HttpServletRequest request)
	{
		String message = "Person created successfully";
		try
		{
			WebApplicationContext context = RequestContextUtils.getWebApplicationContext(request);
			PersonsDao personsDao = (PersonsDao)context.getBean("personsDaoBean");
			personsDao.create(person.getId(), person.getName(), person.getAge());
		}
		catch(Exception ex)
		{
			message = "Error : " + ex.getMessage();
		}
		request.setAttribute("message", message);
		return "results";
	}
}
