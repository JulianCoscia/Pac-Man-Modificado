package EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Contenedor;
import Grafica.EntidadDinamicaGrafica;

public class PersonajePrincipalGraficoAnimado extends EntidadDinamicaGrafica{
	
	int imagenAnimada;
	
	/**
	 * Constructor.
	 * @param miContenedor Contenedor de graficos.
	 * @param animacion Direcciones de las imagenes animadas del personaje.
	 */
	public PersonajePrincipalGraficoAnimado(Contenedor miContenedor, String[][] animacion) {
		this.miContenedor= miContenedor;
		rotacion= 0;		
		imagenAnimada = 0;
		
		miLabel= new JLabel();
		imagenes=new ImageIcon[animacion.length][animacion[0].length];

		
		for (int i = 0; i < animacion.length; i++) {
			for (int j = 0; j < animacion[0].length; j++) {
				imagenes[i][j] = new ImageIcon(this.getClass().getResource(animacion[i][j]));
			}
		}
	}
	
//____________________Operaciones____________________
	
	public ImageIcon getImagen () {
		return imagenes[0][rotacion];
	}
	
	public void crearLabel(int posX, int posY, int ancho, int alto) {
		miLabel.setIcon(getImagen());
		miLabel.setBounds(posX, posY, ancho, alto);
		miContenedor.getContenedorJuego().add(miLabel);
	}
	
	public void actualizar(int posX, int posY, int ancho, int alto, int rotacion) {
		this.rotacion= rotacion;
		
		miLabel.setIcon(imagenes[rotacion][imagenAnimada]);
		imagenAnimada++;
		
		if(imagenAnimada == imagenes[rotacion].length) {
			imagenAnimada=0;
		}
		
		miLabel.setBounds(posX, posY, ancho, alto);
		miLabel.repaint();
	}
	
}