import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/SalvaServlet")  

public class SalvaServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String nome=request.getParameter("nome");  
        String senha=request.getParameter("senha");  
        String email=request.getParameter("email");  
        String pais=request.getParameter("pais");  
       
          
        EmpregadoJava e =new EmpregadoJava();  
        e.setNomeempregado(nome);
        e.setSenhaempregado(senha);
        e.setEmailempregado(email);
        e.setPaisempregado(pais);;
          
        int status=EmpregadoDao.save(e);  
        if(status>0 && (nome!="")&&(senha!="")&&(email!="")&&(pais!="") ){  
            out.print("<p>Registro salvo com sucesso</p>");  
            //request.getRequestDispatcher("cadastrobeneficio.html").include(request, response);  
        }else{  
            out.println("Desculpe! seu registro não foi salvo");
            //request.getRequestDispatcher("cadastrobeneficio.html").include(request, response);  
        }  
          
        out.close();  
    }  
  
}  