package com.web;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import com.beans.EmployeeId;
import com.beans.EmployeeIdEditor;
import com.beans.EmployeeLoginBean;

@Controller
@RequestMapping(value="/EmployeeLogin.spring")
public class EmployeeLoginController 
{
	@InitBinder
	public void bindEmployeeId(WebDataBinder binder)
	{
		binder.registerCustomEditor(EmployeeId.class, "empId", new EmployeeIdEditor());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processLogin(@ModelAttribute EmployeeLoginBean empLogin)
	{
		System.out.println(empLogin.getEmpId().getCode());
		System.out.println(empLogin.getEmpId().getCategorynumber());
		return "redirect:EmployeeLogin.html";
	}
}
