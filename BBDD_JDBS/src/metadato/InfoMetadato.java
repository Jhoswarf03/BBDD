package metadato;

import java.sql.*;
public class InfoMetadato {

	public InfoMetadato() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          mostrainfor_BDD();
	}
    
	static void  mostrainfor_BDD(){
		Connection miConexion = null;
		try {
			 miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
		     //Obtencion de Metadatos
			DatabaseMetaData meta = miConexion.getMetaData();
			
			//Mostramos informacion
			
			System.out.println(meta.getDatabaseProductName() + meta.getDatabaseProductVersion()+ meta.getUserName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		
	}
}
