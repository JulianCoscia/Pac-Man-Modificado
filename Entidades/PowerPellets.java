package Entidades;

import Grafica.EntidadEstaticaGrafica;
import Logica.Grilla;
import Visitor.Visitor;

public class PowerPellets extends EntidadEstatica{
	protected boolean consumido;
	
	public PowerPellets(int posX,int posY,EntidadEstaticaGrafica miRepresentacion,Grilla grilla) {
		alto = 28;
		ancho = 28;
		this.posX= posX;
		this.posY= posY;
		this.miRepresentacion = miRepresentacion;
		miRepresentacion.crearLabel(this.posX, this.posY, ancho, alto);
		miGrilla = grilla;
	}
	
	public boolean fuiConsumido() {
		return consumido;
	}
	public void desaparecer() {
		miGrilla.removerEntidad(this);
		miRepresentacion.eliminarImagen();
	}
	public void sumarPuntos(int puntos) {
		miGrilla.sumarPuntos(puntos);
	}
	public void AfectarEntidades() {
		miGrilla.activarVelocidadPP(3, 4);
		miGrilla.cambiarEstadoDeEnemigosHuir();
		//Cambiar el estado de los fantasmas a huir, hacerlos comibles
	}
	public void accept (Visitor v) {
		v.visit(this);
	}
	
	
}
