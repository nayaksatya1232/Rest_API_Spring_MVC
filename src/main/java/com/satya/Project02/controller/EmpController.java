package com.satya.Project02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satya.Project02.dto.Employee;
import com.satya.Project02.service.EmpService;

@RestController
public class EmpController {
	@Autowired
	private EmpService service;
	
	@PostMapping("/saveEmp")
	public long saveEmp(@RequestBody Employee emp) {
		return this.service.saveEmp(emp);
	}
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmp(){
		return this.service.getAllEmp();
	}
	@GetMapping("/getEmpyId/{id}")
	public Employee getEmpById(@PathVariable("id") long id) {
		return this.service.getEmpById(id);
	}
}
