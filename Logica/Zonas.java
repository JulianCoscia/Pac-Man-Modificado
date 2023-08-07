package Logica;

import java.util.Iterator;
import java.util.LinkedList;

import Entidades.Entidad;
import Entidades.EntidadDinamica;

public class Zonas {

	private LinkedList<Entidad> coleccionEntidades;
	
	public Zonas () {
		coleccionEntidades= new LinkedList<Entidad> ();
	}
	
	public void agregarEntidad(Entidad e) {
		coleccionEntidades.addLast(e);
	}
	
	//POr ahora lo dejamos de testeo____________________________________
	public boolean buscarEntidad (Entidad e) {
		boolean eliminado= false;
		for (Entidad a:coleccionEntidades) {
			if (a == e) {
					eliminado= true;
					return eliminado;
			}
		}
		return eliminado;
	}
	
	public void removerEntidades() {
		Iterator<Entidad> itr=coleccionEntidades.iterator();
	    while(itr.hasNext()) {
	    	itr.next();
	        itr.remove();
	    }
	}
	
	public boolean eliminarEntidad (Entidad e) {
		boolean eliminado= false;
		LinkedList<Entidad> clon = new LinkedList<Entidad>(coleccionEntidades);
		for (Entidad a : clon) {
			if (a == e) {
				coleccionEntidades.remove(a);
				eliminado= true;
				return eliminado;
			}
		}
		return eliminado;
	}
	
	public synchronized void chequearColisiones(EntidadDinamica ed) {
		LinkedList<Entidad> clon = new LinkedList<Entidad>(coleccionEntidades);
		for (Entidad a: clon) {
			if (hayColision(ed, a))
				if (a != null)
					a.accept(ed.getVisitor());
		}
	}

	public synchronized boolean hayColision(EntidadDinamica ed, Entidad a) {
		if (ed == a)
			return false;
		boolean hayColision = false;
		int [] esquina= new int [2];
		esquina= a.getEsquina(1);
		int posxEsquina = esquina[0];
		int posyEsquina = esquina[1];
		
		//Esquina superior izquierda
		if (posxEsquina >= ed.getPosX() && posxEsquina <= (ed.getPosX() + ed.getAlto() - 1) && posyEsquina >= ed.getPosY() && posyEsquina <= (ed.getPosY() + ed.getAncho() - 1))
			hayColision = true;
		
		esquina= a.getEsquina(2);
		posxEsquina = esquina[0];
		posyEsquina = esquina[1];
		if (!hayColision && posxEsquina >= ed.getPosX() && posxEsquina <= (ed.getPosX() + ed.getAlto() - 1) && posyEsquina >= ed.getPosY() && posyEsquina <= (ed.getPosY() + ed.getAncho() - 1))
			hayColision = true;
		
		esquina= a.getEsquina(3);
		posxEsquina = esquina[0];
		posyEsquina = esquina[1];
		if (!hayColision && posxEsquina >= ed.getPosX() && posxEsquina <= (ed.getPosX() + ed.getAlto() - 1) && posyEsquina >= ed.getPosY() && posyEsquina <= (ed.getPosY() + ed.getAncho() - 1))
			hayColision = true;
		
		esquina= a.getEsquina(4);
		posxEsquina = esquina[0];
		posyEsquina = esquina[1];
		if (!hayColision && posxEsquina >= ed.getPosX() && posxEsquina <= (ed.getPosX() + ed.getAlto() - 1) && posyEsquina >= ed.getPosY() && posyEsquina <= (ed.getPosY() + ed.getAncho() -1))
			hayColision = true;
		return hayColision;
	}

	public synchronized boolean pixelDisponible(int posXEsquina, int posYEsquina) {
		boolean disponible= true;
		LinkedList<Entidad> clon = new LinkedList<Entidad>(coleccionEntidades);
		for (Entidad a: clon) {
			if (a.entidadPared() && esquinaColision(posXEsquina, posYEsquina, a))
				disponible= false;
		}
		return disponible;
	}

	private boolean esquinaColision(int posXEsquina, int posYEsquina, Entidad a) { //Chequea si la esquna pasada por parametro esta dentro de la entidad
		boolean hayColision= false;
		if (posXEsquina >= a.getPosX() && posXEsquina <= (a.getPosX() + a.getAlto() - 1) && posYEsquina >= a.getPosY() && posYEsquina <= (a.getPosY() + a.getAncho() - 1))
			hayColision = true;
		return hayColision;
	}
}
