package clases;

public class Normal extends Empleado{
	private String profecion;
	private String supervisor;
	private int sueldo;
	private boolean despedir;
	
	public Normal(String nombre, String apellido, int edad, String genero, String profecion, String supervisor, int sueldo, boolean despedir) {
		super(nombre, apellido, edad, genero);
		this.profecion = profecion;
		this.supervisor = supervisor;
		this.sueldo = sueldo;
		this.despedir = despedir;
	}

	public String getProfecion() {
		return profecion;
	}

	public void setProfecion(String profecion) {
		this.profecion = profecion;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public boolean isDespedir() {
		return despedir;
	}

	public void setDespedir(boolean despedir) {
		this.despedir = despedir;
	}
	
	
	
}
