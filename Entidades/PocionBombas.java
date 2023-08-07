package Entidades;

import Grafica.EntidadEstaticaGrafica;
import Logica.Grilla;
import Visitor.Visitor;

public class PocionBombas extends Pocion{
	
	public PocionBombas(int posX,int posY,EntidadEstaticaGrafica miRepresentacion, Grilla grilla) {
		this.posX= posX;
		this.posY= posY;
		alto = 28;
		ancho = 28;
		this.miRepresentacion = miRepresentacion;
		miRepresentacion.crearLabel(this.posX, this.posY, ancho, alto);
		miGrilla = grilla;
	}
	
	public void accept (Visitor v) {
		v.visit(this);
	}

	public void activarEfecto() {
		activarBombas();
	}
	
	public void desaparecer() {
		miRepresentacion.eliminarImagen();
		miGrilla.removerEntidad(this);
	}
	
	private void activarBombas() {
		miGrilla.activarBombas();
	}
}
