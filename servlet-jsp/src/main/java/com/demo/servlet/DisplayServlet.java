package com.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.Employee;
import com.demo.service.*;

@WebServlet("/showemp")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		EmpService service= new EmpServiceImpl();
		List<Employee> elist= service.getAllEmployees();
		
		req.setAttribute("elist", elist);
		RequestDispatcher rd= req.getRequestDispatcher("Display.jsp") ;
		rd.forward(req, res);
	}

}
