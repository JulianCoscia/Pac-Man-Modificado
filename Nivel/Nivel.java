package Nivel;

import FabricaTematica.FabricaTematicasAbstracta;
import Logica.Grilla;

public abstract class Nivel {

	protected Grilla miGrilla;
	protected FabricaTematicasAbstracta miFabrica;
	
	protected abstract void construirParedes();
	protected abstract void construirPacDots();
	protected abstract void construirPowerPellets();
	protected abstract void construirPociones();
	protected abstract void construirEnemigos();
	protected abstract void construirPersonajePrincipal();
	protected abstract void construirFrutas();
	public abstract int getNumeroNivel();
}