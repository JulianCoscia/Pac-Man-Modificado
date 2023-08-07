package Entidades;

public abstract class Pocion extends EntidadEstatica{
	
	protected boolean consumido;

	public boolean fuiConsumido() {
		return consumido;
	}

	public abstract void desaparecer();
	
	public abstract void activarEfecto();
}
