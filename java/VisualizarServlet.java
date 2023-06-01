

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VisualizarServlet")
public class VisualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<EmpregadoJava> list=EmpregadoDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Nome</th><th>Senha</th><th>Email</th><th>Pais</th><th>Editar</th><th>Delete</th></tr>");  
        for(EmpregadoJava e:list){  
         out.print("<tr><td>"+e.getIdempregado()+"</td><td>"+e.getNomeempregado()+"</td><td>"+e.getSenhaempregado()+"</td><td>"+e.getEmailempregado()+"</td><td>"+e.getPaisempregado()+"</td><td><a href='EditServlet?id="+e.getIdempregado()+"'>edit</a></td><td><a href='ExcluirServlet?id="+e.getIdempregado()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
	}

}
