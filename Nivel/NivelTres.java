package Nivel;

import Entidades.EnemigoBlinky;
import Entidades.Explosion;
import FabricaTematica.FabricaTematicasAbstracta;
import Logica.Grilla;

public class NivelTres extends Nivel {

	public NivelTres (Grilla miGrilla, FabricaTematicasAbstracta miFabrica) {
		this.miGrilla= miGrilla;
		this.miFabrica= miFabrica;	

		construirPersonajePrincipal();
		construirEnemigos();
		construirParedes();
		construirPacDots();
		construirPowerPellets();
		construirPociones();
		construirFrutas();
	}
	
	protected void construirParedes() {
		//____Zona 1____
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 0));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(32, 0));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(32*2, 0));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 0));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(32*4, 0));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(32, 32));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*2));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*2));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*3));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*3));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*4));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(32*2, 32*4));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*4));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearParedNivel3(32*2, 32*3));
		
		//____Zona 2____
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*5, 0));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*6, 0));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 0));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 0));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*9, 0));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 32));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*5, 32));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*9, 32));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*9, 32*3));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 32*3));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*6, 32*3));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*5, 32*3));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*3));
		
		//____Zona 3____
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 0));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 0));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*12, 0));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 0));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*14, 0));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32*2));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32*3));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*2));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*3));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*4));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearParedNivel3(32*14, 32*2));

		//____Zona 4____
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 0));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*16, 0));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 0));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*18, 0));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 0));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*2));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*3));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*4));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*2));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*4));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*16, 32*2));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*2));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*3));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*4));
		
		//____Zona 5____
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*5));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*6));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*7));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*8));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*9));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*5));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32, 32*6));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*6));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32, 32*7));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32, 32*8));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32*2, 32*8));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*8));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32*4, 32*8));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32, 32*9));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32*2, 32*9));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*9));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearParedNivel3(32*4, 32*9));
		
		//____Zona 6 ____
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*5, 32*5));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*5, 32*6));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*5, 32*8));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*5, 32*9));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*6, 32*5));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*6, 32*6));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 32*5));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 32*6));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 32*7));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 32*8));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 32*9));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*5));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*6));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*7));
		
		
		//____Zona 7____
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 32*5));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 32*6));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 32*7));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32*5));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32*7));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32*8));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32*9));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*5));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*6));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*8));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*9));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*14, 32*8));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearParedNivel3(32*14, 32*9));
	
		
		//____Zona 8____
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*5));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*6));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*7));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*8));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*9));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*16, 32*8));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*16, 32*9));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*5));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*6));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*8));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*9));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*18, 32*8));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*18, 32*9));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*5));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*6));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*7));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*8));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*9));

		
		
		//____Zona 9____
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*10));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*11));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*12));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*13));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*14));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(32*2, 32*11));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(32*2, 32*13));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*10));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*11));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*13));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(32*4, 32*10));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(32*4, 32*11));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearParedNivel3(32*4, 32*13));
		
		
		//____Zona 10____
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearParedNivel3(32*5, 32*13));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearParedNivel3(32*6, 32*11));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearParedNivel3(32*6, 32*13));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 32*10));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 32*13));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*10));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*11));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*13));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*14));
	//	miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearParedNivel3(32*9, 32*10));
		
		//____Zona 11____
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 32*10));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 32*11));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 32*13));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 32*14));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32*10));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32*11));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32*13));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*12, 32*13));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*12, 32*14));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*11));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*13));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*14));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*14, 32*11));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*14, 32*13));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearParedNivel3(32*14, 32*14));
		
		//____Zona 12____
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*11));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*14));		
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*16, 32*12));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*16, 32*14));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*11));		
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*12));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*13));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*14));		
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*10));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*11));		
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*12));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*13));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*14));
		
		//____Zona 13____
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*15));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*16));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*17));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*18));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(0, 32*19));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(32*2, 32*15));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(32*2, 32*17));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(32*2, 32*19));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*17));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*19));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(32*3, 32*15));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(32*4, 32*15));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(32*4, 32*17));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(32*4, 32*19));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearParedNivel3(32, 32*19));
		
		//____Zona 14____
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*5, 32*17));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*5, 32*19));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*6, 32*15));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*6, 32*16));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*6, 32*17));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*6, 32*19));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 32*16));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*7, 32*19));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*15));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*16));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*18));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*8, 32*19));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearParedNivel3(32*9, 32*19));
		
		//____Zona 15____
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 32*15));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 32*16));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 32*18));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*10, 32*19));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32*16));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*11, 32*19));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*12, 32*16));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*12, 32*17));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*12, 32*19));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*17));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*13, 32*19));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*14, 32*15));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*14, 32*17));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearParedNivel3(32*14, 32*19));
		
		//____Zona 16____
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*15));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*17));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*15, 32*19));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*16, 32*15));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*16, 32*17));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*16, 32*19));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*15));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*17));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*17, 32*19));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*18, 32*19));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*15));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*16));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*17));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*18));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearParedNivel3(32*19, 32*19));
	}

	protected void construirPacDots() {
		//____Zona 1____
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearPacDots(32*2 + 7, 32 + 7));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearPacDots(32*3 + 7, 32 + 7));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearPacDots(32*4 + 7, 32 + 7));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearPacDots(32 + 7, 32*3 + 7));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearPacDots(32 + 7, 32*4 + 7));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearPacDots(32*2 + 7, 32*2 + 7));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearPacDots(32*4 + 7, 32*3 + 7));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearPacDots(32*4 + 7, 32*2 + 7));
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearPacDots(32*4 + 7, 32*4 + 7));

		miGrilla.sumarCantPacDot(9);
		
		//____Zona 2____
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*5 + 7, 32*2 + 7));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*5 + 7, 32*4 + 7));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*6 + 7, 32 + 7));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*6 + 7, 32*2 + 7));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*7 + 7, 32*2 + 7));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*7 + 7, 32*4 + 7));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*6 + 7, 32*4 + 7));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*8 + 7, 32*4 + 7));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*9 + 7, 32*2 + 7));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*8 + 7, 32 + 7));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*9 + 7, 32*4 + 7));
		miGrilla.getZonas(0, 1).agregarEntidad(miFabrica.crearPacDots(32*8 + 7, 32*2 + 7));
		miGrilla.sumarCantPacDot(12);
		
		//____Zona 3____
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearPacDots(32*10 + 7, 32 + 7));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearPacDots(32*10 + 7, 32*2 + 7));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearPacDots(32*10 + 7, 32*3 + 7));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearPacDots(32*10 + 7, 32*4 + 7));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearPacDots(32*11 + 7, 32*4 + 7));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32 + 7));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32*2 + 7));
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32*3 + 7));
		miGrilla.getZonas(0, 2).agregarEntidad(	miFabrica.crearPacDots(32*12 + 7, 32*4 + 7));
		miGrilla.getZonas(0, 2).agregarEntidad(	miFabrica.crearPacDots(32*13 + 7, 32 + 7));
		miGrilla.getZonas(0, 2).agregarEntidad(	miFabrica.crearPacDots(32*14 + 7, 32 + 7));
		miGrilla.getZonas(0, 2).agregarEntidad(	miFabrica.crearPacDots(32*14 + 7, 32*4 + 7));
		miGrilla.sumarCantPacDot(12);
		
		//____Zona 4____
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearPacDots(32*15 + 7, 32 + 7));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearPacDots(32*16 + 7, 32 + 7));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearPacDots(32*17 + 7, 32 + 7));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32 + 7));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*2 + 7));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*3 + 7));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*4 + 7));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearPacDots(32*15 + 7, 32*3 + 7));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearPacDots(32*16 + 7, 32*3 + 7));
		miGrilla.getZonas(0, 3).agregarEntidad(miFabrica.crearPacDots(32*16 + 7, 32*4+ 7));
		miGrilla.sumarCantPacDot(10);
		
		
		//____Zona 5____
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearPacDots(32 + 7, 32*5 + 7));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearPacDots(32*2 + 7, 32*5 + 7));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearPacDots(32*4 + 7, 32*5 + 7));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearPacDots(32*2 + 7, 32*6 + 7));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearPacDots(32*4 + 7, 32*6 + 7));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearPacDots(32*2 + 7, 32*7 + 7));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearPacDots(32*3 + 7, 32*7 + 7));
		miGrilla.getZonas(1, 0).agregarEntidad(miFabrica.crearPacDots(32*4 + 7, 32*7 + 7));
		miGrilla.sumarCantPacDot(8);
		
		//____Zona 6____
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearPacDots(32*5 + 7, 32*7 + 7));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearPacDots(32*6 + 7, 32*7 + 7));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearPacDots(32*6 + 7, 32*8 + 7));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearPacDots(32*6 + 7, 32*9 + 7));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearPacDots(32*9 + 7, 32*5 + 7));
		miGrilla.getZonas(1, 1).agregarEntidad(miFabrica.crearPacDots(32*9 + 7, 32*6 + 7));
		miGrilla.sumarCantPacDot(6);
		
		//____Zona 7____
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearPacDots(32*11 + 7, 32*6 + 7));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32*5 + 7));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32*6 + 7));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32*7 + 7));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32*8 + 7));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32*9 + 7));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearPacDots(32*13 + 7, 32*7 + 7));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearPacDots(32*14 + 7, 32*5 + 7));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearPacDots(32*14 + 7, 32*6 + 7));
		miGrilla.getZonas(1, 2).agregarEntidad(miFabrica.crearPacDots(32*14 + 7, 32*7 + 7));
		miGrilla.sumarCantPacDot(10);
		
		//____Zona 8____
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearPacDots(32*16 + 7, 32*5 + 7));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearPacDots(32*16 + 7, 32*6 + 7));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearPacDots(32*16 + 7, 32*7 + 7));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearPacDots(32*17 + 7, 32*7 + 7));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*5 + 7));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*6 + 7));
		miGrilla.getZonas(1, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*7 + 7));
		miGrilla.sumarCantPacDot(7);
		
		//____Zona 9____
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearPacDots(32 + 7, 32*10 + 7));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearPacDots(32 + 7, 32*11 + 7));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearPacDots(32 + 7, 32*13 + 7));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearPacDots(32 + 7, 32*14 + 7));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearPacDots(32*2 + 7, 32*12 + 7));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearPacDots(32*2 + 7, 32*14 + 7));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearPacDots(32*3 + 7, 32*12 + 7));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearPacDots(32*3 + 7, 32*14 + 7));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearPacDots(32*4 + 7, 32*12 + 7));
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearPacDots(32*4 + 7, 32*14 + 7));
		miGrilla.sumarCantPacDot(10);
		
		//____Zona 10____
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*5 + 7, 32*10 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*5 + 7, 32*11 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*5 + 7, 32*12 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*5 + 7, 32*14 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*6 + 7, 32*10 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*6 + 7, 32*12 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*6 + 7, 32*14 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*7 + 7, 32*12 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*7 + 7, 32*14 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*8 + 7, 32*12 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*7 + 7, 32*11 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*9 + 7, 32*13 + 7));
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearPacDots(32*9 + 7, 32*14 + 7));
		miGrilla.sumarCantPacDot(13);
		
		//____Zona 11____
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearPacDots(32*10 + 7, 32*12 + 7));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearPacDots(32*11 + 7, 32*12 + 7));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32*10 + 7));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32*11 + 7));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearPacDots(32*13 + 7, 32*10 + 7));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearPacDots(32*13 + 7, 32*12 + 7));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearPacDots(32*14 + 7, 32*10 + 7));
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearPacDots(32*14 + 7, 32*12 + 7));
		miGrilla.sumarCantPacDot(8);
		
		//____Zona 12____
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearPacDots(32*15 + 7, 32*10 + 7));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearPacDots(32*15 + 7, 32*13 + 7));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearPacDots(32*16 + 7, 32*10 + 7));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearPacDots(32*16 + 7, 32*11 + 7));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearPacDots(32*17 + 7, 32*10 + 7));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*11 + 7));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*12 + 7));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*13 + 7));
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*14 + 7));
		miGrilla.sumarCantPacDot(9);
		
		//____Zona 13____
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearPacDots(32 + 7, 32*15 + 7));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearPacDots(32 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearPacDots(32 + 7, 32*17 + 7));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearPacDots(32 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearPacDots(32*2 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearPacDots(32*2 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearPacDots(32*3 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearPacDots(32*3 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearPacDots(32*4 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 0).agregarEntidad(miFabrica.crearPacDots(32*4 + 7, 32*18 + 7));
		miGrilla.sumarCantPacDot(10);
		
		//____Zona 14____
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearPacDots(32*5 + 7, 32*15 + 7));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearPacDots(32*5 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearPacDots(32*5 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearPacDots(32*6 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearPacDots(32*7 + 7, 32*17 + 7));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearPacDots(32*7 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearPacDots(32*8 + 7, 32*17 + 7));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearPacDots(32*9 + 7, 32*15 + 7));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearPacDots(32*9 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearPacDots(32*9 + 7, 32*17 + 7));
		miGrilla.sumarCantPacDot(10);
		
		//____Zona 15____
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearPacDots(32*10 + 7, 32*17 + 7));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearPacDots(32*11 + 7, 32*15 + 7));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearPacDots(32*11 + 7, 32*17 + 7));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearPacDots(32*11 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32*15 + 7));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearPacDots(32*12 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearPacDots(32*13 + 7, 32*15 + 7));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearPacDots(32*13 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearPacDots(32*13 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearPacDots(32*14 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 2).agregarEntidad(miFabrica.crearPacDots(32*14 + 7, 32*18 + 7));
		miGrilla.sumarCantPacDot(11);
		
		//____Zona 16____
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearPacDots(32*15 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearPacDots(32*15 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearPacDots(32*16 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearPacDots(32*16 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearPacDots(32*17 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearPacDots(32*17 + 7, 32*18 + 7));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*15 + 7));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*16 + 7));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*17 + 7));
		miGrilla.getZonas(3, 3).agregarEntidad(miFabrica.crearPacDots(32*18 + 7, 32*18 + 7));
		miGrilla.sumarCantPacDot(10);
	}
	
	protected void construirPowerPellets() {
		//____Zona 1____
		miGrilla.getZonas(0, 0).agregarEntidad(miFabrica.crearPowerPellets(32, 32*2));
		
		//____Zona 3____
		miGrilla.getZonas(0, 2).agregarEntidad(miFabrica.crearPowerPellets(32*14, 32*3));
		
		//____Zona 11____
		miGrilla.getZonas(2, 2).agregarEntidad(miFabrica.crearPowerPellets(32*11, 32*14));
		
		//____Zona 12____
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearPowerPellets(32*18, 32*10));
		
		//____Zona 14 ____
		miGrilla.getZonas(3, 1).agregarEntidad(miFabrica.crearPowerPellets(32*7, 32*15));
		
	}

	protected void construirPociones() {
		//____Zona 9____
		miGrilla.getZonas(2, 0).agregarEntidad(miFabrica.crearPocionVelocidad(32*2, 32*10));
		
		//____Zona 9____
		Explosion bomba = miFabrica.crearExplosion(32, 32*12);
		miGrilla.getZonas(2, 0).agregarEntidad(bomba);
		miGrilla.agregarBomba(bomba);
		
		//____Zona 10____
		bomba = miFabrica.crearExplosion(32*9, 32*12);
		miGrilla.getZonas(2, 1).agregarEntidad(bomba);
		miGrilla.agregarBomba(bomba);
		
		//____Zona 12____
		miGrilla.getZonas(2, 3).agregarEntidad(miFabrica.crearPocionBombas(32*16, 32*13));
		
		//____Zona 12____
		bomba = miFabrica.crearExplosion(32*15, 32*12);
		miGrilla.getZonas(2, 3).agregarEntidad(bomba);
		miGrilla.agregarBomba(bomba);
		
		//____Zona 11____
		bomba = miFabrica.crearExplosion(32*12, 32*12);
		miGrilla.getZonas(2, 2).agregarEntidad(bomba);
		miGrilla.agregarBomba(bomba);
	}
	
	protected void construirFrutas() {
		//____Zona 10____
		miGrilla.getZonas(2, 1).agregarEntidad(miFabrica.crearFruta(32*9, 32*11));
	}

	protected void construirPersonajePrincipal() {
		//____Zona 14____
		miGrilla.setPersonajePrincipal(miFabrica.crearPersonajePrincipal(32*9, 32*18));
	}
	
	protected void construirEnemigos() {
		EnemigoBlinky blinky = miFabrica.crearEnemigoBlinky(32*9,32*8);
		miGrilla.agregarEnemigo(blinky);
		miGrilla.agregarEnemigo(miFabrica.crearEnemigoInky(32*9,32*9, blinky));
		miGrilla.agregarEnemigo(miFabrica.crearEnemigoPinky(32*8,32*8));
		miGrilla.agregarEnemigo(miFabrica.crearEnemigoClyde(32*10,32*8));
	}

	public int getNumeroNivel() {
		return 3;
	}


}