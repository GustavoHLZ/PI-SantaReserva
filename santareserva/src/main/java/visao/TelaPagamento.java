package visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.MaskFormatter;

import controle.PagamentoDAO;
import modelo.Hospedes;
import net.miginfocom.swing.MigLayout;
import modelo.Pagamento;
import modelo.Reserva;

public class TelaPagamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Hospedes Hospedes = null;
	private JPanel contentPane;
	private ArrayList<Pagamento> listarPagamento = new ArrayList<Pagamento>();
	private Pagamento pagamentoselecionado;
	private JTable table;
	private static Hospedes hosplogado;
	private Hospedes usuariologado;
	private Reserva reserva;
	
	public TelaPagamento(Hospedes hospede,Reserva reserva) {
		this.reserva=reserva;
		
		/* TEM Q TER EM TODAS AS TELAS */
		hosplogado = hospede;
		usuariologado = hosplogado;
		/* TEM Q TER EM TODAS AS TELAS */
		
		setTitle("Quartos");
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
		PainelTopo.setLayout(new MigLayout("", "[1800px][]", "[][]")); 
		 
		JLabel lblNewLabel = new JLabel(""); 
		lblNewLabel.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/LogoCerta2.png"))); 
		PainelTopo.add(lblNewLabel, "cell 0 0 1 2"); 
		
		JLabel lblNewLabel_53 = new JLabel("Olá,");
		lblNewLabel_53.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelTopo.add(lblNewLabel_53, "flowx,cell 1 0,alignx right,aligny bottom");
		
		JLabel lblNameuser = new JLabel("");
		lblNameuser.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelTopo.add(lblNameuser, "cell 1 0 1 2,alignx right,aligny bottom");
		lblNameuser.setText(hosplogado.getNome());
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Icones/iconeUser.png")));
		PainelTopo.add(lblNewLabel_19, "cell 2 0,alignx center,aligny center");
		
		JLabel lblNewLabel_51 = new JLabel("");
		lblNewLabel_51.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_51.setIcon(new ImageIcon(TelaHome.class.getResource("/visao/Botões/BtnSair.png")));
		PainelTopo.add(lblNewLabel_51, "cell 2 1,alignx center");
		
		JPanel PainelIcones = new JPanel();
		contentPane.add(PainelIcones, "cell 0 1,grow");
		PainelIcones.setLayout(new MigLayout("", "[][]", "[70px][70px][70px][70px][70px][70px][70px][70px][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeHome.png")));
		PainelIcones.add(lblNewLabel_1, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaHome c = new TelaHome(hospede,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_2, "cell 1 0");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconePerfil.png")));
		PainelIcones.add(lblNewLabel_3, "cell 0 1,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPerfil c = new TelaPerfil(hospede,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_4, "cell 1 1");
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeReserva.png")));
		PainelIcones.add(lblNewLabel_11, "cell 0 2,alignx center");
		
			JLabel lblNewLabel_5 = new JLabel("Pagamento"); 
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
			PainelIcones.add(lblNewLabel_5, "cell 1 2"); 
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		PainelIcones.add(lblNewLabel_12, "cell 0 3,alignx center");
		
		JLabel lblNewLabel_6 = new JLabel("Sala de Reuniões");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaSalaDeReunioes c = new TelaSalaDeReunioes(hospede,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_6, "cell 1 3");
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeComputadores.png")));
		PainelIcones.add(lblNewLabel_13, "cell 0 4,alignx center");
		
		JLabel lblNewLabel_7 = new JLabel("Computadores");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaComputadores tela  = new TelaComputadores(hospede, reserva);
				tela.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_7, "cell 1 4");
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeQuartos.png")));
		PainelIcones.add(lblNewLabel_14, "cell 0 5,alignx center");
		
		JLabel lblNewLabel_8 = new JLabel("Quartos");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaQuartos tela = new TelaQuartos(hospede, reserva);
				tela.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_8, "cell 1 5");
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeAvalie.png")));
		PainelIcones.add(lblNewLabel_15, "cell 0 6,alignx center");
		
		JLabel lblNewLabel_9 = new JLabel("Avalie-nos");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaAvaliacoes tela = new TelaAvaliacoes(hospede, reserva);
				tela.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_9, "cell 1 6");
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeInformacoes.png")));
		PainelIcones.add(lblNewLabel_16, "cell 0 7,alignx center");
		
		JLabel lblNewLabel_10 = new JLabel("Nossas Informações");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaInformacoes tela = new TelaInformacoes(hospede, reserva);
				tela.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_10, "cell 1 7");
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Icones/IconeConfiguracoes.png")));
		PainelIcones.add(lblNewLabel_18, "cell 0 8,aligny bottom");
		
		JLabel lblNewLabel_17 = new JLabel("Configurações");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_17, "cell 1 8,aligny bottom");
		
		MaskFormatter mascaradata = null;

		try {

			mascaradata = new MaskFormatter("##/##");

		} catch (ParseException e) {

			e.printStackTrace();

		}
		
		MaskFormatter mascaranum = null;

		try {

			mascaranum = new MaskFormatter("###");
			mascaranum.setAllowsInvalid(false);

		} catch (ParseException e) {

			e.printStackTrace();

		}
		
		JPanel PainelPrincipal = new JPanel();
		contentPane.add(PainelPrincipal, "cell 1 1,grow");
		PainelPrincipal.setLayout(new MigLayout("", "[grow]", "[][grow][103px]"));
				
				JLabel lblNewLabel_20 = new JLabel("Pagamentos");
				lblNewLabel_20.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 40));
				PainelPrincipal.add(lblNewLabel_20, "cell 0 0");
				
				JScrollPane scrollPane = new JScrollPane();
				PainelPrincipal.add(scrollPane, "cell 0 1,grow");
				
						table = new JTable();
						scrollPane.setViewportView(table);
						atualizarJTable();
						
						JTableHeader header = table.getTableHeader();
					    header.setDefaultRenderer(new HeaderRenderer(table.getTableHeader().getDefaultRenderer()));
					    table.setRowHeight(30);
					    
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if (e.getClickCount() == 1) {
						            JTable source = (JTable) e.getSource();
						            int posicaopagamento = source.getSelectedRow();
						            if (posicaopagamento != -1) {
						                pagamentoselecionado = listarPagamento.get(posicaopagamento); 
						            }
						        }
							
							}
						});
						
						table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "IDPagamento", "Nome", "Número", "Validade","COD Segurança", "Num espaço" }));
						
				JPanel panel_19 = new JPanel();
				PainelPrincipal.add(panel_19, "cell 0 2 5 1,grow");
				panel_19.setLayout(new MigLayout("", "[grow]", "[]"));
				
				JLabel lbApagar = new JLabel("");
				lbApagar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						int idHospede = pagamentoselecionado.getIdPagamento();
						
					       PagamentoDAO dao = PagamentoDAO.getInstancia();
					        dao.removerPagamento(idHospede);
					       atualizarJTable();
						
					}
				});
				lbApagar.setIcon(new ImageIcon(TelaPagamento.class.getResource("/visao/Botões/BtnExcluirPagamento.png")));
				panel_19.add(lbApagar, "cell 0 2,alignx center,growy");
		
		
		
		
		
	}
	protected void atualizarJTable() {
	    DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "IDPagamento", "Nome", "Número", "Validade" ,"COD Segurança", "Num Espaço" });

	    PagamentoDAO pagamentodao = PagamentoDAO.getInstancia();
	    listarPagamento = pagamentodao.listarPagamento();

	    for (int i = 0; i < listarPagamento.size(); i++) {
	        Pagamento pagamento = listarPagamento.get(i);

	        modelo.addRow(new Object[] {pagamento.getIdPagamento(), pagamento.getNometitular(), pagamento.getNumeroCartao(), pagamento.getDataValidade(), pagamento.getCodigoSeguranca(), pagamento.getNumeroEspaco()});
	    }
	    table.setModel(modelo);
	}
	
	private static class HeaderRenderer implements TableCellRenderer {
        private final TableCellRenderer delegate;

        public HeaderRenderer(TableCellRenderer delegate) {
            this.delegate = delegate;
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = delegate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Color topo = new Color(119, 165, 175);
            c.setBackground(topo = new Color(119, 165, 175)); 
            c.setForeground(Color.WHITE); 
            c.setFont(new Font("Arial", Font.TRUETYPE_FONT, 18)); 
            return c;
        }
	}
}