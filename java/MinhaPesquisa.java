

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MinhaPesquisa")
public class MinhaPesquisa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {		
	
		String pesquisa = req.getParameter("nomedapesquisa");
		resp.sendRedirect("https://www.google.com.br/#q="+pesquisa);
	}

}
