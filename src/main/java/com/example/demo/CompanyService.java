package com.example.demo;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Company> getAll(){
		List<Company> companyList = companyMapper.getAll();
		if (companyList != null && companyList.size() > 0) {
			for (Company company : companyList) {
				company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
			}
		}
		return companyList;
	}
	
	@Transactional
	public Company add(Company company) {
		companyMapper.insert(company);
		
		// 연동이 필요한 추가적인 작업을 기술
		if (true) {
			throw new RuntimeException("기존시스템 처리에서 오류 발생!");
		}
		return company;
	}
}
