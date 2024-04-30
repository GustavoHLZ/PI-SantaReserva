package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.AvaliacoesDAO;
import controle.HospedesDAO;
import controle.InfologinDAO;
import controle.Quarto;
import controle.QuartosDAO;
import modelo.Avaliacoes;
import modelo.Hospedes;
import modelo.Infologin;
import modelo.Quartos;
import modelo.TipoHoras;
import modelo.comboBoxDisponivel;
import modelo.comboBoxPreco;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaAvaliacoes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Quartos quartoSelecionado;
	private ArrayList<Avaliacoes> listarAvaliacoes = new ArrayList<Avaliacoes>();
	private Hospedes hospedeLogado;
	private JTextField txtNome;
	private JTextField txtComentario;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAvaliacoes frame = new TelaAvaliacoes(null);
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
	public TelaAvaliacoes(Hospedes hosplogado) {
		hospedeLogado = hosplogado;
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
		lblNewLabel.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/LogoAPP.png")));
		PainelTopo.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeUser.png")));
		PainelTopo.add(lblNewLabel_19, "cell 1 0");
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, "cell 0 1,grow");
		
		JPanel PainelFiltro = new JPanel();
		contentPane.add(PainelFiltro, "cell 1 1,grow");
		PainelFiltro.setLayout(new MigLayout("", "[250px][250px][144px]", "[58px]"));
		
		JPanel PainelIcones = new JPanel();
		contentPane.add(PainelIcones, "cell 0 2,grow");
		PainelIcones.setLayout(new MigLayout("", "[][]", "[][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][][300px][][][][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeHome.png")));
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
		lblNewLabel_3.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconePerfil.png")));
		PainelIcones.add(lblNewLabel_3, "cell 0 3");
		
		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPerfil c = new TelaPerfil(hospedeLogado);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_4, "cell 1 3");
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeReserva.png")));
		PainelIcones.add(lblNewLabel_11, "cell 0 5");
		
		JLabel lblNewLabel_5 = new JLabel("Reserva");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaReservas c = new TelaReservas(hosplogado, null, quartoSelecionado, null, null, null);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_5, "cell 1 5");
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
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
		lblNewLabel_13.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeComputadores.png")));
		PainelIcones.add(lblNewLabel_13, "cell 0 9");
		
		JLabel lblNewLabel_7 = new JLabel("Computadores");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_7, "cell 1 9");
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeQuartos.png")));
		PainelIcones.add(lblNewLabel_14, "cell 0 11");
		
		JLabel lblNewLabel_8 = new JLabel("Quartos");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_8, "cell 1 11");
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeAvalie.png")));
		PainelIcones.add(lblNewLabel_15, "cell 0 13");
		
		JLabel lblNewLabel_9 = new JLabel("Avalie-nos");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_9, "cell 1 13");
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeInformacoes.png")));
		PainelIcones.add(lblNewLabel_16, "cell 0 15");
		
		JLabel lblNewLabel_10 = new JLabel("Nossas Informações");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_10, "cell 1 15");
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeConfiguracoes.png")));
		PainelIcones.add(lblNewLabel_18, "cell 0 25");
		
		JLabel lblNewLabel_17 = new JLabel("Configurações");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_17, "cell 1 25");
		
		JPanel PainelPrincipal = new JPanel();
		contentPane.add(PainelPrincipal, "cell 1 2,grow");
		PainelPrincipal.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(7, 447, 10, 10);
		PainelPrincipal.add(panel);
		
		JLabel lblNewLabel_21 = new JLabel("Nome:");
		lblNewLabel_21.setBounds(35, 36, 43, 14);
		PainelPrincipal.add(lblNewLabel_21);
		
		txtNome = new JTextField();
		txtNome.setBounds(97, 26, 328, 34);
		PainelPrincipal.add(txtNome);
		txtNome.setColumns(10);
		txtNome.setText(hospedeLogado.getNome());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(158, 447, 10, 10);
		PainelPrincipal.add(panel_1);
		
		JLabel lblNewLabel_22 = new JLabel("Comentário:");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setBounds(7, 85, 136, 14);
		PainelPrincipal.add(lblNewLabel_22);
		
		txtComentario = new JTextField();
		txtComentario.setBounds(35, 105, 390, 145);
		PainelPrincipal.add(txtComentario);
		txtComentario.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(317, 447, 10, 10);
		PainelPrincipal.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(331, 447, 10, 10);
		PainelPrincipal.add(panel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(345, 447, 10, 10);
		PainelPrincipal.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(359, 447, 10, 10);
		PainelPrincipal.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(373, 447, 10, 10);
		PainelPrincipal.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(387, 447, 10, 10);
		PainelPrincipal.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(401, 447, 10, 10);
		PainelPrincipal.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(415, 447, 10, 10);
		PainelPrincipal.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(429, 447, 10, 10);
		PainelPrincipal.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(443, 447, 10, 10);
		PainelPrincipal.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(457, 447, 10, 10);
		PainelPrincipal.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(471, 447, 10, 10);
		PainelPrincipal.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(485, 447, 10, 10);
		PainelPrincipal.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(499, 447, 10, 10);
		PainelPrincipal.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(513, 447, 10, 10);
		PainelPrincipal.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBounds(527, 447, 10, 10);
		PainelPrincipal.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBounds(17, 365, 1088, 103);
		PainelPrincipal.add(panel_19);
		panel_19.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[][][][]"));
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AvaliacoesDAO dao = AvaliacoesDAO.getInstancia();
				
				Avaliacoes c = new Avaliacoes();
				
				int id = c.getIdAvaliacao();
				
				dao.removerAvaliacoes(id);
			}
		});
		lblNewLabel_20.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Botões/Apagar Avalição.png")));
		panel_19.add(lblNewLabel_20, "cell 2 2,grow");
		
		JLabel lblReservar = new JLabel("");
		panel_19.add(lblReservar, "cell 12 2,grow");
		lblReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String nome = txtNome.getText();
				Float avalia = Float.valueOf(txtComentario.getText());
				Avaliacoes avaliacao = new Avaliacoes();
				
				avaliacao.setAvaliador(nome);
				avaliacao.setAvaliacao(avalia);
				
				AvaliacoesDAO dao = AvaliacoesDAO.getInstancia();
				
				dao.atualizarAvaliacoes(nome,avalia);
				
				
				listarAvaliacoes.add(avaliacao);
				
				

				 
				 atualizarJTable();		    
				
			}
		});
		
		
		lblReservar.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Botões/Atualizar Avaliação.png")));
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String nome = txtNome.getText();
		        Float av = Float.valueOf(txtComentario.getText());
		        Avaliacoes avaliacao = new Avaliacoes();
		        
		        avaliacao.setAvaliador(nome);
		        avaliacao.setAvaliacao(av);
		        avaliacao.setFkIDHospede(hospedeLogado);
		        
		        AvaliacoesDAO dao = AvaliacoesDAO.getInstancia();
		        
		        int retorno = dao.InserirAvaliacao(avaliacao);
		        
		        if (retorno > 0) {
		            JOptionPane.showMessageDialog(null, "Avaliação inserida com sucesso!");
		            avaliacao.setIdAvaliacao(retorno);
		        	listarAvaliacoes.add(avaliacao);
		            atualizarJTable();
		        } else {
		            JOptionPane.showMessageDialog(null, "Falha ao inserir avaliação!");
		        }

				
				
			}
		});
		lblNewLabel_23.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Botões/BTN Fazer Avaliação.png")));
		panel_19.add(lblNewLabel_23, "cell 16 2,grow");
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(513, 26, 566, 307);
		PainelPrincipal.add(panel_20);
		
		table = new JTable();
		panel_20.add(table);
		atualizarJTable();
	}
	protected void atualizarJTable() {
	    DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Avaliador", "Avaliacao" });

	    AvaliacoesDAO Avaliacoesdao = AvaliacoesDAO.getInstancia();
	    listarAvaliacoes = Avaliacoesdao.listarAvaliacoes();

	    for (int i = 0; i < listarAvaliacoes.size(); i++) {
	        Avaliacoes avalia = listarAvaliacoes.get(i);

	        modelo.addRow(new Object[] {avalia.getIdAvaliacao(), avalia.getAvaliador(), avalia.getAvaliacao()});
	    }
	}
}
