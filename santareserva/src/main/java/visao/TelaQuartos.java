package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class TelaQuartos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaQuartos frame = new TelaQuartos();
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
	public TelaQuartos() {
		setTitle("Quartos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(228, 228, 228));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[350px,grow][grow]", "[200px][grow][grow][grow]"));
		
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[290px][1070px][144px]", "[58px]"));
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/BackgroundsPI/Group 26 quantidade.png")));
		panel.add(lblNewLabel_20, "cell 0 0,alignx left,aligny top");
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/BackgroundsPI/Group 26 quantidade.png")));
		panel.add(lblNewLabel_22, "cell 1 0,alignx left,aligny top");
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Botões/BTN Busca.png")));
		panel.add(lblNewLabel_23, "cell 2 0,alignx left,aligny center");
		
		JPanel PainelIcones = new JPanel();
		contentPane.add(PainelIcones, "cell 0 2,grow");
		PainelIcones.setLayout(new MigLayout("", "[][]", "[][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][][300px][][][][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeHome.png")));
		PainelIcones.add(lblNewLabel_1, "cell 0 1");
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_2, "cell 1 1");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconePerfil.png")));
		PainelIcones.add(lblNewLabel_3, "cell 0 3");
		
		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_4, "cell 1 3");
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeReserva.png")));
		PainelIcones.add(lblNewLabel_11, "cell 0 5");
		
		JLabel lblNewLabel_5 = new JLabel("Reserva");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_5, "cell 1 5");
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		PainelIcones.add(lblNewLabel_12, "cell 0 7");
		
		JLabel lblNewLabel_6 = new JLabel("Sala de Reuniões");
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
		PainelIcones.add(lblNewLabel_18, "cell 0 25");
		
		JLabel lblNewLabel_17 = new JLabel("Configurações");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_17, "cell 1 25");
		
		JPanel PainelPrincipal = new JPanel();
		contentPane.add(PainelPrincipal, "cell 1 2,grow");
		PainelPrincipal.setLayout(new MigLayout("", "[grow]", "[grow][grow][grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(100, 50));
		PainelPrincipal.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[][750px][200px][200px][][100px]", "[][][][]"));
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Fotos/Solteiro.png")));
		panel_1.add(lblNewLabel_21, "cell 0 0");
		
		JLabel lblNewLabel_26 = new JLabel("Quarto Solteiro");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel_26, "cell 1 0,aligny top");
		
		JLabel lblNewLabel_28 = new JLabel("Preço Diária");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_28, "cell 2 0,alignx center");
		
		JLabel lblNewLabel_30 = new JLabel("Quantidade");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_30, "cell 3 0,alignx center");
		
		JLabel lblNewLabel_29 = new JLabel("");
		panel_1.add(lblNewLabel_29, "cell 1 1");
		
		JLabel lblNewLabel_27 = new JLabel("Detalhes: 1 cama de solteiro, wifi disponpível, ar condicionado, banheira e televisão.");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_27, "cell 1 2");
		
		JLabel lblNewLabel_31 = new JLabel("R$ 250,00");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_31, "cell 2 2,alignx center");
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox, "cell 3 2,growx");
		
		JLabel lblNewLabel_32 = new JLabel("");
		lblNewLabel_32.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Botões/BTN Reserva.png")));
		panel_1.add(lblNewLabel_32, "cell 5 2,alignx center");
		
		JPanel panel_2 = new JPanel();
		PainelPrincipal.add(panel_2, "cell 0 1,grow");
		panel_2.setLayout(new MigLayout("", "[][750px][200px][200px][][]", "[][][]"));
		
		JLabel lblNewLabel_24 = new JLabel("");
		lblNewLabel_24.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Fotos/Suite.png")));
		panel_2.add(lblNewLabel_24, "cell 0 0");
		
		JLabel lblNewLabel_26_1 = new JLabel("Quarto Casal");
		lblNewLabel_26_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblNewLabel_26_1, "cell 1 0,aligny top");
		
		JLabel lblNewLabel_28_1 = new JLabel("Preço Diária");
		lblNewLabel_28_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_28_1, "cell 2 0,alignx center");
		
		JLabel lblNewLabel_30_1 = new JLabel("Quantidade");
		lblNewLabel_30_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_30_1, "cell 3 0,alignx center");
		
		JLabel lblNewLabel_27_1 = new JLabel("Detalhes: 1 cama de solteiro, wifi disponpível, ar condicionado, banheira e televisão.");
		lblNewLabel_27_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_27_1, "cell 1 2");
		
		JLabel lblNewLabel_31_1 = new JLabel("R$ 350,00");
		lblNewLabel_31_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_31_1, "cell 2 2,alignx center");
		
		JComboBox comboBox_1 = new JComboBox();
		panel_2.add(comboBox_1, "cell 3 2,growx");
		
		JLabel lblNewLabel_32_1 = new JLabel("");
		lblNewLabel_32_1.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Botões/BTN Reserva.png")));
		panel_2.add(lblNewLabel_32_1, "cell 5 2,alignx center");
		
		JPanel panel_3 = new JPanel();
		PainelPrincipal.add(panel_3, "cell 0 2,grow");
		panel_3.setLayout(new MigLayout("", "[][750px][200px][200px][][]", "[][][]"));
		
		JLabel lblNewLabel_25 = new JLabel("");
		lblNewLabel_25.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Fotos/CamaDupla.png")));
		panel_3.add(lblNewLabel_25, "cell 0 0");
		
		JLabel lblNewLabel_26_1_1 = new JLabel("Quarto Casal");
		lblNewLabel_26_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_3.add(lblNewLabel_26_1_1, "cell 1 0,aligny top");
		
		JLabel lblNewLabel_28_1_1 = new JLabel("Preço Diária");
		lblNewLabel_28_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_28_1_1, "cell 2 0,alignx center");
		
		JLabel lblNewLabel_30_1_1 = new JLabel("Quantidade");
		lblNewLabel_30_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_30_1_1, "cell 3 0,alignx center");
		
		JLabel lblNewLabel_27_1_1 = new JLabel("Detalhes: 1 cama de solteiro, wifi disponpível, ar condicionado, banheira e televisão.");
		lblNewLabel_27_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_27_1_1, "cell 1 2");
		
		JLabel lblNewLabel_31_1_1 = new JLabel("R$ 450,00");
		lblNewLabel_31_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_31_1_1, "cell 2 2,alignx center");
		
		JComboBox comboBox_1_1 = new JComboBox();
		panel_3.add(comboBox_1_1, "cell 3 2,growx");
		
		JLabel lblNewLabel_32_1_1 = new JLabel("");
		lblNewLabel_32_1_1.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Botões/BTN Reserva.png")));
		panel_3.add(lblNewLabel_32_1_1, "cell 5 2");
	}

}
