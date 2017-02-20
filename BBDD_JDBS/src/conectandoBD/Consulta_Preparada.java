package conectandoBD;

import java.sql.*;
import javax.sql.*;

import com.mysql.jdbc.Connection;

public class Consulta_Preparada {
	public Consulta_Preparada() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			// 1 CREAR CONEXION
			java.sql.Connection miconexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			//2  preparar consulta
			PreparedStatement mipreparacion = miconexion.prepareStatement("select códigoartículo, sección, paísdeorigen from productos where sección=?  and paísdeorigen=?");
			mipreparacion.setString(1, "deportes");
			mipreparacion.setString(2, "usa");
			ResultSet miresulset = mipreparacion.executeQuery();
			while(miresulset.next())
			{
				System.out.println(miresulset.getString(1) +" "+ miresulset.getString("sección") +" "+ miresulset.getString("paísdeorigen") + "");		    	  
			}
			miresulset.close();
			///////////////
			mipreparacion.setString(1, "ceramica");
			mipreparacion.setString(2, "china");
			miresulset = mipreparacion.executeQuery();
			System.out.println(" ");
			while(miresulset.next())
			{
				System.out.println(" " + miresulset.getString(1) +" "+ miresulset.getString("sección") +" "+ miresulset.getString("paísdeorigen"));		    	  
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
