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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.HospedesDAO;
import controle.InfologinDAO;
import modelo.Computadores;
import modelo.Espacos;
import modelo.Hospedes;
import modelo.Infologin;
import modelo.Quartos;
import modelo.SalaReunioes;
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
	private static Quartos quartoAlugado;
	private Quartos quartoSelecionado;
	private static SalaReunioes salaAlugada;
	private SalaReunioes salaSelecionada;
	private static Computadores computadorAlugado;
	private Computadores computadorSelecionado;
	private static Hospedes usuariologado;
	private Hospedes usuarioSelecionado;
	private ArrayList<Quartos> listarQuartos = new ArrayList<Quartos>();
	private ArrayList<Espacos> listarEspaco = new ArrayList<Espacos>();
	private ArrayList<Computadores> listarComputadores = new ArrayList<Computadores>();


	/**
	 * Create the frame.
	 */
	public TelaPerfil(Hospedes hospede, Quartos quarto, ArrayList<Quartos> listaQuartos,SalaReunioes salareunioes, ArrayList<Computadores> listaComputadores, Computadores computador, ArrayList<Espacos> listaEspacos) {
		
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
		
		listarEspaco = listaEspacos;
		
		/* TEM Q TER EM TODAS AS TELAS */
		setFont(new Font("Arial", Font.PLAIN, 18));
		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		PainelGeral = new JPanel();
		PainelGeral.setBackground(new Color(255, 255, 255));
		PainelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PainelGeral);
		PainelGeral.setLayout(new MigLayout("", "[][grow]", "[][grow]"));
		
		JPanel PainelLog = new JPanel();
		PainelLog.setBackground(new Color(119, 165, 175));
		PainelGeral.add(PainelLog, "cell 0 0 3 1,grow");
		PainelLog.setLayout(new MigLayout("", "[][]", "[grow]"));
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/LogoCerta2.png")));
		PainelLog.add(lblNewLabel_19);
		
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
		PainelIcones.setLayout(new MigLayout("", "[][]", "[grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeHome.png")));
		PainelIcones.add(lblNewLabel_1, "cell 0 0");
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaHome c = new TelaHome(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarEspaco);
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
		
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_4, "cell 1 1");
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeReserva.png")));
		PainelIcones.add(lblNewLabel_11, "cell 0 2");
		
		JLabel lblNewLabel_5 = new JLabel("Reserva");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaReservas c = new TelaReservas(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarEspaco);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_5, "cell 1 2");
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeSalaReunioes.png")));
		PainelIcones.add(lblNewLabel_12, "cell 0 3");
		
		JLabel lblNewLabel_6 = new JLabel("Sala de Reuniões");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaSalaDeReunioes c = new TelaSalaDeReunioes(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarEspaco);
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
				
				TelaComputadores c = new TelaComputadores(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarEspaco);
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
				
				TelaQuartos c = new TelaQuartos(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarEspaco);
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
				TelaAvaliacoes c = new TelaAvaliacoes(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarEspaco);
				c.setVisible(true);
				dispose();
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
				
				TelaInformacoes c = new TelaInformacoes(usuariologado, quartoAlugado, listarQuartos, salaAlugada, listarComputadores, computadorAlugado, listarEspaco);
				c.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_10, "cell 1 7");
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(TelaQuartos.class.getResource("/visao/Icones/IconeConfiguracoes.png")));
		PainelIcones.add(lblNewLabel_18, "cell 0 8");
		
		JLabel lblNewLabel_17 = new JLabel("Configurações");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PainelIcones.add(lblNewLabel_17, "cell 1 8,growy");
		
		JPanel PainelAlteracao = new JPanel();
		PainelAlteracao.setBackground(new Color(238, 238, 238));
		PainelGeral.add(PainelAlteracao, "cell 1 1,grow");
		PainelAlteracao.setLayout(new MigLayout("", "[grow][400px][500px][400px][grow]", "[200px][100px][][][][][][][][][][][grow][grow]"));
		
		JLabel lblPerfil = new JLabel("");
		PainelAlteracao.add(lblPerfil, "cell 2 0,alignx center,aligny bottom");
		lblPerfil.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/IconeUser.png")));
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblUser, "cell 2 1,alignx center,aligny top");

		lblUser.setText("Olá, " + usuariologado.getNome() + " " + usuariologado.getSobrenome());
		
		JLabel lblAltNome = new JLabel("Alterar Nome");
		lblAltNome.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltNome, "cell 1 2,growx");
		
		JLabel lblAltSobrenome = new JLabel("Alterar Sobrenome");
		lblAltSobrenome.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltSobrenome, "cell 3 2,alignx left,aligny center");
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtNome, "cell 1 3,grow");
		txtNome.setColumns(10);
		txtNome.setText(usuariologado.getNome());
		
		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtSobrenome, "cell 3 3,grow");
		txtSobrenome.setColumns(10);
		txtSobrenome.setText(usuariologado.getSobrenome());
		
		JLabel lblAltTelefone = new JLabel("Alterar Telefone");
		lblAltTelefone.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltTelefone, "cell 1 4");
		
		JLabel lblAltSenha = new JLabel("Alterar Senha");
		lblAltSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltSenha, "cell 3 4");
		
		txtTelefone = new JFormattedTextField(mascaraTel);
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtTelefone, "cell 1 5,grow");
		txtTelefone.setColumns(10);
		txtTelefone.setText(usuariologado.getTelefone());
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtSenha, "cell 3 5,grow");
		txtSenha.setColumns(10);
		txtSenha.setText(usuariologado.getLogin().getSenha());
		
		JLabel lblAltNascimento = new JLabel("Alterar Data de nascimento");
		lblAltNascimento.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltNascimento, "cell 1 6");
		
		JLabel lblAltEmail = new JLabel("Alterar Email");
		lblAltEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltEmail, "cell 3 6");
		
		txtNascimento = new JFormattedTextField(mascaraDat);
		txtNascimento.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtNascimento, "cell 1 7,grow");
		txtNascimento.setColumns(10);
		txtNascimento.setText(usuariologado.getNascimento().format(idtFormater));
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtEmail, "cell 3 7,grow");
		txtEmail.setColumns(10);
		txtEmail.setText(usuariologado.getLogin().getLogin());
		
		JLabel lblNewLabel7 = new JLabel("Senha");
		lblNewLabel7.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblNewLabel7, "cell 2 8,alignx left");
		
		txtVerSenha = new JTextField();
		txtVerSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtVerSenha, "cell 2 9,grow");
		txtVerSenha.setColumns(10);
		txtVerSenha.setText(usuariologado.getLogin().getSenha());
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				InfologinDAO dao = InfologinDAO.getInstancia();
				
				Infologin delete = dao.removerInfologin(usuariologado.getLogin().getLogin());
				
				JOptionPane.showMessageDialog(null, "Informações excluidas com sucesso");
				TelaLogin login = new TelaLogin();
				login.setVisible(true);
				dispose();
			}
		});
		
		JLabel BtnAtualizarInfo = new JLabel("");
		BtnAtualizarInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				
				String nome = txtNome.getText();
				String sobrenome = txtSobrenome.getText();
				
				String dataNascTxt = txtNascimento.getText();

				dataNascTxt = dataNascTxt.replace("/", "");
				dataNascTxt = dataNascTxt.trim();

				LocalDate nascimento = null;
				if (dataNascTxt.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhuma data preenchida!");
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
				
				InfologinDAO idao = InfologinDAO.getInstancia();
				HospedesDAO dao = HospedesDAO.getInstancia();
				
				dao.atualizarHospedes(nome, sobrenome, nascimento, telefone, id);
				
					// pega a chave primaria gerada no inserir do InfologinDAO e insere as info-
					// mações no Login do usuário
					idao.atualizarInfologin(email, senha, idlogin);
					// insere o retorno como o id do Infologin
					// insere as informações de login a partir da chave estrangeira em Hospedes
					JOptionPane.showMessageDialog(null, "Informações atualizadas com sucesso");

					
					
			}
				
		});
		
		JLabel lblNewLabel8 = new JLabel("Confirmar Senha");
		lblNewLabel8.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblNewLabel8, "cell 2 10,alignx left");
		
		txtConfSenha = new JTextField();
		txtConfSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtConfSenha, "cell 2 11,grow");
		txtConfSenha.setColumns(10);
		txtConfSenha.setText(usuariologado.getLogin().getSenha());
		BtnAtualizarInfo.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Botões/BTN Aplicar Atualizações.png")));
		PainelAlteracao.add(BtnAtualizarInfo, "cell 2 12,alignx center,aligny center");
		lblNewLabel.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Botões/BtnExcluirPerfil.png")));
		PainelAlteracao.add(lblNewLabel, "cell 2 13,alignx center,aligny top");
	}

}
