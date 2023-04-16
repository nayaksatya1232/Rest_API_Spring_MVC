package com.satya.Project02.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.satya.Project02.dto.Employee;

@Repository
public class EmpDao {
	@Autowired
	private HibernateTemplate hb;
	
	public HibernateTemplate getHb() {
		return hb;
	}

	public void setHb(HibernateTemplate hb) {
		this.hb = hb;
	}
	@Transactional
	public long saveEmp(Employee emp) {
		return (Long)this.hb.save(emp);
	}
	
	public List<Employee> getAllEmp(){
		return this.hb.loadAll(Employee.class);
	}
	
	public Employee getEmpById(long id) {
		return this.hb.load(Employee.class, id);
	}
}
