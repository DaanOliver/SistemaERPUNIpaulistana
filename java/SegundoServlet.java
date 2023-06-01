

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SegundoServlet")
public class SegundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		try {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			Cookie ck[] = request.getCookies();
			out.println("Ola "+ck[0].getValue());
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
