package com.satya.Project02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.Project02.dto.Employee;
import com.satya.Project02.repository.EmpDao;

@Service
public class EmpService {
	@Autowired
	private EmpDao empDao;

	public EmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public long saveEmp(Employee emp) {
		return this.empDao.saveEmp(emp);
	}

	public List<Employee> getAllEmp() {
		return this.empDao.getAllEmp();
	}

	public Employee getEmpById(long id) {
		return this.empDao.getEmpById(id);
	}
}
