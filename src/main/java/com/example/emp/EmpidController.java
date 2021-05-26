package com.example.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.crud.EmpidDAO;
import com.example.emp.crud.EmpidEntity;



@RestController
@RequestMapping(value="/empid")
public class EmpidController {
	
	@Autowired
	EmpidDAO empdao;
	EmpidEntity emp;
	
	
	@GetMapping("/all")
	public List<EmpidEntity> getAll()
	{
		System.out.println("GetMethod");
		return empdao.retriveEmpId();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addid")
	public String addSingleId(@RequestBody EmpidEntity emp )
	{
		return empdao.addEmpId(emp);
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public EmpidEntity getByID(@PathVariable("id") int id)
	{
		return empdao.getEmpByID(id);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/update/name/{id}")
	public String updateNameById(@PathVariable("id") int id, @RequestParam String emp_name )
	{
		
		return empdao.updateNameById(id, emp_name);
	}
}
