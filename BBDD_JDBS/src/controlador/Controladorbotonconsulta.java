package controlador;
import modelo.*;
import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controladorbotonconsulta implements ActionListener{

	private Marco_Aplicacion marco;
	private Ejecutaconsulta consulta = new  Ejecutaconsulta();
	public Controladorbotonconsulta(Marco_Aplicacion ma) {
		// TODO Auto-generated constructor stub
	      this.marco = ma;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String seccion = (String)marco.getSecciones().getSelectedItem();
		String pais = (String)marco.getPaises().getSelectedItem();
		marco.getResultado().setText("");
		marco.getResultado().append(consulta.FiltrarBBDD(seccion, pais));
		marco.getResultado().append("\n");
		
	}

}
