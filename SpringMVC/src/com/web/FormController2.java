package com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping(value="/Form2.spring")
public class FormController2 //extends MultiActionController
{
	public FormController2()
	{
		System.out.println("***FormController2 created");
	}
	
	@RequestMapping(method=RequestMethod.GET,params="operation=create")
	public void create()
	{
		System.out.println("***Create");
	}
	@RequestMapping(method=RequestMethod.GET,params="operation=view")
	public void view()
	{
		System.out.println("***View");
	}
	@RequestMapping(method=RequestMethod.GET,params="operation=delete")
	public void delete()
	{
		System.out.println("***Delete");
	}
/*	@RequestMapping(value="/Delete",method=RequestMethod.GET)
	public void delete()
	{
		System.out.println("***Delete");
	}
*/}
