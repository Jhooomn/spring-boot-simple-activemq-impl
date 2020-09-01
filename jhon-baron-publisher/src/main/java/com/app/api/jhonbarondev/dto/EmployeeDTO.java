package com.app.api.jhonbarondev.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Builder
@Data
public class EmployeeDTO implements Serializable {
  private String nombres;
  private String apellidos;
  private String tipoDeDocumento;
  private String numeroDeDocumento;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @DateTimeFormat(iso = ISO.DATE)
  private Date fechaDeNacimiento;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @DateTimeFormat(iso = ISO.DATE)
  private Date fechaDeVinculacionCompania;

  private String cargo;
  private Double salario;
  private String tiempoDeVinculacionEmpleado;
  private String edadActualEmpleado;
}
