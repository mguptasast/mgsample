package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
@RequestMapping("/Form.spring")
public class FormController
{
	@RequestMapping(method=RequestMethod.GET,params="operation=Create")
	public void create()
	{
		System.out.println("***Create");
	}
	@RequestMapping(method=RequestMethod.GET,params="operation=View")
	public void view()
	{
		System.out.println("***View");
	}
	@RequestMapping(method=RequestMethod.GET,params="operation=Delete")
	public void delete()
	{
		System.out.println("***Delete");
	}
}
