package conectandoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBD {

	public ModificaBD() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			// 1 CREAR CONEXION
			Connection miconexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
		   //2 CREAR  OBJETO  ESTEIMENT 
			
			Statement miStatement = miconexion.createStatement(); 
		   // 3 EJECUTAR SQL
			
			//String misql = "INSERT INTO PRODUCTOS(CODIGO,NOMBREARTICULO,PRECIO) VALUES('ART77','PANTALON','25.32')";
			//String misql = "UPDATE PRODUCTOS SET PRECIO='257.2' WHERE CODIGO='ART77'" ;
			String misql = "DELETE from PRODUCTOS WHERE códigoartículo='ART77'";
			miStatement.executeUpdate(misql);
		    miStatement.close();
		}
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("No conecta");
		    e.printStackTrace();
		 }
	}

}
