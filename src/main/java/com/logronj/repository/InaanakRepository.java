package com.logronj.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.logronj.models.Inaanak;
import com.logronj.models.Name;

@Repository
public class InaanakRepository {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public String getInaanakByFirstName(String firstName) {
		
		String query = "SELECT * FROM inaanak WHERE first_name = ? ";
		
		List<Inaanak> inaanak = jdbcTemplate.query(query, new Object[] {firstName}, 
		(rs,rowNum)-> new Inaanak(rs.getString("first_name"),rs.getString("middle_name"), rs.getString("last_name")));
		
		String fullName = "";
		for(Inaanak anak : inaanak)
			fullName = anak.getFirstName() + " " + anak.getMiddleName() + " " + anak.getLastName();
		
		return fullName;
	}
	
}
