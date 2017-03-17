package sk.toman.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.toman.model.LoginModel;

public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		LoginModel logModel = new LoginModel();
		boolean boolLogin = logModel.checkLogin(request.getParameter("userName"), request.getParameter("userPass"));
		System.out.println("as6df1s6f15s61f6s51fd6s51");
		if(boolLogin){
			System.out.println("true");
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
			dispatcher.forward(request, response);			
		}else{
			System.out.println("falsee");
			request.setAttribute("error", "Nespravne meno alebo heslo!!!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);	
		}
				
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
	
}
