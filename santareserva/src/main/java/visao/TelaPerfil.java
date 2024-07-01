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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.HospedesDAO;
import controle.InfologinDAO;
import modelo.Hospedes;
import modelo.Infologin;
import net.miginfocom.swing.MigLayout;

public class TelaPerfil extends JFrame {

	private JPanel PainelGeral;
	private JTextField txtSobrenome;
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtTelefone;
	private JTextField txtSenha;
	private JTextField txtNascimento;
	private JTextField txtEmail;
	private JTextField txtVerSenha;
	private JTextField txtConfSenha;
	private Hospedes hospedeLogado;


	/**
	 * Create the frame.
	 */
	public TelaPerfil(Hospedes hospede) {
		hospedeLogado = hospede;
		setFont(new Font("Arial", Font.PLAIN, 18));
		setTitle("Perfil");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		PainelGeral = new JPanel();
		PainelGeral.setBackground(new Color(255, 255, 255));
		PainelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PainelGeral);
		PainelGeral.setLayout(new MigLayout("", "[][][210.00,grow 25][][39.00][21.00][1487.00,grow 25][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[][][40.00][grow][][][][][grow][][][][][][][][][][][][][]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PI-SantaReserva\\santareserva\\src\\main\\resources\\BackgroundsPI\\Rectangle 3 barra s home.png"));
		PainelGeral.add(lblLogo, "cell 0 0 8 1");
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PI-SantaReserva\\santareserva\\src\\main\\resources\\BackgroundsPI\\Line 1.png"));
		PainelGeral.add(lblNewLabel_10, "cell 0 1 8 1,aligny top");
		
		JLabel lblNewLabel_11 = new JLabel("");
		PainelGeral.add(lblNewLabel_11, "cell 7 2");
		
		JLabel lblNewLabel_12 = new JLabel("");
		PainelGeral.add(lblNewLabel_12, "flowx,cell 2 5");
		
		JPanel PainelAlteracao = new JPanel();
		PainelAlteracao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		PainelAlteracao.setBackground(new Color(238, 238, 238));
		PainelGeral.add(PainelAlteracao, "cell 6 3 41 19,grow");
		PainelAlteracao.setLayout(new MigLayout("", "[grow][178.00][142.00][::200.00px][69.00][][173.00][46px,grow]", "[66px][][][][40][][40][][40][46.00][][40][][][40][130.00,grow][20][5px:n][40][15][][5px:n][40][100.00][28.00]"));
		
		JLabel lblPerfil = new JLabel("");
		PainelAlteracao.add(lblPerfil, "cell 3 0,alignx center,aligny center");
		lblPerfil.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/IconeUser.png")));
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblUser, "cell 3 1,alignx center");
		
		JLabel lblAltSobrenome = new JLabel("Alterar Sobrenome");
		lblAltSobrenome.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltSobrenome, "cell 1 3,alignx left,aligny center");
		
		JLabel lblAltNome = new JLabel("Alterar Nome");
		lblAltNome.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltNome, "cell 4 3 3 1");
		
		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtSobrenome, "cell 1 4 2 1,grow");
		txtSobrenome.setColumns(10);
		txtSobrenome.setText(hospedeLogado.getSobrenome());
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtNome, "cell 4 4 3 1,grow");
		txtNome.setColumns(10);
		txtNome.setText(hospedeLogado.getNome());
		
		JLabel lblAltTelefone = new JLabel("Alterar Telefone");
		lblAltTelefone.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltTelefone, "cell 1 5");
		
		JLabel lblAltSenha = new JLabel("Alterar Senha");
		lblAltSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltSenha, "cell 4 5 3 1");
		
		MaskFormatter mascaraTel = null;

		try {

			mascaraTel = new MaskFormatter("(##) #####-####");

		} catch (ParseException e) {

			e.printStackTrace();

		}
		
		txtTelefone = new JFormattedTextField(mascaraTel);
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtTelefone, "cell 1 6 2 1,grow");
		txtTelefone.setColumns(10);
		txtTelefone.setText(hospedeLogado.getTelefone());
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtSenha, "cell 4 6 3 1,grow");
		txtSenha.setColumns(10);
		txtSenha.setText(hospedeLogado.getLogin().getSenha());
		
		JLabel lblAltNascimento = new JLabel("Alterar Data de nascimento");
		lblAltNascimento.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltNascimento, "cell 1 7");
		
		JLabel lblAltEmail = new JLabel("Alterar Email");
		lblAltEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltEmail, "cell 4 7 3 1");
		
		MaskFormatter mascaraDat = null;
		
		try {

			mascaraDat = new MaskFormatter("##/##/####");

		} catch (ParseException e) {

			e.printStackTrace();

		}
		
		txtNascimento = new JFormattedTextField(mascaraDat);
		txtNascimento.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtNascimento, "cell 1 8 2 1,grow");
		txtNascimento.setColumns(10);
		DateTimeFormatter idtFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		txtNascimento.setText(hospedeLogado.getNascimento().format(idtFormater));
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtEmail, "cell 4 8 3 1,grow");
		txtEmail.setColumns(10);
		txtEmail.setText(hospedeLogado.getLogin().getLogin());
		
		JPanel ColunaIcones = new JPanel();
		PainelAlteracao.add(ColunaIcones, "cell 0 12");
		ColunaIcones.setBackground(new Color(238, 238, 238));
		
		JLabel lblNewLabel_6 = new JLabel("Alterar CEP");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblNewLabel_6, "cell 2 13 3 1,growy");
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtCep, "cell 2 14 3 1,grow");
		txtCep.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InfologinDAO dao = InfologinDAO.getInstancia();
				
				Infologin delete = dao.removerInfologin(hospedeLogado.getLogin().getLogin());
				
				JOptionPane.showMessageDialog(null, "Informações excluidas com sucesso");
				TelaLogin login = new TelaLogin();
				login.setVisible(true);
				dispose();
				
			}
		});
		PainelAlteracao.add(btnExcluir, "cell 6 14,grow");
		
		JLabel lblNewLabel_7 = new JLabel("Senha");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblNewLabel_7, "cell 2 16 3 1,alignx left");
		
		txtVerSenha = new JTextField();
		txtVerSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtVerSenha, "cell 2 18 3 1,grow");
		txtVerSenha.setColumns(10);
		txtVerSenha.setText(hospedeLogado.getLogin().getSenha());
		
		JLabel lblNewLabel_8 = new JLabel("Confirmar Senha");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblNewLabel_8, "cell 2 20 3 1,alignx left");
		
		txtConfSenha = new JTextField();
		txtConfSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtConfSenha, "cell 2 22 3 1,grow");
		txtConfSenha.setColumns(10);
		txtConfSenha.setText(hospedeLogado.getLogin().getSenha());
		
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
				Integer id = hospedeLogado.getIdHospede();
				Integer idlogin = hospedeLogado.getLogin().getIdUsuario();
				
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
		BtnAtualizarInfo.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Botões/BTN Aplicar Atualizações.png")));
		PainelAlteracao.add(BtnAtualizarInfo, "cell 2 23 3 1,alignx center,aligny center");
	}

}
