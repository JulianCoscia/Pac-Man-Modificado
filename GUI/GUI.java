package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Logica.Juego;


@SuppressWarnings("serial")
public class GUI extends JFrame {

	private Contenedor contenedorJuego;
	private JPanel contentPane;
	private Juego miJuego;
	
	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("PacMan Modificado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 679);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel puntaje = new JLabel("Puntaje:");
		puntaje.setForeground(Color.WHITE);
		puntaje.setBounds(670, 22, 200, 140);
		contentPane.add(puntaje);
		
		JLabel vidas = new JLabel("Vidas:");
		vidas.setForeground(Color.WHITE);
		vidas.setBounds(670, 44, 200, 140);
		contentPane.add(vidas);
		
		
		String [] arr = new String[2];
		arr[0] = "Tematica Mario Bros";
		arr[1] = "Tematica Naruto";
		int respuesta = 0;
		
		respuesta = JOptionPane.showOptionDialog(null, "Elija una tematica para el videojuego:", "Tematica", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, arr, 0);

		if (respuesta == -1)//(Cuando se cierra la ventana con la x, devuelve -1)
			respuesta = 0;
		
		contenedorJuego= new Contenedor (this);	
		Juego j=new Juego (this, contenedorJuego, respuesta);
		this.miJuego= j;
		ActionListener l1 =new ActionListener(){
	        public void actionPerformed(ActionEvent ae){
	        	puntaje.setText("Puntaje: " + miJuego.getPuntaje());
	        	vidas.setText("Vidas: "+ miJuego.vidasRestantes());
	        }
	    };
        Timer t1 = new Timer(100,l1);
        t1.start();
        
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(GUI.class.getResource("/images/Background.png")));
		background.setBounds(0, 0, 800, 679);
		contentPane.add(background);
		contentPane.repaint();
	}
	
	
	public JPanel getContentPane () {
		return contentPane;
	}


	public void mostrarCartel(int p, int seg, int gano) {
		String s;
		if (gano== 0)
			s= "GAME OVER. Su puntaje es de: " + p + ". Duracion de la partida: " +seg+" segundos.";
		else 
			s= "HAS GANADO!. Su puntaje es de: " + p + ". Duracion de la partida: " + seg+" segundos.";
		miJuego.detenerJuego();
		JOptionPane.showMessageDialog(contentPane, s, "Juego terminado", 1);
		System.exit(1);		
	}
	
}
