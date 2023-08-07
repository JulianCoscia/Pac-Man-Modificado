package Entidades;

import Logica.Grilla;
import Visitor.Visitable;
import Visitor.Visitor;

public abstract class Entidad implements Visitable{
	protected Visitor miVisitor;
	protected Grilla miGrilla;

	protected int posX, posY;
	protected int ancho, alto;
	
	public Visitor getVisitor() {
		return miVisitor;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public int[] getEsquina(int esquina) {
		int[] salida = new int[2];
	
		switch (esquina) {
		case 1: 
			salida[0]= posX;
			salida[1]= posY;
			break;
		case 2:
			salida[0]= posX + ancho - 1;
			salida[1]= posY;
			break;
		case 3: 
			salida[0]= posX;
			salida[1]= posY + alto - 1;
			break;
		case 4:
			salida[0]= posX + ancho - 1;
			salida[1]= posY + alto - 1;
			break;
		}
		
	return salida;
	}
	
	public boolean entidadPared () {//ESTO ESTA PESIMO
		return false;
	}
}
