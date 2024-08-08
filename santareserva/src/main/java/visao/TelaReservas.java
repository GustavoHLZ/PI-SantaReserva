package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.MaskFormatter;

import controle.ComputadoresDAO;
import controle.EspacosDAO;
import controle.IReserva;
import controle.PagamentoDAO;
import controle.QuartosDAO;
import controle.RoundedBorder;
import controle.SalaReunioesDAO;
import modelo.Computadores;
import modelo.Espacos;
import modelo.Hospedes;
import modelo.Infologin;
import modelo.Pagamento;
import modelo.Quartos;
import modelo.Reserva;
import modelo.SalaReunioes;
import modelo.comboBoxDisponivel;
import modelo.comboBoxOpcaoPagamento;
import modelo.comboBoxPreco;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Component;

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
	private static Quartos quartoalugado;
	private SalaReunioes salaalugada;
	private Computadores computadoralugado;

	private Hospedes hosplogado;
	private Quartos quartoSelecionado;
	private ArrayList<Quartos> listarQuartos;
	private JTable table;
	private ArrayList<Espacos> listarEspaco = new ArrayList<Espacos>();
	private Reserva reserva;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @param reserva 
	 */
	public TelaReservas(Hospedes hospede, Reserva reserva) {
		this.reserva=reserva;
		/* TEM Q TER EM TODAS AS TELAS */
		hosplogado = hospede;
	
		/* TEM Q TER EM TODAS AS TELAS */
		
		
		
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
		lblNewLabel_1.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeHome.png")));
		PainelIcones.add(lblNewLabel_1, "cell 0 0");
		
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
		lblNewLabel_3.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconePerfil.png")));
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
		lblNewLabel_11.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeReserva.png")));
		PainelIcones.add(lblNewLabel_11, "cell 0 2,alignx center");
		
		JLabel lblNewLabel_5 = new JLabel("Reserva");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_5, "cell 1 2");
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		PainelIcones.add(lblNewLabel_12, "cell 0 3,alignx center");
		
		JLabel lblNewLabel_6 = new JLabel("Sala de Reuniões");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				TelaSalaDeReunioes c = new TelaSalaDeReunioes(hosplogado,reserva);
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
				
				TelaComputadores c = new TelaComputadores(hosplogado,reserva);
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
				
				TelaQuartos c = new TelaQuartos(hosplogado,reserva);
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
				
				TelaAvaliacoes c = new TelaAvaliacoes(hosplogado,reserva);
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
		lblNewLabel_18.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeConfiguracoes.png")));
		PainelIcones.add(lblNewLabel_18, "cell 0 8,alignx center,aligny bottom");
		
		JLabel lblNewLabel_17 = new JLabel("Configurações");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_17, "cell 1 8,aligny bottom");
		
		JPanel PainelPrincipal = new JPanel();
		contentPane.add(PainelPrincipal, "cell 1 1,grow");
		PainelPrincipal.setLayout(new MigLayout("", "[grow][][][200px:n:200px,grow][][][][][][][][650px][][][grow][][][][][][][][][][][]", "[][][][grow][100px:n][][]"));
		
		JLabel lblNewLabel_26 = new JLabel("Reservas");
		lblNewLabel_26.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 40));
		PainelPrincipal.add(lblNewLabel_26, "cell 0 0 26 1");
		
		JPanel panel_2 = new JPanel();
		PainelPrincipal.add(panel_2, "cell 13 1 13 4,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow][30px][grow][30px][grow][30px][grow][30px][grow][grow][grow][grow][grow][grow][grow]"));
		
		
		JLabel lblNewLabel_21 = new JLabel("Nome Titular");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_21, "cell 0 0");
		
		txtNometitular = new JFormattedTextField();
		panel_2.add(txtNometitular, "cell 0 1,grow");
		txtNometitular.setColumns(10);
		
		MaskFormatter mascaraCart = null;

		try {
			mascaraCart = new MaskFormatter("####  #### #### ####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_22 = new JLabel("Número do Cartão");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_22, "cell 0 2");
		
		txtNumeroCartao = new JFormattedTextField(mascaraCart);
		panel_2.add(txtNumeroCartao, "cell 0 3,grow");
		txtNumeroCartao.setColumns(10);
		
		MaskFormatter mascaraDat = null;

		try {
			mascaraDat = new MaskFormatter("##/##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_23 = new JLabel("Data de Validade");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_23, "cell 0 4");
		
		MaskFormatter mascaraCod = null;

		try {
			mascaraCod = new MaskFormatter("###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtDataValidade = new JFormattedTextField(mascaraDat);
		panel_2.add(txtDataValidade, "cell 0 5,grow");
		txtDataValidade.setColumns(10);
		
		JLabel lblNewLabel_24 = new JLabel("Código de Segurança");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_24, "cell 0 6");
		
		txtCodigoSeguranca = new JFormattedTextField(mascaraCod);
		panel_2.add(txtCodigoSeguranca, "cell 0 7,grow");
		txtCodigoSeguranca.setColumns(10);
		
		JLabel lblNewLabel_25 = new JLabel("Total Sala de Reuniões");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_25, "cell 0 8");
		
		JLabel lblsalareunioes = new JLabel("-");
		lblsalareunioes.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblsalareunioes, "cell 0 9,grow");
		//if( != null) {
		//	lblsalareunioes.setText(salareunioes.getPreco().toString());
	//	}
		
		
		
		JLabel lblNewLabel_27 = new JLabel("Total Computadores");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_27, "cell 0 10");
		
		JLabel lblcomputadores = new JLabel("-");
		panel_2.add(lblcomputadores, "cell 0 11,alignx center");
		//if(computador != null) {
		//	lblcomputadores.setText(computador.getPreco().toString());
	//	}

		
		JLabel lblNewLabel_29 = new JLabel("Total Quartos");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_29, "cell 0 12");
		
		JLabel lblquartos = new JLabel("-");
		panel_2.add(lblquartos, "cell 0 13,alignx center");
		//if(quarto != null) {
		//	lblquartos.setText(quarto.getPreco().toString());
		//}

		
		JLabel lblNewLabel_31 = new JLabel("Total à pagar:");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_31, "cell 0 14");
		
		JLabel lbltotalpagar = new JLabel("-");
		panel_2.add(lbltotalpagar, "cell 0 15,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		PainelPrincipal.add(scrollPane, "cell 0 1 12 3,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID do Espaço" ,"Tipo" ,"Preço", "CheckIn", "CheckOut", "Ocupante" , "ID Hospede"}));
		
		JTableHeader header = table.getTableHeader();
	    header.setDefaultRenderer(new HeaderRenderer(table.getTableHeader().getDefaultRenderer()));
	    table.setRowHeight(30);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		ArrayList<IReserva> listasespacos = reserva.getLista();
		int[] computadorIntervalos = {41, 60, 131, 150};
		int[] salaReunioesIntervalos = {61, 80, 151, 170};
		for (IReserva reser : listasespacos) {
				int tipoEspaco;
			   int id = reser.getId();
			    String tipo = "";

			    if ((id >= computadorIntervalos[0] && id <= computadorIntervalos[1]) || 
			        (id >= computadorIntervalos[2] && id <= computadorIntervalos[3])) {
			        tipo = "Computador";
			        tipoEspaco = 1;
			    } else if ((id >= salaReunioesIntervalos[0] && id <= salaReunioesIntervalos[1]) ||
			             (id >= salaReunioesIntervalos[2] && id <= salaReunioesIntervalos[3])) {
			        tipo = "Sala de Reuniões";
			        tipoEspaco = 2;
			    } else {
			        tipo = "Quarto";
			        tipoEspaco = 3;
			    }
			
			   model.addRow(new Object[] {
					   reser.getId(),
					   tipo,
					   reser.getPreco(),
					   reser.getCheckIn(),
					   reser.getCheckOut(),
				        hosplogado.getNome(),
				        hosplogado.getIdHospede(),
			
		
		 });
		}
		
		JLabel lblNewLabel_34 = new JLabel("");
		lblNewLabel_34.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Remover a reserva do ArrayList no modelo
                    reserva.removerReserva(selectedRow);
                    // Remover a linha da tabela
                    atualizarJTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma reserva para remover.");
                }
			}
		});
		lblNewLabel_34.setIcon(new ImageIcon(TelaReservas.class.getResource("/visao/Botões/BTN Cancelar Reserva.png")));
		PainelPrincipal.add(lblNewLabel_34, "cell 3 5 8 1");
		
		JPanel panel_3 = new JPanel();
		PainelPrincipal.add(panel_3, "cell 14 5 11 1,grow");
		
		txtNometitular.setBorder(bordaPreta); 
		txtNometitular.setFont(new Font("Arial", Font.PLAIN, 25));
		
		txtNumeroCartao.setBorder(bordaPreta); 
		txtNumeroCartao.setFont(new Font("Arial", Font.PLAIN, 25));
		
		txtDataValidade.setBorder(bordaPreta); 
		txtDataValidade.setFont(new Font("Arial", Font.PLAIN, 25));
		
		txtCodigoSeguranca.setBorder(bordaPreta); 
		txtCodigoSeguranca.setFont(new Font("Arial", Font.PLAIN, 25));
		
		JLabel lblEfetuarPagamento = 
				new JLabel("");
		lblEfetuarPagamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!txtNometitular.getText().matches("[\\p{L}\\s~^]+")) {

					JOptionPane.showMessageDialog(null, "O nome deve conter apenas letras.");

					return;

				}
				
		        int selectedRow = table.getSelectedRow(); 
		        
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Nenhum espaço selecionado.");
		            return;
		        }
		        
		        boolean disp = false;
		        int id = (Integer) table.getValueAt(selectedRow, 0); 
		        String tipoEspaco = (String) table.getValueAt(selectedRow, 1); 
		        LocalDate checkIn = (LocalDate) table.getValueAt(selectedRow, 3); 
		        LocalDate checkOut = (LocalDate) table.getValueAt(selectedRow, 4); 
		     
		        if ("Computador".equals(tipoEspaco)) {
		            Computadores computadores = new Computadores();
		            computadores.setDisp(disp);
		        	ComputadoresDAO dao = ComputadoresDAO.getInstancia();
		            dao.atualizarComputadores(checkIn, checkOut, disp, id);
		           
		        } else if ("Sala de Reuniões".equals(tipoEspaco)) {
		        	SalaReunioes sala = new SalaReunioes();
		            sala.setDisp(disp);
		           SalaReunioesDAO dao = SalaReunioesDAO.getInstancia();
		           dao.atualizarSalaReunioes(checkIn, checkOut, disp, id);
		        	
		        } else if ("Quarto".equals(tipoEspaco)) {
		            Quartos quarto = new Quartos();
		            quarto.setDisp(disp);
		        	QuartosDAO dao = QuartosDAO.getInstancia();
		            dao.atualizarQuartos(checkIn, checkOut, disp, id);
		            
		        } else {
		            JOptionPane.showMessageDialog(null, "Tipo de espaço desconhecido.");
		            return;
		        }
		        
				
				    String nomeTitular = txtNometitular.getText();
				    String numeroCartaoStr = txtNumeroCartao.getText().replaceAll("\\s", ""); 
			        String dataValidade = txtDataValidade.getText();
			        String codigoSegurancaStr = txtCodigoSeguranca.getText().replaceAll("\\s", "");
					
			        Pagamento reserva = new Pagamento();
			        
			        long numeroCartao = Long.parseLong(numeroCartaoStr);
		            int codigoSeguranca = Integer.parseInt(codigoSegurancaStr);
		            
			        reserva.setNometitular(nomeTitular);
			        reserva.setNumeroCartao(numeroCartao);
			        reserva.setDataValidade(dataValidade);
			        reserva.setCodigoSeguranca(codigoSeguranca);
			        reserva.setNumeroBoleto(0);
			        reserva.setnumeroEspaco(id);
			        reserva.setHosp(hosplogado);
			        
			       
			        PagamentoDAO dao = PagamentoDAO.getInstancia();
			        
			        int retorno = dao.InserirPagamento(reserva);
			        
			        
			        if (retorno > 0) {
			            TelaRealizado abrir = new TelaRealizado();
			            reserva.setIdPagamento(retorno);
			            //listarEspaco.add(reserva);
			            atualizarJTable();
			        } else {
			        	TelaNaoRealizado abrir = new TelaNaoRealizado();
			        	abrir.setVisible(true);
			        }


			    }				
			
		});
		lblEfetuarPagamento.setIcon(new ImageIcon(TelaReservas.class.getResource("/visao/Botões/BTN Efetuar Pagamento.png")));
		panel_3.add(lblEfetuarPagamento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(84, 113, 119));
		panel_1.setForeground(new Color(84, 113, 119));
		PainelPrincipal.add(panel_1, "cell 12 1 1 24,grow");
		
		JLabel lblNewLabel_20 = new JLabel("");
		PainelPrincipal.add(lblNewLabel_20, "cell 3 6");
		
	}
	
	protected void atualizarJTable() {
	    DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] {"ID do Espaço" ,"Tipo" ,"Preço", "CheckIn", "CheckOut", "Ocupante" , "ID Hospede"});

	    //EspacosDAO EspacoDAO = EspacosDAO.getInstancia();
	    //listarEspaco = EspacoDAO.listarEspacos();
	    
	    MaskFormatter mascaraDat = null;

		try {

			mascaraDat = new MaskFormatter("##/##/####");

		} catch (ParseException e) {

			e.printStackTrace();

		}

	    for (IReserva r : this.reserva.getLista()) {
	    	  int id = r.getId();
			    String tipo = "";
			    
				int[] computadorIntervalos = {41, 60, 131, 150};
				int[] salaReunioesIntervalos = {61, 80, 151, 170};
			    if ((id >= computadorIntervalos[0] && id <= computadorIntervalos[1]) || 
			        (id >= computadorIntervalos[2] && id <= computadorIntervalos[3])) {
			        tipo = "Computador";
			    } else if ((id >= salaReunioesIntervalos[0] && id <= salaReunioesIntervalos[1]) ||
			             (id >= salaReunioesIntervalos[2] && id <= salaReunioesIntervalos[3])) {
			        tipo = "Sala de Reuniões";
			    } else {
			        tipo = "Quarto";
			    }
			    modelo.addRow(new Object[] {
			            r.getId(),
			            tipo,
			            r.getPreco(),
			            r.getCheckIn(),
			            r.getCheckOut(),
			            hosplogado.getNome(),
			            hosplogado.getIdHospede()
			        });
			
		}
	   /* for (int i = 0; i < this.reserva.size(); i++) {
	        Espacos espaco = this.reserva.get(i);
	        modelo.addRow(new Object[] {espaco.getFkidQuartos()});
	    }
	    */
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
