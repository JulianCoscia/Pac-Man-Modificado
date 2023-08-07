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
	
	public FabricaTematicaNaruto(Grilla grilla, Contenedor miContenedor) {
		miGrilla= grilla;
		this.miContenedor= miContenedor;
		direcciones = new String[4];
		afectado = new String[4];
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
		EntidadDinamicaGrafica personajePrincipalGrafico = new PersonajePrincipalGraficoAnimado(miContenedor);
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
}
