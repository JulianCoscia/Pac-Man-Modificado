package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Contenedor;

public abstract class EntidadDinamicaGrafica {

	protected ImageIcon imagenes[][];
	protected int rotacion;
	protected int estado;
	protected Contenedor miContenedor;
	protected JLabel miLabel;
	
	public abstract void crearLabel (int posX, int posY, int ancho, int alto);
	public abstract void actualizar(int posX, int posY, int ancho, int alto, int rotacion);
	
	public void cambiarDeEstado(int e) {
		estado = e;
	}
}
