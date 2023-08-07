package GUI;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Contenedor extends JPanel{

	private JPanel contenedorJuego;
	
	public Contenedor (GUI miGui) {
		contenedorJuego = new JPanel();
		contenedorJuego.setBounds(0, 0, 640, 640);
		miGui.getContentPane().add(contenedorJuego);
		contenedorJuego.setLayout(null);
		contenedorJuego.setBackground(Color.BLUE);
	}

	public JPanel getContenedorJuego () {
		return contenedorJuego;
	}
	
	public void resetearContenedor () {
		contenedorJuego.removeAll();
		contenedorJuego.setBackground(null);
	}
	
	public void iniciarNuevoContenedor() {
		contenedorJuego.setLayout(null);
		contenedorJuego.setBackground(Color.BLUE);
		contenedorJuego.repaint();
	}
	
}