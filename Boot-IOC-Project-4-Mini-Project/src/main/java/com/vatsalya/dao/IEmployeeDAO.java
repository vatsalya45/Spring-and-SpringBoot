package com.vatsalya.dao;

import java.util.*;
import com.vatsalya.model.*;

public interface IEmployeeDAO {

	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception ;
}
