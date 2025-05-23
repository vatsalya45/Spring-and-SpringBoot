package com.vatsalya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vatsalya.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImp implements IEmployeeDAO {

	private static final String GET_EMPS_QUERY="SELECT EMPNO,ENAME,JOB,SALARY,DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	private static final String INSERT_EMPLOYEE = "INSERT INTO EMP(EMPNO,ENAME,JOB,SALARY,DEPTNO) VALUES(EMP_SEQ1.NEXTVAL,?,?,?,?)";
	
	@Autowired
	private DataSource ds;//IOC Container injects HikariDataSource object that comes through AutoConfiguration 
	
	
	@Override
	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception 
	{
		
		List<Employee> list = null;
		
		try(Connection con = ds.getConnection(); PreparedStatement ps =  con.prepareStatement(GET_EMPS_QUERY);) 
		{
			//Set Values to the Query parameter
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			//Execute the SQL query 
			try(ResultSet rs =  ps.executeQuery();)
			{
				//Copy Each Record of the ResultSet Object to Model Class object
				list = new ArrayList<Employee>();
				
				while(rs.next()) 
				{
					//Copy Each record to Employee class object
					Employee emp = new Employee();
					emp.setEno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));
					
					//add each model class object to the rs
					
					list.add(emp);
					
				}
				
			}//Inner Try Close 
			
		}//Outer Try Close 
		catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return list;
		
	}//method 
	
	@Override
	public int insertEmployee(Employee emp) throws Exception {
		int result = 0;
		//try with resource
		try (//get pooled connection
			Connection con=	ds.getConnection();
				//create preparedStatement object having pre-compiled Query
				PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEE);
				){
			//Set values to the Query params
			ps.setString(1,emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4,emp.getDeptno());
			
			//Execute the SQL Query
			result = ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
}//class
