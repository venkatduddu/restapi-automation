package com.automation.restapi.restapiautomation.controller;

import com.automation.restapi.restapiautomation.model.Employee;
import com.automation.restapi.restapiautomation.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {

    Optional<Employee> employee = employeeRepository.findById(id);

    if (employee.isPresent()) {
      return ResponseEntity.ok(employee.get());
    }

    return ResponseEntity.notFound().build();
  }

  @GetMapping()
  public ResponseEntity<List<Employee>> getAllEmployee() {

    List<Employee> employees = employeeRepository.findAll();

    return ResponseEntity.ok(employees);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Employee> saveEmployeeB(@RequestBody Employee employee) {

    Employee savedEmplyee = employeeRepository.saveAndFlush(employee);

    return ResponseEntity.ok(savedEmplyee);
  }

  @DeleteMapping(("/{id}"))
  public ResponseEntity<Employee> saveEmployee(@PathVariable("id") Long id) {

    employeeRepository.deleteById(id);

    return ResponseEntity.status(200).build();
  }
}
