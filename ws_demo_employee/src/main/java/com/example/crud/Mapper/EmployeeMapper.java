package com.example.crud.Mapper;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.example.crud.Employee;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

	@Mapping(target="employee_id",source="employee_id")
	@Mapping(target="employee_name",source="employee_name")
	//@Mapping(target="book_price",source="book_price")
	Employee toEmployee(Employee employeeDTO);
	
	
	@Mapping(target="employee_id",source="employee_id")
	@Mapping(target="employee_name",source="employee_name")
	//@Mapping(target="book_price",source="book_price")
	Employee toEmployeeDTO(Employee employee);
} 