package Puntajes;

public class Jugador {
	private int puntaje;
	private int tiempoJugado;
	private String nombre;
	
	/**
	 * Crea un nuevo perfil para un jugador
	 * @param puntaje Puntaje obtenido durante la partida.
	 * @param tiempoJugado Tiempo de juego.
	 * @param nombre Nombre del jugador.
	 */
	public Jugador(String nombre, int puntaje, int tiempoJugado) {
		this.nombre = nombre;
		this.puntaje = puntaje;
		this.tiempoJugado = tiempoJugado;
	}
	
	//__________Getters___________
	/**
	 * Devuelve el puntaje obtenido durante la partida por el jugador.
	 * @return Puntaje del jugador.
	 */
	public int getPuntaje() {
		return puntaje;
	}
	
	/**
	 * Devuelve el nombre del jugador actual.
	 * @return Nombre del jugador.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devuelve la cantidad de segundos que el jugador jugó.
	 * @return Tiempo de juego.
	 */
	public int getTiempoJugado() {
		return tiempoJugado;
	}
}
