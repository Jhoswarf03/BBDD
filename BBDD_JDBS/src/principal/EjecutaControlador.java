package principal;

import javax.swing.JFrame;

import vista.Marco_Aplicacion;

public class EjecutaControlador {

	public EjecutaControlador() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Marco_Aplicacion mimarco = new  Marco_Aplicacion();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
	}

}
