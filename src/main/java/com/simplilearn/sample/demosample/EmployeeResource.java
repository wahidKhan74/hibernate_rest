package com.simplilearn.sample.demosample;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.simplilearn.sample.demosample.dao.EmployeeDAO;
import com.simplilearn.sample.demosample.entity.Employee;



@Path("/employees")
public class EmployeeResource {
	  	
		@GET
	    @Produces("application/json")
	    public List<Employee> getEmployee() {
	        EmployeeDAO dao = new EmployeeDAO();
	        List employees = dao.getEmployees();
	        return employees;
	    }
	 
	    
	    @POST
	    @Path("/create")
	    @Consumes("application/json")
	    public Response addEmployee(Employee emp){
	        emp.setFirstName(emp.getFirstName());
	        emp.setLastName(emp.getLastName());
	        emp.setDept(emp.getDept());
	        emp.setSalary(emp.getSalary());
	                
	        EmployeeDAO dao = new EmployeeDAO();
	        dao.addEmployee(emp);
	        
	        return Response.ok().build();
	    }
	    
	    @PUT
	    @Path("/update/{id}")
	    @Consumes("application/json")
	    public Response updateEmployee(@PathParam("id") int id, Employee emp){
	        EmployeeDAO dao = new EmployeeDAO();
	        int count = dao.updateEmployee(id, emp);
	        if(count==0){
	            return Response.status(Response.Status.BAD_REQUEST).build();
	        }
	        return Response.ok().build();
	    }
	    
	    @DELETE
	    @Path("/delete/{id}")
	    @Consumes("application/json")
	    public Response deleteEmployee(@PathParam("id") int id){
	        EmployeeDAO dao = new EmployeeDAO();
	        int count = dao.deleteEmployee(id);
	        if(count==0){
	            return Response.status(Response.Status.BAD_REQUEST).build();
	        }
	        return Response.ok().build();
	    }
}
