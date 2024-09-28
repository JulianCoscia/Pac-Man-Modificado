package Entidades;

import State.State;

public abstract class Enemigo extends EntidadDinamica{
	protected State estado;
	protected int posicionObjetivoX;
	protected int posicionObjetivoY;
	protected int posicionCasaX;
	protected int posicionCasaY;
	protected int segundosDescanso;
	
	public State getEstado() {
		return estado;
	}
	
	public void objetivoDeseado() {
		estado.objetivoDeseado();
	}
	
	public int getPosicionObjetivoX() {
		return posicionObjetivoX;
	}
	
	public int getPosicionObjetivoY() {
		return posicionObjetivoX;
	}
	
	public void setPosicionObjetivoX(int x) {
		posicionObjetivoX = x;
	}
	
	public void setPosicionObjetivoY(int y) {
		posicionObjetivoY = y;
	}
	
	public int getSentidoDeseado() {
		return sentidoDeseado;
	}
	
	public void patronMover() {
		calcularSentidoDeseado();
		int rotacionAux= rotacion;
		int pixelesAvanzados= 0;
		boolean puedeDoblar = false;
		
		//Comprueba en cada caso si es posible mover hacia el sentido deseado
		switch (sentidoDeseado) {
		case DERECHA:
			if (posX + ancho - 1 + velocidad <= ancho*20) {
				while (pixelesAvanzados< velocidad && !puedeDoblar) {
					if (movimientoLibre(sentidoDeseado)) {
						rotacion= sentidoDeseado;
						puedeDoblar= true;
					}
					else {
						avanzarPos();
						pixelesAvanzados++;
					}
				}
			}
			break;
		case ABAJO:
			if (posY + alto - 1 + velocidad <= ancho*20)
				while (pixelesAvanzados< velocidad && !puedeDoblar) {
					if (movimientoLibre(sentidoDeseado)) {
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
			if (posX - velocidad >= 0)
				while (pixelesAvanzados< velocidad && !puedeDoblar) {
					if (movimientoLibre(sentidoDeseado)) {
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
			if (posY - velocidad >= 0)
				while (pixelesAvanzados< velocidad && !puedeDoblar) {
					if (movimientoLibre(sentidoDeseado)) {
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
			movimientoDefinitivo(puedeDoblar, diferencia);
		}
		else {
			if (movimientoLibre(rotacion)) {
				movimientoDefinitivo(puedeDoblar, diferencia);
			}
			else {
				buscarNuevoMovimiento();
				movimientoDefinitivo(puedeDoblar, diferencia);
			}
		}
		miGrilla.chequearColisiones(this);
		miRepresentacion.actualizar (posX, posY, ancho, alto, rotacion);
	}

	private void movimientoDefinitivo(boolean puedeDoblar, int diferencia) {
		switch (rotacion) {
		case DERECHA: 
			if (posX + ancho - 1 + velocidad <= ancho*20) {
				if (puedeDoblar) {
					posX += diferencia;
				}
				else {
					posX += velocidad;
				}
			}
			break;
		case ABAJO:
			if (posY + alto - 1 + velocidad <= alto*20) {
				if (puedeDoblar) {
					posY += diferencia;
				}
				else {
				posY += velocidad;
				}
			}
			break;
		case IZQUIERDA: 
			if (posX - velocidad >= 0) {
				if (puedeDoblar) {
					posX -= diferencia;
				}
				else {
					posX -= velocidad;
				}
			}
			break;
		case ARRIBA: 
			if (posY - velocidad >= 0) {
				if (puedeDoblar) {
					posY -= diferencia;
				}
				else {
					posY -= velocidad;
				}
			}
			break;
		}
	}

	private void buscarNuevoMovimiento() {
		switch (rotacion){
		case DERECHA:
			if (movimientoLibre(ABAJO))
				rotacion = ABAJO;
			else 
				if (movimientoLibre (ARRIBA))
					rotacion= ARRIBA;
				else 
					rotacion= IZQUIERDA;
			break;	
		case ABAJO:
			if (movimientoLibre(IZQUIERDA)) 
				rotacion = IZQUIERDA;
			else 
				if (movimientoLibre (DERECHA))
					rotacion= DERECHA;
				else 
					rotacion= ARRIBA;
			break;
		case IZQUIERDA:
			if (movimientoLibre(ARRIBA))
				rotacion = ARRIBA;
			else 
				if (movimientoLibre (ABAJO))
					rotacion= ABAJO;
				else 
					rotacion= DERECHA;
			break;
		case ARRIBA:
			if (movimientoLibre(DERECHA))
				rotacion = DERECHA;
			else 
				if (movimientoLibre (IZQUIERDA))
					rotacion= IZQUIERDA;
				else 
					rotacion= ABAJO;
			break;
		}
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
	
	private boolean movimientoLibre(int sd) {
		boolean movimientoPermitido= miGrilla.movimientoPermitidoEnemigos(this, sd);
		return movimientoPermitido;
	}
	
	private void calcularSentidoDeseado() {
		objetivoDeseado();
		int diferenciaX = Math.abs(posicionObjetivoX - this.posX);
		int diferenciaY = Math.abs(posicionObjetivoY - this.posY);
		int sentidoDeseadoAux= (rotacion + 2) % 4;
		//Switch (para no tener tantos ifs anidados)
		//Case diferenciaY > diferenciaX
		//if (POsY)..
		if (diferenciaY > diferenciaX && posicionObjetivoY >= this.posY)
			sentidoDeseadoAux = ABAJO;
		else
			if (diferenciaY > diferenciaX && posicionObjetivoY < this.posY)
				sentidoDeseadoAux = ARRIBA;
			else
				if (diferenciaX >= diferenciaY && posicionObjetivoX >= this.posX)
					sentidoDeseadoAux = DERECHA;
				else
					if (diferenciaX >= diferenciaY&& posicionObjetivoX < this.posX)
						sentidoDeseadoAux = IZQUIERDA;
		if ((rotacion + 2) % 4 != sentidoDeseadoAux) {
			sentidoDeseado= sentidoDeseadoAux;
		}
	}
	
	protected int[] obtenerPosicionPP() {
		int arr[] = miGrilla.getPosicionPersonajePrincipal();
		return arr;
	}
	
	public abstract void objetivoDeseadoPerseguir();
	
	public abstract void fuiComido();
	
	public abstract void irACasa();
	
	public abstract void cambiarAHuir();
	
	public abstract void cambiarAPerseguir();
	
	public abstract void comiAPacMan();
}