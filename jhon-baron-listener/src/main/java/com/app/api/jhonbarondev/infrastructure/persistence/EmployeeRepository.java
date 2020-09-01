package com.app.api.jhonbarondev.infrastructure.persistence;

import com.app.api.jhonbarondev.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
