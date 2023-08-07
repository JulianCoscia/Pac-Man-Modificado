package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Contenedor;

public abstract class EntidadEstaticaGrafica{

	protected Contenedor miContenedor;
	protected ImageIcon imagen;
	protected JLabel miLabel;
	
	public ImageIcon getImagen() {
		return imagen;
	}
	
	public abstract void crearLabel(int posX, int posY, int ancho, int alto);
	
	public abstract void eliminarImagen();
	
	public abstract void cambiarImagen();
}
