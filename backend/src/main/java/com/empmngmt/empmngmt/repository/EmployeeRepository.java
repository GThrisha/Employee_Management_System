package com.empmngmt.empmngmt.repository;

import com.empmngmt.empmngmt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
