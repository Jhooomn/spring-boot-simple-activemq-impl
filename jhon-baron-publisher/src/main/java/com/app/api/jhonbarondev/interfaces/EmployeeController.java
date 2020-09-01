package com.app.api.jhonbarondev.interfaces;

import com.app.api.jhonbarondev.dto.EmployeeDTO;
import com.app.api.jhonbarondev.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired private EmployeeService employeeService;

  @GetMapping(value = "/")
  public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
    return new ResponseEntity<>(employeeService.saveEmployee(employeeDTO), HttpStatus.OK);
  }
}
