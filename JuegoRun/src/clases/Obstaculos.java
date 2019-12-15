package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Obstaculos extends Posicion{
	private int ancho;
	private int alto;
	private int velocidad;
	private String indiceImagen;
	private boolean capturado;
	public Obstaculos(int x, int y, int ancho, int alto, String indiceImagen) {
		super(x, y);
		this.ancho = ancho;
		this.alto = alto;
		this.indiceImagen = indiceImagen;
	}
	
	public void pintar(GraphicsContext graficos) {
		if (!capturado)
			graficos.drawImage(Juego.imagenes.get(indiceImagen), this.x, this.y);
		//graficos.fillRect(this.x, this.y, 70, 35);
	}
	
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, 70, 21);
	}

	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	
	public void mover() {
		if (Juego.accion) {
			this.velocidad = 5;
		}else {
			this.velocidad = 2; 
		}
		if (Juego.derecha)
			this.x-=velocidad;
	}
}