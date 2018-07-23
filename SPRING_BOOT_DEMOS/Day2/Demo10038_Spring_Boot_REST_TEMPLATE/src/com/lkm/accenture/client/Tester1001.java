package com.lkm.accenture.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.bussiness.bean.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Tester1001 {
	public static final String REST_SERVICE_URI = "http://localhost:8090/emp/controller/";
	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllEmployees() {
		System.out.println("Testing listAllUsers API-----------");

		RestTemplate restTemplate = new RestTemplate();
		//Hitting the Server URL and getting the response
		List<LinkedHashMap<String, Object>> employeeMap = restTemplate.getForObject(REST_SERVICE_URI + "getDetails", List.class); 
		
		//mapper to covert Object to a specific type  
		ObjectMapper mapper =  new ObjectMapper();
		List<Employee> list  = new ArrayList<Employee>();
		
		if (employeeMap != null) {
			for (LinkedHashMap<String, Object> map : employeeMap) {
				//Map object should be converted to Employee type 
				Employee emp=mapper.convertValue(map, Employee.class);
				list.add(emp);
			}
			System.out.println("Employee Details are: "+list);
		} else {
			System.out.println("No user exist----------");
		}
	}

	// GET 
	private static void getEmployee() {
		System.out.println("Testing getEmployee----------");
		RestTemplate restTemplate = new RestTemplate();
		//Placing Request and getting response
		Employee emp = restTemplate.getForObject(REST_SERVICE_URI + "getDetailsById/10003",Employee.class);
		System.out.println(emp);
	}

	 //POST 
	private static void createEmployee() {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = new Employee("TestMSD",0,1000.0,104);
		//Placing Request with a request body and getting Response
		String str = restTemplate.postForObject(REST_SERVICE_URI + "addEmp",emp, String.class);
		System.out.println("String Returned : " + str);
	}

	//PUT 
	private static void updateEmployee() {
		System.out.println("Testing update User API----------");
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = new Employee("MSDClient",10001, 7000.0,105);
		//Placing Request with a request body for Update
		restTemplate.put(REST_SERVICE_URI + "updateEmp", employee);
		System.out.println(employee);
	}

	//DELETE 
	private static void deleteEmployee() {
		System.out.println("Testing delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		//Placing Request with a request body for deletion of Employee
		restTemplate.delete(REST_SERVICE_URI + "deleteEmp/10002");
		System.out.println("Deleted Successfuly!!!");
	}

	public static void main(String args[]) {
		//listAllEmployees();
		//getEmployee();
		//createEmployee();
		//updateEmployee();
		deleteEmployee();
		
		
	}
}
//Step1 please don't put extra slashes in the end
//Step2  for appropriate request method on server side please choose appropriate request method
//example to invoke get method on server please use the getmethod on client
//Step3  please updated the employeeIds to be created/ updated/ deleted in the end of every URL
//put and delete do not return any thing hence showing null
