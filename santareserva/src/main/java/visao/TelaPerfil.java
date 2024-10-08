package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.HospedesDAO;
import controle.InfologinDAO;
import controle.RoundedBorder;
import modelo.Hospedes;
import modelo.Infologin;
import modelo.Quartos;
import modelo.Reserva;
import net.miginfocom.swing.MigLayout;

public class TelaPerfil extends JFrame {

	private JPanel PainelGeral;
	private JTextField txtSobrenome;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtSenha;
	private JTextField txtNascimento;
	private JTextField txtEmail;
	private JTextField txtVerSenha;
	private JTextField txtConfSenha;
	private static Hospedes hosplogado;
	private Hospedes usuariologado;
	private Quartos quartoSelecionado;
	private Reserva reserva;


	/**
	 * Create the frame.
	 */
	public TelaPerfil(Hospedes hospede,Reserva reserva) {
		this.reserva=reserva;
		/* TEM Q TER EM TODAS AS TELAS */
		hosplogado = hospede;
		usuariologado = hosplogado;
		/* TEM Q TER EM TODAS AS TELAS */
		setFont(new Font("Arial", Font.PLAIN, 18));
		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		PainelGeral = new JPanel();
		PainelGeral.setBackground(new Color(255, 255, 255));
		PainelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
		RoundedBorder bordaVermelha = new RoundedBorder(Color.red, 10);
		RoundedBorder bordaPreta = new RoundedBorder(Color.black, 10);

		setContentPane(PainelGeral);
		PainelGeral.setLayout(new MigLayout("", "[][grow]", "[][grow]"));
		
		JPanel PainelTopo = new JPanel();
		PainelTopo.setBackground(new Color(119, 165, 175));
		PainelGeral.add(PainelTopo, "cell 0 0 3 1,grow");
		PainelTopo.setLayout(new MigLayout("", "[][grow][100px]", "[grow][]"));
		
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
		
		MaskFormatter mascaraTel = null;

		try {

			mascaraTel = new MaskFormatter("(##) #####-####");

		} catch (ParseException e) {

			e.printStackTrace();

		}
		
		MaskFormatter mascaraDat = null;
		
		try {

			mascaraDat = new MaskFormatter("##/##/####");

		} catch (ParseException e) {

			e.printStackTrace();

		}
		DateTimeFormatter idtFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		JPanel PainelIcones = new JPanel();
		PainelIcones.setBackground(new Color(240, 240, 240));
		PainelGeral.add(PainelIcones, "cell 0 1,alignx leading,growy");
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
		PainelIcones.add(lblNewLabel_3, "cell 0 1,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("Perfil");
		
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_4, "cell 1 1");
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeReserva.png")));
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
		lblNewLabel_12.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		PainelIcones.add(lblNewLabel_12, "cell 0 3,alignx center");
		
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
		PainelIcones.add(lblNewLabel_13, "cell 0 4,alignx center");
		
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
		PainelIcones.add(lblNewLabel_14, "cell 0 5,alignx center");
		
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
		PainelIcones.add(lblNewLabel_15, "cell 0 6,alignx center");
		
		JLabel lblNewLabel_9 = new JLabel("Avalie-nos");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaAvaliacoes c = new TelaAvaliacoes(usuariologado,reserva);
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
				
				TelaInformacoes c = new TelaInformacoes(usuariologado,reserva);
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
		
		JPanel PainelAlteracao = new JPanel();
		PainelAlteracao.setBackground(new Color(238, 238, 238));
		PainelGeral.add(PainelAlteracao, "cell 1 1,grow");
		PainelAlteracao.setLayout(new MigLayout("", "[grow][400px][500px][][400px][][grow]", "[][200px][100px][][][][][][][][][][][grow][grow]"));
		
		JLabel lblPerfil = new JLabel("");
		PainelAlteracao.add(lblPerfil, "cell 2 1,alignx center,aligny bottom");
		lblPerfil.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/IconeUser.png")));
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblUser, "cell 2 2,alignx center,aligny top");

		lblUser.setText("Olá, " + usuariologado.getNome() + " " + usuariologado.getSobrenome());
		
		JLabel lblAltNome = new JLabel("Alterar Nome");
		lblAltNome.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltNome, "cell 1 3,growx");
		
		JLabel lblAltSobrenome = new JLabel("Alterar Sobrenome");
		lblAltSobrenome.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltSobrenome, "cell 4 3,alignx left,aligny center");
		
		txtNome = new JTextField();
		txtNome.setBorder(bordaPreta);
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtNome, "cell 1 4,grow");
		txtNome.setColumns(10);
		txtNome.setText(usuariologado.getNome());
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBorder(bordaPreta);
		txtSobrenome.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtSobrenome, "cell 4 4,grow");
		txtSobrenome.setColumns(10);
		txtSobrenome.setText(usuariologado.getSobrenome());
		
		JLabel lblAltTelefone = new JLabel("Alterar Telefone");
		lblAltTelefone.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltTelefone, "cell 1 5");
		
		JLabel lblAltSenha = new JLabel("Alterar Senha");
		lblAltSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltSenha, "cell 4 5");
		
		txtTelefone = new JFormattedTextField(mascaraTel);
		txtTelefone.setBorder(bordaPreta);
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtTelefone, "cell 1 6,grow");
		txtTelefone.setColumns(10);
		txtTelefone.setText(usuariologado.getTelefone());
		
		txtSenha = new JPasswordField();
		txtSenha.setBorder(bordaPreta);
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtSenha, "flowx,cell 4 6,grow");
		txtSenha.setColumns(10);
		txtSenha.setText(usuariologado.getLogin().getSenha());
		
		JLabel lblMostrar = new JLabel("");
		lblMostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                if (txtSenha instanceof JPasswordField) {
                    JTextField txtSenhaVisivel = new JTextField(txtSenha.getText());
                    txtSenhaVisivel.setBorder(txtSenha.getBorder());
                    txtSenhaVisivel.setFont(txtSenha.getFont());
                    txtSenhaVisivel.setForeground(txtSenha.getForeground());
                    txtSenhaVisivel.setBackground(txtSenha.getBackground());
                    txtSenhaVisivel.setEditable(true);

                    PainelAlteracao.remove(txtSenha);
                    txtSenha = txtSenhaVisivel;
                    PainelAlteracao.add(txtSenha, "flowx,cell 4 6,grow");
                    lblMostrar.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/iconeEsconderSenha.png")));

                    revalidate();
                    repaint();
                } else if (txtSenha instanceof JTextField) {
                    JPasswordField txtSenhaEscondida = new JPasswordField();
                    txtSenhaEscondida.setBorder(txtSenha.getBorder());
                    txtSenhaEscondida.setFont(txtSenha.getFont());
                    txtSenhaEscondida.setForeground(txtSenha.getForeground());
                    txtSenhaEscondida.setBackground(txtSenha.getBackground());
                    txtSenhaEscondida.setText(txtSenha.getText());
                    txtSenhaEscondida.setEditable(true);

                    PainelAlteracao.remove(txtSenha);
                    txtSenha = txtSenhaEscondida;
                    PainelAlteracao.add(txtSenha, "flowx,cell 4 6,grow");
                    lblMostrar.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/iconeVerSenha.png")));

                    revalidate();
                    repaint();
                }
            }
        });
		
		
		lblMostrar.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/iconeVerSenha.png")));
		PainelAlteracao.add(lblMostrar, "cell 5 6,alignx center");
		
		JLabel lblAltNascimento = new JLabel("Alterar Data de nascimento");
		lblAltNascimento.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltNascimento, "cell 1 7");
		
		JLabel lblAltEmail = new JLabel("Alterar Email");
		lblAltEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltEmail, "cell 4 7");
		
		txtNascimento = new JFormattedTextField(mascaraDat);
		txtNascimento.setBorder(bordaPreta);
		txtNascimento.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtNascimento, "cell 1 8,grow");
		txtNascimento.setColumns(10);
		txtNascimento.setText(usuariologado.getNascimento().format(idtFormater));
		
		txtEmail = new JTextField();
		txtEmail.setBorder(bordaPreta);
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtEmail, "cell 4 8,grow");
		txtEmail.setColumns(10);
		txtEmail.setText(usuariologado.getLogin().getLogin());
		
		JLabel lblNewLabel7 = new JLabel("Senha");
		lblNewLabel7.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblNewLabel7, "cell 2 9,alignx left");
		
		txtVerSenha = new JPasswordField();
		txtVerSenha.setBorder(bordaPreta);
		txtVerSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtVerSenha, "flowx,cell 2 10,grow");
		txtVerSenha.setColumns(10);
		txtVerSenha.setText(usuariologado.getLogin().getSenha());
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				InfologinDAO dao = InfologinDAO.getInstancia();
				
				Infologin delete = dao.removerInfologin(usuariologado.getLogin().getLogin());
				
				TelaPerfilExcluido abrir = new TelaPerfilExcluido();
				TelaLogin login = new TelaLogin();
				login.setVisible(true);
				dispose();
				abrir.setVisible(true);
			}
		});
		
		JLabel BtnAtualizarInfo = new JLabel("");
		BtnAtualizarInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				if (txtNome.getText().trim().isEmpty()) {
					TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
					txtNome.setBorder(bordaVermelha);
					return;
				}
				
				if (txtSobrenome.getText().trim().isEmpty()) {
					TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
				    txtSobrenome.setBorder(bordaVermelha);
					return;
				}
				if (txtTelefone.getText().trim().isEmpty()) {
					TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
				    txtTelefone.setBorder(bordaVermelha);
					return;
				}
				if (txtNascimento.getText().trim().isEmpty()) {
					TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
				    txtNascimento.setBorder(bordaVermelha);
					return;
				}
				if (txtEmail.getText().trim().isEmpty()) {
					TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
				    txtEmail.setBorder(bordaVermelha);
					return;
				}
				if (!txtVerSenha.getText().equals(txtConfSenha.getText())) {
					TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
				    txtVerSenha.setBorder(bordaVermelha);
					return;
				}
				
				if (!txtNome.getText().matches("[\\p{L}\\s~^]+")) {

					JOptionPane.showMessageDialog(null, "O nome deve conter apenas letras.");

					txtNome.setBorder(bordaVermelha);
					return;

				}

				if (!txtSobrenome.getText().matches("[\\p{L}\\s~^]+")) {

					JOptionPane.showMessageDialog(null, "O sobrenome deve conter apenas letras.");

					txtSobrenome.setBorder(bordaVermelha);
					return;

				}
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				
				String nome = txtNome.getText();
				String sobrenome = txtSobrenome.getText();
				
				String dataNascTxt = txtNascimento.getText();

				dataNascTxt = dataNascTxt.replace("/", "");
				dataNascTxt = dataNascTxt.trim();

				LocalDate nascimento = null;
				if (dataNascTxt.isEmpty()) {
					TelanInserido tela = new TelanInserido();
				    tela.setVisible(true);
				    txtNascimento.setBorder(bordaVermelha);
				} else {

					String diaTxt = dataNascTxt.substring(0, 2);
					String mesTxt = dataNascTxt.substring(2, 4);
					String anoTxt = dataNascTxt.substring(4, 8);

					Integer dia = Integer.valueOf(diaTxt);
					Integer mes = Integer.valueOf(mesTxt);
					Integer ano = Integer.valueOf(anoTxt);

					nascimento = LocalDate.of(ano, mes, dia);

				}
				
				String telefone = txtTelefone.getText();
				String email = txtEmail.getText();
				String senha = txtSenha.getText();
				Integer id = usuariologado.getIdHospede();
				Integer idlogin = usuariologado.getLogin().getIdUsuario();
				
				Hospedes hospedes = new Hospedes();
				Infologin login = new Infologin();
				
				login.setLogin(email);
				login.setSenha(senha);
				
				hospedes.setNome(nome);
				hospedes.setSobrenome(sobrenome);
				hospedes.setNascimento(nascimento);
				hospedes.setTelefone(telefone);
				
				usuariologado.setNome(txtNome.getText());
		        usuariologado.setSobrenome(txtSobrenome.getText());
		        usuariologado.setTelefone(txtTelefone.getText());
		        usuariologado.setNascimento(LocalDate.parse(txtNascimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		        usuariologado.getLogin().setLogin(txtEmail.getText());
		        usuariologado.getLogin().setSenha(txtSenha.getText());
				
				InfologinDAO idao = InfologinDAO.getInstancia();
				HospedesDAO dao = HospedesDAO.getInstancia();
				
				dao.atualizarHospedes(usuariologado.getNome(), sobrenome, nascimento, telefone, id);
				
					// pega a chave primaria gerada no inserir do InfologinDAO e insere as info-
					// mações no Login do usuário
					idao.atualizarInfologin(email, senha, idlogin);
					// insere o retorno como o id do Infologin
					// insere as informações de login a partir da chave estrangeira em Hospedes
					TelaPerfilAtualizado abrir = new TelaPerfilAtualizado();
					abrir.setVisible(true);
					lblNameuser.setText(usuariologado.getNome());
					lblUser.setText("Olá, " + usuariologado.getNome() + " " + usuariologado.getSobrenome());
					lblNameuser.setText(hosplogado.getNome());
			        PainelAlteracao.revalidate();
			        PainelAlteracao.repaint();
			        
			        

					
					
			}
				
		});
		
		JLabel lblMostrar2 = new JLabel("");
		lblMostrar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                if (txtVerSenha instanceof JPasswordField) {
                    JTextField txtSenhaVisivel = new JTextField(txtVerSenha.getText());
                    txtSenhaVisivel.setBorder(txtVerSenha.getBorder());
                    txtSenhaVisivel.setFont(txtVerSenha.getFont());
                    txtSenhaVisivel.setForeground(txtVerSenha.getForeground());
                    txtSenhaVisivel.setBackground(txtVerSenha.getBackground());
                    txtSenhaVisivel.setEditable(true);

                    PainelAlteracao.remove(txtVerSenha);
                    txtVerSenha = txtSenhaVisivel;
                    PainelAlteracao.add(txtVerSenha, "flowx,cell 2 10,grow");
                    lblMostrar2.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/iconeEsconderSenha.png")));

                    revalidate();
                    repaint();
                } else if (txtVerSenha instanceof JTextField) {
                    JPasswordField txtSenhaEscondida = new JPasswordField();
                    txtSenhaEscondida.setBorder(txtVerSenha.getBorder());
                    txtSenhaEscondida.setFont(txtVerSenha.getFont());
                    txtSenhaEscondida.setForeground(txtVerSenha.getForeground());
                    txtSenhaEscondida.setBackground(txtVerSenha.getBackground());
                    txtSenhaEscondida.setText(txtVerSenha.getText());
                    txtSenhaEscondida.setEditable(true);

                    PainelAlteracao.remove(txtVerSenha);
                    txtVerSenha = txtSenhaEscondida;
                    PainelAlteracao.add(txtVerSenha, "flowx,cell 2 10,grow");
                    lblMostrar2.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/iconeVerSenha.png")));

                    revalidate();
                    repaint();
                }
            }
        });
		lblMostrar2.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/iconeVerSenha.png")));
		PainelAlteracao.add(lblMostrar2, "cell 3 10");
		
		JLabel lblNewLabel8 = new JLabel("Confirmar Senha");
		lblNewLabel8.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblNewLabel8, "cell 2 11,alignx left");
		
		txtConfSenha = new JPasswordField();
		txtConfSenha.setBorder(bordaPreta);
		txtConfSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtConfSenha, "flowx,cell 2 12,grow");
		txtConfSenha.setColumns(10);
		txtConfSenha.setText(usuariologado.getLogin().getSenha());
		
		JLabel lblMostrar3 = new JLabel("");
		lblMostrar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                if (txtConfSenha instanceof JPasswordField) {
                    JTextField txtSenhaVisivel = new JTextField(txtConfSenha.getText());
                    txtSenhaVisivel.setBorder(txtConfSenha.getBorder());
                    txtSenhaVisivel.setFont(txtConfSenha.getFont());
                    txtSenhaVisivel.setForeground(txtConfSenha.getForeground());
                    txtSenhaVisivel.setBackground(txtConfSenha.getBackground());
                    txtSenhaVisivel.setEditable(true);

                    PainelAlteracao.remove(txtConfSenha);
                    txtConfSenha = txtSenhaVisivel;
                    PainelAlteracao.add(txtConfSenha, "flowx,cell 2 12,grow");
                    lblMostrar3.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/iconeEsconderSenha.png")));

                    revalidate();
                    repaint();
                } else if (txtConfSenha instanceof JTextField) {
                    JPasswordField txtSenhaEscondida = new JPasswordField();
                    txtSenhaEscondida.setBorder(txtConfSenha.getBorder());
                    txtSenhaEscondida.setFont(txtConfSenha.getFont());
                    txtSenhaEscondida.setForeground(txtConfSenha.getForeground());
                    txtSenhaEscondida.setBackground(txtConfSenha.getBackground());
                    txtSenhaEscondida.setText(txtConfSenha.getText());
                    txtSenhaEscondida.setEditable(true);

                    PainelAlteracao.remove(txtConfSenha);
                    txtConfSenha = txtSenhaEscondida;
                    PainelAlteracao.add(txtConfSenha, "flowx,cell 2 12,grow");
                    lblMostrar3.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/iconeVerSenha.png")));

                    revalidate();
                    repaint();
                }
            }
        });
		lblMostrar3.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/iconeVerSenha.png")));
		PainelAlteracao.add(lblMostrar3, "cell 3 12");
		BtnAtualizarInfo.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Botões/BTN Aplicar Atualizações.png")));
		PainelAlteracao.add(BtnAtualizarInfo, "cell 2 13,alignx center,aligny center");
		lblNewLabel1.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Botões/BtnExcluirPerfil.png")));
		PainelAlteracao.add(lblNewLabel1, "cell 2 14,alignx center,aligny top");
		
		JLabel lblNewLabel_20 = new JLabel("");
		PainelAlteracao.add(lblNewLabel_20, "cell 2 10");
	}

}
