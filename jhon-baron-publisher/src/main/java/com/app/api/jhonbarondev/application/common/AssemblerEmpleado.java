package com.app.api.jhonbarondev.application.common;

import com.app.api.jhonbarondev.domain.Employee;
import com.app.api.jhonbarondev.dto.EmployeeDTO;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@Slf4j
public class AssemblerEmpleado {
  public static Employee convertToEntity(final EmployeeDTO employeeDTO) {
    Employee employee = Employee.builder().build();
    if (!Objects.isNull(employeeDTO)) {
      BeanUtils.copyProperties(employeeDTO, employee);
    }
    return employee;
  }
}
