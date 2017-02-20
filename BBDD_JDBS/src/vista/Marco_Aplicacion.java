package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controlador.ControladorCargarSeccion;
import controlador.Controladorbotonconsulta;
public class Marco_Aplicacion extends JFrame{


	private  JComboBox secciones;
	
	public JComboBox getSecciones() {
		return secciones;
	}

	public void setSecciones(JComboBox secciones) {
		this.secciones = secciones;
	}

	public JComboBox getPaises() {
		return paises;
	}

	public void setPaises(JComboBox paises) {
		this.paises = paises;
	}

	private JComboBox paises;

	private JTextArea resultado;	
	
	public JTextArea getResultado() {
		return resultado;
	}

	public void setResultado(JTextArea resultado) {
		this.resultado = resultado;
	}

	public Marco_Aplicacion() {
		// TODO Auto-generated constructor stub
		setTitle ("Consulta BBDD");

		setBounds(500,300,400,400);

		setLayout(new BorderLayout());

		JPanel menus=new JPanel();

		menus.setLayout(new FlowLayout());

		secciones=new JComboBox();

		secciones.setEditable(false);

		secciones.addItem("Todos");

		paises=new JComboBox();

		paises.setEditable(false);

		paises.addItem("Todos");

		resultado= new JTextArea(4,50);

		resultado.setEditable(false);

		add(resultado);

		menus.add(secciones);

		menus.add(paises);	

		add(menus, BorderLayout.NORTH);

		add(resultado, BorderLayout.CENTER);

		JButton botonConsulta=new JButton("Consulta");	
        botonConsulta.addActionListener(new  Controladorbotonconsulta(this)); 
		add(botonConsulta, BorderLayout.SOUTH);
        addWindowListener(new ControladorCargarSeccion(this));
	}

}
