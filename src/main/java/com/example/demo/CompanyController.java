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
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("")
	public Company post(@RequestBody Company company) throws Exception {
		//companyMapper.insert(company);
		companyService.add(company);
		return company;
	}
	
	@GetMapping("")
	public List<Company> getAll() {
		//return companyService.getAll();
		return companyMapper.getAll();
	}
	
	@GetMapping("/{id}")
	public Company getById(@PathVariable("id") int id) {
		return companyMapper.getId(id);
	}
	
	@PutMapping("")
	public Company put(@RequestBody Company company) throws Exception {
		//companyMapper.update(company);
		companyService.edit(company);
		return company;
	}
	
	@DeleteMapping("/{id}")
	public int delete(@PathVariable("id") int id) {
		return companyMapper.delete(id);
	}
}
