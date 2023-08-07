package EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Contenedor;
import Grafica.EntidadEstaticaGrafica;

public class ExplosionGrafica extends EntidadEstaticaGrafica{

	public ExplosionGrafica(Contenedor miContenedor, String url) {
		miLabel= new JLabel ();
		this.miContenedor= miContenedor;
		imagen = new ImageIcon(this.getClass().getResource(url));
	}
	@Override
	public void crearLabel(int posX, int posY, int ancho, int alto) {
		miLabel.setIcon(imagen);
		miLabel.setBounds(posX, posY, ancho, alto);
		miContenedor.getContenedorJuego().add(miLabel);	}

	@Override
	public void eliminarImagen() {
		miLabel.setIcon(null);
	}
	
	public void cambiarImagen() {
		miLabel.setIcon(new ImageIcon (this.getClass().getResource("/images/Explosion.png")));
	}
	

}
