package FabricaTematica;

import Entidades.EnemigoBlinky;
import Entidades.EnemigoClyde;
import Entidades.EnemigoInky;
import Entidades.EnemigoPinky;
import Entidades.Explosion;
import Entidades.Fruta;
import Entidades.PacDots;
import Entidades.Pared;
import Entidades.PersonajePrincipal;
import Entidades.PocionBombas;
import Entidades.PocionVelocidad;
import Entidades.PowerPellets;
import EntidadesGraficas.EnemigoBlinkyGrafico;
import EntidadesGraficas.EnemigoClydeGrafico;
import EntidadesGraficas.EnemigoInkyGrafico;
import EntidadesGraficas.EnemigoPinkyGrafico;
import EntidadesGraficas.ExplosionGraficaAnimada;
import EntidadesGraficas.FrutaGrafica;
import EntidadesGraficas.PacDotsGrafica;
import EntidadesGraficas.ParedGraficaNivel1;
import EntidadesGraficas.ParedGraficaNivel2;
import EntidadesGraficas.ParedGraficaNivel3;
import EntidadesGraficas.PersonajePrincipalGraficoAnimado;
import EntidadesGraficas.PocionBombaGrafica;
import EntidadesGraficas.PocionVelocidadGrafica;
import EntidadesGraficas.PowerPelletsGrafica;
import GUI.Contenedor;
import Grafica.EntidadDinamicaGrafica;
import Grafica.EntidadEstaticaGrafica;
import Logica.Grilla;

public class FabricaTematicaNaruto implements FabricaTematicasAbstracta{

	protected Grilla miGrilla;
	protected Contenedor miContenedor;
	protected String[] direcciones;
	protected String[] afectado;
	protected String[][] animacion;
	
	public FabricaTematicaNaruto(Grilla grilla, Contenedor miContenedor) {
		miGrilla= grilla;
		this.miContenedor= miContenedor;
		direcciones = new String[4];
		afectado = new String[4];
		animacion = new String[4][8];
	}
	
	@Override
	public EnemigoBlinky crearEnemigoBlinky(int posX,int posY) {
		direcciones[0] = "/images/EnemigoBlinkyNaruto.png";
		direcciones[1] = "/images/EnemigoBlinkyNaruto.png";
		direcciones[2] = "/images/EnemigoBlinkyNaruto.png";
		direcciones[3] = "/images/EnemigoBlinkyNaruto.png";
		
		afectado[0] = "/images/EnemigoBlinkyNarutoHuir.png";
		afectado[1] = "/images/EnemigoBlinkyNarutoHuir.png";
		afectado[2] = "/images/EnemigoBlinkyNarutoHuir.png";
		afectado[3] = "/images/EnemigoBlinkyNarutoHuir.png";
		
		EntidadDinamicaGrafica enemigoBlinkyGrafico = new EnemigoBlinkyGrafico(miContenedor, direcciones, afectado);
		EnemigoBlinky enemigoBlinky = new EnemigoBlinky(posX, posY, enemigoBlinkyGrafico, miGrilla);
		return enemigoBlinky;
	}

	@Override
	public EnemigoClyde crearEnemigoClyde(int posX, int posY) {
		direcciones[0] = "/images/EnemigoClydeNaruto.png";
		direcciones[1] = "/images/EnemigoClydeNaruto.png";
		direcciones[2] = "/images/EnemigoClydeNaruto.png";
		direcciones[3] = "/images/EnemigoClydeNaruto.png";
		
		afectado[0] = "/images/EnemigoClydeNarutoHuir.png";
		afectado[1] = "/images/EnemigoClydeNarutoHuir.png";
		afectado[2] = "/images/EnemigoClydeNarutoHuir.png";
		afectado[3] = "/images/EnemigoClydeNarutoHuir.png";
		
		EntidadDinamicaGrafica enemigoClydeGrafico = new EnemigoClydeGrafico(miContenedor, direcciones, afectado);
		EnemigoClyde enemigoClyde = new EnemigoClyde(posX, posY, enemigoClydeGrafico, miGrilla);
		return enemigoClyde;
	}

	@Override
	public EnemigoInky crearEnemigoInky(int posX, int posY, EnemigoBlinky blinky) {
		direcciones[0] = "/images/EnemigoInkyNaruto.png";
		direcciones[1] = "/images/EnemigoInkyNaruto.png";
		direcciones[2] = "/images/EnemigoInkyNaruto.png";
		direcciones[3] = "/images/EnemigoInkyNaruto.png";
		
		afectado[0] = "/images/EnemigoInkyNarutoHuir.png";
		afectado[1] = "/images/EnemigoInkyNarutoHuir.png";
		afectado[2] = "/images/EnemigoInkyNarutoHuir.png";
		afectado[3] = "/images/EnemigoInkyNarutoHuir.png";
		
		EntidadDinamicaGrafica enemigoInkyGrafico = new EnemigoInkyGrafico(miContenedor, direcciones, afectado);
		EnemigoInky enemigoInky = new EnemigoInky(posX, posY, enemigoInkyGrafico, miGrilla, blinky);
		return enemigoInky;
	}

	@Override
	public EnemigoPinky crearEnemigoPinky(int posX, int posY) {
		direcciones[0] = "/images/EnemigoPinkyNaruto.png";
		direcciones[1] = "/images/EnemigoPinkyNaruto.png";
		direcciones[2] = "/images/EnemigoPinkyNaruto.png";
		direcciones[3] = "/images/EnemigoPinkyNaruto.png";
		
		afectado[0] = "/images/EnemigoPinkyNarutoHuir.png";
		afectado[1] = "/images/EnemigoPinkyNarutoHuir.png";
		afectado[2] = "/images/EnemigoPinkyNarutoHuir.png";
		afectado[3] = "/images/EnemigoPinkyNarutoHuir.png";
		
		EntidadDinamicaGrafica enemigoPinkyGrafico = new EnemigoPinkyGrafico(miContenedor, direcciones, afectado);
		EnemigoPinky enemigoPinky = new EnemigoPinky(posX, posY, enemigoPinkyGrafico, miGrilla);
		return enemigoPinky;
	}

	@Override
	public PersonajePrincipal crearPersonajePrincipal(int posX, int posY) {
	
		animacion[0][0]= "/images/narutoder1.png";
		animacion[0][1]= "/images/narutoder2.png";
		animacion[0][2]= "/images/narutoder3.png";
		animacion[0][3]= "/images/narutoder4.png";
		animacion[0][4]= "/images/narutoder5.png";
		animacion[0][5]= "/images/narutoder6.png";
		animacion[0][6]= "/images/narutoder7.png";
		animacion[0][7]= "/images/narutoder8.png";
		
		animacion[1][0]= "/images/narutoaba1.png";
		animacion[1][1]= "/images/narutoaba2.png";
		animacion[1][2]= "/images/narutoaba3.png";
		animacion[1][3]= "/images/narutoaba4.png";
		animacion[1][4]= "/images/narutoaba5.png";
		animacion[1][5]= "/images/narutoaba6.png";
		animacion[1][6]= "/images/narutoaba7.png";
		animacion[1][7]= "/images/narutoaba8.png";

		animacion[2][0]= "/images/narutoizq1.png";
		animacion[2][1]= "/images/narutoizq2.png";
		animacion[2][2]= "/images/narutoizq3.png";
		animacion[2][3]= "/images/narutoizq4.png";
		animacion[2][4]= "/images/narutoizq5.png";
		animacion[2][5]= "/images/narutoizq6.png";
		animacion[2][6]= "/images/narutoizq7.png";
		animacion[2][7]= "/images/narutoizq8.png";

		animacion[3][0]= "/images/narutoarr1.png";
		animacion[3][1]= "/images/narutoarr2.png";
		animacion[3][2]= "/images/narutoarr3.png";
		animacion[3][3]= "/images/narutoarr4.png";
		animacion[3][4]= "/images/narutoarr5.png";
		animacion[3][5]= "/images/narutoarr6.png";
		animacion[3][6]= "/images/narutoarr7.png";
		animacion[3][7]= "/images/narutoarr8.png";

		EntidadDinamicaGrafica personajePrincipalGrafico = new PersonajePrincipalGraficoAnimado(miContenedor, animacion);
		PersonajePrincipal personajePrincipal = new PersonajePrincipal(posX, posY, personajePrincipalGrafico, miGrilla);
		return personajePrincipal;
	}

	@Override
	public Pared crearParedNivel1(int posX, int posY) {
		EntidadEstaticaGrafica paredGraficaNivel1 = new ParedGraficaNivel1(miContenedor, "/images/ParedNivel1Naruto.png");
		Pared pared = new Pared(posX, posY, paredGraficaNivel1, miGrilla);
		return pared;
	}

	@Override
	public Pared crearParedNivel2(int posX, int posY) {
		EntidadEstaticaGrafica paredGraficaNivel2 = new ParedGraficaNivel2(miContenedor, "/images/ParedNivel2Naruto.png");
		Pared pared = new Pared(posX, posY, paredGraficaNivel2, miGrilla);
		return pared;
	}

	@Override
	public Pared crearParedNivel3(int posX, int posY) {
		EntidadEstaticaGrafica paredGraficaNivel3 = new ParedGraficaNivel3(miContenedor, "/images/ParedNivel3Naruto.png");
		Pared pared = new Pared(posX, posY, paredGraficaNivel3, miGrilla);
		return pared;
	}

	@Override
	public Fruta crearFruta(int posX, int posY) {
		EntidadEstaticaGrafica frutaGrafica = new FrutaGrafica(miContenedor, "/images/FrutaNaruto.png");
		Fruta fruta = new Fruta(posX, posY, frutaGrafica, miGrilla);
		return fruta;
	}

	@Override
	public PacDots crearPacDots(int posX, int posY) {
		EntidadEstaticaGrafica pacDotsGrafica = new PacDotsGrafica(miContenedor, "/images/PacDotNaruto.png");
		PacDots pacDot = new PacDots(posX, posY, pacDotsGrafica, miGrilla);
		return pacDot;
	}

	@Override
	public PowerPellets crearPowerPellets(int posX, int posY) {
		EntidadEstaticaGrafica powerGrafica = new PowerPelletsGrafica(miContenedor, "/images/PowerPelletNaruto.png");
		PowerPellets power = new PowerPellets(posX, posY, powerGrafica,miGrilla);
		return power;
	}

	@Override
	public PocionVelocidad crearPocionVelocidad(int posX, int posY) {
		EntidadEstaticaGrafica pocionVelocidadGrafica = new PocionVelocidadGrafica(miContenedor, "/images/PocionVelocidadNaruto.png");
		PocionVelocidad pocionVelo = new PocionVelocidad(posX, posY, pocionVelocidadGrafica, miGrilla);
		return pocionVelo;
	}

	@Override
	public PocionBombas crearPocionBombas(int posX, int posY) {
		EntidadEstaticaGrafica pocionBombaGrafica = new PocionBombaGrafica(miContenedor, "/images/PocionExplosivaNaruto.png");
		PocionBombas pocionBomba = new PocionBombas(posX, posY, pocionBombaGrafica, miGrilla);
		return pocionBomba;
	}
	
	public Explosion crearExplosion(int x, int y) {
		EntidadEstaticaGrafica explosionGrafica = new ExplosionGraficaAnimada(miContenedor);
		Explosion explosion = new Explosion(x, y, explosionGrafica,miGrilla);
		return explosion;
	}
	
	public String musicaNivel(int lvl) {
		String salida = "";
		
		switch(lvl) {
			case 1: salida = "/Sonido/CancionNivelUnoNaruto.wav";
					break;
			case 2: salida = "/Sonido/CancionNivelDosNaruto.wav";
					break;
			case 3: salida = "/Sonido/CancionNivelTresNaruto.wav";
					break;
		}
		
		return salida;
	}
}
