package com.example.crud.Repo;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.crud.Employee;


	@RepositoryRestResource
	(collectionResourceRel="employee",path="employee")
	public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	       

	}


