package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaInicial extends JFrame {

	private JPanel contentPane;
	private int tematicaSeleccionada;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VentanaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 520);
		setTitle("Pac-Man Modificado");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Creado por "+"\n"+ "Julian Coscia");
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 28));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 436, 504, 45);
		contentPane.add(lblNewLabel_1);
		
		JComboBox CBTematica = new JComboBox();
		CBTematica.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		CBTematica.setForeground(Color.DARK_GRAY);
		CBTematica.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una tem\u00E1tica", "Mario Bros", "Naruto"}));
		CBTematica.setBounds(158, 164, 185, 22);
		contentPane.add(CBTematica);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CBTematica.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(btnAceptar, "Seleccione una temática.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					GUI frame = new GUI(CBTematica.getSelectedIndex());
					setVisible(false);
					frame.setVisible(true);
					
				}
			}
		});
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBackground(Color.ORANGE);
		btnAceptar.setBounds(200, 197, 105, 30);
		contentPane.add(btnAceptar);
		
		JLabel lblNewLabel = new JLabel("Tematica");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 62));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 89, 504, 53);
		contentPane.add(lblNewLabel);
		
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 504, 481);
		fondo.setIcon(new ImageIcon(GUI.class.getResource("/images/VentanaPrincipal.png")));
		contentPane.add(fondo);
	}
	
	public int getTematica() {
		return tematicaSeleccionada;
	}
}
