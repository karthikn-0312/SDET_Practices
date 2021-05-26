package com.example.emp.crud;

import java.util.List;

public interface EmpidDAO {

	 List<EmpidEntity> retriveEmpId();
	 String addEmpId(EmpidEntity empid);
	 EmpidEntity getEmpByID(int id);
	 String updateNameById(int id, String name);
}
