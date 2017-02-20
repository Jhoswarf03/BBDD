package controlador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Statement;
import modelo.Cargarseccion;
import modelo.Productos;
import vista.Marco_Aplicacion;
public class ControladorCargarSeccion extends WindowAdapter
{
	private Cargarseccion obj= new  Cargarseccion();
	private Marco_Aplicacion ventana;

	public ControladorCargarSeccion(Marco_Aplicacion marco2) {
		// TODO Auto-generated constructor stub
		this.ventana=marco2;
	}
	public  void windowOpened(WindowEvent e){
		obj.Ejecutasql("SECCIÓN");
		try {
			while(obj.rs.next())
			{
				ventana.getSecciones().addItem(obj.rs.getString(1));
			} 	      
		obj.Ejecutasql("PAÍSDEORIGEN");
			while(obj.rs.next())
			{
				ventana.getPaises().addItem(obj.rs.getString(1));
			} 
			obj.rs.close();
		} catch (Exception f) {
			// TODO: handle exception
		}
	}
}
