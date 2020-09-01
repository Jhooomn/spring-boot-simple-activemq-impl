package com.app.api.jhonbarondev.events.impl;

import com.app.api.jhonbarondev.dto.EmployeeDTO;
import com.app.api.jhonbarondev.events.EmployeEvents;
import com.app.api.jhonbarondev.services.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmployeeEventImpl implements EmployeEvents {

  @Autowired private ObjectMapper objectMapper;

  @Value("${message.outbound.employee}")
  private String employeeQueue;

  @Autowired private EmployeeService employeeService;

  @Override
  @JmsListener(destination = "${message.outbound.employee}")
  public void saveEmployee(String employeeDTO) {
    log.info("[Publish saveEmployee event] ::: [Publish saveEmployee event]");
    try {
      employeeService.saveEmployee(objectMapper.readValue(employeeDTO, EmployeeDTO.class));
    } catch (JsonProcessingException e) {
      log.info("[Publish saveEmployee event] ::: [Publish saveEmployee event]");
    }
  }
}
