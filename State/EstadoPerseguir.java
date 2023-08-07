package State;

import Entidades.Enemigo;
import Logica.Grilla;

public class EstadoPerseguir implements State{
	
	protected Grilla grilla;
	protected Enemigo enemigo;
	
	public EstadoPerseguir(Grilla g, Enemigo e) {
		grilla = g;
		enemigo = e;
	}

	public void objetivoDeseado() {
		enemigo.objetivoDeseadoPerseguir();
	}
	
	public void visitar() {
		enemigo.comiAPacMan();
	}
}
