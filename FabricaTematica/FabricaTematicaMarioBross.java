package FabricaTematica;

import Entidades.*;
import EntidadesGraficas.*;
import GUI.Contenedor;
import Grafica.*;
import Logica.Grilla;

public class FabricaTematicaMarioBross implements FabricaTematicasAbstracta {

	protected Grilla miGrilla;
	protected Contenedor miContenedor;
	protected String[] direcciones;
	protected String[] afectado;
	
	public FabricaTematicaMarioBross(Grilla grilla, Contenedor miContenedor) {
		miGrilla= grilla;
		this.miContenedor= miContenedor;
		direcciones = new String[4];
		afectado = new String[4];
	}
	
	@Override
	public EnemigoBlinky crearEnemigoBlinky(int posX,int posY) {
		direcciones[0] = "/images/EnemigoBlinkyMario.png";
		direcciones[1] = "/images/EnemigoBlinkyMario.png";
		direcciones[2] = "/images/EnemigoBlinkyMario.png";
		direcciones[3] = "/images/EnemigoBlinkyMario.png";
		
		afectado[0] = "/images/EnemigoBlinkyMarioHuir.png";
		afectado[1] = "/images/EnemigoBlinkyMarioHuir.png";
		afectado[2] = "/images/EnemigoBlinkyMarioHuir.png";
		afectado[3] = "/images/EnemigoBlinkyMarioHuir.png";
		
		EntidadDinamicaGrafica enemigoBlinkyGrafico = new EnemigoBlinkyGrafico(miContenedor, direcciones, afectado);
		EnemigoBlinky enemigoBlinky = new EnemigoBlinky(posX, posY, enemigoBlinkyGrafico, miGrilla);
		return enemigoBlinky;
	}

	@Override
	public EnemigoClyde crearEnemigoClyde(int posX, int posY) {
		direcciones[0] = "/images/EnemigoClydeMario.png";
		direcciones[1] = "/images/EnemigoClydeMario.png";
		direcciones[2] = "/images/EnemigoClydeMario.png";
		direcciones[3] = "/images/EnemigoClydeMario.png";
		
		afectado[0] = "/images/EnemigoClydeMarioHuir.png";
		afectado[1] = "/images/EnemigoClydeMarioHuir.png";
		afectado[2] = "/images/EnemigoClydeMarioHuir.png";
		afectado[3] = "/images/EnemigoClydeMarioHuir.png";
		
		EntidadDinamicaGrafica enemigoClydeGrafico = new EnemigoClydeGrafico(miContenedor, direcciones, afectado);
		EnemigoClyde enemigoClyde = new EnemigoClyde(posX, posY, enemigoClydeGrafico, miGrilla);
		return enemigoClyde;
	}

	@Override
	public EnemigoInky crearEnemigoInky(int posX, int posY, EnemigoBlinky blinky) {
		direcciones[0] = "/images/EnemigoInkyMario2.png";
		direcciones[1] = "/images/EnemigoInkyMario.png";
		direcciones[2] = "/images/EnemigoInkyMario.png";
		direcciones[3] = "/images/EnemigoInkyMario.png";
		
		afectado[0] = "/images/EnemigoInkyMarioHuir2.png";
		afectado[1] = "/images/EnemigoInkyMarioHuir.png";
		afectado[2] = "/images/EnemigoInkyMarioHuir.png";
		afectado[3] = "/images/EnemigoInkyMarioHuir.png";
		
		EntidadDinamicaGrafica enemigoInkyGrafico = new EnemigoInkyGrafico(miContenedor, direcciones, afectado);
		EnemigoInky enemigoInky = new EnemigoInky(posX, posY, enemigoInkyGrafico, miGrilla, blinky);
		return enemigoInky;
	}

	@Override
	public EnemigoPinky crearEnemigoPinky(int posX, int posY) {
		direcciones[0] = "/images/EnemigoPinkyMario.png";
		direcciones[1] = "/images/EnemigoPinkyMario.png";
		direcciones[2] = "/images/EnemigoPinkyMario2.png";
		direcciones[3] = "/images/EnemigoPinkyMario.png";
		
		afectado[0] = "/images/EnemigoPinkyMarioHuir.png";
		afectado[1] = "/images/EnemigoPinkyMarioHuir.png";
		afectado[2] = "/images/EnemigoPinkyMarioHuir2.png";
		afectado[3] = "/images/EnemigoPinkyMarioHuir.png";
		
		EntidadDinamicaGrafica enemigoPinkyGrafico = new EnemigoPinkyGrafico(miContenedor, direcciones, afectado);
		EnemigoPinky enemigoPinky = new EnemigoPinky(posX, posY, enemigoPinkyGrafico, miGrilla);
		return enemigoPinky;
	}

	@Override
	public PersonajePrincipal crearPersonajePrincipal(int posX, int posY) {
		direcciones[0] = "/images/Mario.png";
		direcciones[1] = "/images/MarioAbajo.png";
		direcciones[2] = "/images/MarioIzquierda.png";
		direcciones[3] = "/images/MarioArriba.png";
		
		afectado[0] = "/images/MarioVelocidad.png";
		afectado[1] = "/images/MarioAbajoVelocidad.png";
		afectado[2] = "/images/MarioIzquierdaVelocidad.png";
		afectado[3] = "/images/MarioArribaVelocidad.png";
		
		EntidadDinamicaGrafica personajePrincipalGrafico = new PersonajePrincipalGrafico(miContenedor, direcciones, afectado);
		PersonajePrincipal personajePrincipal = new PersonajePrincipal(posX, posY, personajePrincipalGrafico, miGrilla);
		return personajePrincipal;
	}

	@Override
	public Pared crearParedNivel1(int posX, int posY) {
		EntidadEstaticaGrafica paredGraficaNivel1 = new ParedGraficaNivel1(miContenedor, "/images/ParedNivel1Mario.png");
		Pared pared = new Pared(posX, posY, paredGraficaNivel1, miGrilla);
		return pared;
	}

	@Override
	public Pared crearParedNivel2(int posX, int posY) {
		EntidadEstaticaGrafica paredGraficaNivel2 = new ParedGraficaNivel2(miContenedor, "/images/ParedNivel2Mario.png");
		Pared pared = new Pared(posX, posY, paredGraficaNivel2, miGrilla);
		return pared;
	}

	@Override
	public Pared crearParedNivel3(int posX, int posY) {
		EntidadEstaticaGrafica paredGraficaNivel3 = new ParedGraficaNivel3(miContenedor, "/images/ParedNivel3Mario.png");
		Pared pared = new Pared(posX, posY, paredGraficaNivel3, miGrilla);
		return pared;
	}

	@Override
	public Fruta crearFruta(int posX, int posY) {
		EntidadEstaticaGrafica frutaGrafica = new FrutaGrafica(miContenedor, "/images/FrutaMario.png");
		Fruta fruta = new Fruta(posX, posY, frutaGrafica, miGrilla);
		return fruta;
	}

	@Override
	public PacDots crearPacDots(int posX, int posY) {
		EntidadEstaticaGrafica pacDotsGrafica = new PacDotsGrafica(miContenedor, "/images/PacDotMario.png");
		PacDots pacDot = new PacDots(posX, posY, pacDotsGrafica, miGrilla);
		return pacDot;
	}

	@Override
	public PowerPellets crearPowerPellets(int posX, int posY) {
		EntidadEstaticaGrafica powerGrafica = new PowerPelletsGrafica(miContenedor, "/images/PowerPelletMario.png");
		PowerPellets power = new PowerPellets(posX, posY, powerGrafica,miGrilla);
		return power;
	}

	@Override
	public PocionVelocidad crearPocionVelocidad(int posX, int posY) {
		EntidadEstaticaGrafica pocionVelocidadGrafica = new PocionVelocidadGrafica(miContenedor, "/images/PocionVelocidadMario.png");
		PocionVelocidad pocionVelo = new PocionVelocidad(posX, posY, pocionVelocidadGrafica, miGrilla);
		return pocionVelo;
	}

	@Override
	public PocionBombas crearPocionBombas(int posX, int posY) {
		EntidadEstaticaGrafica pocionBombaGrafica = new PocionBombaGrafica(miContenedor, "/images/PocionExplosivaMario.png");
		PocionBombas pocionBomba = new PocionBombas(posX, posY, pocionBombaGrafica, miGrilla);
		return pocionBomba;
	}
	
	public Explosion crearExplosion(int x, int y) {
		EntidadEstaticaGrafica explosionGrafica = new ExplosionGrafica(miContenedor, "/images/Bomba.png");
		Explosion explosion = new Explosion (x, y, explosionGrafica, miGrilla);
		return explosion;
	}
}
