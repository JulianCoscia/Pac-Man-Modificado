package Logica;

public class Reloj extends Thread{
	protected boolean activo;		
	protected int step;				
	protected Juego miJuego;	
	protected int vueltasDadas;
	protected int topeVueltasReloj;
	protected boolean temporizadorActivo;
	
	public Reloj (Juego j) {
		activo = true;
		miJuego = j;
		step= 20;
		temporizadorActivo= false;
	}
	
	public void detener() {
		activo = false;
	}
	
	public void iniciar() {
		activo = true;
	}
	
	public void run() {
		while(activo) {
			try {
				Thread.sleep(step);
				miJuego.moverPersonajePrincipal();
				if (temporizadorActivo) {
					vueltasDadas++;
					chequearTemporizador();
				}
			}
			catch (InterruptedException e) {}
		}
	}

	private void chequearTemporizador() {
		if (vueltasDadas== topeVueltasReloj) {
			temporizadorActivo= false;
			miJuego.resetearVelocidadPP();
			miJuego.cambiarEnemigosAPerseguir();
		}
	}

	public void iniciarTemporizador(double tiempo) {
		temporizadorActivo= true;
		topeVueltasReloj = (int) ((tiempo*1000) / step);
		vueltasDadas= 0;
		if (vueltasDadas== topeVueltasReloj) {
			temporizadorActivo= false;
		}
	}

	public void setStep(int i) {
		step= i;
	}
	
}//Fin de reloj
