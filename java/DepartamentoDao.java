import java.sql.*;
import java.util.ArrayList;
import java.util.List; 

public class DepartamentoDao {
	  
	    public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rhuni","root","2129");
	        }
	        catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(Departamento e){  
	        int status=0;
	        
	        try{  
	            Connection con=DepartamentoDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into departamento(nomedepartamento,sigladepartamento,descricao) values (?,?,?)");  
	            
	            ps.setString(1,e.getNomedepartamento());  
	            ps.setString(2,e.getSigla());  
	            ps.setString(3,e.getDescricao());   
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }
	        catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }
		public static int update(Departamento e)
		{
			int status = 0;
			try 
			{
				Connection con=DepartamentoDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("update departamento set nomedepartamento=?,sigladepartamento=?,descricao=? where iddepartamento=?");  
	            ps.setString(1,e.getNomedepartamento());  
	            ps.setString(2,e.getSigla());  
	            ps.setString(3, e.getDescricao());
	            ps.setInt(4,e.getIddepartamento());                
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
	            Connection con=DepartamentoDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from departamento where iddepartamento=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }
		 public static Departamento getDepartamentoById(int id){  
		        Departamento e=new Departamento();  
		          
		        try{  
		            Connection con=DepartamentoDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from departamento where iddepartamento=?");  
		            ps.setInt(1,id);  
		            ResultSet rs=ps.executeQuery();  
		            if(rs.next()){  
		                e.setIddepartamento(rs.getInt(1));  
		                e.setNomedepartamento(rs.getString(2));  
		                e.setSigla(rs.getString(3)); 
		                e.setDescricao(rs.getString(4));  
		            }  
		            con.close();  
		        }
		        catch(Exception ex){ex.printStackTrace();}  
		          
		        return e;  
		    }  
		 	public static List<Departamento> getAllDepartamento(){  
		        List<Departamento> list=new ArrayList<Departamento>();  
		          
		        try{  
		            Connection con=DepartamentoDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from departamento");  
		            ResultSet rs=ps.executeQuery();  
		            while(rs.next())
		            {  
		            	Departamento e=new Departamento();  
		                e.setIddepartamento(rs.getInt(1));  
		                e.setNomedepartamento(rs.getString(2));  
		                e.setSigla(rs.getString(3));  
		                e.setDescricao(rs.getString(4));  
		                list.add(e);  
		            }  
		            con.close();  
		        }
		        catch(Exception e){e.printStackTrace();}  
		          
		        return list;  
		    }  
}
