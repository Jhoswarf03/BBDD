package modelo;

public class Productos {

	private  String seccion;
	private String  precio;
	private String  porigen;
	private  String articulo;
	
	public Productos() {
		// TODO Auto-generated constructor stub
	}
	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getPorigen() {
		return porigen;
	}

	public void setPorigen(String porigen) {
		this.porigen = porigen;
	}
}
