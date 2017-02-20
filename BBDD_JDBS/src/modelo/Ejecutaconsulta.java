package modelo;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ejecutaconsulta {
    private Connection miconexcio;
    private  ResultSet rs=null;
    private PreparedStatement st;
    private final String consulta = "select  NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN, PRECIO from PRODUCTOS WHERE SECCIÓN=?  ";
	private final String consulta2 = "select  NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN, PRECIO from PRODUCTOS WHERE PAÍSDEORIGEN=?  ";
	private final String consulta3 = "select  NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN, PRECIO from PRODUCTOS WHERE PAÍSDEORIGEN=? AND SECCIÓN=?  ";
	private String resultado ="";
	public Ejecutaconsulta() {
		// TODO Auto-generated constructor stub
	    miconexcio = new  Conexciones().miconexcion();
	}
	public String FiltrarBBDD(String  sec, String  pais){
		resultado ="";
		if(sec.equals("Todos") && pais.equals("Todos"))
		{ 
			JOptionPane.showMessageDialog(null, "Seleciones una Seccion o un Pais");
		    return resultado = "";
		}	  
		else
		{		
			try{ 
				if(!sec.equals("Todos") && pais.equals("Todos"))
				{ 
					st = miconexcio.prepareStatement(consulta);
					st.setString(1,sec);  
				}else if(!pais.equals("Todos") && sec.equals("Todos"))
				{ 
					st = miconexcio.prepareStatement(consulta2);
					st.setString(1,pais);
				}
				else if(!pais.equals("Todos") && !sec.equals("Todos"))
				{ 
					st = miconexcio.prepareStatement(consulta3);
					st.setString(1,pais);
					st.setString(2,sec);
				}
				rs  = st.executeQuery();
				while(rs.next())
				{
					resultado += (rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3)+ "  " + rs.getString(4) + "\n");
					//System.out.println(rsconsulta.getString(1)+ " " + rsconsulta.getString(2) + " " + rsconsulta.getString(3)+ " " + rsconsulta.getString(4));
				}
				rs.close();
				//miconexcio.close();
			}
			catch (Exception f) {
				// TODO: handle exception
				System.out.println("No conecta");
				f.printStackTrace();
			}
           
		}
		return resultado ;
	}

}
