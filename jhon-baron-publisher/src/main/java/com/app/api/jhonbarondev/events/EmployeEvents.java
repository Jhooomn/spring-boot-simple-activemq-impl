package com.app.api.jhonbarondev.events;

import com.app.api.jhonbarondev.dto.EmployeeDTO;

public interface EmployeEvents {
  void saveEmployee(final EmployeeDTO employeeDTO);
}
