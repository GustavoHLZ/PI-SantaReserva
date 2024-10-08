package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Hospedes;
import modelo.Quartos;
import modelo.Reserva;
import net.miginfocom.swing.MigLayout;

public class TelaInformacoes extends JFrame {

	private JPanel contentPane1;
	private static Hospedes hosplogado;
	private Hospedes usuariologado;
	private JPanel contentPane;
	private Quartos quartoSelecionado;
	private Reserva reserva;

	
	public TelaInformacoes(Hospedes hospede,Reserva reserva) {
		this.reserva=reserva;
		
		/* TEM Q TER EM TODAS AS TELAS */
		hosplogado = hospede;
		usuariologado = hosplogado;
		/* TEM Q TER EM TODAS AS TELAS */
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(0, 0, 1920, 1080);
		contentPane1 = new JPanel();
		setUndecorated(true);
		contentPane1.setBackground(new Color(228, 228, 228));
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane1);
		contentPane1.setLayout(new MigLayout("", "[300px][grow]", "[100px][grow][grow]"));
		
		JPanel PainelTopo = new JPanel();
		PainelTopo.setBackground(new Color(119, 165, 175));
		contentPane1.add(PainelTopo, "cell 0 0 2 1,grow");
		PainelTopo.setLayout(new MigLayout("", "[][grow][100px]", "[][]"));
		
		
		JPanel PainelIcones = new JPanel();
		PainelIcones.setBackground(new Color(240, 240, 240));
		contentPane1.add(PainelIcones, "cell 0 1,grow");
		PainelIcones.setLayout(new MigLayout("", "[][]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeHome.png")));
		PainelIcones.add(lblNewLabel_1, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaHome c = new TelaHome(usuariologado,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_2, "cell 1 0");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconePerfil.png")));
		PainelIcones.add(lblNewLabel_3, "cell 0 1,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPerfil c = new TelaPerfil(usuariologado,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_4, "cell 1 1");
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeReserva.png")));
		PainelIcones.add(lblNewLabel_11, "cell 0 2,alignx center");
		
		if(hospede.getLogin().getIdUsuario()== (1)) {
			JLabel lblNewLabel_5 = new JLabel("Pagamento"); 
			lblNewLabel_5.addMouseListener(new MouseAdapter() { 
				@Override 
				public void mouseClicked(MouseEvent e) { 
					TelaPagamento c = new TelaPagamento(hospede,reserva); 
					c.setVisible(true); 
					dispose(); 
				} 
			});
			
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
			PainelIcones.add(lblNewLabel_5, "cell 1 2"); 
		}else {
		JLabel lblNewLabel_5 = new JLabel("Reserva"); 
		lblNewLabel_5.addMouseListener(new MouseAdapter() { 
			@Override 
			public void mouseClicked(MouseEvent e) { 
				TelaReservas c = new TelaReservas(hospede,reserva); 
				c.setVisible(true); 
				dispose(); 
			} 
		}); 
		
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
		PainelIcones.add(lblNewLabel_5, "cell 1 2"); 
		}
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		PainelIcones.add(lblNewLabel_12, "cell 0 3,alignx center");
		
		JLabel lblNewLabel_6 = new JLabel("Sala de Reuniões");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaSalaDeReunioes c = new TelaSalaDeReunioes(usuariologado,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_6, "cell 1 3");
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeComputadores.png")));
		PainelIcones.add(lblNewLabel_13, "cell 0 4,alignx center");
		
		JLabel lblNewLabel_7 = new JLabel("Computadores");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaComputadores c = new TelaComputadores(usuariologado,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_7, "cell 1 4");
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeQuartos.png")));
		PainelIcones.add(lblNewLabel_14, "cell 0 5,alignx center");
		
		JLabel lblNewLabel_8 = new JLabel("Quartos");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaQuartos c = new TelaQuartos(usuariologado,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_8, "cell 1 5");
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeAvalie.png")));
		PainelIcones.add(lblNewLabel_15, "cell 0 6,alignx center");
		
		JLabel lblNewLabel_9 = new JLabel("Avalie-nos");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaAvaliacoes c = new TelaAvaliacoes(usuariologado,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_9, "cell 1 6");
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeInformacoes.png")));
		PainelIcones.add(lblNewLabel_16, "cell 0 7,alignx center");
		
		JLabel lblNewLabel_10 = new JLabel("Nossas Informações");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_10, "cell 1 7");
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeConfiguracoes.png")));
		PainelIcones.add(lblNewLabel_18, "cell 0 8,alignx center");
		
		JLabel lblNewLabel_17 = new JLabel("Configurações");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_17, "cell 1 8");
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow]"));

		contentPane1.add(panel, "cell 1 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[][]", "[30px][30px][30px][30px][30px][250px,bottom][25px][25px][25px][25px]"));
		
		JLabel lblNewLabel_19 = new JLabel("\r\n");
		lblNewLabel_19.setIcon(new ImageIcon(TelaInformacoes.class.getResource("/visao/Icones/IconMaps.png")));
		panel_1.add(lblNewLabel_19, "cell 0 0 1 3,alignx center");
		
		JLabel lblNewLabel_20 = new JLabel("Rua Avenida Asfaltada,  2299 \r\n");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_20, "cell 1 0");
		
		JLabel lblGasparSc = new JLabel("Gaspar -  SC,\r\n");
		lblGasparSc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblGasparSc, "cell 1 1");
		
		JLabel lblNewLabel_54 = new JLabel("CEP – 89112-900");
		lblNewLabel_54.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_54, "cell 1 2");
		
		JLabel lblNewLabel_51 = new JLabel("");
		lblNewLabel_51.setIcon(new ImageIcon(TelaInformacoes.class.getResource("/visao/Icones/IconeTelefone.png")));
		panel_1.add(lblNewLabel_51, "cell 0 3 1 2,alignx center,aligny center");
		
		JLabel lblNewLabel_53 = new JLabel("(47) 99999-9999");
		lblNewLabel_53.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_53, "cell 1 3");
		
		JLabel lblNewLabel_55 = new JLabel("\n\n(47) 3333-3333\r\n");
		lblNewLabel_55.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_55, "cell 1 4");
		
		JLabel lblNewLabel_56 = new JLabel("Sobre nós:");
		lblNewLabel_56.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_56, "cell 0 5");
		
		JLabel lblNewLabel_57 = new JLabel("Localizado bem localizado proximo ao centro, nosso Hotel");
		lblNewLabel_57.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_57, "cell 0 6 2 1");
		
		JLabel lblNewLabel_58 = new JLabel("oferece o refúgio ideal para quem  busca conforto e ");
		lblNewLabel_58.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_58, "cell 0 7 2 1");
		
		JLabel lblNewLabel_59 = new JLabel("tranquilidade. Quartos elegantes, gastronomia refinada  e ");
		lblNewLabel_59.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_59, "cell 0 8 2 1");
		
		JLabel lblNewLabel_60 = new JLabel("serviço excepcional garantem uma estadia \n\nmemorável. ");
		lblNewLabel_60.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_60, "cell 0 9 2 1");
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
		panel.add(panel_3, "cell 1 0,growx,aligny bottom");
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, "cell 0 0,alignx left,aligny center");
		
		JLabel lblNewLabel_47 = new JLabel("Nossos Espaços");
		lblNewLabel_47.setFont(new Font("Tahoma", Font.BOLD, 50));
		panel_5.add(lblNewLabel_47);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow]"));
		panel_3.add(panel_6, "cell 0 1,grow");
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, "cell 0 0,growx,aligny center");
		
		JLabel lblNewLabel_48 = new JLabel("");
		lblNewLabel_48.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Fotos/HomeP1.png")));
		panel_7.add(lblNewLabel_48);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9, "cell 1 0,growx,aligny center");
		
		JLabel lblNewLabel_49 = new JLabel("");
		lblNewLabel_49.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Fotos/HomeP2.png")));
		panel_9.add(lblNewLabel_49);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, "cell 0 1,growx,aligny center");
		
		JLabel lblNewLabel_52 = new JLabel("");
		lblNewLabel_52.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Fotos/HomeP4.png")));
		panel_8.add(lblNewLabel_52);
		
		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10, "cell 1 1,alignx center,aligny center");
		
		JLabel lblNewLabel_50 = new JLabel("");
		panel_10.add(lblNewLabel_50);
		lblNewLabel_50.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Fotos/HomeP3.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow]"));
		panel.add(panel_2, "cell 0 1 2 1,growx,aligny center");
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconeCama.png")));
		panel_2.add(lblNewLabel_21, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconeWifi.png")));
		panel_2.add(lblNewLabel_23, "cell 1 0,alignx center");
		
		JLabel lblNewLabel_41 = new JLabel("");
		lblNewLabel_41.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconeComputadores.png")));
		panel_2.add(lblNewLabel_41, "cell 2 0,alignx center");
		
		JLabel lblNewLabel_43 = new JLabel("");
		lblNewLabel_43.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		panel_2.add(lblNewLabel_43, "cell 3 0,alignx center");
		
		JLabel lblNewLabel_45 = new JLabel("");
		lblNewLabel_45.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/IconeMapa.png")));
		panel_2.add(lblNewLabel_45, "cell 4 0,alignx center");
		
		JLabel lblNewLabel_22 = new JLabel("Acomodações Confortáveis");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_22, "cell 0 1,alignx center");
		
		JLabel lblNewLabel_24 = new JLabel("Internet Rápida e Gratuita");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_24, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_42 = new JLabel("Salas com Computadores de de última geração");
		lblNewLabel_42.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_42, "cell 2 1,alignx center");
		
		JLabel lblNewLabel_44 = new JLabel("Salas Prontas para Conferências e Reuniões");
		lblNewLabel_44.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_44, "cell 3 1,alignx center");
		
		JLabel lblNewLabel_46 = new JLabel("Localização Privilegiada");
		lblNewLabel_46.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_46, "cell 4 1,alignx center");
		
		JPanel PainelInferior = new JPanel();
		PainelInferior.setBackground(new Color(119, 165, 175));
		contentPane1.add(PainelInferior, "cell 0 2 2 1,grow");
		PainelInferior.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow]"));
		
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
	
	
		
		JLabel lblNewLabel = new JLabel(""); 
		lblNewLabel.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/LogoCerta2.png"))); 
		PainelTopo.add(lblNewLabel, "cell 0 0 1 2"); 
		
		JLabel lblNewLabel_531 = new JLabel("Olá,");
		lblNewLabel_531.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelTopo.add(lblNewLabel_531, "flowx,cell 1 0,alignx right,aligny bottom");
		
		JLabel lblNameuser = new JLabel("");
		lblNameuser.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelTopo.add(lblNameuser, "cell 1 0 1 2,alignx right,aligny bottom");
		lblNameuser.setText(hosplogado.getNome());
		
		JLabel lblNewLabel_191 = new JLabel("");
		lblNewLabel_191.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/iconeUser.png")));
		PainelTopo.add(lblNewLabel_191, "cell 2 0,alignx center,aligny center");
		
		JLabel lblNewLabel_511 = new JLabel("");
		lblNewLabel_511.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_511.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Botões/BtnSair.png")));
		PainelTopo.add(lblNewLabel_511, "cell 2 1,alignx center");
	}

}
