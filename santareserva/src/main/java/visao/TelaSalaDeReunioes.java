package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.MaskFormatter;

import modelo.comboBoxPreco;
import controle.RoundedBorder;
import controle.SalaReunioesDAO;
import modelo.Hospedes;
import modelo.Reserva;
import modelo.SalaReunioes;
import modelo.TipoHoras;
import modelo.comboBoxDisponivel;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.time.DateTimeException;
import java.time.LocalDate;
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
	private SalaReunioes salaalugada;
	private JTable table;
	private JTextField textCheckIn;
	private JTextField textCheckOut;
	private Reserva reserva;


	public TelaSalaDeReunioes(Hospedes hospede,Reserva reserva) {
		this.reserva=reserva;
		/* TEM Q TER EM TODAS AS TELAS */
		hosplogado = hospede;

		/* TEM Q TER EM TODAS AS TELAS */
		setTitle("Sala De Reunioes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(228, 228, 228));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		RoundedBorder bordaVermelha = new RoundedBorder(Color.red, 10);
		RoundedBorder bordaPreta = new RoundedBorder(Color.black, 10);
	
		
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[300px][grow]", "[100px][grow]"));
		
		JPanel PainelTopo = new JPanel();
		PainelTopo.setBackground(new Color(119, 165, 175));
		contentPane.add(PainelTopo, "cell 0 0 2 1,grow");
		PainelTopo.setLayout(new MigLayout("", "[][grow][100px]", "[][]"));
		
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
		lblNewLabel_1.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeHome.png")));
		PainelIcones.add(lblNewLabel_1, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaHome c = new TelaHome(hosplogado,reserva);
				c.setVisible(true);
				dispose();
		
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_2, "cell 1 0");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconePerfil.png")));
		PainelIcones.add(lblNewLabel_3, "cell 0 1,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaPerfil c = new TelaPerfil(hosplogado,reserva);
				c.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_4, "cell 1 1");
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeReserva.png")));
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
		lblNewLabel_12.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		PainelIcones.add(lblNewLabel_12, "cell 0 3,alignx center");
		
		JLabel lblNewLabel_6 = new JLabel("Sala de Reuniões");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_6, "cell 1 3");
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeComputadores.png")));
		PainelIcones.add(lblNewLabel_13, "cell 0 4,alignx center");
		
		JLabel lblNewLabel_7 = new JLabel("Computadores");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaComputadores c = new TelaComputadores(hosplogado,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_7, "cell 1 4");
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeQuartos.png")));
		PainelIcones.add(lblNewLabel_14, "cell 0 5,alignx center");
		
		JLabel lblNewLabel_8 = new JLabel("Quartos");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaQuartos c = new TelaQuartos(hospede,reserva);
				c.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_8, "cell 1 5");
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeAvalie.png")));
		PainelIcones.add(lblNewLabel_15, "cell 0 6,alignx center");
		
		JLabel lblNewLabel_9 = new JLabel("Avalie-nos");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaAvaliacoes c = new TelaAvaliacoes(hosplogado,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_9, "cell 1 6");
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeInformacoes.png")));
		PainelIcones.add(lblNewLabel_16, "cell 0 7,alignx center");
		
		JLabel lblNewLabel_10 = new JLabel("Nossas Informações");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaInformacoes c = new TelaInformacoes(hosplogado,reserva);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_10, "cell 1 7");
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Icones/IconeConfiguracoes.png")));
		PainelIcones.add(lblNewLabel_18, "cell 0 8,alignx center,aligny bottom");
		
		JLabel lblNewLabel_17 = new JLabel("Configurações");
		lblNewLabel_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_17, "cell 1 8,aligny bottom");
		
		JPanel PainelPrincipal = new JPanel();
		contentPane.add(PainelPrincipal, "cell 1 1,grow");
		PainelPrincipal.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JLabel lblNewLabel_20 = new JLabel("Sala de Reuniões");
		lblNewLabel_20.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 40));
		PainelPrincipal.add(lblNewLabel_20, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		PainelPrincipal.add(scrollPane, "cell 0 1,grow");
		
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
		
		JTableHeader header = table.getTableHeader();
	    header.setDefaultRenderer(new HeaderRenderer(table.getTableHeader().getDefaultRenderer()));
	    table.setRowHeight(30);
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Preço", "Tempo", "Capacidade", "Disponibilidade" }));
		
		JLabel lblReserva = new JLabel("");
		lblReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if (salaalugada != null) {  
		            if (salaalugada.getDisp()) {
				
				if (textCheckIn.getText().equals("  /  /    ") && textCheckOut.getText().equals("  /  /    ")) {
				    textCheckIn.setBorder(bordaVermelha);
				    textCheckOut.setBorder(bordaVermelha);
				    TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
				    System.out.println("1");
				    return;
				}
				
				LocalDate checkINN = null;
				
				if (textCheckIn.getText().equals("  /  /    ")) { 
				    textCheckIn.setBorder(bordaVermelha);
				    textCheckOut.setBorder(bordaPreta);
				    TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
				    System.out.println("11");
				    return;

				} else if (!textCheckIn.getText().matches("\\d{2}/\\d{2}/\\d{4}")) { 
				    textCheckIn.setBorder(bordaVermelha);
				    TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
				    System.out.println(textCheckIn.getText());
				    return;

				} else {
				    try {
				        String diaTxt = textCheckIn.getText().substring(0, 2); 
				        String mesTxt = textCheckIn.getText().substring(3, 5); 
				        String anoTxt = textCheckIn.getText().substring(6, 10); 

				        Integer dia = Integer.valueOf(diaTxt); 
				        Integer mes = Integer.valueOf(mesTxt); 
				        Integer ano = Integer.valueOf(anoTxt); 

				        checkINN = LocalDate.of(ano, mes, dia);
				        salaalugada.setCheckIn(checkINN);
				        textCheckIn.setBorder(bordaPreta);

				    } catch (DateTimeException ex) {
				        textCheckIn.setBorder(bordaVermelha);
				        TelanInserido tela = new TelanInserido();
				        tela.setVisible(true);
				        return;
				    }
				}            	
				LocalDate checkOUTT = null;

				if (textCheckOut.getText().equals("  /  /    ")) { 
				    textCheckOut.setBorder(bordaVermelha);
				    TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
				    return;

				} else if (!textCheckOut.getText().matches("\\d{2}/\\d{2}/\\d{4}")) { 
				    textCheckOut.setBorder(bordaVermelha);
				    TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
				    return;

				} else {
				    try {
				        String diaTxt = textCheckOut.getText().substring(0, 2); 
				        String mesTxt = textCheckOut.getText().substring(3, 5); 
				        String anoTxt = textCheckOut.getText().substring(6, 10); 

				        Integer dia = Integer.valueOf(diaTxt); 
				        Integer mes = Integer.valueOf(mesTxt); 
				        Integer ano = Integer.valueOf(anoTxt); 

				        checkOUTT = LocalDate.of(ano, mes, dia);
				        salaalugada.setCheckOut(checkOUTT);
				        textCheckOut.setBorder(bordaPreta);

				    } catch (DateTimeException ex) {
				        textCheckOut.setBorder(bordaVermelha);
				        TelanInserido tela = new TelanInserido();
				        tela.setVisible(true);
				        return;
				    }
				} 
				
				Integer idsala = salaalugada.getId();	
				
				SalaReunioesDAO dao = SalaReunioesDAO.getInstancia();
				
				dao.atualizarSalaReunioes(checkINN, checkOUTT, idsala);
				
				Float precoSalas = salaalugada.getPreco();
				
				reserva.setPrecoSalas(precoSalas);
				
				reserva.adicionarReserva(salaalugada);
				TelaReservas telaReservas = new TelaReservas(hosplogado,reserva);
		        telaReservas.setVisible(true);
				atualizarJTable();
				dispose();
				
		            } else { 
		                TelaIndisponivel tela = new TelaIndisponivel();
		                return;
		            } 
		        } else { 
		        	TelasEspaco tela = new TelasEspaco();
		        }
			}
		});
		
		JPanel panel_19 = new JPanel();
		PainelPrincipal.add(panel_19, "flowx,cell 0 2");
		
		MaskFormatter mascaraDat = null;

		try {

			mascaraDat = new MaskFormatter("##/##/####");

		} catch (ParseException e) {

			e.printStackTrace();

		}
		
		JLabel lblNewLabel_21 = new JLabel("Check-in");
		lblNewLabel_21.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 22));
		PainelPrincipal.add(lblNewLabel_21, "cell 0 2,aligny center");
		
		textCheckIn = new JFormattedTextField(mascaraDat);
		textCheckIn.setBorder(bordaPreta);
		PainelPrincipal.add(textCheckIn, "cell 0 2");
		textCheckIn.setColumns(10);
		
		JPanel panel_20 = new JPanel();
		PainelPrincipal.add(panel_20, "cell 0 2");
		
		JLabel lblNewLabel_22 = new JLabel("Check-Out");
		lblNewLabel_22.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 22));
		PainelPrincipal.add(lblNewLabel_22, "cell 0 2,aligny center");
		
		textCheckOut = new JFormattedTextField(mascaraDat);
		textCheckOut.setBorder(bordaPreta);
		PainelPrincipal.add(textCheckOut, "cell 0 2");
		textCheckOut.setColumns(10);
		
		JPanel panel = new JPanel();
		PainelPrincipal.add(panel, "cell 0 2");
		
		JPanel panel_1 = new JPanel();
		PainelPrincipal.add(panel_1, "cell 0 2");
		
		JPanel panel_2 = new JPanel();
		PainelPrincipal.add(panel_2, "cell 0 2");
		
		JPanel panel_3 = new JPanel();
		PainelPrincipal.add(panel_3, "cell 0 2");
		
		JPanel panel_5 = new JPanel();
		PainelPrincipal.add(panel_5, "cell 0 2");
		
		JPanel panel_6 = new JPanel();
		PainelPrincipal.add(panel_6, "cell 0 2");
		
		JPanel panel_7 = new JPanel();
		PainelPrincipal.add(panel_7, "cell 0 2");
		
		JPanel panel_8 = new JPanel();
		PainelPrincipal.add(panel_8, "cell 0 2");
		
		JPanel panel_9 = new JPanel();
		PainelPrincipal.add(panel_9, "cell 0 2");
		
		JPanel panel_10 = new JPanel();
		PainelPrincipal.add(panel_10, "cell 0 2");
		
		JPanel panel_11 = new JPanel();
		PainelPrincipal.add(panel_11, "cell 0 2");
		
		JPanel panel_12 = new JPanel();
		PainelPrincipal.add(panel_12, "cell 0 2");
		
		JPanel panel_13 = new JPanel();
		PainelPrincipal.add(panel_13, "cell 0 2");
		
		JPanel panel_14 = new JPanel();
		PainelPrincipal.add(panel_14, "cell 0 2");
		
		JPanel panel_15 = new JPanel();
		PainelPrincipal.add(panel_15, "cell 0 2");
		
		JPanel panel_16 = new JPanel();
		PainelPrincipal.add(panel_16, "cell 0 2");
		
		
		lblReserva.setIcon(new ImageIcon(TelaSalaDeReunioes.class.getResource("/visao/Botões/BTN Reserva.png")));
		PainelPrincipal.add(lblReserva, "cell 0 2,alignx center");
		
		atualizarJTable();
	}
	protected void atualizarJTable() {
	    DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] {"Preço", "Tempo", "Capacidade", "Disponibilidade" });
	    
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
	        modelo.addRow(new Object[] {sala.getPreco(), sala.getTemp(), sala.getCap(), disponibilidade});
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