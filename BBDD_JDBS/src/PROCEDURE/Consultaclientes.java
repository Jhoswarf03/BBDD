package PROCEDURE;

import java.sql.*;

public class Consultaclientes {

	public Consultaclientes() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     try {
    	 
    	 Connection miconex = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
    	 
    	 CallableStatement misql = miconex.prepareCall("{call muestraclientes}");
    	
    	 ResultSet rs= misql.executeQuery();
    	   
    	 while(rs.next())
    	 {	 
    		 
    		 System.out.println(rs.getString(1) + rs.getString(2)+ rs.getString(3)); 
    		    	
    	 }
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("no conecto");
	}
	}

}
