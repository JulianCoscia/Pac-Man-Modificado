package Entidades;

import Grafica.EntidadEstaticaGrafica;
import Logica.Grilla;
import Visitor.Visitor;
public class Pared extends EntidadEstatica{
	
	public Pared(int posX,int posY,EntidadEstaticaGrafica miRepresentacion, Grilla miGrilla) {
		this.posX = posX;
		this.posY = posY;
		alto = 32;
		ancho = 32;
		this.miGrilla= miGrilla;
		this.miRepresentacion = miRepresentacion;
		miRepresentacion.crearLabel(this.posX, this.posY, ancho, alto);
	}
	
	public void accept (Visitor v) {
		v.visit(this);
	}
	
	public boolean entidadPared () {
		return true;
	}

	public void acomodarEntidad(int ent) {//Solo funciona para el pacman, no para los enemigos
		miGrilla.acomodarEntidadDinamica(ent, this);
	}

}
