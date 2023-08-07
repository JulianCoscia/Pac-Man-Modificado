package Visitor;

import Entidades.Enemigo;
import Entidades.Explosion;
import Entidades.Fruta;
import Entidades.PacDots;
import Entidades.Pared;
import Entidades.PersonajePrincipal;
import Entidades.Pocion;
import Entidades.PowerPellets;

public class VisitorEnemigos implements Visitor{	//Verlo como Yo le afecto a

	@Override
	public void visit(PersonajePrincipal e) {
	//	System.out.println("Chocque con pacman");
	}

	@Override
	public void visit(Enemigo e) {}

	@Override
	public void visit(Pared e) {
		e.acomodarEntidad(1);
	}

	@Override
	public void visit(PacDots e) {}

	@Override
	public void visit(PowerPellets e) {}

	@Override
	public void visit(Fruta e) {}

	@Override
	public void visit(Pocion e) {}
	
	public void visit(Explosion e) {
		e.getState().visitar();
	}

}
