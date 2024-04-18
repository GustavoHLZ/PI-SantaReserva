package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controle.HospedesDAO;
import controle.InfologinDAO;
import modelo.Hospedes;
import modelo.Infologin;
import net.miginfocom.swing.MigLayout;

public class TelaCadastro extends JFrame {

	private JPanel Tela;
	private JTextField txtEmail;
	private JTextField txtSobrenome;
	private JTextField txtNascimento;
	private JTextField txtTelefone;
	private JTextField txtSenha;
	private JTextField txtNome;
	private Hospedes hospSelecionado;
	private ArrayList<Hospedes> listaHospedes;
	private ArrayList<Infologin> listaLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setLocationRelativeTo(null);
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
	public TelaCadastro() {
		ArrayList<Hospedes> listaHospedes = new ArrayList<Hospedes>();
		ArrayList<Infologin> listaLogin = new ArrayList<Infologin>();

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Aluno\\Desktop\\PI-SantaReserva\\santareserva\\src\\main\\resources\\Icones\\LogoAPP.png"));
		setTitle("Bem-vindo à Santa Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		Tela = new JPanel();
		Tela.setBackground(new Color(238, 238, 238));
		Tela.setBorder(null);

		setContentPane(Tela);
		Tela.setLayout(new MigLayout("", "[960][][][][][][][][][][][][][][][1000px]", "[800px,grow][][][][][60px]"));

		JPanel PainelHotel = new JPanel();
		Tela.add(PainelHotel, "cell 0 0,grow");
		PainelHotel.setLayout(new MigLayout("", "[]", "[]"));

		JLabel ImgHotel = new JLabel("");
		ImgHotel.setIcon(new ImageIcon(TelaCadastro.class.getResource("/visao/Fotos/Hotel.png")));
		PainelHotel.add(ImgHotel, "cell 0 0,alignx left,aligny top");

		JPanel PainelCadastro = new JPanel();
		Tela.add(PainelCadastro, "flowx,cell 15 0 1 6,alignx center,growy");
		PainelCadastro.setLayout(new MigLayout("", "[195px,grow]",
				"[][40px][][40px][][40px][][40px][][40px][][40px][][40px][][40px][180px][][]"));

		JLabel lblRegistro = new JLabel("Registrar-se");
		lblRegistro.setFont(new Font("Arial", Font.PLAIN, 36));
		PainelCadastro.add(lblRegistro, "cell 0 0,alignx center,aligny top");

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblEmail, "cell 0 4");

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(txtEmail, "cell 0 5,grow");
		txtEmail.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblNome, "cell 0 6");

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(txtNome, "cell 0 7,grow");
		txtNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblSobrenome, "cell 0 8");

		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(txtSobrenome, "cell 0 9,grow");
		txtSobrenome.setColumns(10);

		JLabel lblNascimento = new JLabel("Data de nascimento");
		lblNascimento.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblNascimento, "cell 0 10");

		MaskFormatter mascaraDat = null;

		try {

			mascaraDat = new MaskFormatter("##/##/####");

		} catch (ParseException e) {

			e.printStackTrace();

		}

		txtNascimento = new JFormattedTextField(mascaraDat);
		txtNascimento.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(txtNascimento, "cell 0 11,grow");
		txtNascimento.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblTelefone, "cell 0 12");

		MaskFormatter mascaraTel = null;

		try {

			mascaraTel = new MaskFormatter("(##) #####-####");

		} catch (ParseException e) {

			e.printStackTrace();

		}

		txtTelefone = new JFormattedTextField(mascaraTel);
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(txtTelefone, "cell 0 13,grow");
		txtTelefone.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblSenha, "cell 0 14");

		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(txtSenha, "cell 0 15,grow");
		txtSenha.setColumns(10);

		JLabel BTNRegistrar = new JLabel("");
		BTNRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (txtEmail.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Preencha o campo E-mail.");

					return;

				}

				if (txtNome.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Preencha o campo Nome.");

					return;

				}

				if (txtSobrenome.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Preencha o campo Sobrenome.");

					return;

				}

				if (txtNascimento.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Preencha o campo Nascimento.");

					return;

				}

				if (txtTelefone.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Preencha o campo Telefone.");

					return;

				}

				if (txtSenha.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Preencha o campo Senha.");

					return;

				}

				if (!txtNome.getText().matches("[a-zA-Z\\s]+")) {

					JOptionPane.showMessageDialog(null, "O nome deve conter apenas letras.");

					return;

				}

				if (!txtSobrenome.getText().matches("[a-zA-Z\\s]+")) {

					JOptionPane.showMessageDialog(null, "O sobrenome deve conter apenas letras.");

					return;

				}

				if (!txtNascimento.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {

					JOptionPane.showMessageDialog(null, "A data de nascimento deve estar no formato dd/MM/yyyy.");

					return;

				}

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

				String email = txtEmail.getText();
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
				String senha = txtSenha.getText();

				Hospedes hospede = new Hospedes();
				Infologin login = new Infologin();

				login.setLogin(email);
				login.setSenha(senha);

				hospede.setNome(nome);
				hospede.setSobrenome(sobrenome);
				hospede.setNascimento(nascimento);
				
				telefone = telefone.replace("(", "");
				telefone = telefone.replace(")", "");
				telefone = telefone.replace("-", "");
				telefone = telefone.replace(" ", "");
				telefone = telefone.trim();
				hospede.setTelefone(telefone);

				HospedesDAO dao = HospedesDAO.getInstancia();
				InfologinDAO idao = InfologinDAO.getInstancia();

				try {
					// pega a chave primaria gerada no inserir do InfologinDAO e insere as info-
					// mações no Login do usuário
					int retorno = idao.InserirInfologin(login);
					// insere o retorno como o id do Infologin
					login.setIdUsuario(retorno);
					// insere as informações de login a partir da chave estrangeira em Hospedes
					hospede.setLogin(login);
					// insere as informações em hospede
					int id = dao.InserirHospedes(hospede);

					if (id != 1) {
						JOptionPane.showMessageDialog(null, "inserido");
						TelaLogin c = new TelaLogin();
						c.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Erro");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao inserir informações");
				}

			}
		});
		BTNRegistrar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/visao/Botões/BTN Registrar.png")));
		PainelCadastro.add(BTNRegistrar, "cell 0 21");

		JLabel lblJapossui = new JLabel("Já possui registro? Faça o Login");
		lblJapossui.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelCadastro.add(lblJapossui, "cell 0 22,alignx center,aligny bottom");
	}

}
