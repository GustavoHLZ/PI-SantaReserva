package visao;

import java.awt.Color;
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
import javax.swing.text.MaskFormatter;

import controle.PagamentoDAO;
import modelo.Hospedes;
import net.miginfocom.swing.MigLayout;
import modelo.Pagamento;

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
	private JTextField textNome;
	private JTextField textNumCartao;
	private JTextField textValidade;
	private JTextField textSeguranca;
	private JTextField textBoleto;
	private JTextField textPix;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPagamento frame = new TelaPagamento();
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
	public TelaPagamento() {
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
				TelaPerfil c = new TelaPerfil(null);
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
				//TelaReservas c = new TelaReservas(hosplogado);
				//c.setVisible(true);
				//();
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
				//TelaSalaDeReunioes c = new TelaSalaDeReunioes(hosplogado);
				//c.setVisible(true);
				//dispose();
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
		lblNewLabel_21.setBounds(35, 36, 67, 14);
		PainelPrincipal.add(lblNewLabel_21);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(513, 26, 566, 307);
		PainelPrincipal.add(panel_20);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_20.add(scrollPane);

		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(560, 300)); // Defina as dimensões do JScrollPane conforme necessário
		panel_20.add(scrollPane);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "IDPagamento", "Nome", "Número", "Validade","COD Segurança", "Num Boleto", "Num Pix" }));
		
		
		
		JPanel panel_19 = new JPanel();
		panel_19.setBounds(17, 365, 1088, 103);
		PainelPrincipal.add(panel_19);
		panel_19.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[][][][]"));
		
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
		lbApagar.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Botões/Apagar Avalição.png")));
		panel_19.add(lbApagar, "cell 2 2,grow");
		
		JLabel lblatualizar = new JLabel("");
		panel_19.add(lblatualizar, "cell 12 2,grow");
		lblatualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				 int linhaSelecionada = table.getSelectedRow();
			        if (linhaSelecionada >= 0) {
			            int idpagamento = (int) table.getValueAt(linhaSelecionada, 0);
			            String novonome = textNome.getText();
			            Integer novonumcartao = Integer.valueOf(textNumCartao.getText());
			            String novovalidade = textValidade.getText();
			            Integer novoseg = Integer.valueOf(textSeguranca.getText());
			            Integer novonumboleto = Integer.valueOf(textBoleto.getText());
			            Integer novonumpix = Integer.valueOf(textPix.getText());

			            PagamentoDAO dao = PagamentoDAO.getInstancia();
			            boolean atualizado = dao.atualizarPagamento(idpagamento, novonome, novonumcartao, novovalidade, novoseg, novonumboleto, novonumpix);
			            
			            if (atualizado) {
			                JOptionPane.showMessageDialog(null, "Avaliação atualizada com sucesso!");
			                atualizarJTable(); 
			            } else {
			                JOptionPane.showMessageDialog(null, "Falha ao atualizar avaliação!");
			            }
			        }
			}
		});
		
		
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
		
		
		lblatualizar.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Botões/Atualizar Avaliação.png")));
		
		JLabel lblFazerAvaliacao = new JLabel("");
		lblFazerAvaliacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String nome = textNome.getText();
		        Integer numcartao = Integer.valueOf(textNumCartao.getText());
		        String validade = textValidade.getText();
		        Integer seg = Integer.valueOf(textSeguranca.getText());
		        Integer numboleto = Integer.valueOf(textBoleto.getText());
		        Integer numpix = Integer.valueOf(textPix.getText());
		        
		        Pagamento pagamentos = new Pagamento();
		        
		        pagamentos.setNometitular(nome);
		        pagamentos.setNumeroCartao(numcartao);
		        pagamentos.setDataValidade(validade);
		        pagamentos.setCodigoSeguranca(seg);
		        pagamentos.setNumeroBoleto(numboleto);
		        pagamentos.setNumeroPix(numpix);
		        
		        PagamentoDAO dao = PagamentoDAO.getInstancia();
		        
		        int retorno = dao.InserirPagamento(pagamentos);
		        
		        if (retorno > 0) {
		            JOptionPane.showMessageDialog(null, "Avaliação inserida com sucesso!");
		            pagamentos.setIdPagamento(retorno);
		            listarPagamento.add(pagamentos);
		            atualizarJTable();
		        } else {
		            JOptionPane.showMessageDialog(null, "Falha ao inserir avaliação!");
		        }
				
			}
		});
		lblFazerAvaliacao.setIcon(new ImageIcon(TelaPagamento.class.getResource("/visao/Botões/BTN Efetuar Pagamento.png")));
		panel_19.add(lblFazerAvaliacao, "cell 16 2,grow");
		
		textNome = new JTextField();
		textNome.setBounds(158, 33, 86, 20);
		PainelPrincipal.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("Número Cartão:");
		lblNewLabel_20.setBounds(35, 75, 110, 14);
		PainelPrincipal.add(lblNewLabel_20);
		
		JLabel lblNewLabel_22 = new JLabel("Validade:");
		lblNewLabel_22.setBounds(35, 115, 86, 14);
		PainelPrincipal.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Códico de Segurança:");
		lblNewLabel_23.setBounds(35, 155, 125, 14);
		PainelPrincipal.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Num Boleto:");
		lblNewLabel_24.setBounds(32, 198, 89, 14);
		PainelPrincipal.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Num Pix:");
		lblNewLabel_25.setBounds(35, 240, 110, 14);
		PainelPrincipal.add(lblNewLabel_25);
		
		textNumCartao = new JTextField();
		textNumCartao.setBounds(158, 72, 86, 20);
		PainelPrincipal.add(textNumCartao);
		textNumCartao.setColumns(10);
		
		MaskFormatter mascaradata = null;

		try {

			mascaradata = new MaskFormatter("##/##");

		} catch (ParseException e) {

			e.printStackTrace();

		}
		
		textValidade = new JFormattedTextField(mascaradata);
		textValidade.setBounds(158, 112, 86, 20);
		PainelPrincipal.add(textValidade);
		textValidade.setColumns(10);
		
		MaskFormatter mascaranum = null;

		try {

			mascaranum = new MaskFormatter("###");
			mascaranum.setAllowsInvalid(false);

		} catch (ParseException e) {

			e.printStackTrace();

		}
		
		textSeguranca = new JFormattedTextField(mascaranum);
		textSeguranca.setBounds(158, 152, 86, 20);
		PainelPrincipal.add(textSeguranca);
		textSeguranca.setColumns(10);
		
		textBoleto = new JTextField();
		textBoleto.setBounds(158, 195, 86, 20);
		PainelPrincipal.add(textBoleto);
		textBoleto.setColumns(10);
		
		textPix = new JTextField();
		textPix.setBounds(158, 237, 86, 20);
		PainelPrincipal.add(textPix);
		textPix.setColumns(10);
		
		
		
		
		
	}
	protected void atualizarJTable() {
	    DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "IDPagamento", "Nome", "Número", "Validade" ,"COD Segurança", "Num Boleto", "Num Pix" });

	    PagamentoDAO pagamentodao = PagamentoDAO.getInstancia();
	    listarPagamento = pagamentodao.listarPagamento();

	    for (int i = 0; i < listarPagamento.size(); i++) {
	        Pagamento pagamento = listarPagamento.get(i);

	        modelo.addRow(new Object[] {pagamento.getIdPagamento(), pagamento.getNometitular(), pagamento.getNumeroCartao(), pagamento.getDataValidade(), pagamento.getCodigoSeguranca(), pagamento.getNumeroBoleto(), pagamento.getNumeroPix()});
	    }
	    table.setModel(modelo);
	}
}