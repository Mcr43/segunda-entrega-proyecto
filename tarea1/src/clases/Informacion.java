package clases;

public class Informacion {
	private String screemSize;
	private String resolucion;
	private String marca;
	private String modelo;
	
	public Informacion(String screemSize, String resolucion, String marca, String modelo) {
		super();
		this.screemSize = screemSize;
		this.resolucion = resolucion;
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getScreemSize() {
		return screemSize;
	}

	public void setScreemSize(String screemSize) {
		this.screemSize = screemSize;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Informacion [screemSize=" + screemSize + ", resolucion=" + resolucion + ", marca=" + marca + ", modelo="
				+ modelo + "]";
	}
	
}
