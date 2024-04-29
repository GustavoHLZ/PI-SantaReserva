package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.comboBoxPreco;
import controle.SalaReunioesDAO;
import modelo.Hospedes;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaSalaDeReunioes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String valor;
	private ArrayList<SalaReunioes> listaSala = new ArrayList<SalaReunioes>();
	private SalaReunioes salaSelecionado;
	private Hospedes hosplogado;
	private Hospedes usuariologado;
	private SalaReunioes salaalugada;
	private JTable table;
	private JTextField textCheckIn;
	private JTextField textCheckOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSalaDeReunioes frame = new TelaSalaDeReunioes(null);
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
	public TelaSalaDeReunioes(Hospedes hospede) {
		hosplogado = hospede;
		usuariologado = hosplogado;
		
		setTitle("Sala De Reunioes");
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
		lblNewLabel.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/LogoAPP.png")));
		PainelTopo.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeUser.png")));
		PainelTopo.add(lblNewLabel_19, "cell 1 0");
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, "cell 0 1,grow");
		
		JPanel PainelFiltro = new JPanel();
		contentPane.add(PainelFiltro, "cell 1 1,grow");
		PainelFiltro.setLayout(new MigLayout("", "[250px][250px][144px]", "[][58px]"));
		
		JPanel PainelIcones = new JPanel();
		contentPane.add(PainelIcones, "cell 0 2,grow");
		PainelIcones.setLayout(new MigLayout("", "[][]", "[][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][50px][][300px][][][][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeHome.png")));
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
		lblNewLabel_3.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconePerfil.png")));
		PainelIcones.add(lblNewLabel_3, "cell 0 3");
		
		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_4, "cell 1 3");
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeReserva.png")));
		PainelIcones.add(lblNewLabel_11, "cell 0 5");
		
		JLabel lblNewLabel_5 = new JLabel("Reserva");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaReservas c = new TelaReservas(hospede, null, null , salaalugada, null);
				c.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_5, "cell 1 5");
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		PainelIcones.add(lblNewLabel_12, "cell 0 7");
		
		JLabel lblNewLabel_6 = new JLabel("Sala de Reuniões");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_6, "cell 1 7");
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeComputadores.png")));
		PainelIcones.add(lblNewLabel_13, "cell 0 9");
		
		JLabel lblNewLabel_7 = new JLabel("Computadores");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_7, "cell 1 9");
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeQuartos.png")));
		PainelIcones.add(lblNewLabel_14, "cell 0 11");
		
		JLabel lblNewLabel_8 = new JLabel("Quartos");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaQuartos c = new TelaQuartos(hospede);
				c.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_8, "cell 1 11");
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeAvalie.png")));
		PainelIcones.add(lblNewLabel_15, "cell 0 13");
		
		JLabel lblNewLabel_9 = new JLabel("Avalie-nos");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_9, "cell 1 13");
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeInformacoes.png")));
		PainelIcones.add(lblNewLabel_16, "cell 0 15");
		
		JLabel lblNewLabel_10 = new JLabel("Nossas Informações");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_10, "cell 1 15");
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeConfiguracoes.png")));
		PainelIcones.add(lblNewLabel_18, "cell 0 25");
		
		JLabel lblNewLabel_17 = new JLabel("Configurações");
		lblNewLabel_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_17, "cell 1 25");
		
		JPanel PainelPrincipal = new JPanel();
		contentPane.add(PainelPrincipal, "cell 1 2,grow");
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
		                salaalugada = listaSala.get(posicaoSala);
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
				TelaReservas telaReservas = new TelaReservas(hosplogado, usuariologado , null , salaalugada, null);
		        telaReservas.setVisible(true);
				atualizarJTable();
			}
		});
		
		JPanel panel_19 = new JPanel();
		PainelPrincipal.add(panel_19, "flowx,cell 0 1");
		
		JLabel lblNewLabel_21 = new JLabel("Check-in");
		PainelPrincipal.add(lblNewLabel_21, "cell 0 1");
		
		textCheckIn = new JTextField();
		PainelPrincipal.add(textCheckIn, "cell 0 1");
		textCheckIn.setColumns(10);
		
		JPanel panel_20 = new JPanel();
		PainelPrincipal.add(panel_20, "cell 0 1");
		
		JLabel lblNewLabel_22 = new JLabel("Check-Out");
		PainelPrincipal.add(lblNewLabel_22, "cell 0 1");
		
		textCheckOut = new JTextField();
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
	    listaSala = SalaDAO.listarSalaReunioes();

	    for (int i = 0; i < listaSala.size(); i++) {
	        SalaReunioes sala = listaSala.get(i);
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