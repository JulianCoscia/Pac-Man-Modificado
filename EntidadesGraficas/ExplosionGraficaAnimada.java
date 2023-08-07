package EntidadesGraficas;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Contenedor;
import Grafica.EntidadEstaticaGrafica;

public class ExplosionGraficaAnimada extends EntidadEstaticaGrafica{

	private ImageIcon[] imagenes;
	
	public ExplosionGraficaAnimada(Contenedor miContenedor) {
		miLabel= new JLabel ();
		this.miContenedor= miContenedor;
		imagenes=new ImageIcon[4];
		for (int i=0;i<imagenes.length;i++) {
			imagenes[i]=new ImageIcon();
		}
		imagenes[0]=new ImageIcon(this.getClass().getResource("/images/ExplosionNaruto1.png"));
		imagenes[1]=new ImageIcon(this.getClass().getResource("/images/ExplosionNaruto2.png"));
		imagenes[2]=new ImageIcon(this.getClass().getResource("/images/ExplosionNaruto3.png"));
		imagenes[3]=new ImageIcon(this.getClass().getResource("/images/ExplosionNaruto4.png"));
	}

	@Override
	public void crearLabel(int posX, int posY, int ancho, int alto) {
		// TODO Auto-generated method stub
		imagen=new ImageIcon(this.getClass().getResource("/images/KunaiExplosiva.png"));
		miLabel.setIcon(imagen);
		miLabel.setBounds(posX, posY, ancho, alto);
		miContenedor.getContenedorJuego().add(miLabel);
	}

	@Override
	public void eliminarImagen() {
		imagenes[0]=null;
		imagenes[1]=null;
		imagenes[2]=null;
		imagenes[3]=null;
		miLabel.setIcon(null);
	}

	@Override
	public void cambiarImagen() {
Timer timer=new Timer();
		
		TimerTask task=new TimerTask() {
			int numimagen=0;
			@Override
			public void run() {
				numimagen++;
				miLabel.setIcon(imagenes[numimagen]);
				if(numimagen==3) {
					numimagen=0;
				}
			}
			
		};
		timer.scheduleAtFixedRate(task, 100, 200);
		
	}

}
