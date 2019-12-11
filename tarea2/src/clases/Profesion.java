package clases;

public class Profesion {
	private String codogo;
	private String titulo;
	
	public String getCodogo() {
		return codogo;
	}
	public void setCodogo(String codogo) {
		this.codogo = codogo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public String toString() {
		return "Profesion [codogo=" + codogo + ", titulo=" + titulo + "]";
	}

}
