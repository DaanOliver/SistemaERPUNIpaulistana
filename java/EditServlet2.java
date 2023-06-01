

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String nome=request.getParameter("nome");  
        String senha=request.getParameter("senha");  
        String email=request.getParameter("email");  
        String pais=request.getParameter("pais");  
          
        EmpregadoJava e=new EmpregadoJava();  
        e.setIdempregado(id);  
        e.setNomeempregado(nome);  
        e.setSenhaempregado(senha);  
        e.setEmailempregado(email);  
        e.setPaisempregado(pais);  
          
        int status=EmpregadoDao.update(e);  
        if(status>0){  
            response.sendRedirect("VisualizarServlet");  
        }else{  
            out.println("Desculpa! não foi possivel atualizar o registro");  
        }  
          
        out.close();  
    }  
  
}  