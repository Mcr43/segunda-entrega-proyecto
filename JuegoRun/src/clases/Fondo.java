package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Fondo {
	private double x;
	private double y;
	private double velocidad;
	private String indiceImagen;
	public Fondo(int x, int y, int velocidad, String indiceImagen) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.indiceImagen = indiceImagen;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(indiceImagen), x, y);
		//graficos.drawImage(Juego.imagenes.get(indiceImagen), x, y);
	}
	
	public void mover() {
		if (Juego.accion) {
			this.velocidad = 2;
		}else {
			this.velocidad = 0.5; 
		}
		if (Juego.derecha)
			x-=velocidad;
		
		if (Juego.izquierda)
			x+=velocidad;
	}
}