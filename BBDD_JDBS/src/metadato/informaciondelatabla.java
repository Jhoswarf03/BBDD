package metadato;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class informaciondelatabla {

	public informaciondelatabla() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mostrainfor_BDD();
	}
	static void  mostrainfor_BDD(){
		Connection miConexion = null;
		ResultSet rs =null;
		try {
			
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
		     //Obtencion de Metadatos
			System.out.println("List de  Tablas");
			DatabaseMetaData meta = miConexion.getMetaData();
			rs = meta.getTables(null, null,  null, null);
			while(rs.next())
			{
				System.out.println(rs.getString("TABLE_NAME"));	
				
			}
			System.out.println("List de columnas");
		     //Obtencion de Metadatos
			rs = meta.getColumns(null, null,  null, null);
			while(rs.next())
			{
				System.out.println(rs.getString("COLUMN_NAME"));	
			}
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
