package service;

import java.util.List;

import entity.Employee;

public interface EmployeeService {
	
	public Employee add(Employee e);
	public void remove(Employee e);
	public Employee edit(Employee e);
	public List<Employee> GetAll();

}
