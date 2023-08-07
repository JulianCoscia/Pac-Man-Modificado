package Logica;

public class Cronometro extends Thread {
	
	protected boolean activo;		
	protected int step;				
	protected Juego miJuego;	
	protected int vueltasDadas;
	
	public Cronometro (Juego j) {
		activo = true;
		miJuego = j;
		step= 1000;
		vueltasDadas= 0;
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
				vueltasDadas++;
			}
			catch (InterruptedException e) {}
		}
	}
	
	public int getSegundosTranscurridos () {
		return vueltasDadas;
	}

}
