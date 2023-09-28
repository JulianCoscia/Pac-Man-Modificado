package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
	public GUI(int tematica) {		
		setTitle("PacMan Modificado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 679);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nombreHighScore = new JLabel("");
		nombreHighScore.setForeground(Color.WHITE);
		nombreHighScore.setHorizontalAlignment(SwingConstants.CENTER);
		nombreHighScore.setVerticalAlignment(SwingConstants.CENTER);
		nombreHighScore.setBounds(680, 22, 72, 18);
		contentPane.add(nombreHighScore);
		
		JLabel puntajeHighScore = new JLabel("");
		puntajeHighScore.setForeground(Color.WHITE);
		puntajeHighScore.setFont(new Font("Gadugi", 1, 14));
		puntajeHighScore.setHorizontalAlignment(SwingConstants.CENTER);
		puntajeHighScore.setVerticalAlignment(SwingConstants.CENTER);
		puntajeHighScore.setBounds(660, 35, 115, 35);
		contentPane.add(puntajeHighScore);
		
		JLabel puntaje = new JLabel("Puntaje:");
		puntaje.setForeground(Color.WHITE);
		puntaje.setBounds(670, 92, 100, 18);
		contentPane.add(puntaje);
		
		JLabel vidas = new JLabel("Vidas:");
		vidas.setForeground(Color.WHITE);
		vidas.setBounds(670, 115, 100, 18);
		contentPane.add(vidas);
		
		contenedorJuego= new Contenedor (this);	
		Juego j=new Juego (this, contenedorJuego, tematica);
		this.miJuego= j;
		ActionListener l1 =new ActionListener(){
	        public void actionPerformed(ActionEvent ae){
	        	puntaje.setText("Puntaje: " + miJuego.getPuntaje());
	        	vidas.setText("Vidas: "+ miJuego.vidasRestantes());
	        }
	    };
        Timer t1 = new Timer(100,l1);
        t1.start();
        
        //Establece el puntaje High Score
	    String[] highScore = miJuego.getPuntajeMaximo();
	    nombreHighScore.setText(highScore[0]);
	    puntajeHighScore.setText(highScore[1]);
        
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(GUI.class.getResource("/images/Background.png")));
		background.setBounds(0, 0, 800, 679);
		contentPane.add(background);
		contentPane.repaint();
	}
	
	
	public JPanel getContentPane () {
		return contentPane;
	}

	public void mostrarMensajeFinDeJuego(int p, int seg, int gano) {
		String s;
		if (gano== 0)
			s= "GAME OVER. Su puntaje es de: " + p + " y la duracion de la partida fue de: " +seg+" segundos.\nIngrese su nombre:";
		else 
			s= "HAS GANADO!. Su puntaje es de: " + p + " y la duracion de la partida: " + seg+" segundos.\nIngrese su nombre:";
		miJuego.detenerJuego();
		//INPUT DIALOG Y PASAR EL NUEVO JUGADOR A JUEGO Y DESPUES CREAR EL NUEV CARTEL DE FINALIZAR Y LISTO. REEMPLAZAR EL NUEVO POR EL IMPUT Y CHAU. NUEVO FRAME
		String nombre = JOptionPane.showInputDialog(s);
		miJuego.guardarNuevoPuntaje(nombre);
		System.exit(1);		
	}
	
}
