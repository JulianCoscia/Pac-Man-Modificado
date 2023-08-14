package Logica;

import java.util.LinkedList;

import Entidades.Enemigo;
import Entidades.Entidad;
import Entidades.EntidadDinamica;
import Entidades.Explosion;
import Entidades.PersonajePrincipal;
import FabricaTematica.FabricaTematicasAbstracta;
import GUI.Contenedor;
import Nivel.*;


public class Grilla {

	protected static final int constanteZonas = 160;
	protected Zonas matrizZonas[][];
	protected Juego miJuego;
	protected FabricaTematicasAbstracta miFabrica;
	protected Nivel nivelActual;
	protected PersonajePrincipal personajePrincipal;
	protected LinkedList<Enemigo> listaEnemigos;
	protected LinkedList<Explosion> listaBombas;
	
	//___Constructor___
	public Grilla (Juego juego, Contenedor contenedorJuego) {
		miJuego= juego;
		matrizZonas= new Zonas[4][4];
		
		//Inicializa cada zona
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				matrizZonas[i][j] = new Zonas();
			}
		}
		listaBombas = new LinkedList<Explosion>();
		listaEnemigos = new LinkedList<Enemigo>();
	}

	//____Metodos____
	public void asignarFabrica(FabricaTematicasAbstracta fabrica) {
		miFabrica= fabrica;
		nivelActual= new NivelUno (this, miFabrica); 
	}
	

	public void cambiarNivel() {
		switch (nivelActual.getNumeroNivel()) {
		case 1:
			nivelActual= new NivelDos (this, miFabrica);
			miJuego.detenerMusica();
			miJuego.correrMusica();
			break;
		case 2:
			nivelActual= new NivelTres (this, miFabrica);
			miJuego.detenerMusica();
			miJuego.correrMusica();
			break;
		}
	}

	public void reiniciarZonas() {
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                matrizZonas[i][j].removerEntidades();
            }
        }
        listaBombas = new LinkedList<Explosion>();
		listaEnemigos = new LinkedList<Enemigo>();
	}
	
	public Zonas getZonas (int f, int c){
		return matrizZonas[f][c];
	}
	
	public void setRotacionPP(int i) {
		personajePrincipal.setSentidoDeseado(i);
		actualizarZonaPerteneciente(personajePrincipal);
	}
	
	public void setPersonajePrincipal (PersonajePrincipal miPP) {
		personajePrincipal = miPP;
	}
	
	public void agregarEnemigo(Enemigo enemigo) {
		listaEnemigos.addLast(enemigo);
	}
	
	public synchronized void moverPersonajePrincipal() {
		personajePrincipal.mover();
		actualizarZonaPerteneciente(personajePrincipal);
	}
	
	public synchronized void moverEnemigo() {
		for(Enemigo e:listaEnemigos) {
			e.mover();
		    actualizarZonaPerteneciente(e);
		}
	}
	
	public void sumarPuntos(int puntos) {
		miJuego.sumarPuntos(puntos);
	}
	
	public void restarPacDot() {
		miJuego.restarPacDot();
	}
	
	public void sumarCantPacDot(int pd) {
		miJuego.sumarPacDot(pd);
	}
	
	public void activarVelocidadPP(int velocidad, double tiempo) {
		personajePrincipal.setVelocidad(velocidad);
		personajePrincipal.activarCambioDeEstadoGrafico(1);
		miJuego.temporizador(tiempo);
	}
	
	public synchronized void chequearColisiones(EntidadDinamica ed) {
		for (int i=0;i<4;i++) {
            for (int j=0;j<4;j++) {
                getZonas(i, j).chequearColisiones(ed);
            }
        }
	}

	public void resetearVelocidadPersonajePrincipal() {
		personajePrincipal.resetearVelocidad();
		personajePrincipal.activarCambioDeEstadoGrafico(0);
	}

	public void removerEntidad(Entidad e) {
		int valorx = e.getPosX()/constanteZonas;
		int valory = e.getPosY()/constanteZonas;
		
		this.getZonas(valory, valorx).eliminarEntidad(e);
	}
	
	public void agregarBomba(Explosion e) {
		listaBombas.addLast(e);
	}
	
	public void activarBombas() {
		LinkedList<Explosion> clon = new LinkedList<Explosion>(listaBombas);
		
		for (Explosion e:clon) {
			e.Explotar();
			listaBombas.remove(e);
		}
	}
	
	public void afectarEnemigo(Explosion e) {
		Zonas[] arr;
		
		for (Enemigo a: listaEnemigos) {
			arr = a.getZonasPertenecientes();
			if (arr[0].hayColision(a, e) || arr[1].hayColision(a, e) || arr[2].hayColision(a, e) || arr[3].hayColision(a, e))
				a.fuiComido();
		}
		e.eliminarImagen();
		removerEntidad(e);
	}
	
	public synchronized boolean movimientoPermitido(PersonajePrincipal pp) {
		boolean movimientoDisponible= true;
		int posXEsquina1, posYEsquina1;
		int posXEsquina2, posYEsquina2;
		switch (pp.getSentidoDeseado()) {
		case 0: //0 significa derecha
			posXEsquina1= pp.getEsquina(2)[0] + 1;
			posYEsquina1= pp.getEsquina(2)[1];
			posXEsquina2= pp.getEsquina(4)[0] + 1;
			posYEsquina2= pp.getEsquina(4)[1];
			movimientoDisponible= pixelDisponible(posXEsquina1, posYEsquina1, posXEsquina2, posYEsquina2);
			break;
		case 1: //1 significa abajo
			posXEsquina1= pp.getEsquina(3)[0];
			posYEsquina1= pp.getEsquina(3)[1] + 1;
			posXEsquina2= pp.getEsquina(4)[0];
			posYEsquina2= pp.getEsquina(4)[1] + 1;
			movimientoDisponible= pixelDisponible(posXEsquina1, posYEsquina1, posXEsquina2, posYEsquina2);
			break;
		case 2: //2 significa izquierda
			posXEsquina1= pp.getEsquina(1)[0] - 1;
			posYEsquina1= pp.getEsquina(1)[1];
			posXEsquina2= pp.getEsquina(3)[0] - 1;
			posYEsquina2= pp.getEsquina(3)[1];
			movimientoDisponible= pixelDisponible(posXEsquina1, posYEsquina1, posXEsquina2, posYEsquina2);
			break;
		case 3: //3 significa arriba
			posXEsquina1= pp.getEsquina(1)[0];
			posYEsquina1= pp.getEsquina(1)[1] - 1;
			posXEsquina2= pp.getEsquina(2)[0];
			posYEsquina2= pp.getEsquina(2)[1] - 1;
			movimientoDisponible= pixelDisponible(posXEsquina1, posYEsquina1, posXEsquina2, posYEsquina2);
			break;
		}
		return movimientoDisponible;
	}
	
	public boolean movimientoPermitidoEnemigos(Enemigo e, int sd) {
		boolean movimientoDisponible= true;
		int posXEsquina1, posYEsquina1;
		int posXEsquina2, posYEsquina2;
		switch (sd) {
		case 0: //0 significa derecha
			posXEsquina1= e.getEsquina(2)[0] + 1;
			posYEsquina1= e.getEsquina(2)[1];
			posXEsquina2= e.getEsquina(4)[0] + 1;
			posYEsquina2= e.getEsquina(4)[1];
			movimientoDisponible= pixelDisponible(posXEsquina1, posYEsquina1, posXEsquina2, posYEsquina2);
			break;
		case 1: //1 significa abajo
			posXEsquina1= e.getEsquina(3)[0];
			posYEsquina1= e.getEsquina(3)[1] + 1;
			posXEsquina2= e.getEsquina(4)[0];
			posYEsquina2= e.getEsquina(4)[1] + 1;
			movimientoDisponible= pixelDisponible(posXEsquina1, posYEsquina1, posXEsquina2, posYEsquina2);
			break;
		case 2: //2 significa izquierda
			posXEsquina1= e.getEsquina(1)[0] - 1;
			posYEsquina1= e.getEsquina(1)[1];
			posXEsquina2= e.getEsquina(3)[0] - 1;
			posYEsquina2= e.getEsquina(3)[1];
			movimientoDisponible= pixelDisponible(posXEsquina1, posYEsquina1, posXEsquina2, posYEsquina2);
			break;
		case 3: //3 significa arriba
			posXEsquina1= e.getEsquina(1)[0];
			posYEsquina1= e.getEsquina(1)[1] - 1;
			posXEsquina2= e.getEsquina(2)[0];
			posYEsquina2= e.getEsquina(2)[1] - 1;
			movimientoDisponible= pixelDisponible(posXEsquina1, posYEsquina1, posXEsquina2, posYEsquina2);
			break;
		}
		return movimientoDisponible;
	}

	public void acomodarEntidadDinamica (int ed, Entidad pared) {
		boolean listo= false;
		switch (ed) {
		case 0:
			personajePrincipal.acomodar(pared);
			break;
		case 1:
			Zonas zonasActuales [];
			for (Enemigo enemy: listaEnemigos) {
				zonasActuales= enemy.getZonasPertenecientes();
				int i= 0;
				while (i< zonasActuales.length && !listo) {
					if (zonasActuales[i].hayColision(enemy, pared)) {
						listo= true;
						enemy.acomodar(pared);
					}
					else 
						i++;
				}
			}
		}
				
	}
	
	public int [] getPosicionPersonajePrincipal(){
		int arr[] = new int[2];
		arr[0] = personajePrincipal.getPosX();
		arr[1] = personajePrincipal.getPosY();
		return arr;
	}
	
	public Nivel getNivel() {
		return nivelActual;
	}
	
	public Zonas calcularEsquinaZona (int posX, int posY) {
		return getZonas(posX/constanteZonas, posY/constanteZonas);
	}
	
	public synchronized void actualizarZonaPerteneciente(EntidadDinamica e) {
		Zonas[] zonasAntiguas = e.getZonasPertenecientes();
		
		//____Esquina superior izquierda____
		Zonas zonaEsquina = calcularEsquinaZona(e.getPosX(), e.getPosY());
		if (zonasAntiguas[0] != zonaEsquina) {
			zonasAntiguas[0].eliminarEntidad(e);
			zonaEsquina.agregarEntidad(e);
			e.setZonasPertenecientes(0, zonaEsquina);
		}
		
		//____Esquina superior derecha____
		zonaEsquina = calcularEsquinaZona(e.getPosX() + e.getAncho()-1, e.getPosY());
		if (zonasAntiguas[1] != zonaEsquina) {
			zonasAntiguas[1].eliminarEntidad(e);
			zonaEsquina.agregarEntidad(e);
			e.setZonasPertenecientes(1, zonaEsquina);
		}
		
		//____Esquina inferior izquierda____
		zonaEsquina = calcularEsquinaZona(e.getPosX(), e.getPosY() + e.getAlto()-1);
		if (zonasAntiguas[2] != zonaEsquina) {
			zonasAntiguas[2].eliminarEntidad(e);
			zonaEsquina.agregarEntidad(e);
			e.setZonasPertenecientes(2, zonaEsquina);
		}
		
		//____Esquina inferior derecha____
		zonaEsquina = calcularEsquinaZona(e.getPosX() + e.getAncho()-1, e.getPosY() + e.getAlto()-1);
		if (zonasAntiguas[3] != zonaEsquina) {
			zonasAntiguas[3].eliminarEntidad(e);
			zonaEsquina.agregarEntidad(e);
			e.setZonasPertenecientes(3, zonaEsquina);
		}
	}

	public void cambiarEstadoDeEnemigosHuir() {
		for (Enemigo e: listaEnemigos)
			e.cambiarAHuir();
	}
	
	public void cambiarEstadoDeEnemigosPerseguir() {
		for (Enemigo e: listaEnemigos)
			e.cambiarAPerseguir();
	}
	
	public void pacManFueComido() {
		for (Enemigo e: listaEnemigos)
			e.irACasa();

		personajePrincipal.irACasa();
		miJuego.restarUnaVida();
	}
	
	//____Metodos Privados____
	private synchronized boolean pixelDisponible(int posX1, int posY1, int posX2, int posY2) {
		boolean esquina1Disponible;
		boolean esquina2Disponible;
		esquina1Disponible= matrizZonas[(posY1)/(160)][(posX1)/(160)].pixelDisponible(posX1, posY1);
		esquina2Disponible= matrizZonas[(posY2)/(160)][(posX2)/(160)].pixelDisponible(posX2, posY2);
		return esquina1Disponible && esquina2Disponible;
	}
	
	public int getSegundoActual() {
		return miJuego.getSegundoActual();
	}
}
