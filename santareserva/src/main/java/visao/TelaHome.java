package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import modelo.Hospedes;
import modelo.Quartos;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

public class TelaHome extends JFrame {
	
	private static Hospedes hosplogado;
	private Hospedes usuariologado;
	private JPanel contentPane;
	private Quartos quartoSelecionado;



	/**
	 * Create the frame.
	 */
	public TelaHome(Hospedes hospede) {
	
		hosplogado = hospede;
		usuariologado = hosplogado;
		
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(228, 228, 228));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[350px,grow][grow]", "[200px][grow][grow][200px]"));
		
	
		
		JPanel PainelTopo = new JPanel();
		PainelTopo.setBackground(new Color(119, 165, 175));
		contentPane.add(PainelTopo, "cell 0 0 2 1,grow");
		PainelTopo.setLayout(new MigLayout("", "[1800px][]", "[]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/LogoAPP.png")));
		PainelTopo.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeUser.png")));
		PainelTopo.add(lblNewLabel_19, "cell 1 0");
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, "cell 0 1,grow");
		
		JPanel PainelFiltro = new JPanel();
		contentPane.add(PainelFiltro, "cell 1 1,grow");
		PainelFiltro.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel PainelIcones = new JPanel();
		PainelIcones.setBackground(new Color(240, 240, 240));
		contentPane.add(PainelIcones, "cell 0 2,grow");
		PainelIcones.setLayout(new MigLayout("", "[][]", "[][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][][100px]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeHome.png")));
		PainelIcones.add(lblNewLabel_1, "cell 0 1");
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaHome c = new TelaHome(null);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_2, "cell 1 1");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconePerfil.png")));
		PainelIcones.add(lblNewLabel_3, "cell 0 3");
		
		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPerfil c = new TelaPerfil(hosplogado);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_4, "cell 1 3");
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeReserva.png")));
		PainelIcones.add(lblNewLabel_11, "cell 0 5");
		
		JLabel lblNewLabel_5 = new JLabel("Reserva");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaReservas c = new TelaReservas(hospede, null, quartoSelecionado, null, null, null, null);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_5, "cell 1 5");
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		PainelIcones.add(lblNewLabel_12, "cell 0 7");
		
		JLabel lblNewLabel_6 = new JLabel("Sala de Reuniões");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaSalaDeReunioes c = new TelaSalaDeReunioes(hosplogado);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_6, "cell 1 7");
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeComputadores.png")));
		PainelIcones.add(lblNewLabel_13, "cell 0 9");
		
		JLabel lblNewLabel_7 = new JLabel("Computadores");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_7, "cell 1 9");
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeQuartos.png")));
		PainelIcones.add(lblNewLabel_14, "cell 0 11");
		
		JLabel lblNewLabel_8 = new JLabel("Quartos");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_8, "cell 1 11");
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeAvalie.png")));
		PainelIcones.add(lblNewLabel_15, "cell 0 13");
		
		JLabel lblNewLabel_9 = new JLabel("Avalie-nos");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaAvaliacoes c = new TelaAvaliacoes(hosplogado);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_9, "cell 1 13");
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeInformacoes.png")));
		PainelIcones.add(lblNewLabel_16, "cell 0 15");
		
		JLabel lblNewLabel_10 = new JLabel("Nossas Informações");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_10, "cell 1 15");
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeConfiguracoes.png")));
		PainelIcones.add(lblNewLabel_18, "cell 0 17");
		
		JLabel lblNewLabel_17 = new JLabel("Configurações");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_17, "cell 1 17");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 2,grow");
		
		JPanel PainelInferior = new JPanel();
		PainelInferior.setBackground(new Color(119, 165, 175));
		contentPane.add(PainelInferior, "cell 0 3 2 1,grow");
		PainelInferior.setLayout(new MigLayout("", "[350px][400px][400px][400px][400px]", "[50px][24px][24px][24px][24px][24px]"));
		
		JLabel lblNewLabel_25 = new JLabel("Espaços");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.BOLD, 15));
		PainelInferior.add(lblNewLabel_25, "flowx,cell 1 0,alignx left");
		
		JLabel lblNewLabel_26 = new JLabel("Agendamento");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 14));
		PainelInferior.add(lblNewLabel_26, "cell 2 0");
		
		JLabel lblNewLabel_27 = new JLabel("Fale Conosco");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.BOLD, 14));
		PainelInferior.add(lblNewLabel_27, "cell 3 0");
		
		JLabel lblNewLabel_31 = new JLabel("Redes Sociais");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.BOLD, 14));
		PainelInferior.add(lblNewLabel_31, "cell 4 0");
		
		JLabel lblNewLabel_28 = new JLabel("Quartos");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PainelInferior.add(lblNewLabel_28, "cell 1 1");
		
		JLabel lblNewLabel_32 = new JLabel("Reservas");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PainelInferior.add(lblNewLabel_32, "cell 2 1");
		
		JLabel lblNewLabel_34 = new JLabel("(47) 93333-3333");
		lblNewLabel_34.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PainelInferior.add(lblNewLabel_34, "cell 3 1");
		
		JLabel lblNewLabel_37 = new JLabel("");
		lblNewLabel_37.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconeInstagram.png")));
		PainelInferior.add(lblNewLabel_37, "flowx,cell 4 1");
		
		JLabel lblNewLabel_29 = new JLabel("Sala de Reuniões");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PainelInferior.add(lblNewLabel_29, "cell 1 2");
		
		JLabel lblNewLabel_33 = new JLabel("Termos de Uso");
		lblNewLabel_33.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PainelInferior.add(lblNewLabel_33, "cell 2 2");
		
		JLabel lblNewLabel_35 = new JLabel("(47) 99999-9999");
		lblNewLabel_35.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PainelInferior.add(lblNewLabel_35, "cell 3 2");
		
		JLabel lblNewLabel_38 = new JLabel("");
		lblNewLabel_38.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconeFaceBook.png")));
		PainelInferior.add(lblNewLabel_38, "flowx,cell 4 2");
		
		JLabel lblNewLabel_30 = new JLabel("Computadores");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PainelInferior.add(lblNewLabel_30, "cell 1 3 1 2");
		
		JLabel lblNewLabel_36 = new JLabel("SantaReserva@gmail.com");
		lblNewLabel_36.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PainelInferior.add(lblNewLabel_36, "cell 3 3 1 2");
		
		JLabel lblNewLabel_39 = new JLabel("@SantaReserva");
		lblNewLabel_39.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PainelInferior.add(lblNewLabel_39, "cell 4 1");
		
		JLabel lblNewLabel_40 = new JLabel("@SantaReserva");
		lblNewLabel_40.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PainelInferior.add(lblNewLabel_40, "cell 4 2");
		PainelTopo.setBackground(new Color(119, 165, 175));
		PainelTopo.setLayout(new MigLayout("", "[1800px][]", "[][][][]"));
	
	
	
	
	
	}
}
