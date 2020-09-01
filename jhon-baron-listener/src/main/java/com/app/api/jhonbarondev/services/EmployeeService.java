package com.app.api.jhonbarondev.services;

import com.app.api.jhonbarondev.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
  EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

  List<EmployeeDTO> listEmployees();
}
