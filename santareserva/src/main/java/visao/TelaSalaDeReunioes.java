package visao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaSalaDeReunioes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PainelGeral;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSalaDeReunioes frame = new TelaSalaDeReunioes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaSalaDeReunioes() {
		setTitle("Sala de Reuniões");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		PainelGeral = new JPanel();
		PainelGeral.setBackground(new Color(255, 255, 255));
		PainelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PainelGeral);
		PainelGeral.setLayout(new MigLayout("", "[][grow][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[][][][][][grow][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		JPanel PainelTopo = new JPanel();
		PainelTopo.setBackground(new Color(119, 165, 175));
		PainelGeral.add(PainelTopo, "cell 0 0 66 5,grow");
		PainelTopo.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][grow][][]", "[grow]"));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/LogoAPP.png")));
		PainelTopo.add(lblNewLabel_2, "cell 0 0");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeUser.png")));
		PainelTopo.add(lblNewLabel, "cell 56 0");
		
		JPanel PainelIcones = new JPanel();
		PainelIcones.setBackground(new Color(239, 239, 239));
		PainelGeral.add(PainelIcones, "cell 1 5 9 31,grow");
		PainelIcones.setLayout(new MigLayout("", "[][grow]", "[grow][][grow][][grow][][grow][][grow][][grow][][grow][][grow][][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][]"));
		
		JPanel panel_9 = new JPanel();
		PainelIcones.add(panel_9, "cell 1 0,grow");
		
		JLabel lblImagemHome = new JLabel("");
		lblImagemHome.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeHome.png")));
		PainelIcones.add(lblImagemHome, "cell 0 1");
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblHome, "cell 1 1");
		
		JPanel panel_8 = new JPanel();
		PainelIcones.add(panel_8, "cell 1 2,grow");
		
		JLabel lblImagemPerfil = new JLabel("");
		lblImagemPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImagemPerfil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblImagemPerfil.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconePerfil.png")));
		PainelIcones.add(lblImagemPerfil, "cell 0 3");
		
		JLabel lblNewLabel_1 = new JLabel("Perfil");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPerfil c = new TelaPerfil();
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_1, "cell 1 3");
		
		JPanel panel_10 = new JPanel();
		PainelIcones.add(panel_10, "cell 1 4,grow");
		
		JLabel lblImagemReserva = new JLabel("");
		lblImagemReserva.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeReserva.png")));
		PainelIcones.add(lblImagemReserva, "cell 0 5");
		
		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblReserva, "cell 1 5");
		
		JPanel panel_7 = new JPanel();
		PainelIcones.add(panel_7, "cell 1 6,grow");
		
		JLabel lblImagemSalaReunioes = new JLabel("");
		lblImagemSalaReunioes.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		PainelIcones.add(lblImagemSalaReunioes, "cell 0 7");
		
		JLabel lblSalaReunioes = new JLabel("Sala de Reuniões");
		lblSalaReunioes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblSalaReunioes, "cell 1 7");
		
		JPanel panel_6 = new JPanel();
		PainelIcones.add(panel_6, "cell 1 8,grow");
		
		JLabel lblImagemComputador = new JLabel("");
		lblImagemComputador.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeComputadores.png")));
		PainelIcones.add(lblImagemComputador, "cell 0 9");
		
		JLabel lblComputadores = new JLabel("Computadores");
		lblComputadores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblComputadores, "cell 1 9");
		
		JPanel panel_5 = new JPanel();
		PainelIcones.add(panel_5, "cell 1 10,grow");
		
		JLabel lblImagemQuarto = new JLabel("");
		lblImagemQuarto.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeQuartos.png")));
		PainelIcones.add(lblImagemQuarto, "cell 0 11");
		
		JLabel lblQuartos = new JLabel("Quartos");
		lblQuartos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblQuartos, "cell 1 11");
		
		JPanel panel_4 = new JPanel();
		PainelIcones.add(panel_4, "cell 1 12,grow");
		
		JLabel lblImagemAvalie = new JLabel("");
		lblImagemAvalie.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeAvalie.png")));
		PainelIcones.add(lblImagemAvalie, "cell 0 13");
		
		JLabel lblAvalie = new JLabel("Avalie-nos");
		lblAvalie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblAvalie, "cell 1 13");
		
		JPanel panel_3 = new JPanel();
		PainelIcones.add(panel_3, "cell 1 14,grow");
		
		JLabel lblImagemNossasInfo = new JLabel("");
		lblImagemNossasInfo.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeInformacoes.png")));
		PainelIcones.add(lblImagemNossasInfo, "cell 0 15");
		
		JLabel lblNossasInfo = new JLabel("Nossas Informações");
		lblNossasInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNossasInfo, "cell 1 15");
		
		JPanel panel_2 = new JPanel();
		PainelIcones.add(panel_2, "cell 1 16,grow");
		
		JPanel panel_11 = new JPanel();
		PainelIcones.add(panel_11, "cell 1 17,grow");
		
		JPanel panel_12 = new JPanel();
		PainelIcones.add(panel_12, "cell 1 18,grow");
		
		JPanel panel_13 = new JPanel();
		PainelIcones.add(panel_13, "cell 1 19,grow");
		
		JPanel panel = new JPanel();
		PainelIcones.add(panel, "cell 1 20,grow");
		
		JPanel panel_1 = new JPanel();
		PainelIcones.add(panel_1, "cell 1 21,grow");
		
		JPanel panel_14 = new JPanel();
		PainelIcones.add(panel_14, "cell 1 22,grow");
		
		JPanel panel_15 = new JPanel();
		PainelIcones.add(panel_15, "cell 1 23,grow");
		
		JPanel panel_16 = new JPanel();
		PainelIcones.add(panel_16, "cell 1 24,grow");
		
		JPanel panel_17 = new JPanel();
		PainelIcones.add(panel_17, "cell 1 25,grow");
		
		JPanel panel_18 = new JPanel();
		PainelIcones.add(panel_18, "cell 1 26,grow");
		
		JPanel panel_19 = new JPanel();
		PainelIcones.add(panel_19, "cell 1 27,grow");
		
		JPanel panel_20 = new JPanel();
		PainelIcones.add(panel_20, "cell 1 28,grow");
		
		JLabel lblImagemConfig = new JLabel("");
		lblImagemConfig.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeConfiguracoes.png")));
		PainelIcones.add(lblImagemConfig, "cell 0 29");
		
		JLabel lblConfiguracoes = new JLabel("Configurações");
		lblConfiguracoes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblConfiguracoes, "cell 1 29");
		
		JPanel PainelSalaDeReunioes = new JPanel();
		PainelSalaDeReunioes.setBackground(new Color(239, 239, 239));
		PainelGeral.add(PainelSalaDeReunioes, "cell 11 6 55 30,grow");
		PainelSalaDeReunioes.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JPanel panel_21 = new JPanel();
		PainelSalaDeReunioes.add(panel_21, "cell 0 0");
		
		
	}

}
