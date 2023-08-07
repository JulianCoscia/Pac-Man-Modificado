package Entidades;

import Grafica.EntidadEstaticaGrafica;
import Logica.Grilla;
import Visitor.Visitor;

public class Fruta extends EntidadEstatica{
	
	protected boolean consumido;
	
	public Fruta(int posX,int posY,EntidadEstaticaGrafica miRepresentacion, Grilla grilla) {
		this.posX= posX;
		this.posY= posY;
		alto = 28;
		ancho = 28;
		this.miRepresentacion = miRepresentacion;
		miRepresentacion.crearLabel(this.posX, this.posY, ancho, alto);
		miGrilla = grilla;
	}

	
	public boolean fuiConsumido() {
		return consumido;
	}
	
	public void consumir() {
		miRepresentacion.eliminarImagen();
		miGrilla.sumarPuntos(100);
		miGrilla.removerEntidad(this);
	}
	
	public void accept (Visitor v) {
		v.visit(this);
	}
}
