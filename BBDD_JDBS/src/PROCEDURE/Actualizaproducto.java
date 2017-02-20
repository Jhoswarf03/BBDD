package PROCEDURE;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Actualizaproducto {
    
	public Actualizaproducto() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
		int  precio = Integer.parseInt(JOptionPane.showInputDialog("introduce precio"));
	    String nombre = JOptionPane.showInputDialog("introduce articulo");	
		
		try {
		    	 Connection miconex = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
		    	 CallableStatement misql = miconex.prepareCall("{call ACTUALIZAR_PROD(?,?)}");
		    	 misql.setInt(1, precio);
		    	 misql.setString(2, nombre);
		         misql.execute();
		         } catch (Exception e) {
				// TODO: handle exception
				System.out.println("no conecto");
			}
	}

}
