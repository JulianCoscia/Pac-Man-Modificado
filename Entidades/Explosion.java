package Entidades;

import Grafica.EntidadEstaticaGrafica;
import Logica.Grilla;
import State.EstadoApagado;
import State.EstadoEncendidas;
import State.StateBombas;
import Visitor.Visitor;

public class Explosion extends EntidadEstatica{
	protected StateBombas estado;
	protected Grilla miGrilla;

	public Explosion(int posX,int posY,EntidadEstaticaGrafica miRepresentacion, Grilla grilla) {
		this.posX = posX;
		this.posY = posY;
		alto = 32;
		ancho = 32;
		this.miRepresentacion = miRepresentacion;
		miRepresentacion.crearLabel(this.posX, this.posY, ancho, alto);
		estado = new EstadoApagado(this, miGrilla);
		miGrilla = grilla;
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public StateBombas getState() {
		return estado;
	}
	
	public void Explotar() {
		estado = new EstadoEncendidas(this, miGrilla);
		miRepresentacion.cambiarImagen();
	}
	
	public void eliminarImagen() {
		miRepresentacion.eliminarImagen();
	}

}
