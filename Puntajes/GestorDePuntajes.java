package Puntajes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GestorDePuntajes {
//-------------Falta usar estas clases en el juego y mostrar los higscores. modificar la imagen de background
	private static final String RUTA_ARCHIVO = "src/Puntajes/Puntajes.txt";
	private final File archivo; 
	
	
	//_----------------Cambie los metodos de gpt le borre los static para reemplazar el NOmbreArchivo por el file. Capaz falta un fileOpen algo de eso
	
	public GestorDePuntajes() {
		archivo = new File(RUTA_ARCHIVO);
	}
	
	
	/**
	 * Guarda en un archivo de texto los datos obtenidos por un jugador.
	 * @param jugador Jugador actual.
	 */
    public void guardarPuntaje(Jugador jugador) { 	
    	List<Jugador> puntajes = cargarPuntajes();
        puntajes.add(jugador);
        Collections.sort(puntajes, Collections.reverseOrder(Comparator.comparingInt(Jugador::getPuntaje)));

        //NO ORDENA TODOS LOS PUNTAJES. CUANDO SE GUARDA UN PUNTAJE NUEVO.
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(jugador.getNombre() + "," + jugador.getPuntaje() + "," + jugador.getTiempoJugado());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga todos los puntajes historicos al sistema.
     * @return Lista con los datos de las partidas de todos los jugadores.
     */
    public List<Jugador> cargarPuntajes() {
        List<Jugador> puntajes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            
            //Lee una linea, la asigna a la variable y luego evalua si es distinta de null.
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String nombre = datos[0];
                    int puntaje = Integer.parseInt(datos[1]);
                    int tiempoSegundos = Integer.parseInt(datos[2]);
                    Jugador jugador = new Jugador(nombre, puntaje, tiempoSegundos);
                    puntajes.add(jugador);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return puntajes;
    }
    
    public Jugador jugadorConMayorPuntajeActual() {
    	Jugador salida = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea = reader.readLine();
            
	                String[] datos = linea.split(",");
	                if (datos.length == 3) {
	                    String nombre = datos[0];
	                    int puntaje = Integer.parseInt(datos[1]);
	                    int tiempoSegundos = Integer.parseInt(datos[2]);
	                    salida = new Jugador(nombre, puntaje, tiempoSegundos);
                }            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return salida;
    }
}
