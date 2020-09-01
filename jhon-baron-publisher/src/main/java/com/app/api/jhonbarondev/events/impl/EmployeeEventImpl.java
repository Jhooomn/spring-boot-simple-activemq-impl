package com.app.api.jhonbarondev.events.impl;

import com.app.api.jhonbarondev.dto.EmployeeDTO;
import com.app.api.jhonbarondev.events.EmployeEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmployeeEventImpl implements EmployeEvents {

  @Autowired ObjectMapper objectMapper;
  @Autowired JmsTemplate jmsTemplate;

  @Value("${message.outbound.employee}")
  private String employeeQueue;

  @Override
  public void saveEmployee(EmployeeDTO employeeDTO) {
    log.info("[Publish saveEmployee event] ::: [Publish saveEmployee event]");
    try {
      jmsTemplate.convertAndSend(employeeQueue, objectMapper.writeValueAsString(employeeDTO));
    } catch (JsonProcessingException ex) {
      log.error("[saveEmployee] jms send. Exception convert object to json: " + ex.getMessage());
    }
  }
}
