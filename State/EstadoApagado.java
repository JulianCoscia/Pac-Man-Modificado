package State;

import Entidades.Explosion;
import Logica.Grilla;

public class EstadoApagado implements StateBombas{
	protected Grilla miGrilla;
	protected Explosion bomba;

	public EstadoApagado(Explosion e, Grilla grilla) {
		bomba = e;
		miGrilla = grilla;
	}

	public void visitar() {}

}
