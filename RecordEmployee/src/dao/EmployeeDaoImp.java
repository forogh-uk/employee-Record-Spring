package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import entity.Employee;


@Repository
public class EmployeeDaoImp implements EmployeeDao {
	
@PersistenceContext	
private EntityManager em;


	@Override
	public Employee insertEmp(Employee e) {
		em.persist(e);
		em.flush();
		return e;
	}

	@Override
	public Employee updateEmp(Employee e) {
		
		return em.merge(e);
	}

	@Override
	public void deleteEmp(Employee e) {
		e =em.merge(e);
		em.remove(e);
		
	}

	@Override
	public List<Employee> selectAll() {
		Query q = em.createQuery("FROM Employee");
		return (List<Employee>) q.getResultList();
	}

}
