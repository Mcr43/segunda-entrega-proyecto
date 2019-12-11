package clases;

import java.util.ArrayList;

public class Telefono extends Informacion {
	private String numero;
	private String compa��a;
	private int camaraMegaPixeles;
	private String procasadorMarca;
	private int ram;
	private String sistemaOperativo;
	private int almacenamiento;
	private ArrayList<String> otros;

	public Telefono(String screemSize, String resolucion, String marca, String modelo, String numero, String compa��a,
			int camaraMegaPixeles, String procasadorMarca, int ram, String sistemaOperativo, int almacenamiento,
			ArrayList<String> otros) {
		super(screemSize, resolucion, marca, modelo);
		this.numero = numero;
		this.compa��a = compa��a;
		this.camaraMegaPixeles = camaraMegaPixeles;
		this.procasadorMarca = procasadorMarca;
		this.ram = ram;
		this.sistemaOperativo = sistemaOperativo;
		this.almacenamiento = almacenamiento;
		this.otros = otros;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCompa��a() {
		return compa��a;
	}

	public void setCompa��a(String compa��a) {
		this.compa��a = compa��a;
	}

	public int getCamaraMegaPixeles() {
		return camaraMegaPixeles;
	}

	public void setCamaraMegaPixeles(int camaraMegaPixeles) {
		this.camaraMegaPixeles = camaraMegaPixeles;
	}

	public String getProcasadorMarca() {
		return procasadorMarca;
	}

	public void setProcasadorMarca(String procasadorMarca) {
		this.procasadorMarca = procasadorMarca;
	}
	
	public ArrayList<String> getOtros() {
		return otros;
	}

	public void setOtros(ArrayList<String> otros) {
		this.otros = otros;
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
		return "Telefono [numero=" + numero + ", compa��a=" + compa��a + ", camaraMegaPixeles=" + camaraMegaPixeles
				+ ", procasadorMarca=" + procasadorMarca + ", ram=" + ram + ", sistemaOperativo=" + sistemaOperativo
				+ ", almacenamiento=" + almacenamiento + ", otros=" + otros + "]";
	}
	
	
	
}
