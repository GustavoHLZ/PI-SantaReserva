package visao; 
 
import java.awt.EventQueue; 
 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder; 
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.MaskFormatter; 
 
import controle.AvaliacoesDAO; 
import controle.HospedesDAO; 
import controle.InfologinDAO; 
import controle.Quarto; 
import controle.QuartosDAO;
import controle.RoundedBorder;
import modelo.Avaliacoes; 
import modelo.Hospedes; 
import modelo.Infologin; 
import modelo.Quartos;
import modelo.Reserva;
import modelo.TipoHoras; 
import modelo.comboBoxDisponivel; 
import modelo.comboBoxPreco; 
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
	private ArrayList<Avaliacoes> listarAvaliacoes = new ArrayList<Avaliacoes>(); 
	private Hospedes usuariologado; 
	private Avaliacoes avaliacoesselc; 
	private JTextField txtNome; 
	private JTextField txtAvaliacao; 
	private JTable table; 
	private JTextField txtComentario; 
	private static Hospedes hosplogado; 
	private Quartos quartoSelecionado; 
	private Reserva reserva;
 
 
	/** 
	 * Launch the application. 
	 */ 
 
	/** 
	 * Create the frame. 
	 */ 
	public TelaAvaliacoes(Hospedes hospede,Reserva reserva) { 
		this.reserva=reserva;
		hosplogado = hospede; 
		usuariologado = hosplogado; 
		 
		 
		setTitle("Quartos"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setUndecorated(true); 
		setBounds(0, 0, 1920, 1080); 
		contentPane = new JPanel(); 
		contentPane.setBackground(new Color(228, 228, 228)); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		RoundedBorder bordaVermelha = new RoundedBorder(Color.red, 10);
		RoundedBorder bordaPreta = new RoundedBorder(Color.black, 10);
 
		setContentPane(contentPane); 
		contentPane.setLayout(new MigLayout("", "[350px][grow]", "[100px][grow][grow][grow]")); 
		 
		JPanel PainelTopo = new JPanel(); 
		PainelTopo.setBackground(new Color(119, 165, 175)); 
		contentPane.add(PainelTopo, "cell 0 0 2 1,grow"); 
		PainelTopo.setLayout(new MigLayout("", "[][grow][100px]", "[][]")); 
		 
		JPanel PainelIcones = new JPanel(); 
		PainelIcones.setBackground(new Color(240, 240, 240)); 
		contentPane.add(PainelIcones, "cell 0 1 1 3,grow"); 
		PainelIcones.setLayout(new MigLayout("", "[][]", "[70px][70px][70px][70px][70px][70px][70px][70px][grow]")); 
		 
		JLabel lblNewLabel_1 = new JLabel(""); 
		lblNewLabel_1.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeHome.png"))); 
		PainelIcones.add(lblNewLabel_1, "cell 0 0"); 
		 
		JLabel lblNewLabel_2 = new JLabel("Home"); 
		lblNewLabel_2.addMouseListener(new MouseAdapter() { 
			@Override 
			public void mouseClicked(MouseEvent e) { 
				TelaHome c = new TelaHome(usuariologado,reserva); 
				c.setVisible(true); 
				dispose(); 
			} 
		}); 
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
		PainelIcones.add(lblNewLabel_2, "cell 1 0"); 
		 
		JLabel lblNewLabel_3 = new JLabel(""); 
		lblNewLabel_3.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconePerfil.png"))); 
		PainelIcones.add(lblNewLabel_3, "cell 0 1"); 
		 
		JLabel lblNewLabel_4 = new JLabel("Perfil"); 
		lblNewLabel_4.addMouseListener(new MouseAdapter() { 
			@Override 
			public void mouseClicked(MouseEvent e) { 
				TelaPerfil c = new TelaPerfil(usuariologado,reserva); 
				c.setVisible(true); 
				dispose(); 
			} 
		}); 
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
		PainelIcones.add(lblNewLabel_4, "cell 1 1"); 
		 
		JLabel lblNewLabel_11 = new JLabel(""); 
		lblNewLabel_11.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeReserva.png"))); 
		PainelIcones.add(lblNewLabel_11, "cell 0 2"); 
		 
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
		lblNewLabel_12.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeSalaReunioes.png"))); 
		PainelIcones.add(lblNewLabel_12, "cell 0 3"); 
		 
		JLabel lblNewLabel_6 = new JLabel("Sala de Reuniões"); 
		lblNewLabel_6.addMouseListener(new MouseAdapter() { 
			@Override 
			public void mouseClicked(MouseEvent e) { 
				TelaSalaDeReunioes c = new TelaSalaDeReunioes(usuariologado,reserva); 
				c.setVisible(true); 
				dispose(); 
			} 
		}); 
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
		PainelIcones.add(lblNewLabel_6, "cell 1 3"); 
		 
		JLabel lblNewLabel_13 = new JLabel(""); 
		lblNewLabel_13.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeComputadores.png"))); 
		PainelIcones.add(lblNewLabel_13, "cell 0 4"); 
		 
		JLabel lblNewLabel_7 = new JLabel("Computadores"); 
		lblNewLabel_7.addMouseListener(new MouseAdapter() { 
			@Override 
			public void mouseClicked(MouseEvent e) { 
				TelaComputadores c = new TelaComputadores(usuariologado,reserva); 
				c.setVisible(true); 
				dispose(); 
			} 
		}); 
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
		PainelIcones.add(lblNewLabel_7, "cell 1 4"); 
		 
		JLabel lblNewLabel_14 = new JLabel(""); 
		lblNewLabel_14.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeQuartos.png"))); 
		PainelIcones.add(lblNewLabel_14, "cell 0 5"); 
		 
		JLabel lblNewLabel_8 = new JLabel("Quartos"); 
		lblNewLabel_8.addMouseListener(new MouseAdapter() { 
			@Override 
			public void mouseClicked(MouseEvent e) { 
				TelaQuartos c = new TelaQuartos(usuariologado,reserva); 
				c.setVisible(true); 
				dispose(); 
			} 
		}); 
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
		PainelIcones.add(lblNewLabel_8, "cell 1 5"); 
		 
		JLabel lblNewLabel_15 = new JLabel(""); 
		lblNewLabel_15.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeAvalie.png"))); 
		PainelIcones.add(lblNewLabel_15, "cell 0 6"); 
		 
		JLabel lblNewLabel_9 = new JLabel("Avalie-nos"); 
		lblNewLabel_9.addMouseListener(new MouseAdapter() { 
			@Override 
			public void mouseClicked(MouseEvent e) { 
				 
			} 
		}); 
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
		PainelIcones.add(lblNewLabel_9, "cell 1 6"); 
		 
		JLabel lblNewLabel_16 = new JLabel(""); 
		lblNewLabel_16.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeInformacoes.png"))); 
		PainelIcones.add(lblNewLabel_16, "cell 0 7"); 
		 
		JLabel lblNewLabel_10 = new JLabel("Nossas Informações"); 
		lblNewLabel_10.addMouseListener(new MouseAdapter() { 
			@Override 
			public void mouseClicked(MouseEvent e) { 
				 
				TelaInformacoes c = new TelaInformacoes(usuariologado,reserva); 
				c.setVisible(true); 
				dispose(); 
			} 
		}); 
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
		PainelIcones.add(lblNewLabel_10, "cell 1 7"); 
		 
		JLabel lblNewLabel_18 = new JLabel(""); 
		lblNewLabel_18.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeConfiguracoes.png"))); 
		PainelIcones.add(lblNewLabel_18, "cell 0 8,aligny bottom"); 
		 
		JLabel lblNewLabel_17 = new JLabel("Configurações"); 
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
		PainelIcones.add(lblNewLabel_17, "cell 1 8,aligny bottom");
		 
		MaskFormatter mascaraAva = null; 
 
		try { 
 
			mascaraAva = new MaskFormatter("#.#"); 
 
		} catch (ParseException e) { 
 
			e.printStackTrace(); 
 
		} 
		 
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
		 
		JPanel PainelPrincipal1 = new JPanel(); 
		contentPane.add(PainelPrincipal1, "cell 1 1 1 3,grow"); 
		PainelPrincipal1.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow]")); 
		
		JPanel panel = new JPanel();
		PainelPrincipal1.add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[][grow]", "[40px][40px][40px]")); 
		
		JLabel lblNewLabel21 = new JLabel("Nome:");
		lblNewLabel21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel21, "cell 0 0");
		 
		txtNome = new JTextField();
		txtNome.setBorder(bordaPreta);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtNome, "cell 1 0,growx,aligny center");
		txtNome.setColumns(10); 
		txtNome.setText(usuariologado.getNome()); 
		

		 
		JLabel lblNewLabel22 = new JLabel("Nota:"); 
		lblNewLabel22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel22, "cell 0 1");
		lblNewLabel22.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtAvaliacao = new JFormattedTextField(mascaraAva);
		txtAvaliacao.setBorder(bordaPreta);
		txtAvaliacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtAvaliacao, "cell 1 1,growx,aligny center");
		txtAvaliacao.setColumns(10); 
		
		JLabel lblNewLabel_20 = new JLabel("Comentario:");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_20, "cell 0 2");
		
		txtComentario = new JTextField();
		txtComentario.setBorder(bordaPreta);
		txtComentario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtComentario, "cell 1 2,growx,aligny center");
		txtComentario.setColumns(10);

											table = new JTable(); 
											JScrollPane scrollPane = new JScrollPane(table); 
											PainelPrincipal1.add(scrollPane, "cell 1 0 2 1,grow");
											scrollPane.setPreferredSize(new Dimension(560, 300));
											table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "IDAvaliacao", "Avaliador", "Avaliação", "comentario", "fkIDHospede" })); 
											
											
											table.addMouseListener(new MouseAdapter() { 
												@Override 
												public void mouseClicked(MouseEvent e) { 
													if (e.getClickCount() == 1) { 
											           JTable source = (JTable) e.getSource(); 
											           int posicaoavaliacao = source.getSelectedRow(); 
											           if (posicaoavaliacao != -1) { 
											           	avaliacoesselc = listarAvaliacoes.get(posicaoavaliacao);  
											           } 
											       } 
												 
												} 
											}); 
											atualizarJTable();
											
											 JTableHeader header = table.getTableHeader();
										        header.setDefaultRenderer(new HeaderRenderer(table.getTableHeader().getDefaultRenderer()));
										        table.setRowHeight(30);
											
					JLabel lbApagar = new JLabel(""); 
					PainelPrincipal1.add(lbApagar, "cell 0 1,alignx center,aligny center");
					lbApagar.addMouseListener(new MouseAdapter() { 
						@Override 
						public void mouseClicked(MouseEvent e) { 
							 
							int linhaSelecionada = table.getSelectedRow();
						       if (linhaSelecionada >= 0) {
						           int idAvaliacao = (int) table.getValueAt(linhaSelecionada, 0);
						           int idHospede = usuariologado.getIdHospede();

						           AvaliacoesDAO dao = AvaliacoesDAO.getInstancia();
						           boolean removido = dao.removerAvaliacoes(idAvaliacao, idHospede);

						           if (removido) {
						               JOptionPane.showMessageDialog(null, "Avaliação removida com sucesso!");
						               atualizarJTable();
						           } else {
						               JOptionPane.showMessageDialog(null, "Falha ao remover avaliação!");
						           }
						       }
						   }
						});
					lbApagar.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Botões/Apagar Avalição.png")));
					
					JLabel lblatualizar = new JLabel("");
					PainelPrincipal1.add(lblatualizar, "cell 1 1,alignx center,aligny center");
					lblatualizar.addMouseListener(new MouseAdapter() { 
						@Override 
						public void mouseClicked(MouseEvent e) { 
 
							int linhaSelecionada = table.getSelectedRow(); 
							if (linhaSelecionada >= 0) { 
								 
							    int idAvaliacao = (int) table.getValueAt(linhaSelecionada, 0); 
							    String novoNome = txtNome.getText(); 
							    Float novaAvaliacao = Float.valueOf(txtAvaliacao.getText()); 
							    String comentario = txtComentario.getText(); 
	 
							    int idUsuario = usuariologado.getIdHospede(); 
 
							    AvaliacoesDAO dao = AvaliacoesDAO.getInstancia(); 
							    boolean atualizado = dao.atualizarAvaliacoes(idAvaliacao, novoNome, novaAvaliacao, comentario, idUsuario); 
							     
							    if (atualizado) { 
							    	TelaAvaliacaoAtualizada abrir = new TelaAvaliacaoAtualizada();
							        atualizarJTable();  
							        abrir.setVisible(true);
							    } else { 
	 
							       TelaAvaliacaoFalha abrir = new TelaAvaliacaoFalha();
							       abrir.setVisible(true);
							    } 
							} 
						} 
					}); 
					
					
					lblatualizar.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Botões/Atualizar Avaliação.png"))); 
					
					JLabel lblFazerAvaliacao = new JLabel(""); 
					PainelPrincipal1.add(lblFazerAvaliacao, "cell 2 1,alignx center,aligny center");
					lblFazerAvaliacao.addMouseListener(new MouseAdapter() { 
						@Override 
						public void mouseClicked(MouseEvent e) { 
							 
							String nome = txtNome.getText(); 
					        Float av = Float.valueOf(txtAvaliacao.getText()); 
					        Avaliacoes avaliacao = new Avaliacoes(); 
					        String comentario = txtComentario.getText(); 
					         
					        avaliacao.setAvaliador(nome); 
					        avaliacao.setAvaliacao(av); 
					        avaliacao.setComentario(comentario); 
					        avaliacao.setFkIDHospede(usuariologado); 
					         
					        AvaliacoesDAO dao = AvaliacoesDAO.getInstancia(); 
					         
					        int retorno = dao.InserirAvaliacao(avaliacao); 
					         
					        if (retorno > 0) { 
					        	TelaAvaliacaoRealizada abrir = new TelaAvaliacaoRealizada();
					            avaliacao.setIdAvaliacao(retorno); 
					        	listarAvaliacoes.add(avaliacao); 
					            atualizarJTable(); 
					            abrir.setVisible(true);
					        } else { 
					            TelaLoginNaoRealizado abrir = new TelaLoginNaoRealizado();
					            abrir.setVisible(true);
					        } 
 
							 
							 
						} 
					}); 
					lblFazerAvaliacao.setIcon(new ImageIcon(TelaAvaliacoes.class.getResource("/visao/Botões/BTN Fazer Avaliação.png")));
		 
		 
		 
		 
		 
	} 
	protected void atualizarJTable() { 
	    DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Avaliador", "Avaliação","comentario", "fkIDHospede" }); 
 
	    AvaliacoesDAO Avaliacoesdao = AvaliacoesDAO.getInstancia(); 
	    listarAvaliacoes = Avaliacoesdao.listarAvaliacoes(); 
 
	    for (int i = 0; i < listarAvaliacoes.size(); i++) { 
	        Avaliacoes avalia = listarAvaliacoes.get(i); 
	         
	        modelo.addRow(new Object[] {avalia.getIdAvaliacao(), avalia.getAvaliador(), avalia.getAvaliacao(), avalia.getComentario() ,avalia.getFkIDHospede().getIdHospede()}); 
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
