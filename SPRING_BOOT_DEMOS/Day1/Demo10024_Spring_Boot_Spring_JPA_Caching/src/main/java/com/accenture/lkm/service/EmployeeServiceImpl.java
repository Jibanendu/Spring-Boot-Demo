package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.Employee;
import com.accenture.lkm.dao.EmployeeDAO;
import com.accenture.lkm.entity.EmployeeEntity;
@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAO employeeDAO;

	 // name element defines name of the cache used.
	 // key defines the index value for the cached object.
	 // This annotation makes sure that the return value from
	 // this method is stored in the cache empCacheSpace with the employeeId as the key
     // and return values as the value.
	 // Note: employeeId is retrieved from the parameter
	@Cacheable(value="empCacheSpace", key="#employeeId")
	public Employee getEmployeeDetailByEmployeeId(int employeeId){
		Employee employee =null;
		EmployeeEntity employeeEntity= employeeDAO.findOne(employeeId);
		if(employeeEntity!=null){
			employee= new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
	}
	
	// Return value is saved in the cache with random key
	@Cacheable(value="empCacheSpace")
	public Collection<Employee> getEmployeeDetails(){
		Collection<EmployeeEntity> collec =employeeDAO.findAll();
		List<Employee> listEmployee = new ArrayList<Employee> ();
		for (EmployeeEntity employeeEntity : collec) {
			Employee employee=new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
			listEmployee.add(employee);
		}
		return listEmployee;
	}

	//2nd to discuss
	// @CachePut is used to put the items in the cache
	// or update the items already in the cache.
	// This annotation makes sure that the return value from
	// this method is stored in the cache empCacheSpace with the employeeId as the key
    // and return values as the Employee object returned by the method after the DB update
	// Note: key is derived from the method's return value,
	// if return type of method would have been int 
	// then it would have format: result
	@CachePut(value="empCacheSpace",key="#result.employeeId") 
	public Employee addEmployee(Employee employee) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		EmployeeEntity emp= (EmployeeEntity)employeeDAO.save(employeeEntity);
		System.out.println(emp);
		Employee employee2 = new Employee();
		
		BeanUtils.copyProperties(emp,employee2 );
		return employee2;
	}	
	
	
	//3nd to discuss
	// @CachePut is used to put the items in the cache
	// or update the items already in the cache.
	// This annotation makes sure that the return value from
	// this method is stored in the cache empCacheSpace with the employeeId as the key
    // and return values as the Employee object returned by the method after the DB update
	// Note: key is derived from the method parameter received
	@CachePut(value="empCacheSpace",key="#employee.employeeId")
	public Employee updateEmployee(Employee employee){
		Employee employee2 =null;
		EmployeeEntity employeeEntity= employeeDAO.findOne(employee.getEmployeeId());
		if(employeeEntity!=null){
			//update operation
			BeanUtils.copyProperties(employee, employeeEntity);	
			EmployeeEntity employeeEntity2=employeeDAO.save(employeeEntity);
			
			//copying the properties back to Employee DTO Object 
			employee2= new Employee();
			BeanUtils.copyProperties(employeeEntity2, employee2);
		}
		return employee2;
	}
	
	
	//4the one
    // This annotation is used to delete the values from the cache.
	// key defines the index/key value for the cached object.
	// When delete method is successfully completed then element is removed from the cache also
	// after removing the same from DB.
	@CacheEvict(value="empCacheSpace",key="#employeeId") 
	public Employee deleteEmployee(int employeeId){
		Employee employee =null;
		EmployeeEntity employeeEntity= employeeDAO.findOne(employeeId);
		if(employeeEntity!=null){
			employeeDAO.delete(employeeEntity);
			employee= new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
	}
	
	
	// 5th one
	// Many applications need a  method to clear the whole cache.
	// Purge all the items in the cache 
	@CacheEvict(value="empCacheSpace", allEntries=true)
	public void evictAll(){
		
	}
	// When this method will be invoked then all items in the cache will be purged
}
