package Visitor;

import Entidades.Enemigo;
import Entidades.Explosion;
import Entidades.Fruta;
import Entidades.PacDots;
import Entidades.Pared;
import Entidades.PersonajePrincipal;
import Entidades.Pocion;
import Entidades.PowerPellets;

public interface Visitor {

	public void visit(PersonajePrincipal e);
	
	public void visit(Enemigo e);
	
	public void visit(Pared e);
	
	public void visit(PacDots e);
	
	public void visit(PowerPellets e);
	
	public void visit(Fruta e);
	
	public void visit(Pocion e);
	
	public void visit(Explosion e);
	
}