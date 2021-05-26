package com.example.emp.crud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpidEntity {

int id;
String emp_name;

EmpidEntity(int id, String emp_name) {
	this.id=id;
	this.emp_name=emp_name;
}

EmpidEntity(){
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getEmp_name() {
	return emp_name;
}

public void setEmp_name(String emp_name) {
	this.emp_name = emp_name;
}
}
