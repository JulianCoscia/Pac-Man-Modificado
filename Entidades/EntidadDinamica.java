package Entidades;

import Grafica.EntidadDinamicaGrafica;
import Logica.Zonas;

public abstract class EntidadDinamica extends Entidad {
	protected int sentidoDeseado;
	protected int velocidad;
	protected int movimiento;
	protected int rotacion;
	protected EntidadDinamicaGrafica miRepresentacion;
	protected Zonas[] zonasPertenecientes;
	protected static final int DERECHA= 0;
	protected static final int ABAJO= 1;
	protected static final int IZQUIERDA= 2;
	protected static final int ARRIBA= 3;
	
	public abstract void mover();
	
	public Zonas[] getZonasPertenecientes() {
		return zonasPertenecientes;
	}
	//______Asginar Zona cuando se crea la ed____________
	public void setZonasPertenecientes(int esquina, Zonas zona) {
		zonasPertenecientes[esquina] = zona;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void acomodar(Entidad e) {
		int pixelesAVolver;
		switch (rotacion) {
		case DERECHA: 
			pixelesAVolver= (this.posX + this.ancho - 1) - e.getPosX();
			posX-= (pixelesAVolver + 1);
			break;
		case ABAJO: 
			pixelesAVolver= (this.posY + this.alto - 1) - e.getPosY();
			posY-= (pixelesAVolver + 1);
			break;
		case IZQUIERDA: 
			pixelesAVolver=(e.getPosX() + e.getAncho() - 1) - this.posX;
			posX+= (pixelesAVolver + 1);
			break;
		case ARRIBA: 
			pixelesAVolver=(e.getPosY() + e.getAlto() - 1) - this.posY;
			posY+= (pixelesAVolver + 1);
			break;
		}
	}
}
