package State;

import Entidades.Explosion;
import Logica.Grilla;

public class EstadoEncendidas implements StateBombas{
	protected Explosion bomba;
	protected Grilla miGrilla;

	public EstadoEncendidas(Explosion e, Grilla grilla) {
		bomba = e;
		miGrilla = grilla;
	}
	
	public void visitar() {
		miGrilla.afectarEnemigo(bomba);
	}

}
