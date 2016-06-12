package com.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class PersonsDao extends SimpleJdbcDaoSupport 
{
	public void create(int id,String name,int age)
	{
		String sql = "insert into persons values(?,?,?)";
		getSimpleJdbcTemplate().update(sql, id,name,age);
	}
}
