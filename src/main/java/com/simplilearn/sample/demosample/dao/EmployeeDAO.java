package com.simplilearn.sample.demosample.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.sample.demosample.entity.Employee;
import com.simplilearn.sample.demosample.util.SessionUtil;



public class EmployeeDAO {
	
	public void addEmployee(Employee bean){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addEmployee(session,bean);        
        tx.commit();
        session.close();
        
    }
    
    private void addEmployee(Session session, Employee bean){
        Employee employee = new Employee();
        
        employee.setFirstName(bean.getFirstName());
        employee.setDept(bean.getDept());
        employee.setLastName(bean.getLastName());
        employee.setSalary(bean.getSalary());
        
        session.save(employee);
    }
    
    public List<Employee> getEmployees(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Employee");
        List<Employee> employees =  query.list();
        session.close();
        return employees;
    }
 
    public int deleteEmployee(int id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Employee where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updateEmployee(int id, Employee emp){
         if(id <=0)  
               return 0;  
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Employee set name = :name, age=:age where id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id",id);
            query.setString("firstName",emp.getFirstName());
            query.setString("lastName",emp.getLastName());
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }
}
