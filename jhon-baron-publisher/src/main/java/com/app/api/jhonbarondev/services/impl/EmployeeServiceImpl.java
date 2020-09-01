package com.app.api.jhonbarondev.services.impl;

import com.app.api.jhonbarondev.application.common.Utility;
import com.app.api.jhonbarondev.dto.EmployeeDTO;
import com.app.api.jhonbarondev.events.EmployeEvents;
import com.app.api.jhonbarondev.exceptions.EmployeeExceptions;
import com.app.api.jhonbarondev.services.EmployeeService;
import java.time.LocalDate;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired EmployeEvents employeEvents;

  @Override
  public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
    getEmployeeWithInfo(employeeDTO);
    employeEvents.saveEmployee(employeeDTO);
    return employeeDTO;
  }

  private void getEmployeeWithInfo(EmployeeDTO employeeDTO) {
    validateEmployeeStructure(employeeDTO);
    validateEmployeesAge(employeeDTO);
    validateEmployeeWorkingTime(employeeDTO);
  }

  private void validateEmployeeStructure(final EmployeeDTO employeeDTO) {
    final String employeeMessage = "Debe ingresar %s del empleado.";
    final String emptyString = "";
    if (Objects.isNull(employeeDTO)) {
      throw new EmployeeExceptions("Debe llenar toda la información solicitada.");
    }
    if (Objects.isNull(employeeDTO.getNombres()) || employeeDTO.getNombres().equals(emptyString)) {
      throw new EmployeeExceptions(String.format(employeeMessage, "nombres"));
    }
    if (Objects.isNull(employeeDTO.getApellidos())
        || employeeDTO.getApellidos().equals(emptyString)) {
      throw new EmployeeExceptions(String.format(employeeMessage, "apellidos"));
    }
    if (Objects.isNull(employeeDTO.getTipoDeDocumento())
        || employeeDTO.getTipoDeDocumento().equals(emptyString)) {
      throw new EmployeeExceptions(String.format(employeeMessage, "tipo de documento"));
    }
    if (Objects.isNull(employeeDTO.getNumeroDeDocumento())
        || employeeDTO.getNumeroDeDocumento().equals(emptyString)) {
      throw new EmployeeExceptions(String.format(employeeMessage, "numero de documento"));
    }
    if (Objects.isNull(employeeDTO.getFechaDeNacimiento())
        || employeeDTO.getFechaDeNacimiento().equals(emptyString)) {
      throw new EmployeeExceptions(String.format(employeeMessage, "fecha de nacimiento"));
    } else if (employeeDTO.getFechaDeNacimiento().after(Utility.localDateToDate(LocalDate.now()))) {
      throw new EmployeeExceptions("Fecha de nacimiento no puede ser mayor a la actual.");
    }
    if (Objects.isNull(employeeDTO.getFechaDeVinculacionCompania())
        || employeeDTO.getFechaDeVinculacionCompania().equals(emptyString)) {
      throw new EmployeeExceptions(
          String.format(employeeMessage, "fecha de vinculación a la compañía"));
    }
    if (Objects.isNull(employeeDTO.getCargo()) || employeeDTO.getCargo().equals(emptyString)) {
      throw new EmployeeExceptions(String.format(employeeMessage, "cargo"));
    }
    if (Objects.isNull(employeeDTO.getSalario()) || employeeDTO.getSalario() < 0) {
      throw new EmployeeExceptions(String.format(employeeMessage, "salario"));
    }
  }

  private void validateEmployeesAge(EmployeeDTO employeeDTO) {
    LocalDate employeeBirthday = Utility.dateToLocalDate(employeeDTO.getFechaDeNacimiento());
    int employeeAge =
        Utility.calculateAge(
            Utility.dateToLocalDate(employeeDTO.getFechaDeNacimiento()), LocalDate.now());
    if (employeeAge <= 17) {
      throw new EmployeeExceptions("Este empleado es menor de edad.");
    } else {
      employeeDTO.setEdadActualEmpleado(
          String.format(
              "Edad: %s - Meses: %s - Dias: %s",
              employeeAge,
              Utility.calculateMonths(employeeBirthday, LocalDate.now()),
              Utility.calculateDays(employeeBirthday, LocalDate.now())));
    }
  }

  private void validateEmployeeWorkingTime(EmployeeDTO employeeDTO) {
    LocalDate employeeVincTime =
        Utility.dateToLocalDate(employeeDTO.getFechaDeVinculacionCompania());
    employeeDTO.setTiempoDeVinculacionEmpleado(
        String.format(
            "Años: %s - Meses: %s - Dias: %s",
            Utility.calculateAge(employeeVincTime, LocalDate.now()),
            Utility.calculateMonths(employeeVincTime, LocalDate.now()),
            Utility.calculateDays(employeeVincTime, LocalDate.now())));
  }
}
