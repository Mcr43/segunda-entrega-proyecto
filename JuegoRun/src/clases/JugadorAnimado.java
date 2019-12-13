package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.animation.PathTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class JugadorAnimado {
	private int x;
	private int y;
	private String indiceImagen;
	private int velocidad;
	private HashMap<String, Animacion> animaciones;
	private String animacionActual;
	private int puntuacion = 0;
	private int vidas = 3;

	//Coordenadas para el fragmento de la imagen a pintar
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;

	public JugadorAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super();
		this.x = x;
		this.y = y;
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
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
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
		/*if (this.x>=1100)
			this.x = -100;
		if (Juego.derecha)
			this.x+=velocidad;

		if (Juego.izquierda)
			this.x-=velocidad;*/

		//System.out.println("y = " + this.y);
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
		//graficos.fillRect(this.x, this.y, this.anchoImagen, this.altoImagen);
		graficos.fillText("Puntuacion " + puntuacion, 0, 10);
		graficos.fillText("vidas " + vidas, 0, 20);
	}

	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}

	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();
			Rectangle coordenadasCorrer[]= {
					new Rectangle(0,0, 70,73),
					new Rectangle(70,0, 51,73),
					new Rectangle(121,0, 58,73),
					new Rectangle(179,0, 67,73),
					new Rectangle(246,0, 60,73),
					new Rectangle(306,0, 65,73)
			};


			Animacion animacionCorrer = new Animacion("correr",coordenadasCorrer,0.1);
			animaciones.put("correr",animacionCorrer);

			Rectangle coordenadasDescanso[] = {
					new Rectangle(26, 16, 63,73),
					new Rectangle(89,16, 63,73),
					new Rectangle(154,16, 63,73),
					new Rectangle(226,16, 63,73)
			};
			Animacion animacionDescanso = new Animacion("descanso",coordenadasDescanso,0.2);
			animaciones.put("descanso",animacionDescanso);
	}

	public void verificarColisiones(Obstaculos obstaculos) {
		if (this.obtenerRectangulo().intersects(obstaculos.obtenerRectangulo().getBoundsInLocal())) {
				if (!obstaculos.isCapturado())
					this.vidas-=1;
				obstaculos.setCapturado(true);
				if(vidas==0)
					Juego.main(null);
		}
	}
	
	public void verificarColisiones(Item items) {
		if (this.obtenerRectangulo().intersects(items.obtenerRectangulo().getBoundsInLocal())) {
				if (!items.isCapturado())
					this.puntuacion+=5;
				items.setCapturado(true);
		}
	}

	public void puntuacion(){
			
	}
}