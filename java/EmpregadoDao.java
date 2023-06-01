import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpregadoDao {

	public static Connection getConnection(){
		
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudservlet","root","2129");
			
			
		} catch (Exception e)
		{
			System.out.println(e);
			
		}
		return con;
	}
	public static int save(EmpregadoJava e)
	{
		int status =0;
		try 
		{
			Connection con=EmpregadoDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into empregado(nomeempregado, senhaempregado, emailempregado, paisempregado) values(?,?,?,?)");
			ps.setString(1, e.getNomeempregado());
			ps.setString(2, e.getSenhaempregado());
			ps.setString(3, e.getEmailempregado());
			ps.setString(4, e.getPaisempregado());
			
			status=ps.executeUpdate();
			con.close();
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		return status;
	}
	public static int update(EmpregadoJava e)
	{
		int status = 0;
		try 
		{
			Connection con=EmpregadoDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update empregado set nomeempregado=?,senhaempregado=?,emailempregado=?,paisempregado=? where idempregado=?");  
            ps.setString(1,e.getNomeempregado());  
            ps.setString(2,e.getSenhaempregado());  
            ps.setString(3,e.getEmailempregado());  
            ps.setString(4,e.getPaisempregado());  
            ps.setInt(5,e.getIdempregado());  
              
            status=ps.executeUpdate();  
              
            con.close();  

		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		return status;
	}
	public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpregadoDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from empregado where idempregado=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }
	 public static EmpregadoJava getEmployeeById(int id){  
	        EmpregadoJava e=new EmpregadoJava();  
	          
	        try{  
	            Connection con=EmpregadoDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from empregado where idempregado=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setIdempregado(rs.getInt(1));  
	                e.setNomeempregado(rs.getString(2));  
	                e.setSenhaempregado(rs.getString(3)); 
	                e.setEmailempregado(rs.getString(4));  
	                e.setPaisempregado(rs.getString(5));  
	            }  
	            con.close();  
	        }
	        catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	 	public static List<EmpregadoJava> getAllEmployees(){  
	        List<EmpregadoJava> list=new ArrayList<EmpregadoJava>();  
	          
	        try{  
	            Connection con=EmpregadoDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from empregado");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next())
	            {  
	            	EmpregadoJava e=new EmpregadoJava();  
	                e.setIdempregado(rs.getInt(1));  
	                e.setNomeempregado(rs.getString(2));  
	                e.setSenhaempregado(rs.getString(3));  
	                e.setEmailempregado(rs.getString(4));  
	                e.setPaisempregado(rs.getString(5));  
	                list.add(e);  
	            }  
	            con.close();  
	        }
	        catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
}
