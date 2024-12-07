package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentManager;
import model.StudentModel;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("T1"));
		String name= request.getParameter("T2");
		String mobileNum= request.getParameter("T3");
		String email = request.getParameter("T4");
		String gender = request.getParameter("T5");
		int age = Integer.parseInt(request.getParameter("T6"));
		String location = request.getParameter("T7");
		
		StudentModel s=new StudentModel();
		s.setAge(age);
		s.setEmail(email);
		s.setGender(gender);
		s.setId(id);
		s.setLocation(location);
		s.setMobileNum(mobileNum);
		s.setName(name);
		StudentManager sm=new StudentManager();
		
		response.setContentType("text/html");
		try {
			String akm = sm.addStudent(s);
			
			PrintWriter pr=response.getWriter();
			pr.print("<h2>"+ akm+"</h2>");
		} catch (Exception e) {
			PrintWriter pr=response.getWriter();
			pr.print("<h2>"+ e.getMessage()+"</h2>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
