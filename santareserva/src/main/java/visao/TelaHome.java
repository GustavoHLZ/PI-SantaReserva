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
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setBounds(44, 319, 46, 14);
		panel.add(lblPerfil);
		
		JLabel IconPerfil = new JLabel("");
		IconPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPerfil perfil = new TelaPerfil(hosplogado);
				perfil.setVisible(true);
				dispose();
			}
		});
		IconPerfil.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconePerfil.png")));
		IconPerfil.setBounds(10, 310, 24, 23);
		panel.add(IconPerfil);
		
		JLabel lblNewLabel_2 = new JLabel("Reserva");
		lblNewLabel_2.setBounds(44, 353, 57, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaReservas reserva = new TelaReservas(hosplogado, hospedelogado, null, null, null, null, null);
				reserva.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconeReserva.png")));
		lblNewLabel_3.setBounds(10, 343, 45, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quartos");
		lblNewLabel_4.setBounds(45, 262, 45, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaQuartos quartos = new TelaQuartos(hosplogado);
				quartos.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconeCama.png")));
		lblNewLabel_5.setBounds(10, 252, 45, 23);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Computadores");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaComputadores computadores = new TelaComputadores(hosplogado);
				computadores.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconeComputadores.png")));
		lblNewLabel_6.setBounds(10, 219, 102, 23);
		panel.add(lblNewLabel_6);
		
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
