package sk.toman;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	
/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(urlPatterns = {// "/", 
		"/FirstServlet", "/FirstServlet2"}, initParams = {@WebInitParam(name="name",value="menooo")} )
public class FirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static int counter = 0;
	private static String name = "";	
	private int [] polePrvkov = {9,8,7,6,5,4,3,2,1};
	
    /**
     * Default constructor
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		counter++;
		PrintWriter out = response.getWriter();
		Date date = new Date();
		out.println("<html><h2>Hi There is TOMAS!</h2><br/><h3>Date="+date +"</h3>"
				+ "<br/><h2>counter="+counter + name + "</h2></html>");
		System.out.println("lineeeeeeeeeee");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		counter += 1000;
		System.out.println("POST");
		doGet(request, response);		
	}

}
