package clases;

public class Computadora extends Informacion{
	private String tipo;
	private int ram;
	private String sistemaOperativo;
	private int almacenamiento;

	public Computadora(String screemSize, String resolucion, String marca, String modelo, String tipo, int ram,
			String sistemaOperativo, int almacenamiento) {
		super(screemSize, resolucion, marca, modelo);
		this.tipo = tipo;
		this.ram = ram;
		this.sistemaOperativo = sistemaOperativo;
		this.almacenamiento = almacenamiento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public int getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(int almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	@Override
	public String toString() {
		return "Computadora [tipo=" + tipo + ", ram=" + ram + ", sistemaOperativo=" + sistemaOperativo
				+ ", almacenamiento=" + almacenamiento + "]";
	}
		
}
