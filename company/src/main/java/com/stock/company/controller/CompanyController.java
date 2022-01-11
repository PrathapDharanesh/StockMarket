package com.stock.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.company.pojo.Company;
import com.stock.company.pojo.CompanyStock;
import com.stock.company.service.CompanyService;

@RestController
@RequestMapping(value = "/api/v1.0/market")
public class CompanyController {

	
	@Autowired
	CompanyService companyService;
	
	@GetMapping(value = "/company/info/{companyCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CompanyStock getCompanyDetails(@PathVariable String companyCode) {
		return companyService.findByCompanyCode(companyCode);
		
		
		
	}

	@GetMapping(value = "/company/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Company> getAllCompanyDetails() {
		return companyService.findAll();
	}

	@PostMapping(value="/company/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		System.out.println(company);
		if (company.equals(null) || company.getCompanyTrunover() < 100000000.00) {
			return new ResponseEntity<>("TurnOver must be greater than 10Cr", HttpStatus.BAD_REQUEST);
		}
		companyService.saveCompany(company);
		return new ResponseEntity<>("Created " + company.getCompanyCode(), HttpStatus.CREATED);
	}
}
