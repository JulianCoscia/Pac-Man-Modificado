package Entidades;

import Grafica.EntidadDinamicaGrafica;
import Logica.Grilla;
import Logica.Zonas;
import State.EstadoHuir;
import State.EstadoPerseguir;
import Visitor.Visitor;
import Visitor.VisitorEnemigos;

public class EnemigoClyde extends Enemigo {
	

	
	public EnemigoClyde(int posX,int posY,EntidadDinamicaGrafica miRepresentacion, Grilla grilla) {
		ancho = 32;
		alto = 32;
		this.posX = posX;
		this.posY = posY;
		this.miRepresentacion = miRepresentacion;
		miRepresentacion.crearLabel(this.posX, this.posY, ancho, alto);
		miGrilla = grilla;
		velocidad = 3;
		rotacion= ABAJO;
		segundosDescanso= 3;
		estado = new EstadoPerseguir(grilla, this);
		posicionCasaX = posX;
		posicionCasaY = posY;
		miVisitor = new VisitorEnemigos();
		zonasPertenecientes = new Zonas[4];
		asignarZonas();
	}
	
	public void mover () {
		if (miGrilla.getSegundoActual() >= segundosDescanso)
			this.patronMover();
	}
	
	private void asignarZonas() {
		for (int i = 0; i < 4; i++) {
			int [] arr = this.getEsquina(i);
			zonasPertenecientes[i] = miGrilla.getZonas(arr[0]/160, arr[1]/160);
		}
	}
	
	public void cambiarAHuir() {
		estado = new EstadoHuir(miGrilla, this, 32*18, 32);
		miRepresentacion.cambiarDeEstado(1);
	}
	
	public void cambiarAPerseguir() {
		estado = new EstadoPerseguir(miGrilla, this);
		miRepresentacion.cambiarDeEstado(0);
	}
	
	public void irACasa() {
		posX = posicionCasaX;
		posY = posicionCasaY;
		cambiarAPerseguir();
	}
	
	public void fuiComido() {
		irACasa();
		miGrilla.sumarPuntos(200);
	}
	
	public void comiAPacMan() {
		miGrilla.pacManFueComido();
	}

	public void accept (Visitor v) {
		v.visit(this);
	}

	public void setSentidoDeseado(int sentidoDeseado) {
		this.sentidoDeseado = sentidoDeseado;
	}

	@Override
	public void objetivoDeseadoPerseguir() {
		int [] posPP= obtenerPosicionPP();
		int posPPX= posPP[0];
		int posPPY= posPP[1];
		int posXAux= posPPX - 128;
		int posYAux= posPPY - 128;
		this.setPosicionObjetivoX(posXAux);
		this.setPosicionObjetivoY(posYAux);
	}

}
