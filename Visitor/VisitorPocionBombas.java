package Visitor;

import Entidades.Enemigo;
import Entidades.Explosion;
import Entidades.Fruta;
import Entidades.PacDots;
import Entidades.Pared;
import Entidades.PersonajePrincipal;
import Entidades.Pocion;
import Entidades.PowerPellets;

public class VisitorPocionBombas implements Visitor{
	
	@Override
	public void visit(PersonajePrincipal e) {}
	
	@Override
	public void visit(Pared e) {}

	@Override
	public void visit(PacDots e) {}

	@Override
	public void visit(PowerPellets e) {}

	@Override
	public void visit(Fruta e) {}

	@Override
	public void visit(Pocion e) {}


	@Override
	public void visit(Enemigo e) {}

	@Override
	public void visit(Explosion e) {}
}
