package com.automation.restapi.restapiautomation.repository;

import com.automation.restapi.restapiautomation.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  @Query("select e from Employee e where e.name like %?1%")
  List<Employee> findByName(String name);

}
