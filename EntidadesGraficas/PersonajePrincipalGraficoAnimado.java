package EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Contenedor;
import Grafica.EntidadDinamicaGrafica;

public class PersonajePrincipalGraficoAnimado extends EntidadDinamicaGrafica{

	private int derecha;
	private int arriba;
	private int abajo;
	private int izquierda;
	
	public PersonajePrincipalGraficoAnimado(Contenedor miContenedor) {
		this.miContenedor= miContenedor;
		rotacion= 0;
	//	movimiento= 0;
		
		derecha=0;
		arriba=16;
		abajo=24;
		izquierda=8;
		
		miLabel= new JLabel();
		imagenes=new ImageIcon[12][32];

		imagenes[0][0]=new ImageIcon(this.getClass().getResource("/images/narutoder1.png"));
		imagenes[0][1]=new ImageIcon(this.getClass().getResource("/images/narutoder2.png"));
		imagenes[0][2]=new ImageIcon(this.getClass().getResource("/images/narutoder3.png"));
		imagenes[0][3]=new ImageIcon(this.getClass().getResource("/images/narutoder4.png"));
		imagenes[0][4]=new ImageIcon(this.getClass().getResource("/images/narutoder5.png"));
		imagenes[0][5]=new ImageIcon(this.getClass().getResource("/images/narutoder6.png"));
		imagenes[0][6]=new ImageIcon(this.getClass().getResource("/images/narutoder7.png"));
		imagenes[0][7]=new ImageIcon(this.getClass().getResource("/images/narutoder8.png"));

		imagenes[0][8]=new ImageIcon(this.getClass().getResource("/images/narutoizq1.png"));
		imagenes[0][9]=new ImageIcon(this.getClass().getResource("/images/narutoizq2.png"));
		imagenes[0][10]=new ImageIcon(this.getClass().getResource("/images/narutoizq3.png"));
		imagenes[0][11]=new ImageIcon(this.getClass().getResource("/images/narutoizq4.png"));
		imagenes[0][12]=new ImageIcon(this.getClass().getResource("/images/narutoizq5.png"));
		imagenes[0][13]=new ImageIcon(this.getClass().getResource("/images/narutoizq6.png"));
		imagenes[0][14]=new ImageIcon(this.getClass().getResource("/images/narutoizq7.png"));
		imagenes[0][15]=new ImageIcon(this.getClass().getResource("/images/narutoizq8.png"));

		imagenes[0][16]=new ImageIcon(this.getClass().getResource("/images/narutoarr1.png"));
		imagenes[0][17]=new ImageIcon(this.getClass().getResource("/images/narutoarr2.png"));
		imagenes[0][18]=new ImageIcon(this.getClass().getResource("/images/narutoarr3.png"));
		imagenes[0][19]=new ImageIcon(this.getClass().getResource("/images/narutoarr4.png"));
		imagenes[0][20]=new ImageIcon(this.getClass().getResource("/images/narutoarr5.png"));
		imagenes[0][21]=new ImageIcon(this.getClass().getResource("/images/narutoarr6.png"));
		imagenes[0][22]=new ImageIcon(this.getClass().getResource("/images/narutoarr7.png"));
		imagenes[0][23]=new ImageIcon(this.getClass().getResource("/images/narutoarr8.png"));

		imagenes[0][24]=new ImageIcon(this.getClass().getResource("/images/narutoaba1.png"));
		imagenes[0][25]=new ImageIcon(this.getClass().getResource("/images/narutoaba2.png"));
		imagenes[0][26]=new ImageIcon(this.getClass().getResource("/images/narutoaba3.png"));
		imagenes[0][27]=new ImageIcon(this.getClass().getResource("/images/narutoaba4.png"));
		imagenes[0][28]=new ImageIcon(this.getClass().getResource("/images/narutoaba5.png"));
		imagenes[0][29]=new ImageIcon(this.getClass().getResource("/images/narutoaba6.png"));
		imagenes[0][30]=new ImageIcon(this.getClass().getResource("/images/narutoaba7.png"));
		imagenes[0][31]=new ImageIcon(this.getClass().getResource("/images/narutoaba8.png"));

//		imagenes[0][3]=new ImageIcon(this.getClass().getResource("/images/gatoarr1.png"));
//		imagenes[0][4]=new ImageIcon(this.getClass().getResource("/images/gatoarr2.png"));
//		imagenes[0][5]=new ImageIcon(this.getClass().getResource("/images/gatoarr3.png"));
//		
//		imagenes[0][6]=new ImageIcon(this.getClass().getResource("/images/gato1.png"));
//		imagenes[0][7]=new ImageIcon(this.getClass().getResource("/images/gato2.png"));
//		imagenes[0][8]=new ImageIcon(this.getClass().getResource("/images/gato3.png"));
//		
//		imagenes[0][9]=new ImageIcon(this.getClass().getResource("/images/gatoizq1.png"));
//		imagenes[0][10]=new ImageIcon(this.getClass().getResource("/images/gatoizq2.png"));
//		imagenes[0][11]=new ImageIcon(this.getClass().getResource("/images/gatoizq3.png"));
	}
	
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
		switch (rotacion) {
		case 0: 
			miLabel.setIcon(imagenes[0][derecha]);
			derecha++;
			
			if(derecha==7) {
				derecha=0;
			}
			miLabel.setBounds(posX, posY, ancho, alto);
			miLabel.repaint();
			break;
		case 1:
			miLabel.setIcon(imagenes[0][abajo]);
			abajo++;

			if(abajo==31) {
				abajo=24;
			}
			miLabel.setBounds(posX, posY, ancho, alto);
			miLabel.repaint();
			break;
		case 2: 
			miLabel.setIcon(imagenes[0][izquierda]);
			izquierda++;

			if(izquierda==15) {
				izquierda=8;
			}
			miLabel.setBounds(posX, posY, ancho, alto);
			miLabel.repaint();
			break;
		case 3: 
			miLabel.setIcon(imagenes[0][arriba]);
			arriba++;
			
			if(arriba==23) {
				arriba=16;
			}
			miLabel.setBounds(posX, posY, ancho, alto);
			miLabel.repaint();
			break;
		}
	
	}
}