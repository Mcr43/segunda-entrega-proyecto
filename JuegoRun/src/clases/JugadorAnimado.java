package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends Posicion{
	private String indiceImagen;
	private int velocidad;
	private HashMap<String, Animacion> animaciones;
	private String animacionActual;
	private int puntuacion = 0;
	private int puntMax = 0;
	private int vidas = 3;

	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;

	public JugadorAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super(x, y);
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.animacionActual = animacionActual;
		inicializarAnimaciones();
	}

	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}

	public void mover(){
		if(this.y>0 && this.y<467) {
			if (Juego.arriba)
				this.y-=velocidad;
			
			if (Juego.abajo)
				this.y+=velocidad;
		}
		if(this.y<=0)
			this.y++;
		
		if(this.y>=467)
			this.y--;

	}

	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen),
				this.xImagen, this.yImagen,
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
		graficos.fillText("Puntuacion " + puntuacion, 0, 10);
		graficos.fillText("Maximo: " + puntMax, 90, 10);
		graficos.fillText("vidas " + vidas, 0, 22);
	}

	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}

	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();
			Rectangle coordenadasCorrer[]= {
					new Rectangle(0,0,70,63),
					new Rectangle(70,0,51,63),
					new Rectangle(121,0,58,63),
					new Rectangle(179,0,67,63),
					new Rectangle(246,0,60,63),
					new Rectangle(306,0,65,63)
			};


			Animacion animacionCorrer = new Animacion("correr",coordenadasCorrer,0.1);
			animaciones.put("correr",animacionCorrer);
	}
	
	public void verificarColisiones(Obstaculos obstaculos) {
		if (this.obtenerRectangulo().intersects(obstaculos.obtenerRectangulo().getBoundsInLocal())) {
				if (!obstaculos.isCapturado())
					this.vidas-=1;
				obstaculos.setCapturado(true);
		}
	}
	
	public void verificarColisiones(Item items) {
		if (this.obtenerRectangulo().intersects(items.obtenerRectangulo().getBoundsInLocal())) {
				if (!items.isCapturado())
					this.puntuacion+=5;
				items.setCapturado(true);
		}
	}
	
	public void puntuacion() {
		if(this.puntuacion > this.puntMax)
			this.puntMax = this.puntuacion;
	}
}