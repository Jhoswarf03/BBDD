package conectandoBD;
import java.sql.*;

import javax.swing.JOptionPane;
public class TransaccionesInsertaclientepedido {
	

	public TransaccionesInsertaclientepedido() {
		// TODO Auto-generated constructor stub
	
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		 Connection miConexion=null;
		
		try{					
            
		    miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");				
			miConexion.setAutoCommit(false);/// Para que tomo la sentenci sql  como un bloque  y  no por separado
			Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";			    
		    miStatement.executeUpdate(instruccionSql_1);			    
		    String instruccionSql_2="INSERT INTO PEDIDOS (NÚMERO_DE_PEDIDO, CÓDIGOCLIENTE,FECHA_DE_PEDIDO) VALUES('82', 'CT84', '11/03/2000')";		    
		    miStatement.executeUpdate(instruccionSql_2);	    
		    miConexion.commit();////CONFIRMA  QUE TODO  ALS SENTINCIA SE REALIZARON CORRECTAMENTE
		    System.out.println("Datos INSERTADOS correctamente");			
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




		
		
