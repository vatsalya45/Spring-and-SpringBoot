package com.vatsalya.service;

import java.util.*;
import com.vatsalya.model.*;

public interface IEmployeeService {

	public List<Employee> fetchAllEmployeeByDegs(String desg1, String desg2, String desg3) throws Exception;
	public String registerEmployee(Employee emp) throws Exception;
}
