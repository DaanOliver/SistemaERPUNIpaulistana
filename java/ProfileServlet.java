package Lservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("link.html").include(request, response);

		Cookie ck[] = request.getCookies();

		if (ck != null) {
			String name = ck[0].getValue();

			if (name != "" || name != null) {
				out.print("<h1>Seja bem vindo ao perfil</h1>");
				out.print("<p>Seja bem vindo: </p>" + name);
			}

		} else {
			out.print("Por favor efetue o login primeiro");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
