package com.automation.restapi.restapiautomation.repository;

import com.automation.restapi.restapiautomation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
