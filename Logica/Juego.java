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
import Puntajes.GestorDePuntajes;
import Puntajes.Jugador;

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
	GestorDePuntajes puntajes;
	
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
		añadirListener();
		miReloj.start();
		miRelojEnemigo.start();
		miCronometro.start();
		puntaje = 0;
		musica=new Musica();
		correrMusica();
		cantidadVidas = 30;
		puntajes = new GestorDePuntajes();
	}
	
	public int getSegundoActual() {
		return miCronometro.getSegundosTranscurridos();
	}
	
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

	public synchronized void moverPersonajePrincipal() {
		miGrilla.moverPersonajePrincipal();
	}
	public synchronized void moverEnemigo() {
		miGrilla.moverEnemigo();
	}
	
	private void añadirListener(){
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
	
	public void sumarPacDot(int pd) {
		cantPacDot+= pd;
	}
	
	public void sumarPuntos(int puntos) {
		puntaje = puntaje + puntos;
	}
	
	public int vidasRestantes() {
		return cantidadVidas;
	}
	
	public void restarPacDot() {
		cantPacDot--;
		if (cantPacDot == 0) {
			resetearContenedor();
		}
	}
	
	public int cantPacDotRestantes() {
		return cantPacDot;
	}
	
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

	public void temporizador(double tiempo) {
		miReloj.iniciarTemporizador(tiempo);
	}

	public void resetearVelocidadPP() {
		miGrilla.resetearVelocidadPersonajePrincipal();
	}
	
	public void cambiarEnemigosAPerseguir() {
		miGrilla.cambiarEstadoDeEnemigosPerseguir();
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void restarUnaVida() {
		cantidadVidas--;
		if (cantidadVidas <= 0) {
			miVentana.mostrarMensajeFinDeJuego(getPuntaje(), miCronometro.getSegundosTranscurridos(), 0 );
		}
	}
	
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
	
	public void detenerMusica() {
		musica.detener();
	}

	public void finalizarJuegoExitoso() {
		miVentana.mostrarMensajeFinDeJuego(getPuntaje(), miCronometro.getSegundosTranscurridos(), 1 ); 
	}

	public void detenerJuego() {
		miReloj.detener();
		miRelojEnemigo.detener();
		miCronometro.detener();
	}

	public String[] getPuntajeMaximo() {
		String[] arr = new String[2];
		Jugador jugador = puntajes.jugadorConMayorPuntajeActual();
		arr[0] = jugador.getNombre();
		arr[1] = jugador.getPuntaje()+"";
		return arr;
	}
	
	public void guardarNuevoPuntaje(String nombre) {
		Jugador nuevo = new Jugador(nombre, puntaje, miCronometro.getSegundosTranscurridos());
		puntajes.guardarPuntaje(nuevo);
	}
}
