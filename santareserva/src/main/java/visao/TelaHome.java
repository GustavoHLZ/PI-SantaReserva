package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Hospedes;
import modelo.Infologin;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaHome extends JFrame {

	private JPanel contentPane;
	private Hospedes hosplogado;


	/**
	 * Create the frame.
	 */
	public TelaHome(Hospedes hospedelogado) {
		hosplogado = hospedelogado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(239, 239, 239));
		panel.setBounds(0, 100, 311, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAvaliacao = new JLabel("");
		lblAvaliacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaAvaliacoes abrir = new TelaAvaliacoes(hosplogado);
				abrir.setVisible(true);
				dispose();
					
			}
		});
		lblAvaliacao.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconeAvalie.png")));
		lblAvaliacao.setBounds(10, 285, 24, 14);
		panel.add(lblAvaliacao);
		
		JLabel lblNewLabel_1 = new JLabel("Avalie");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(44, 285, 46, 14);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(119, 165, 175));
		panel_1.setBounds(0, 0, 1370, 100);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 518, 1369, 220);
		contentPane.add(panel_2);
		panel_2.setBackground(new Color(119, 165, 175));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(228, 228, 228));
		panel_3.setBounds(321, 111, 567, 305);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(908, 196, 436, 220);
		contentPane.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Nossos Espaços");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 60));
		lblNewLabel.setBounds(898, 111, 453, 74);
		contentPane.add(lblNewLabel);
	}
}
