package conectandoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
////// TRASNSACCION PRA EJECUTAR SENTENCIA  SQL  DE  UPDATE Y  DELETE
public class Transaccionesproductos {

	public Transaccionesproductos() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
			Connection miConexion=null;
		
		try{					
		    miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");				
			miConexion.setAutoCommit(false);/// Para que tomo la sentenci sql  como un bloque  y  no por separado
			Statement miStatement =miConexion.createStatement();
		   
		    if(JOptionPane.showConfirmDialog(null, "¿Ejecutamos la transacción?", "Pregunta", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
		    {
		    String instruccionSql_1="delete from productos where paíSdeorigen ='ESPAÑA'";  			       
			String instruccionSql_2="delete from productos where precio > 300";		        	    
		    String instruccionSql_3="update productos set precio= precio*1.15";		    
		    miStatement.executeUpdate(instruccionSql_1);
		    miStatement.executeUpdate(instruccionSql_2);
		    miStatement.executeUpdate(instruccionSql_3);
		    miConexion.commit();////CONFIRMA  QUE TODO  ALS SENTINCIA SE REALIZARON CORRECTAMENTE
		    System.out.println("Datos INSERTADOS correctamente");			
		    }
		    else
		    {System.out.println("NO SE REALIO CAMBIO EN LA BBDD");} 
		    	
		    }catch(Exception e){
			try {
				miConexion.rollback();// SI HAY  UN ERROR  DEJA TODO  COMO ESTABA Y  NO REALIZA  NINGUNA ACCION
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
			e.printStackTrace();		
			}
		
	}

}
