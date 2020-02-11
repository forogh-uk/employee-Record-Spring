package dao;

import java.util.List;

import entity.Employee;

public interface EmployeeDao {
	public Employee insertEmp(Employee e);
	public Employee updateEmp(Employee e);
	public void deleteEmp(Employee e);
	public List<Employee> selectAll();
}
