package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.EmployeeDao;
import entity.Employee;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeedao;

	@Override
	public Employee add(Employee e) {
		employeedao.insertEmp(e);
		return e;
	}

	@Override
	public void remove(Employee e) {
		employeedao.deleteEmp(e);
		
	}

	@Override
	public Employee edit(Employee e) {
		employeedao.updateEmp(e);
		return e;
	}

	@Override
	public List<Employee> GetAll() {
		
		return employeedao.selectAll();
	}

	
}
