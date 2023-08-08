package EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import GUI.Contenedor;
import Grafica.EntidadDinamicaGrafica;

public class PersonajePrincipalGrafico extends EntidadDinamicaGrafica{
	
	public PersonajePrincipalGrafico (Contenedor miContenedor, String[] rotaciones, String[] afectado) {
		this.miContenedor= miContenedor;
		rotacion= 0;
		estado= 0;
		miLabel= new JLabel();
		imagenes= new ImageIcon[2][4];
		
		if (rotaciones != null) {
			imagenes[0][0]= new ImageIcon(this.getClass().getResource(rotaciones[0]));
			imagenes[0][1]= new ImageIcon(this.getClass().getResource(rotaciones[1]));
			imagenes[0][2]= new ImageIcon(this.getClass().getResource(rotaciones[2]));
			imagenes[0][3]= new ImageIcon(this.getClass().getResource(rotaciones[3]));
			
			imagenes[1][0] = new ImageIcon(this.getClass().getResource(afectado[0]));
			imagenes[1][1] = new ImageIcon(this.getClass().getResource(afectado[1]));
			imagenes[1][2] = new ImageIcon(this.getClass().getResource(afectado[2]));
			imagenes[1][3] = new ImageIcon(this.getClass().getResource(afectado[3]));
		}
		
	}
	
	public ImageIcon getImagen () {
		return imagenes[estado][rotacion];
	}
	
	public void crearLabel(int posX, int posY, int ancho, int alto) {
		miLabel.setIcon(getImagen());
		miLabel.setBounds(posX, posY, ancho, alto);
		miContenedor.getContenedorJuego().add(miLabel);
	}
	
	public void actualizar(int posX, int posY, int ancho, int alto, int rotacion) {
		this.rotacion= rotacion;
		miLabel.setIcon(getImagen());
		miLabel.setBounds(posX, posY, ancho, alto);
	}

}
