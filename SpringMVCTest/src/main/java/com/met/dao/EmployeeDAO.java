package com.met.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.met.model.Employee;

//@Component

@Repository
public class EmployeeDAO {
	

	
	@Autowired
	@Qualifier("mySQLDataSource")
	private DataSource mySQLDataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public void save(Employee employee) {
		
		saveUsingDataSource(employee);
		
		
		
		System.out.println("Saving emp to database: " + employee);
		
	}
	


	private void saveUsingDataSource(Employee employee) {
		
		try(Connection connection = mySQLDataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("insert into "
					+ " Employeetbl values(?, ?, ?, ?, ?, ?, ?)");
				){
			
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getAddress());
			pstmt.setString(4, employee.getEmailId());
			pstmt.setInt(5, employee.getMobile());
			pstmt.setString(6, employee.getPassword());
			pstmt.setString(7, employee.getConfirmPassword());
			
			
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public  Collection<Employee> getAllEmployees(){
		
		
		return jdbcTemplate.query("select id,name,address,emailid,mobile from Employeetbl", 
				
					new BeanPropertyRowMapper<Employee>(Employee.class)
					//new EmployeeMapper()
				
				);
		
		
	}
	
	
}








