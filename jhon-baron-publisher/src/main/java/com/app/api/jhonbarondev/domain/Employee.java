package com.app.api.jhonbarondev.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column private String nombres;
  @Column private String apellidos;
  @Column private String tipoDeDocumento;
  @Column private String numeroDeDocumento;
  @Column private Date fechaDeNacimiento;
  @Column private Date fechaDeVinculacionCompania;
  @Column private String cargo;
  @Column private Double salario;
  @Column private String tiempoDeVinculacionEmpleado;
  @Column private Integer edadActualEmpleado;
}
