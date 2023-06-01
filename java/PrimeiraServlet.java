

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrimeiraServlet")
public class PrimeiraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String nome = request.getParameter("nome");
			out.println("Bem vindo "+nome);
			
			Cookie ck = new Cookie("uname", nome);
			response.addCookie(ck);
			
			out.println("<!DOCTYPE html>");
			out.println("<html lang='pt-br'>");
			out.println("<head>");
			out.println("<title>");
			out.println("Chamando Segundo Servlet");
			out.println("</title>");
			out.println("</head>");
			out.println("<body>");
			out.print("<form action='servlet2' method='post'>");  
		    out.print("<input type='submit' value='Navegue ate nosso segundo servlet'>");  
		    out.print("</form>");  
			out.println("</body>");
			out.println("</html>");
			out.println("");
			out.println("");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
