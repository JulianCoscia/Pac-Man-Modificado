package Entidades;

import Grafica.EntidadEstaticaGrafica;

public abstract class EntidadEstatica extends Entidad {
	
	protected EntidadEstaticaGrafica miRepresentacion;
	
	public EntidadEstaticaGrafica getRepresentacionGrafica() {
		return miRepresentacion;
	}
	
}
