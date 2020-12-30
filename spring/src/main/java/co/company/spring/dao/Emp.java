package co.company.spring.dao;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Emp {
    String employeeId;   
	String firstName;
	String lastName;
	String email;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	//@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	Date hireDate;	
	String jobId;	
	String departmentId;
	Integer salary;
	String msg;
}
