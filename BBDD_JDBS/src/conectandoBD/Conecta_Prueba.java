package conectandoBD;

import java.sql.*;

import javax.sql.*;

public class Conecta_Prueba {

	public Conecta_Prueba() {
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
			ResultSet miresulset = miStatement.executeQuery("select  * from  productos");
			// 4 recorrer  el resulset  (que es  un tabla  virtual  q contienes el resultado del  sql)

			while(miresulset.next())
			{
				System.out.println(miresulset.getString("CÓDIGOARTÍCULO"));

			}
           miresulset.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("No conecta");
			e.printStackTrace();
		}
		
		}
		
	

}
