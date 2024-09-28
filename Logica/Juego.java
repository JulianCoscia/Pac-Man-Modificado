package Logica;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import FabricaTematica.FabricaTematicaMarioBross;
import FabricaTematica.FabricaTematicaNaruto;
import FabricaTematica.FabricaTematicasAbstracta;
import GUI.Contenedor;
import GUI.GUI;
import Musica.Musica;
import Puntajes.*;

public class Juego {

	protected Reloj miReloj;
	protected GUI miVentana;
	protected Grilla miGrilla;
	protected Contenedor miContenedor;
	protected int puntaje;
	protected int cantPacDot;
	protected RelojEnemigo miRelojEnemigo;
	protected Cronometro miCronometro;
	protected Musica musica;
	protected int cantidadVidas;
	protected FabricaTematicasAbstracta miFabrica;
	protected ScoreManager puntajes;
	
	public Juego (GUI ventana, Contenedor contenedorJuego, int fabrica) {
		miVentana= ventana;
		miContenedor= contenedorJuego;
		cantPacDot= 0;
		miGrilla= new Grilla (this, contenedorJuego);
		miFabrica = crearFabrica(fabrica);
		miGrilla.asignarFabrica(miFabrica);
		miReloj= new Reloj (this);
		miRelojEnemigo=new RelojEnemigo(this);
		miCronometro= new Cronometro (this);
		aniadirListener();
		miReloj.start();
		miRelojEnemigo.start();
		miCronometro.start();
		puntaje = 0;
		musica=new Musica();
		correrMusica();
		cantidadVidas = 30;
		puntajes = new ScoreManager();
	}
	
	/**
	 * Retorna la cantidad de segundos transcurridos desde el comienzo del juego.
	 * @return Cantidad de segundos de juego.
	 */
	public int getSegundoActual() {
		return miCronometro.getSegundosTranscurridos();
	}

	/**
	 * Indica al personaje principal que debe moverse.
	 */
	public synchronized void moverPersonajePrincipal() {
		miGrilla.moverPersonajePrincipal();
	}
	
	/**
	 * Indica al enemigo que debe moverse.
	 */
	public synchronized void moverEnemigo() {
		miGrilla.moverEnemigo();
	}
	
	private void aniadirListener(){
		miVentana.addKeyListener(new KeyListener() {		
			public void keyTyped(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					miGrilla.setRotacionPP(0);
					break;
				case KeyEvent.VK_DOWN:
					miGrilla.setRotacionPP(1);
					break;
				case KeyEvent.VK_LEFT:
					miGrilla.setRotacionPP(2);
					break;
				case KeyEvent.VK_UP:
					miGrilla.setRotacionPP(3);
					break;
				}
			}
			public void keyReleased(KeyEvent e) {}
		});
	}
	
	/**
	 * Suma la cantidad pasada por parametro a la cantidad de pacdots del nivel.
	 * @param pd Cantidad de pacdots agregados
	 */
	public void sumarPacDot(int pd) {
		cantPacDot+= pd;
	}
	
	/**
	 * Suma un valor al puntaje acumulado en la sesion de juego.
	 * @param puntos Cantidad a sumar.
	 */
	public void sumarPuntos(int puntos) {
		puntaje = puntaje + puntos;
	}
	
	/**
	 * Devuelve la cantidad de vidas restantes.
	 * @return Numero de vidas restantes.
	 */
	public int vidasRestantes() {
		return cantidadVidas;
	}
	
	/**
	 * Resta un pacdot del nivel y elimina su representacion grafica.
	 * Si la cantidad de pacdots restantes llega a 0, indica el cambio de nivel.
	 */
	public void restarPacDot() {
		cantPacDot--;
		if (cantPacDot == 0) {
			resetearContenedor();
		}
	}
	
	/**
	 * Devuelve la cantidad de pacdots restantes.
	 * @return Numero de pacdots restantes.
	 */
	public int cantPacDotRestantes() {
		return cantPacDot;
	}
	
	/**
	 * Resetea el contenedor del frame para colocar los nuevos elementos al comenzar un nuevo nivel.
	 */
	private void resetearContenedor () {
		if (miGrilla.getNivel().getNumeroNivel() != 3) {
			miRelojEnemigo.setStep(1000);
			miContenedor.resetearContenedor();
			miGrilla.reiniciarZonas();
			miGrilla.cambiarNivel();
			miRelojEnemigo.setStep(20);
			miContenedor.iniciarNuevoContenedor();
		}
		else {
			finalizarJuegoExitoso();
		}
	}

	/**
	 * Inicia el temporizador de tiempo de juego.
	 * @param tiempo no se.
	 */
	public void temporizador(double tiempo) {
		miReloj.iniciarTemporizador(tiempo);
	}

	/**
	 * Devuelve a la velocidad inicial al personaje principal.
	 */
	public void resetearVelocidadPP() {
		miGrilla.resetearVelocidadPersonajePrincipal();
	}
	
	/**
	 * Cambia el estado de los enemigos para perseguir al personaje principal.
	 */
	public void cambiarEnemigosAPerseguir() {
		miGrilla.cambiarEstadoDeEnemigosPerseguir();
	}
	
	/**
	 * Devuelve el puntaje obtenido en la sesion de juego actual.
	 * @return Puntaje obtenido.
	 */
	public int getPuntaje() {
		return puntaje;
	}
	
	/**
	 * Resta una vida al personaje.
	 */
	public void restarUnaVida() {
		cantidadVidas--;
		if (cantidadVidas <= 0) {
			miVentana.mostrarMensajeFinDeJuego(getPuntaje(), miCronometro.getSegundosTranscurridos(), 0 );
		}
	}
	
	/**
	 * Inicia la reproduccion de la musica.
	 */
	public void correrMusica() {
		int nivelNro;
		nivelNro = miGrilla.getNivel().getNumeroNivel();
		
		try{
		 AudioInputStream inputStream = null;

		inputStream = AudioSystem.getAudioInputStream(this.getClass().getResourceAsStream(miFabrica.musicaNivel(nivelNro)));
				
		musica = new Musica();
		musica.abrir(inputStream);
		musica.iniciar();
		musica.repetirInfinitamente();

		}catch(IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Detiene la musica que se este reproduciendo en el momento.
	 */
	public void detenerMusica() {
		musica.detener();
	}

	public void finalizarJuegoExitoso() {
		miVentana.mostrarMensajeFinDeJuego(getPuntaje(), miCronometro.getSegundosTranscurridos(), 1 ); 
	}

	/**
	 * Detiene el funcionamiento del juego.
	 */
	public void detenerJuego() {
		miReloj.detener();
		miRelojEnemigo.detener();
		miCronometro.detener();
		musica.detener();
	}
	
/**
 * Devuelve el maximo puntaje historico y el nombre del jugador que lo obtuvo.
 * @return Nombre del jugador y su puntaje maximo historico.
 */
	public String[] getPuntajeMaximo() {
		String[] arr = new String[2];
		Player jugador = puntajes.getHighestScore();
		arr[0] = jugador.getName();
		arr[1] = jugador.getScore()+"";
		return arr;
	}
	
	/**
	 * Guarda un nuevo puntaje en la tabla historica de puntajes.
	 * @param nombre Nombre del jugador.
	 */
	public void guardarNuevoPuntaje(String nombre) {
		Player nuevo = new Player(nombre, puntaje, miCronometro.getSegundosTranscurridos());
		puntajes.saveScore(nuevo);
	}
	
	/**
	 * Establece el volumen de la musica.
	 * @param val Volumen.
	 */
	public void setVolumen(int val) {
		musica.setVolumen(val);
	}
	
	//______________Metodos privados________________
	
	/**CORREGIR
	 * Crea la fabrica tematica que el usuario seleccion�.
	 * @param Tematica seleccionada: 1: Tematica de Mario Bros. 2: Tematica Naruto.
	 * @return Fabrica de la tematica seleccionada.
	 */
	private FabricaTematicasAbstracta crearFabrica(int fabrica) {
		FabricaTematicasAbstracta salida = null;
		switch(fabrica) {
		case 1:
			salida =  new FabricaTematicaMarioBross(miGrilla, miContenedor);
			break;
		case 2:
			salida =  new FabricaTematicaNaruto(miGrilla, miContenedor);
			break;
		}
	return salida;
	}
}
