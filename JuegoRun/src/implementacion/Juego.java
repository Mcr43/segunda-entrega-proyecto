package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import clases.Fondo;
import clases.Item;
import clases.JugadorAnimado;
import clases.Obstaculos;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Juego extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private JugadorAnimado jugadorAnimado;
	public static boolean derecha=true;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static boolean accion=false;
	public static HashMap<String, Image> imagenes;
	private Fondo fondo;
	private Fondo fondo1;
	
	private ArrayList<Item> items;
	private ArrayList<Obstaculos> obstaculos;

	private ArrayList<Tile> tiles;

	private int[][] mapa = {
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1},
			{1,2,4,4,4,3,1,1}
	};

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("Madara Runner");
		gestionarEventos();
		ventana.show();
		cicloJuego();
	}

	public void inicializarComponentes() {
		jugadorAnimado = new JugadorAnimado(20,287,"madara",5, "correr");
		fondo = new Fondo(0,0,2,"fondo");
		fondo1 = new Fondo(0,0,2,"fondo1");
		root = new Group();
		escena = new Scene(root,800,500);
		canvas  = new Canvas(800,500);
		imagenes = new HashMap<String,Image>();
		items = new ArrayList<Item>();
		obstaculos = new ArrayList<Obstaculos>();
		cargarImagenes();
		cargarTiles();
		cargarItems();
	}

	public void cargarImagenes() {
		imagenes.put("fondo", new Image("fondo.png"));
		imagenes.put("fondo1", new Image("fondo.png"));
		imagenes.put("tilemap", new Image("tilesmapa.png"));
		imagenes.put("madara", new Image("madara.png"));
		imagenes.put("item", new Image("item.png"));
		imagenes.put("kunai", new Image("kunai.png"));
	}
	
	public void cargarItems() {
		for(int i=0;i<mapa.length;i++) {
			int rand = (int)(Math.random()*7)+1;
			obstaculos.add(new Obstaculos((i+1)*200, rand*70, 0, 0, "kunai"));
			int rand1 = (int)(Math.random()*7)+1;
			items.add(new Item((i+1)*150, rand1*70, 0, 0, "item"));
		}
	}

	public void pintar() {
		graficos.setFill(Color.WHITE);
		graficos.fillRect(0, 0, 800, 500);
		graficos.setFill(Color.BLACK);
		fondo1.pintar(graficos);
		fondo.pintar(graficos);
		for (int i=0;i<tiles.size();i++)
			tiles.get(i).pintar(graficos);
		for(int j=0;j<mapa.length;j++) {
			items.get(j).pintar(graficos);
			obstaculos.get(j).pintar(graficos);
		}
		jugadorAnimado.pintar(graficos);
	}

	public void cargarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j], i*70, j*70, "tilemap",3));
			}
		}
	}

	public void gestionarEventos() {

		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
				switch (evento.getCode().toString()) {
					case "UP":
						arriba=true;
						break;
					case "DOWN":
						abajo=true;
						break;
					case "SPACE":
						Juego.accion = true;
						break;
					case "ESCAPE":
						System.exit(0);
						break;
				}
			}
		});

		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				switch (evento.getCode().toString()) {
					case "UP":
						arriba=false;
						break;
					case "DOWN":
						abajo=false;
						break;
					case "SPACE":
						Juego.accion = false;
						break;
				}

			}

		});

	}

	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {

			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				pintar();
				actualizar(t);

			}

		};
		animationTimer.start();
	}

	public void actualizar(double t) {
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
		for(int i=0;i<mapa.length;i++) {
			jugadorAnimado.verificarColisiones(items.get(i));
			items.get(i).mover();
			jugadorAnimado.verificarColisiones(obstaculos.get(i));
			obstaculos.get(i).mover();
		}
		jugadorAnimado.puntuacion();
		fondo1.mover();
		fondo.mover();
		cambiarFondo();
	}

	public void cambiarFondo() {
		if (fondo1.getX() <= 0) {
			fondo.setX((int)imagenes.get("fondo1").getWidth()+fondo1.getX());
		}

		if (fondo.getX() <= 0) {
			fondo1.setX((int)imagenes.get("fondo").getWidth()+fondo.getX());
		}
	}
}
