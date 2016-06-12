package com.beans;

import java.beans.PropertyEditorSupport;

public class EmployeeIdEditor extends PropertyEditorSupport
{
	@Override
	public String getAsText() 
	{
		EmployeeId empId = (EmployeeId)getValue();
		return empId.getCode() + empId.getCategorynumber();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException 
	{
		String code = text.substring(0, 2);
		long number = Integer.parseInt(text.substring(2));
		EmployeeId empId = new EmployeeId();
		empId.setCode(code);
		empId.setCategorynumber(number);
		setValue(empId);
	}
}
