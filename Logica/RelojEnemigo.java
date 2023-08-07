package Logica;

public class RelojEnemigo extends Thread{
	protected boolean activo;		
	protected int step;				
	protected Juego miJuego;	
	protected int vueltasDadas;
	protected int topeVueltasReloj;
	protected boolean temporizadorActivo;
	
	public RelojEnemigo (Juego j) {
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
				miJuego.moverEnemigo();
			}
			catch (InterruptedException e) {}
		}
	}

	public void setStep(int s) {
		step= s;
	}
	
}//Fin de reloj
