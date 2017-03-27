package sk.toman.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ApplicationContext context = 
	
	
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
				
		ServletContext ctx = getServletContext();
		String mimeType = ctx.getMimeType("/picture.jpg");
		response.setContentType(mimeType);

		//treba header aby client rozpoznal ze ide o content + nazov suboru kt je volitelny
		String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=obazok.jpg");
        response.setHeader(headerKey, headerValue);
		
		InputStream is = ctx.getResourceAsStream("/picture.jpg");
		int read = 0;
		byte[] bytes = new byte[1024];
		OutputStream os = response.getOutputStream();
		while ((read = is.read(bytes)) != -1) {
		os.write(bytes, 0, read);
		}
		os.flush();
		os.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		doGet(request, response);
	}
}
