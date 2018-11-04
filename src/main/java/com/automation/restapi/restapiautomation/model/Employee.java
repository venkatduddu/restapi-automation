package com.automation.restapi.restapiautomation.model;

import com.automation.restapi.restapiautomation.model.Department;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Employee {

  @Id
  @GeneratedValue
  private Long id;
  private String name;




}
