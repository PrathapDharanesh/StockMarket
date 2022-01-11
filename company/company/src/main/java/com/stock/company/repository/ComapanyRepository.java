package com.stock.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.company.pojo.Company;

@Repository
public interface ComapanyRepository extends JpaRepository<Company, String> {

	public Company findByCompanyCode(String companyCode);

	public List<Company> findAll();

	@SuppressWarnings("unchecked")
	public Company save(Company company);

}
