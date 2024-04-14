package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeMapper employeeMapper;
	
	/*
	 * @PostMapping("") public int post(@RequestBody Company company) { return
	 * companyMapper.insert(company); }
	 */
	
	@PostMapping("")
	public Employee post(@RequestBody Employee employee) {
		employeeMapper.insert(employee);
		return employee;
	}
	
	@GetMapping("")
	public List<Employee> getAll() {
		return employeeMapper.getAll();
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable("id") int id) {
		return employeeMapper.getId(id);
	}
	
	@PutMapping("")
	public Employee put(@RequestBody Employee employee) throws Exception {
		employeeMapper.update(employee);
		return employee;
		
	}
	
	@DeleteMapping("/{id}")
	public int delete(@PathVariable("id") int id) {
		return employeeMapper.delete(id);
	}
}
