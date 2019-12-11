package clases;

public class Supervisor extends Empleado{
	private int cantidadSubordinados;
	private String departamento;
	
	public Supervisor(String nombre, String apellido, int edad, String genero, int cantidadSubordinados, String departamento) {
		super(nombre, apellido, edad, genero);
		this.cantidadSubordinados = cantidadSubordinados;
		this.departamento = departamento;
	}

	public int getCantidadSubordinados() {
		return cantidadSubordinados;
	}

	public void setCantidadSubordinados(int cantidadSubordinados) {
		this.cantidadSubordinados = cantidadSubordinados;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	

	
}
