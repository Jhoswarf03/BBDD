package modelo;
import java.sql.*;
public class Cargarseccion {
    
	Conexciones miconexcion;
	public  ResultSet rs;
	public Cargarseccion() {
		// TODO Auto-generated constructor stub
	   miconexcion = new Conexciones();
	}
    
	public ResultSet Ejecutasql(String combo){
		
		Connection accesoBBDD = miconexcion.miconexcion();
    	try {
    		Statement miestament = accesoBBDD.createStatement();
			String  consulta= "SELECT " + combo +"   FROM PRODUCTOS GROUP BY " + combo ; 
			//String  consulta1="SELECT SECCIÓN FROM PRODUCTOS GROUP BY SECCIÓN";
			rs = miestament.executeQuery(consulta);  
			return  rs;
			
		} catch (Exception e) {
			// TODO: handle exception	
			System.out.println("No conecta1");
			e.printStackTrace();
		}
    	
    	return null;
    }

	public Conexciones getMiconexcion() {
		return miconexcion;
	}

	public void setMiconexcion(Conexciones miconexcion) {
		this.miconexcion = miconexcion;
	}
}
