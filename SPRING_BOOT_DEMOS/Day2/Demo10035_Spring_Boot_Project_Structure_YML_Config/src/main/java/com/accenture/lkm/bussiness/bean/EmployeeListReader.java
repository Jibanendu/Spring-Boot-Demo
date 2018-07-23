package com.accenture.lkm.bussiness.bean;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("data")
public class EmployeeListReader {
	private String description;
	private List<Employee> employeeList;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	@Override
	public String toString() {
		return "EmployeeListReader [description=" + description
				+ ", employeeList=" + employeeList + "]";
	}
	
	
}
