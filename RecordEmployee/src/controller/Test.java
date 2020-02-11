package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.ProjectConfig;
import entity.Employee;
import service.EmployeeService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
		EmployeeService ep = ctx.getBean(EmployeeService.class);
		Employee employee= new Employee();
		employee.setName("Forogh");
		employee.setPayroll(123);
		employee.setPostcode("kt21");
		ep.add(employee);

	}

}
