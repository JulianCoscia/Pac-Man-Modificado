package Entidades;

import Grafica.EntidadDinamicaGrafica;
import Logica.Grilla;
import Logica.Zonas;
import Visitor.Visitor;
import Visitor.VisitorPersonajePrincipal;

public class PersonajePrincipal extends EntidadDinamica {
	protected int sentidoDeseado;
	protected int velocidad;
	protected int PosicionCasaX;
	protected int PosicionCasaY;
	protected static final int velocidadInicial= 3;
	
	
	public PersonajePrincipal (int posX, int posY, EntidadDinamicaGrafica representacionPP, Grilla grilla) {
		ancho= 32;
		alto= 32;
		this.posX= posX;
		this.posY= posY;
		rotacion= DERECHA;
		sentidoDeseado= DERECHA;
		velocidad= velocidadInicial;
		miRepresentacion= representacionPP;
		miRepresentacion.crearLabel(this.posX, this.posY, ancho, alto);
		miGrilla = grilla;
		PosicionCasaX = posX;
		PosicionCasaY = posY;
		miVisitor = new VisitorPersonajePrincipal();
		zonasPertenecientes = new Zonas[4];
		asignarZonas();
	}
	
	public void activarCambioDeEstadoGrafico(int s) {
		miRepresentacion.cambiarDeEstado(s);
	}
	
	public void mover () {
		int pixelesAvanzados=0;
		int rotacionAux= rotacion;
		boolean puedeDoblar= false;
		switch (sentidoDeseado) {
		case DERECHA:
			//Tengo que comprobar que si es posible mover hacia el sentido deseado
			if (posX + ancho - 1 + velocidad <= ancho*20)
				while (pixelesAvanzados< velocidad && !puedeDoblar) {
					if (movimientoLibre()) {
						rotacion= sentidoDeseado;
						puedeDoblar= true;
					}
					else {
						avanzarPos();
						pixelesAvanzados++;
					}
				}
			break;
		case ABAJO:
			//Tengo que comprobar que si es posible mover hacia el sentido deseado
			if (posY + alto - 1 + velocidad <= ancho*20)
				while (pixelesAvanzados< velocidad && !puedeDoblar) {
					if (movimientoLibre()) {
						rotacion= sentidoDeseado;
						puedeDoblar= true;
					}
					else {
						avanzarPos();
						pixelesAvanzados++;
					}
				}
			break;
		case IZQUIERDA:
			//Tengo que comprobar que si es posible mover hacia el sentido deseado
			if (posX - velocidad >= 0)
				while (pixelesAvanzados< velocidad && !puedeDoblar) {
					if (movimientoLibre()) {
						rotacion= sentidoDeseado;
						puedeDoblar= true;
					}
					else {
						avanzarPos();
						pixelesAvanzados++;
					}
				}
			break;
		case ARRIBA:
			//Tengo que comprobar que si es posible mover hacia el sentido deseado
			if (posY - velocidad >= 0)
				while (pixelesAvanzados< velocidad && !puedeDoblar) {
					if (movimientoLibre()) {
						rotacion= sentidoDeseado;
						puedeDoblar= true;
					}
					else {
						avanzarPos();
						pixelesAvanzados++;
					}
				}
			break;
		}
		retrocederPos(pixelesAvanzados, rotacionAux);
		int diferencia= velocidad - pixelesAvanzados;
		if (puedeDoblar) {
			switch (rotacionAux) {
			case DERECHA: 
				if (posX + ancho - 1 + velocidad <= ancho*20) {
					posX += pixelesAvanzados;
				}
				break;
			case ABAJO:
				if (posY + alto - 1 + velocidad <= alto*20) {
					posY += pixelesAvanzados;
				}
				break;
			case IZQUIERDA: 
				if (posX - velocidad >= 0) {
					posX -= pixelesAvanzados;
				}
				break;
			case ARRIBA: 
				if (posY - velocidad >= 0) {
					posY -= pixelesAvanzados;
				}
				break;
			}
		}
		switch (rotacion) {
		case DERECHA: 
			if (posX + ancho - 1 + velocidad <= ancho*20) {
				if (puedeDoblar) {
					posX += diferencia;
					miGrilla.chequearColisiones(this);
					miRepresentacion.actualizar (posX, posY, ancho, alto, rotacion);
				}
				else {
					posX += velocidad;
					miGrilla.chequearColisiones(this);
					miRepresentacion.actualizar (posX, posY, ancho, alto, rotacion);
				}
			}
			break;
		case ABAJO:
			if (posY + alto - 1 + velocidad <= alto*20) {
				if (puedeDoblar) {
					posY += diferencia;
					miGrilla.chequearColisiones(this);
					miRepresentacion.actualizar (posX, posY, ancho, alto, rotacion);
				}
				else {
				posY += velocidad;
				miGrilla.chequearColisiones(this);
				miRepresentacion.actualizar (posX, posY, ancho, alto, rotacion);
				}
			}
			break;
		case IZQUIERDA: 
			if (posX - velocidad >= 0) {
				if (puedeDoblar) {
					posX -= diferencia;
					miGrilla.chequearColisiones(this);
					miRepresentacion.actualizar (posX, posY, ancho, alto, rotacion);
				}
				else {
					posX -= velocidad;
					miGrilla.chequearColisiones(this);
					miRepresentacion.actualizar (posX, posY, ancho, alto, rotacion);
				}
			}
			break;
		case ARRIBA: 
			if (posY - velocidad >= 0) {
				if (puedeDoblar) {
					posY -= diferencia;
					miGrilla.chequearColisiones(this);
					miRepresentacion.actualizar (posX, posY, ancho, alto, rotacion);
				}
				else {
					posY -= velocidad;
					miGrilla.chequearColisiones(this);
					miRepresentacion.actualizar (posX, posY, ancho, alto, rotacion);
				}
			}
			break;
		}
	}

	public void irACasa() {
		posX = PosicionCasaX;
		posY = PosicionCasaY;
	}
	
	private void avanzarPos() {
		switch (rotacion) {
		case DERECHA:
			posX += 1;
			break;
		case ABAJO:
			posY += 1;
			break;
		case IZQUIERDA:
			posX -= 1;
			break;
		case ARRIBA:
			posY -= 1;
			break;
		}
	}
	
	private void retrocederPos(int i, int rotacionAux) {
		switch (rotacionAux) {
		case DERECHA:
			posX -= i;
			break;
		case ABAJO:
			posY -= i;
			break;
		case IZQUIERDA:
			posX += i;
			break;
		case ARRIBA:
			posY += i;
			break;
		}
	}

	private synchronized boolean movimientoLibre() {
		boolean movimientoPermitido= miGrilla.movimientoPermitido(this);
		return movimientoPermitido;
	}
	
	private void asignarZonas() {
		for (int i = 0; i < 4; i++) {
			int [] arr = this.getEsquina(i);
			zonasPertenecientes[i] = miGrilla.getZonas(arr[0]/160, arr[1]/160);
		}
	}

	public void setSentidoDeseado(int s) {
		sentidoDeseado= s;
	}
	
	public int getSentidoDeseado () {
		return sentidoDeseado;
	}
	
	public void accept (Visitor v) {
		v.visit(this);
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void resetearVelocidad() {
		setVelocidad (velocidadInicial);
	}
	
	public boolean entidadPared () {
		return false;
	}

}
