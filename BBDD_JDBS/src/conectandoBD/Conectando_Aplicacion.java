package conectandoBD;


import javax.swing.*;

import org.ietf.jgss.MessageProp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Conectando_Aplicacion {

	public Conectando_Aplicacion() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame mimarco=new Marco_Aplicacion();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{

	public Marco_Aplicacion(){

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

		botonConsulta.addActionListener(new  ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//if(secciones.getSelectedItem().equals("Todos"))
				//	System.out.println(secciones.getSelectedItem());
				if((paises.getSelectedItem().equals("Todos")) && secciones.getSelectedItem().equals("Todos"))
					JOptionPane.showMessageDialog(null,"Seleccione una Opcion"); 	
				else if(!(paises.getSelectedItem().equals("Todos"))|| !(secciones.getSelectedItem().equals("Todos")))
				{		
				try{ 
					if(!secciones.getSelectedItem().equals("Todos") && paises.getSelectedItem().equals("Todos"))
					{ 
						miestamento = miconexion.prepareStatement(consulta);
						miestamento.setString(1,(String)(secciones.getSelectedItem()));
						System.out.println("1");   
					}else if(!paises.getSelectedItem().equals("Todos") && secciones.getSelectedItem().equals("Todos"))
					{ 
						miestamento = miconexion.prepareStatement(consulta2);
						miestamento.setString(1,(String)(paises.getSelectedItem()));
						System.out.println("2"); 
					}
					else if(!paises.getSelectedItem().equals("Todos") && !secciones.getSelectedItem().equals("Todos"))
					{ 
						miestamento = miconexion.prepareStatement(consulta3);
						miestamento.setString(1,(String)(paises.getSelectedItem()));
						miestamento.setString(2,(String)(secciones.getSelectedItem()));
						System.out.println("3"); 
					}
					 
					ResultSet rsconsulta = miestamento.executeQuery();
					resultado.setText("");
					while(rsconsulta.next())
					{
						resultado.append(rsconsulta.getString(1)+ " " + rsconsulta.getString(2) + " " + rsconsulta.getString(3)+ "  " + rsconsulta.getString(4) + "\n");
						System.out.println(rsconsulta.getString(1)+ " " + rsconsulta.getString(2) + " " + rsconsulta.getString(3)+ " " + rsconsulta.getString(4));
					}
					rsconsulta.close();
				}
				catch (Exception f) {
					// TODO: handle exception
					System.out.println("No conecta");
					f.printStackTrace();
				}
				}
			}
		});

		add(botonConsulta, BorderLayout.SOUTH);

		// Crear  Base de dato
		try{
			// 1 CREAR CONEXION
			miconexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			//2 CREAR  OBJETO  ESTEIMENT
			Statement miestament = miconexion.createStatement();

			/////// CARGAR  COMBO SECCION ///////
			String  consulta="SELECT SECCIÓN FROM PRODUCTOS GROUP BY SECCIÓN"; 
			ResultSet rs = miestament.executeQuery(consulta);
			while(rs.next())
				secciones.addItem(rs.getString(1)); 	

			rs.close();
			/////// CARGAR  COMBO PAIS ///////
			consulta="SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS"; 
			rs = miestament.executeQuery(consulta);
			while(rs.next())
				paises.addItem(rs.getString(1)); 	
			rs.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("No conecta");
			e.printStackTrace();
		}



	}	


	private Connection miconexion;
	private JComboBox secciones;

	private JComboBox paises;

	private JTextArea resultado;	

	private PreparedStatement miestamento; 

	final String consulta = "select  NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN, PRECIO from PRODUCTOS WHERE SECCIÓN=?  ";
	final String consulta2 = "select  NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN, PRECIO from PRODUCTOS WHERE PAÍSDEORIGEN=?  ";
	final String consulta3 = "select  NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN, PRECIO from PRODUCTOS WHERE PAÍSDEORIGEN=? AND SECCIÓN=?  ";
}



