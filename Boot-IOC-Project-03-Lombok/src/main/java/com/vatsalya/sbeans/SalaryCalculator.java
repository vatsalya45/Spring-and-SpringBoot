package com.vatsalya.sbeans;


//@Component("sc")
public class SalaryCalculator {

	
	private double basicSalary;
	private double hra;
	private double da;
	private double bonous;
	private double totalSalary;
	
	
	public SalaryCalculator(double basicSal) {
		this.basicSalary = basicSal;
	}
//	//Reduced boilerplate: No need for @Autowired annotation on the constructor (from Spring 4.3 onwards).
	
	public String totalSalary() {
		
		basicSalary = 13000;
		hra = 0.2*basicSalary;
		da = 0.3*basicSalary;
		bonous = 0.1*basicSalary;
		
		totalSalary = basicSalary + hra + da;
		
		if(basicSalary > 12000) {
			
			totalSalary += bonous;
			return "Salary = "+totalSalary;
		}
		else {
			return "Salary = "+totalSalary;
		}
		
	}
	
	
}
