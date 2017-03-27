package sk.toman.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.toman.model.*;

public class BeerSelect extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("Beer Selection Advice<br>");
		
		String color = request.getParameter("color");
		out.println("<br>Got beer color " + color);
		
		BeerExpert expert = new BeerExpert();
		List<String> result= expert.getBrands(color);
		
		request.setAttribute("brands", result);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
		
		

		
		
		
		
		
//		Iterator<String> iterator = result.iterator();
//		while(iterator.hasNext()){
//			out.println("<br>Beer Brand " + iterator.next());
//		}
//		
		
		
		String d = request.getParameter("name");
		out.println("<br>Name beer " + d);
	}
}
