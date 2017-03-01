package sk.toman.util;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
 @WebServlet("/echo")
public class Echo extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      // Write the response message, in an HTML page
      try {
    	  System.out.println(request.getParameterNames().toString());
    	  if((request.getParameter("username")).equalsIgnoreCase("tom")){
    		  response.sendRedirect("redirect.html");
    	  }else{
    		  HttpSession ss = request.getSession();
    		  String sessionID = ss.getId();
    		  ss.setMaxInactiveInterval(30);
    		  
    		  out.println("<html>");
              out.println("<head><title>Hello, World</title></head>");
              out.println("<body>");
              out.println("<h1>Hello, world!</h1>");  // says Hello
              // Echo client's request information
              out.println(request.getParameter("username"));
              out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
              out.println("<p>Protocol: " + request.getProtocol() + "</p>");
              out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
              out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
              out.println("<p>sessionID: " + sessionID + "</p>");

              // Generate a random number upon each request
              out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
              out.println("</body></html>"); 
    	  }
    	  
    	  
    	  
    	  
         
      } finally {
         out.close();  // Always close the output writer
      }
   }
}