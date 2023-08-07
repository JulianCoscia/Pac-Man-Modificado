package Entidades;

import Grafica.EntidadDinamicaGrafica;
import Logica.Grilla;
import Logica.Zonas;
import State.EstadoHuir;
import State.EstadoPerseguir;
import Visitor.Visitor;
import Visitor.VisitorEnemigos;

public class EnemigoInky extends Enemigo {
	
	protected EnemigoBlinky blinky;
	
	public EnemigoInky(int posX,int posY,EntidadDinamicaGrafica miRepresentacion, Grilla grilla, EnemigoBlinky blinky) {
		ancho = 32;
		alto = 32;
		this.posX = posX;
		this.posY = posY;
		this.miRepresentacion = miRepresentacion;
		miRepresentacion.crearLabel(this.posX, this.posY, ancho, alto);
		miGrilla = grilla;
		velocidad = 3;
		rotacion= ABAJO;
		segundosDescanso= 0;
		this.blinky= blinky;
		estado = new EstadoPerseguir(grilla, this);
		posicionCasaX = posX;
		posicionCasaY = posY;
		miVisitor = new VisitorEnemigos();
		zonasPertenecientes = new Zonas[4];
		asignarZonas();
	}
	
	public void mover () {
		this.patronMover();
	}
	
	private void asignarZonas() {
		for (int i = 0; i < 4; i++) {
			int [] arr = this.getEsquina(i);
			zonasPertenecientes[i] = miGrilla.getZonas(arr[0]/160, arr[1]/160);
		}
	}
	
	public void cambiarAHuir() {
		estado = new EstadoHuir(miGrilla, this, 32, 32*18);
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
		
	public void setSentidoDeseado(int sentidoDeseado) {
		this.sentidoDeseado = sentidoDeseado;
	}
	
	public void accept (Visitor v) {
		v.visit(this);
	}

	
	@Override
	public void objetivoDeseadoPerseguir() {
		int [] posPP= obtenerPosicionPP();
		int posPPX= posPP[0];
		int posPPY= posPP[1];
		int posBlinkyX= blinky.getPosX();
		int posBlinkyY= blinky.getPosY();
		int posXAux= posBlinkyX - posPPX;
		int posYAux= posBlinkyY - posPPY;
		posXAux= (posXAux * -1) + posPPX;
		posYAux= (posYAux * -1) + posPPY;
		this.setPosicionObjetivoX(posXAux);
		this.setPosicionObjetivoY(posYAux);
	}

}
