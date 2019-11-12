package com.example.crud.Controller;

	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import javax.validation.Valid;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.rest.webmvc.ResourceNotFoundException;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

import com.example.crud.Employee;
import com.example.crud.Repo.EmployeeRepo;
	@RestController
	public class EmployeeController {

	       @Autowired
	       private EmployeeRepo employeeRepo;

	       @GetMapping("/employee")
	       public List<Employee> getAllEmployeeDetails() {
	              return employeeRepo.findAll();
	       }

	       @GetMapping("/employee/{id}")
	       public ResponseEntity<Employee> getMovieById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
	              Employee emp = employeeRepo.findById(id)
	                           .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
	              return ResponseEntity.ok().body(emp);
	       }

	       @PostMapping("/employee")
	       public Employee InsertEmployee(@Valid @RequestBody Employee emp) {
	              return employeeRepo.save(emp);
	       }

	       @PutMapping("/employee/{id}")
	       public ResponseEntity<Employee> updateMovie(@PathVariable(value = "id") Integer id,
	                     @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
	              Employee emp = employeeRepo.findById(id)
	                           .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
	              emp.setName(employeeDetails.getName());
	              final Employee updatedEmployee = employeeRepo.save(emp);
	              return ResponseEntity.ok(updatedEmployee);
	       }

	       @DeleteMapping("/employee/{id}")
	       public Map<String, Boolean> deleteMovie(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
	              Employee emp = employeeRepo.findById(id)
	                           .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

	              employeeRepo.delete(emp);
	              Map<String, Boolean> response = new HashMap<>();
	              response.put("deleted", Boolean.TRUE);
	              return response;
	       }
	}

