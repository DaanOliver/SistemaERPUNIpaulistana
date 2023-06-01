

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Empregado</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        
        EmpregadoJava e = EmpregadoDao.getEmployeeById(id);
		
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getIdempregado()+"'/></td></tr>");  
        out.print("<tr><td>Nome:</td><td><input type='text' name='nome' value='"+e.getNomeempregado()+"'/></td></tr>");  
        out.print("<tr><td>Senha:</td><td><input type='password' name='senha' value='"+e.getSenhaempregado()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmailempregado()+"'/></td></tr>");  
        out.print("<tr><td>Pais:</td><td>");  
        out.print("<select name='pais' style='width:150px'>");  
        out.print("<option>Brasil</option>");  
        out.print("<option>Bolovia</option>");  
        out.print("<option>Paraguai</option>"); 
        out.print("<option>Argentina</option>");  
        out.print("<option>Venezuela</option>");  
        out.print("<option>Outro</option>");  
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Editar & Salvar '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
        out.close();
	}

}
