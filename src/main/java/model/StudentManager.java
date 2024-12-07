package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;

public class StudentManager {
	public String addStudent(StudentModel s) throws Exception{
		
		SessionFactory SF= new Configuration().configure().buildSessionFactory();
		Session SES= SF.openSession();
		
		SES.getTransaction().begin();
		SES.persist(s);
		SES.getTransaction().commit();
		
		SES.close();
		SF.close();
		
		return "Data has been stored";
	}
	
	public List<StudentModel> retrieveStudent() throws Exception{
		
		 List<StudentModel> slist = null;
		    
		 SessionFactory SF= new Configuration().configure().buildSessionFactory();
		 Session SES= SF.openSession();
	   
		 SES.getTransaction().begin();
		    
		 TypedQuery<StudentModel> qry = SES.createQuery("select S from StudentModel S",StudentModel.class);
		 slist = qry.getResultList();
		  
		 SES.getTransaction().commit();
		   
		 SES.close();
		 SF.close();
		return slist;
	}
}	
