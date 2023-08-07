package EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Contenedor;
import Grafica.EntidadEstaticaGrafica;

public class PowerPelletsGrafica extends EntidadEstaticaGrafica {

	public PowerPelletsGrafica(Contenedor miContenedor, String url) {
		this.miContenedor= miContenedor;
		miLabel= new JLabel ();
		imagen = new ImageIcon(this.getClass().getResource(url));
	}
	
	public ImageIcon getImagen() {
		return imagen;
	}
	
	public void crearLabel(int posX, int posY, int ancho, int alto) {
		miLabel.setIcon(imagen);
		miLabel.setBounds(posX, posY, ancho, alto);
		miContenedor.getContenedorJuego().add(miLabel);
	}

	@Override
	public void eliminarImagen() {
		miLabel.setIcon(null);
	}
	
	public void cambiarImagen() {
		
	}
	
}
