<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1" import="java.sql.*" %> 

<%!
public class Conexao {  
  
	private Statement stm;
	private Connection con;
	private String user = "root";
	private String pass = "root";
	private String schema = "jsp";
	
    public Connection getConexao() throws SQLException 
    {  
        try {  
  
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + schema, user, pass);
            stm = con.createStatement();
            return con; 
  
         } catch (ClassNotFoundException e) {  
  
            System.out.println("erro "+ e);  
  
        }  
        return null;  
    }
    
    public Statement getStatement()
    {
    	return stm;
    }
    
}  
%>