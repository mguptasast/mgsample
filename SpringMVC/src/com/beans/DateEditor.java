package com.beans;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport
{
	@Override
	public String getAsText() 
	{
		Date dt = (Date)getValue();
		return dt.toString();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try 
		{
			Date dt = sdf.parse(text);
			setValue(dt);
		} 
		catch (ParseException e) 
		{
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
}
