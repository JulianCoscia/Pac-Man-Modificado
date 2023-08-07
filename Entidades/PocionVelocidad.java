package Entidades;

import Grafica.EntidadEstaticaGrafica;
import Logica.Grilla;
import Visitor.Visitor;

public class PocionVelocidad extends Pocion{
	
	public PocionVelocidad(int posX,int posY,EntidadEstaticaGrafica miRepresentacion, Grilla grilla) {
		alto = 28;
		ancho = 28;
		this.posX= posX;
		this.posY= posY;
		this.miRepresentacion = miRepresentacion;
		miRepresentacion.crearLabel(this.posX, this.posY, ancho, alto);
		miGrilla = grilla;
	}
	
	public void accept (Visitor v) {
		v.visit(this);
	}

	public void activarEfecto() {
		miGrilla.activarVelocidadPP(5, 5);
	}

	public void desaparecer() {
		miGrilla.removerEntidad(this);
		miRepresentacion.eliminarImagen();
	}
	


}
