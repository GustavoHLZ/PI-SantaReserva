package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Computadores;
import modelo.Quartos;
import modelo.SalaReunioes;
import modelo.comboBoxDisponivel;
import modelo.comboBoxOpcaoPagamento;
import modelo.comboBoxPreco;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaReservas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNometitular;
	private JTextField txtNumeroCartao;
	private JTextField txtDataValidade;
	private JTextField txtCodigoSeguranca;
	private static TelaQuartos quartoalugado;
	private static TelaSalaDeReunioes salaalugada;
	private static Computadores computadoralugado;
	private static TelaLogin usuariologado;
	private JTable table;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public TelaReservas(TelaLogin login ,TelaQuartos quarto, TelaSalaDeReunioes salareunioes) {
		usuariologado = login;
		quartoalugado = quarto;
		salaalugada = salareunioes;
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
		
		JPanel PainelFiltro = new JPanel();
		contentPane.add(PainelFiltro, "cell 1 1,grow");
		PainelFiltro.setLayout(new MigLayout("", "[250px][250px][144px]", "[58px]"));
		
		JComboBox comboBoxDisp = new JComboBox();
		comboBoxDisp.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		comboBoxDisp.setModel(new DefaultComboBoxModel(comboBoxDisponivel.values()));
		PainelFiltro.add(comboBoxDisp, "cell 0 0,growx");
		
		JComboBox comboBoxFiltroPreco = new JComboBox();
		comboBoxFiltroPreco.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		comboBoxFiltroPreco.setModel(new DefaultComboBoxModel(comboBoxPreco.values()));
		PainelFiltro.add(comboBoxFiltroPreco, "cell 1 0,growx");
		
		JPanel PainelIcones = new JPanel();
		contentPane.add(PainelIcones, "cell 0 2,grow");
		PainelIcones.setLayout(new MigLayout("", "[][]", "[][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][][300px][][][][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeHome.png")));
		PainelIcones.add(lblNewLabel_1, "cell 0 1");
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaHome c = new TelaHome();
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
				TelaPerfil c = new TelaPerfil();
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
		PainelPrincipal.setLayout(new MigLayout("", "[grow][][][200px:n:200px,grow][][][][][][][][650px][][][grow][][][][][][][][][][][]", "[][][grow][100px:n][][]"));
		
		JPanel panel_2 = new JPanel();
		PainelPrincipal.add(panel_2, "cell 13 0 13 4,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_21 = new JLabel("Nome Titular");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_21, "cell 0 0");
		
		txtNometitular = new JTextField();
		panel_2.add(txtNometitular, "cell 0 1,grow");
		txtNometitular.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("Número do Cartão");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_22, "cell 0 3");
		
		txtNumeroCartao = new JTextField();
		panel_2.add(txtNumeroCartao, "cell 0 4,growx");
		txtNumeroCartao.setColumns(10);
		
		JLabel lblNewLabel_23 = new JLabel("Data de Validade");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_23, "cell 0 6");
		
		txtDataValidade = new JTextField();
		panel_2.add(txtDataValidade, "cell 0 7,growx");
		txtDataValidade.setColumns(10);
		
		JLabel lblNewLabel_24 = new JLabel("Código de Segurança");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_24, "cell 0 9");
		
		txtCodigoSeguranca = new JTextField();
		panel_2.add(txtCodigoSeguranca, "cell 0 10,growx");
		txtCodigoSeguranca.setColumns(10);
		
		JLabel lblNewLabel_25 = new JLabel("Total Sala de Reuniões");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_25, "cell 0 12");
		
		JLabel lbltotalsalareunioes = new JLabel("-");
		lbltotalsalareunioes.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lbltotalsalareunioes, "cell 0 13,grow");
		
		
		
		JLabel lblNewLabel_27 = new JLabel("Total Computadores");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_27, "cell 0 17");
		
		JLabel lblcomputadores = new JLabel("-");
		panel_2.add(lblcomputadores, "cell 0 18,alignx center");
		
		JLabel lblNewLabel_29 = new JLabel("Total Quartos");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_29, "cell 0 20");
		
		JLabel lblquartos = new JLabel("-");
		panel_2.add(lblquartos, "cell 0 21,alignx center");
		
		JLabel lblNewLabel_31 = new JLabel("Total à pagar:");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_31, "cell 0 22");
		
		JLabel lbltotalpagar = new JLabel("-");
		panel_2.add(lbltotalpagar, "cell 0 23,alignx center");
		
		JLabel lblOpcaoPagamento = new JLabel("Escolha outra forma de pagamento");
		lblOpcaoPagamento.addMouseListener(new MouseAdapter() {
			@Override
		
			public void mousePressed(MouseEvent e) {
				JComboBox comboBoxOpcaoPagmento = new JComboBox(comboBoxOpcaoPagamento.values());
				PainelPrincipal.add(comboBoxOpcaoPagmento, "cell 3 11,growx");
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		PainelPrincipal.add(scrollPane, "cell 0 0 12 3,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID da Reserva", "CheckIn", "CheckOut", "ID do Espaço"}));
		
		JLabel lblReservasRealizadas = new JLabel("Reservas Realizadas");
		PainelPrincipal.add(lblReservasRealizadas, "cell 2 3,alignx center,growy");
		lblOpcaoPagamento.setHorizontalAlignment(SwingConstants.CENTER);
		PainelPrincipal.add(lblOpcaoPagamento, "cell 3 3");
		
		JLabel lblNewLabel_34 = new JLabel("");
		lblNewLabel_34.setIcon(new ImageIcon(TelaReservas.class.getResource("/visao/Botões/BTN Cancelar Reserva.png")));
		PainelPrincipal.add(lblNewLabel_34, "cell 3 4");
		
		JPanel panel_3 = new JPanel();
		PainelPrincipal.add(panel_3, "cell 14 4 11 1,grow");
		
		JLabel lblEfetuarPagamento = new JLabel("");
		lblEfetuarPagamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				 String nomeTitular = txtNometitular.getText();
			        String numeroCartao = txtNumeroCartao.getText();
			        String dataValidade = txtDataValidade.getText();
			        String codigoSeguranca = txtCodigoSeguranca.getText();
			        
			       
			        if (nomeTitular.isEmpty() || numeroCartao.isEmpty() || dataValidade.isEmpty() || codigoSeguranca.isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
			            return; 
			        }
			        
			      
			        int quantidadeQuartos = Integer.parseInt(comboBoxFiltroPreco.getSelectedItem().toString());
			        double precoQuarto = 250; 
			        double totalPagar = quantidadeQuartos * precoQuarto;
			        
			
			        JOptionPane.showMessageDialog(null, "Reserva efetuada com sucesso!\nTotal a pagar: R$ " + totalPagar, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			    }				
			
		});
		lblEfetuarPagamento.setIcon(new ImageIcon(TelaReservas.class.getResource("/visao/Botões/BTN Efetuar Pagamento.png")));
		panel_3.add(lblEfetuarPagamento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(84, 113, 119));
		panel_1.setForeground(new Color(84, 113, 119));
		PainelPrincipal.add(panel_1, "cell 12 0 1 24,grow");
		
		JLabel lblNewLabel_20 = new JLabel("");
		PainelPrincipal.add(lblNewLabel_20, "cell 3 5");
	}
}
