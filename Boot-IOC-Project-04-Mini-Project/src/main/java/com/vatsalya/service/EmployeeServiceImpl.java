package com.vatsalya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vatsalya.dao.IEmployeeDAO;
import com.vatsalya.model.Employee;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO empDAO;
	
	@Override
	public List<Employee> fetchAllEmployeeByDegs(String desg1, String desg2, String desg3) throws Exception {
		
		//Convert desgs to the upper case
		desg1 = desg1.toUpperCase();
		desg2 = desg2.toUpperCase();
		desg3 = desg3.toUpperCase();
		
		//use DAO
		List<Employee> list = empDAO.getEmployeeByDesgs(desg1, desg2, desg3);
		
		//Sort the Object in the list
		list.sort((t1,t2)->t1.getEno().compareTo(t2.getEno()));
		
		//Calculate Gross and Net Salary
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary() + (emp.getSalary()*0.5));
			emp.setNetSalary(emp.getSalary() + (emp.getSalary()*0.2));
		});
		
		return list;
	}

	@Override
	public String registerEmployee(Employee emp) throws Exception {
		//Use DAO
		int result = empDAO.insertEmployee(emp);
		
		return result ==0?"Employee not registered":"Employee regisetered.";
	}
}
