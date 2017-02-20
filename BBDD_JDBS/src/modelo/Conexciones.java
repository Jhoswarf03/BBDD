package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexciones {
	
	private Connection miconexion = null;
	
	public Conexciones() {
		// TODO Auto-generated constructor stub
		
	}
  public Connection miconexcion(){
	// Crear  Base de dato
			try{
				miconexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			  }
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("No conecta");
				e.printStackTrace();
			}
			  return miconexion;
  }
  
  


}
