package com.example.emp.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpidImpl implements EmpidDAO {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	private static final String getAllEmpId ="select * from Employlee_Details.emp_id";
	private static final String addEmpId ="insert into Employlee_Details.emp_id (id,emp_name) values (?,?)";
	private static final String getEmpById ="select * from Employlee_Details.emp_id where id=?";
	private static final String updateEmpnameById ="update Employlee_Details.emp_id set emp_name =? where id =?";
	@Override
	public List<EmpidEntity> retriveEmpId() {		

		return jdbctemplate.query(getAllEmpId, (rs,rowNum) -> {
			return new EmpidEntity(rs.getInt("id"),rs.getString("emp_name"));
		});
		
	}
	@Override
	public String addEmpId(EmpidEntity empid) {
		
		String message= null;
		try{
			jdbctemplate.update(addEmpId, empid.getId(),empid.getEmp_name());
			message ="Added sucussfully";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return message;
	}
	@Override
	public EmpidEntity getEmpByID(int id) {
		return jdbctemplate.queryForObject(getEmpById,(rs,rowNum) ->
		{
			return new EmpidEntity(rs.getInt("id"),rs.getString("emp_name"));
		},id);
	}
	@Override
	public String updateNameById(int id,String name) {
		jdbctemplate.update(updateEmpnameById, name,id);
		return "update emp name for the Id"+id;
	}
	

}
