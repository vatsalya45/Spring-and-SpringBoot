package com.vatsalya.controller;

import java.util.List;
import com.vatsalya.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vatsalya.service.IEmployeeService;

@Controller("payroll")
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeService service;//Service Implemented Class object has injected
	
	public List<Employee> showAllEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception{
		
		//Use Service 
		List<Employee> list = service.fetchAllEmployeeByDegs(desg1, desg2, desg3);
		return list;
		
	}//method
	
	public String processEmployee(Employee emp)throws Exception{
		//Use Service
		String resultMsg = service.registerEmployee(emp);
		return resultMsg;
	}
}//class
