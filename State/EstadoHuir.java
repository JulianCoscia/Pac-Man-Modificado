package State;

import Entidades.Enemigo;
import Logica.Grilla;

public class EstadoHuir implements State{
	
	protected Grilla grilla;
	protected Enemigo enemigo;
	protected int posXaHuir;
	protected int posYaHuir;
	
	public EstadoHuir(Grilla g, Enemigo e, int x, int y) {
		grilla = g;
		enemigo = e;
		posXaHuir = x;
		posYaHuir = y;
	}

	public void objetivoDeseado() {
		enemigo.setPosicionObjetivoX(posXaHuir);
		enemigo.setPosicionObjetivoY(posYaHuir);
	}
	
	public void visitar() {
		enemigo.fuiComido();
	}
}