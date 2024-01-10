package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.EmpService;
import com.demo.service.EmpServiceImpl;


@WebServlet("/deleteemp")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		int id= Integer.parseInt(req.getParameter("eid")) ;
		EmpService service= new EmpServiceImpl();
		service.deleteEmployee(id);
		
		RequestDispatcher rd= req.getRequestDispatcher("showemp") ;
		rd.forward(req, res);
	}

}
 