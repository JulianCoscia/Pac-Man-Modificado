package Entidades;

import Grafica.EntidadEstaticaGrafica;
import Logica.Grilla;
import Visitor.Visitor;

public class PacDots extends EntidadEstatica{
	
	protected boolean consumido;
	
	public PacDots(int posX,int posY,EntidadEstaticaGrafica miRepresentacion, Grilla grilla) {
		alto = 18;
		ancho = 18;
		this.posX= posX;
		this.posY= posY;
		this.miRepresentacion = miRepresentacion;
		miRepresentacion.crearLabel(this.posX, this.posY, ancho, alto);
		miGrilla = grilla;
	}
	
	public void desaparecer() {
		miGrilla.removerEntidad(this);
		miRepresentacion.eliminarImagen();
		miGrilla.restarPacDot();
	}
	
	public void sumarPuntos(int puntaje) {
		miGrilla.sumarPuntos(puntaje);
	}
	
	public void accept (Visitor v) {
		v.visit(this);
	}
}
