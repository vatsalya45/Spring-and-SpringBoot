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

@Repository("empMySQLDAO")
public class EmployeeDAOImpMySQL implements IEmployeeDAO {

	private static final String GET_EMPS_BY_DESGS = "SELECT EMPNO,ENAME,SALARY,JOB,DEPTNO  FROM EMP WHERE JOB IN(?,?,?)";
	
	private static final String REGISTER_NEW_EMPLOYEE = "INSERT INTO EMP(ENAME,SALARY,JOB,DEPTNO) VALUES(?,?,?,?)";
	
	@Autowired
	private DataSource ds;
	
	@Override
	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = null;
		try(//get pooled connection
				Connection con = ds.getConnection();
				//get PreparedStatement object having pre-compiled Query
				PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS);
				){
			//set values to the Query parameters
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			try(//execute the query
					ResultSet rs = ps.executeQuery();
					
					)
			{
				//process the result object
				list = new ArrayList<Employee>();
				while(rs.next()) {
					//Copy each record into java bean
					Employee emp = new Employee();
					emp.setEno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setSalary(rs.getDouble(3));
					emp.setJob(rs.getString(4));
					emp.setDeptno(rs.getInt(5));
					
					
					//add each record to the list object
					list.add(emp);
				}//while
				
			}//inner try
			
		}//outer try
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return list;
	}

	@Override
	public int insertEmployee(Employee emp) throws Exception {
		int result = 0;
		try(//get pooled object
				Connection con = ds.getConnection();
				//get PreparedStatement object having pre-compiled Query
				PreparedStatement ps = con.prepareStatement(REGISTER_NEW_EMPLOYEE); 
				){
			//set values to the query parameters
			ps.setString(1, emp.getEname());
			ps.setDouble(2, emp.getSalary());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getDeptno());
			
			
			//execute the query
			result = ps.executeUpdate();
			
		}//try
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
