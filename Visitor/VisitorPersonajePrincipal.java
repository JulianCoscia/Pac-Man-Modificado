package Visitor;

import Entidades.Enemigo;
import Entidades.Explosion;
import Entidades.Fruta;
import Entidades.PacDots;
import Entidades.Pared;
import Entidades.PersonajePrincipal;
import Entidades.Pocion;
import Entidades.PowerPellets;

public class VisitorPersonajePrincipal implements Visitor{

	@Override
	public void visit(PersonajePrincipal e) {
		//No es posible
	}

	@Override
	public void visit(Enemigo e) {//Enemigo.getEstado.Visitar()
		e.getEstado().visitar();
	}

	@Override
	public void visit(Pared e) {
		e.acomodarEntidad(0); // 0 significa que lo choco el personaje principal
	}

	@Override
	public void visit(PacDots e) {
		e.desaparecer ();
		e.sumarPuntos(10);
	}

	@Override
	public void visit(PowerPellets e) {
		e.desaparecer();
		e.sumarPuntos(50);
		e.AfectarEntidades();
	}

	@Override
	public void visit(Fruta e) {
		e.consumir();
	}

	@Override
	public void visit(Pocion e) {
		e.desaparecer();
		e.activarEfecto();
	}
	
	public void visit(Explosion e) {
	}

}
