package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentManager;
import model.StudentModel;

@WebServlet("/RetrieveStudent")
public class RetrieveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    
	    response.setContentType("text/html");
	    PrintWriter PW =  response.getWriter();

	    try {
	      
	      StudentManager SM = new StudentManager();
	      List<StudentModel> slist = SM.retrieveStudent();
	      request.setAttribute("studentlist", slist);
	      slist.forEach((n) -> System.out.println(n));
	    }catch(Exception e)
	    {
	      PW.println(e.getMessage());
	    }
	    RequestDispatcher RD= request.getRequestDispatcher("retrieve.jsp");
	    RD.forward(request, response);
	   
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    doGet(request, response);
	  }

}
