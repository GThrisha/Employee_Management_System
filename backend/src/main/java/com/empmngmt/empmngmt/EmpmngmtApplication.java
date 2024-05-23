package com.empmngmt.empmngmt;

import com.empmngmt.empmngmt.model.Employee;
import com.empmngmt.empmngmt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpmngmtApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmpmngmtApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String args[]) throws Exception{
//		Employee employee= new Employee();
//		employee.setFirstName("Thrisha");
//		employee.setLastName("G");
//		employee.setEmailId("thrishag1804@gmail.com");
//		employeeRepository.save(employee);
//
//		Employee employee1= new Employee();
//		employee1.setFirstName("Yeshwitha");
//		employee1.setLastName("G");
//		employee1.setEmailId("yeshwitha27@gmail.com");
//		employeeRepository.save(employee1);

	}
}
