package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import modelo.comboBoxPreco;
import controle.SalaReunioesDAO;
import modelo.Computadores;
import modelo.Espacos;
import modelo.Hospedes;
import modelo.Quartos;
import modelo.SalaReunioes;
import modelo.TipoHoras;
import modelo.comboBoxDisponivel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaSalaDeReunioes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String valor;
	private ArrayList<SalaReunioes> listarSalas = new ArrayList<SalaReunioes>();
	private ArrayList<Quartos> listarQuartos = new ArrayList<Quartos>();
	private ArrayList<Espacos> listarEspacos = new ArrayList<Espacos>();
	private ArrayList<Computadores> listarComputadores = new ArrayList<Computadores>();
	private static Quartos quartoAlugado;
	private Quartos quartoSelecionado;
	private static SalaReunioes salaAlugada;
	private SalaReunioes salaSelecionada;
	private static Computadores computadorAlugado;
	private Computadores computadorSelecionado;
	private static Hospedes usuariologado;
	private Hospedes usuarioSelecionado;
	private JTable table;
	private JTextField textCheckIn;
	private JTextField textCheckOut;


	public TelaSalaDeReunioes(Hospedes hospede, Quartos quarto, ArrayList<Quartos> listaQuartos,SalaReunioes salareunioes, ArrayList<Computadores> listaComputadores, Computadores computador, ArrayList<SalaReunioes> listaSalas) {
		
		/* TEM Q TER EM TODAS AS TELAS */
		usuarioSelecionado = hospede;
		usuariologado = usuarioSelecionado;
		/* TEM Q TER EM TODAS AS TELAS */
		
		quartoSelecionado = quarto;
		quartoAlugado = quartoSelecionado;
		
		computadorSelecionado = computador;
		computadorAlugado = computadorSelecionado;
		
		salaSelecionada = salareunioes;
		salaAlugada = salaSelecionada;
		
		listarQuartos = listaQuartos;
		
		listarComputadores = listaComputadores;
		
		listarSalas= listaSalas;
		
		setTitle("Sala De Reunioes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(228, 228, 228));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	
		
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[300px][grow]", "[100px][grow]"));
		
		JPanel PainelTopo = new JPanel();
		PainelTopo.setBackground(new Color(119, 165, 175));
		contentPane.add(PainelTopo, "cell 0 0 2 1,grow");
		PainelTopo.setLayout(new MigLayout("", "[][]", "[]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/LogoCerta2.png")));
		PainelTopo.add(lblNewLabel, "cell 0 0");
		
		JPanel PainelIcones = new JPanel();
		contentPane.add(PainelIcones, "cell 0 1,grow");
		PainelIcones.setLayout(new MigLayout("", "[][]", "[grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeHome.png")));
		PainelIcones.add(lblNewLabel_1, "cell 0 0");
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaHome c = new TelaHome(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarSalas);
				c.setVisible(true);
				dispose();
		
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_2, "cell 1 0");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconePerfil.png")));
		PainelIcones.add(lblNewLabel_3, "cell 0 1");
		
		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaPerfil c = new TelaPerfil(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarSalas);
				c.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_4, "cell 1 1");
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeReserva.png")));
		PainelIcones.add(lblNewLabel_11, "cell 0 2");
		
		JLabel lblNewLabel_5 = new JLabel("Reserva");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaReservas c = new TelaReservas(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarSalas);
				c.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_5, "cell 1 2");
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		PainelIcones.add(lblNewLabel_12, "cell 0 3");
		
		JLabel lblNewLabel_6 = new JLabel("Sala de Reuniões");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_6, "cell 1 3");
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeComputadores.png")));
		PainelIcones.add(lblNewLabel_13, "cell 0 4");
		
		JLabel lblNewLabel_7 = new JLabel("Computadores");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaComputadores c = new TelaComputadores(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarSalas);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_7, "cell 1 4");
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeQuartos.png")));
		PainelIcones.add(lblNewLabel_14, "cell 0 5");
		
		JLabel lblNewLabel_8 = new JLabel("Quartos");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaQuartos c = new TelaQuartos(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarSalas);
				c.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_8, "cell 1 5");
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeAvalie.png")));
		PainelIcones.add(lblNewLabel_15, "cell 0 6");
		
		JLabel lblNewLabel_9 = new JLabel("Avalie-nos");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaAvaliacoes c = new TelaAvaliacoes(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarSalas);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_9, "cell 1 6");
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeInformacoes.png")));
		PainelIcones.add(lblNewLabel_16, "cell 0 7");
		
		JLabel lblNewLabel_10 = new JLabel("Nossas Informações");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaInformacoes c = new TelaInformacoes(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarSalas);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_10, "cell 1 7");
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeConfiguracoes.png")));
		PainelIcones.add(lblNewLabel_18, "cell 0 8");
		
		JLabel lblNewLabel_17 = new JLabel("Configurações");
		lblNewLabel_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_17, "cell 1 8");
		
		JPanel PainelPrincipal = new JPanel();
		contentPane.add(PainelPrincipal, "cell 1 1,grow");
		PainelPrincipal.setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		PainelPrincipal.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
		            JTable source = (JTable) e.getSource();
		            int posicaoSala = source.getSelectedRow();
		            if (posicaoSala != -1) {
		                salaAlugada = listarSalas.get(posicaoSala);
		            }
		        }
			
			}
		});
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Preço", "Tempo", "Capacidade", "Disponibilidade" }));
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaReservas telaReservas = new TelaReservas(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarSalas);
		        telaReservas.setVisible(true);
				atualizarJTable();
			}
		});
		
		JPanel panel_19 = new JPanel();
		PainelPrincipal.add(panel_19, "flowx,cell 0 1");
		
		MaskFormatter mascaraDat = null;

		try {

			mascaraDat = new MaskFormatter("##/##/####");

		} catch (ParseException e) {

			e.printStackTrace();

		}
		
		JLabel lblNewLabel_21 = new JLabel("Check-in");
		PainelPrincipal.add(lblNewLabel_21, "cell 0 1");
		
		textCheckIn = new JFormattedTextField(mascaraDat);
		PainelPrincipal.add(textCheckIn, "cell 0 1");
		textCheckIn.setColumns(10);
		
		JPanel panel_20 = new JPanel();
		PainelPrincipal.add(panel_20, "cell 0 1");
		
		JLabel lblNewLabel_22 = new JLabel("Check-Out");
		PainelPrincipal.add(lblNewLabel_22, "cell 0 1");
		
		textCheckOut = new JFormattedTextField(mascaraDat);
		PainelPrincipal.add(textCheckOut, "cell 0 1");
		textCheckOut.setColumns(10);
		
		JPanel panel = new JPanel();
		PainelPrincipal.add(panel, "cell 0 1");
		
		JPanel panel_1 = new JPanel();
		PainelPrincipal.add(panel_1, "cell 0 1");
		
		JPanel panel_2 = new JPanel();
		PainelPrincipal.add(panel_2, "cell 0 1");
		
		JPanel panel_3 = new JPanel();
		PainelPrincipal.add(panel_3, "cell 0 1");
		
		JPanel panel_5 = new JPanel();
		PainelPrincipal.add(panel_5, "cell 0 1");
		
		JPanel panel_6 = new JPanel();
		PainelPrincipal.add(panel_6, "cell 0 1");
		
		JPanel panel_7 = new JPanel();
		PainelPrincipal.add(panel_7, "cell 0 1");
		
		JPanel panel_8 = new JPanel();
		PainelPrincipal.add(panel_8, "cell 0 1");
		
		JPanel panel_9 = new JPanel();
		PainelPrincipal.add(panel_9, "cell 0 1");
		
		JPanel panel_10 = new JPanel();
		PainelPrincipal.add(panel_10, "cell 0 1");
		
		JPanel panel_11 = new JPanel();
		PainelPrincipal.add(panel_11, "cell 0 1");
		
		JPanel panel_12 = new JPanel();
		PainelPrincipal.add(panel_12, "cell 0 1");
		
		JPanel panel_13 = new JPanel();
		PainelPrincipal.add(panel_13, "cell 0 1");
		
		JPanel panel_14 = new JPanel();
		PainelPrincipal.add(panel_14, "cell 0 1");
		
		JPanel panel_15 = new JPanel();
		PainelPrincipal.add(panel_15, "cell 0 1");
		
		JPanel panel_16 = new JPanel();
		PainelPrincipal.add(panel_16, "cell 0 1");
		
		
		lblNewLabel_20.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Botões/BTN Reserva.png")));
		PainelPrincipal.add(lblNewLabel_20, "cell 0 1,alignx center");
		
		atualizarJTable();
	}
	protected void atualizarJTable() {
	    DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Preço", "Tempo", "Capacidade", "Disponibilidade" });
	    
	    SalaReunioesDAO SalaDAO = SalaReunioesDAO.getInstancia();
	    listarSalas = SalaDAO.listarSalaReunioes();

	    for (int i = 0; i < listarSalas.size(); i++) {
	        SalaReunioes sala = listarSalas.get(i);
	        String disponibilidade;
	        if (sala.getDisp()) {
	            disponibilidade = "Disponível";
	        } else {
	            disponibilidade = "Indisponível";
	        }
	        modelo.addRow(new Object[] {sala.getIdSala(), sala.getPreco(), sala.getTemp(), sala.getCap(), disponibilidade});
	    }
	    
	    table.setModel(modelo);

}
}