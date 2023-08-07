package Visitor;

import Entidades.Enemigo;
import Entidades.Explosion;
import Entidades.Fruta;
import Entidades.PacDots;
import Entidades.Pared;
import Entidades.PersonajePrincipal;
import Entidades.Pocion;
import Entidades.PowerPellets;

public class VisitorPared implements Visitor{

	@Override
	public void visit(PersonajePrincipal e) {
	}

	@Override
	public void visit(Pared e) {
		//No es posible
	}

	@Override
	public void visit(PacDots e) {
		//No es posible
	}

	@Override
	public void visit(PowerPellets e) {
		//No es posible
	}

	@Override
	public void visit(Fruta e) {
		//No es posible
	}

	@Override
	public void visit(Pocion e) {
		//No es posible
	}

	@Override
	public void visit(Enemigo e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(Explosion e) {
		// TODO Auto-generated method stub
		
	}

}
