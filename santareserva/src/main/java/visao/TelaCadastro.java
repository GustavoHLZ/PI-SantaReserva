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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controle.HospedesDAO;
import controle.InfologinDAO;
import controle.RoundedBorder;
import modelo.Hospedes;
import modelo.Infologin;
import modelo.Reserva;
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
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		Tela = new JPanel();
		Tela.setBackground(new Color(229, 236, 238));
		Tela.setBorder(null);
		RoundedBorder bordaVermelha = new RoundedBorder(Color.red, 10); 
		RoundedBorder bordaPreta = new RoundedBorder(Color.black, 10); 

		setContentPane(Tela);
		Tela.setLayout(new MigLayout("", "[960px][grow]", "[grow]"));

		JPanel PainelHotel = new JPanel();
		Tela.add(PainelHotel, "cell 0 0,grow");
		PainelHotel.setLayout(new MigLayout("", "[]", "[]"));

		JLabel ImgHotel = new JLabel("");
		ImgHotel.setIcon(new ImageIcon(TelaCadastro.class.getResource("/visao/Fotos/Hotel.png")));
		PainelHotel.add(ImgHotel, "cell 0 0,alignx left,aligny top");

		JPanel PainelCadastro = new JPanel();
		PainelCadastro.setBackground(new Color(229, 236, 238));
		Tela.add(PainelCadastro, "flowx,cell 1 0 1 6,alignx center,growy");
		PainelCadastro.setLayout(new MigLayout("", "[grow][]", "[250px][][][][][][][][][][][][][][grow]"));

		JLabel lblRegistro = new JLabel("Registrar-se");
		lblRegistro.setFont(new Font("Arial", Font.PLAIN, 36));
		PainelCadastro.add(lblRegistro, "cell 0 0,alignx center,aligny center");
		
				JLabel lblEmail = new JLabel("Email");
				lblEmail.setFont(new Font("Arial", Font.PLAIN, 32));
				PainelCadastro.add(lblEmail, "cell 0 1");
		
				txtEmail = new JTextField();
				txtEmail.setBorder(bordaPreta);
				txtEmail.setFont(new Font("Arial", Font.PLAIN, 25));
				PainelCadastro.add(txtEmail, "cell 0 2,grow");
				txtEmail.setColumns(10);
		
				JLabel lblNome = new JLabel("Nome");
				lblNome.setFont(new Font("Arial", Font.PLAIN, 32));
				PainelCadastro.add(lblNome, "cell 0 3");
		
				txtNome = new JTextField();
				txtNome.setBorder(bordaPreta);
				txtNome.setFont(new Font("Arial", Font.PLAIN, 25));
				PainelCadastro.add(txtNome, "cell 0 4,grow");
				txtNome.setColumns(10);
		
				JLabel lblSobrenome = new JLabel("Sobrenome");
				lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 32));
				PainelCadastro.add(lblSobrenome, "cell 0 5");
		
				txtSobrenome = new JTextField();
				txtSobrenome.setBorder(bordaPreta);
				txtSobrenome.setFont(new Font("Arial", Font.PLAIN, 25));
				PainelCadastro.add(txtSobrenome, "cell 0 6,grow");
				txtSobrenome.setColumns(10);

		MaskFormatter mascaraDat = null;

		try {

			mascaraDat = new MaskFormatter("##/##/####");

		} catch (ParseException e) {

			e.printStackTrace();

		}
		
				JLabel lblNascimento = new JLabel("Data de nascimento");
				lblNascimento.setFont(new Font("Arial", Font.PLAIN, 32));
				PainelCadastro.add(lblNascimento, "cell 0 7");
		
				txtNascimento = new JFormattedTextField(mascaraDat);
				txtNascimento.setBorder(bordaPreta);
				txtNascimento.setFont(new Font("Arial", Font.PLAIN, 25));
				PainelCadastro.add(txtNascimento, "cell 0 8,grow");
				txtNascimento.setColumns(10);

		MaskFormatter mascaraTel = null;

		try {

			mascaraTel = new MaskFormatter("(##) #####-####");

		} catch (ParseException e) {

			e.printStackTrace();

		}
		
				JLabel lblTelefone = new JLabel("Telefone");
				lblTelefone.setFont(new Font("Arial", Font.PLAIN, 32));
				PainelCadastro.add(lblTelefone, "cell 0 9");
		
				txtTelefone = new JFormattedTextField(mascaraTel);
				txtTelefone.setBorder(bordaPreta);
				txtTelefone.setFont(new Font("Arial", Font.PLAIN, 25));
				PainelCadastro.add(txtTelefone, "cell 0 10,grow");
				txtTelefone.setColumns(10);
		
				JLabel lblSenha = new JLabel("Senha");
				lblSenha.setFont(new Font("Arial", Font.PLAIN, 32));
				PainelCadastro.add(lblSenha, "cell 0 11");
				
						txtSenha = new JPasswordField();
						txtSenha.setBorder(bordaPreta);
						txtSenha.setFont(new Font("Arial", Font.PLAIN, 25));
						PainelCadastro.add(txtSenha, "cell 0 12,grow");
						txtSenha.setColumns(10);
				
						JLabel BTNRegistrar = new JLabel("");
						BTNRegistrar.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {

								if(txtEmail.getText().equals("") && txtSenha.getText().equals("") && txtNome.getText().equals("") && txtSobrenome.getText().equals("") && txtNascimento.getText().equals("  /  /    ")) { 
									TelanInserido tela  = new TelanInserido();
									tela.setVisible(true);
									txtEmail.setBorder(bordaVermelha);
									txtNome.setBorder(bordaVermelha);
									txtSobrenome.setBorder(bordaVermelha);
									txtNascimento.setBorder(bordaVermelha);
									txtTelefone.setBorder(bordaVermelha);
									txtSenha.setBorder(bordaVermelha);
									
								} 
								
								if (txtEmail.getText().equals("")) {

									TelanInserido tela  = new TelanInserido();
									tela.setVisible(true);
									txtEmail.setBorder(bordaVermelha);
									return;

								} else{
									txtEmail.setBorder(bordaPreta);
								}

								if (txtNome.getText().equals("")) {

									JOptionPane.showMessageDialog(null, "Preencha o campo Nome.");
									txtNome.setBorder(bordaVermelha);
									return;

								}else{
									txtNome.setBorder(bordaPreta);
								}

								if (txtSobrenome.getText().equals("")) {

									JOptionPane.showMessageDialog(null, "Preencha o campo Sobrenome.");
									txtSobrenome.setBorder(bordaVermelha);
									return;

								}else{
									txtSobrenome.setBorder(bordaPreta);
								}

								if (txtNascimento.getText().equals("  /  /    ")) {

									JOptionPane.showMessageDialog(null, "Preencha o campo Nascimento.");
									txtNascimento.setBorder(bordaVermelha);
									return;

								}else{
									txtNascimento.setBorder(bordaPreta);
								}

								if (txtTelefone.getText().equals("(  )      -    ")) {

									JOptionPane.showMessageDialog(null, "Preencha o campo Telefone.");
									txtTelefone.setBorder(bordaVermelha);
									return;

								}else{
									txtTelefone.setBorder(bordaPreta);
								}
								
								
								if (txtSenha.getText().equals("")) {
									JOptionPane.showMessageDialog(null, "Preencha o campo Senha.");
									txtSenha.setBorder(bordaVermelha);
									return;
								}else{
									txtEmail.setBorder(bordaPreta);
								}
								
								if (txtSenha.getText().length() < 8) {
									JOptionPane.showMessageDialog(null, "A senha deve ter no mínimo 8 caracteres.");
									txtSenha.setBorder(bordaVermelha);
									return;
								}else{
									txtSenha.setBorder(bordaPreta);
								}
								
								


								if (!txtNome.getText().matches("[\\p{L}\\s~^]+")) {

									JOptionPane.showMessageDialog(null, "O nome deve conter apenas letras.");
									txtNome.setBorder(bordaVermelha);
									return;

								}else{
									txtNome.setBorder(bordaPreta);
								}

								if (!txtSobrenome.getText().matches("[\\p{L}\\s~^]+")) {

									JOptionPane.showMessageDialog(null, "O sobrenome deve conter apenas letras.");
									txtSobrenome.setBorder(bordaVermelha);
									return;

								}else{
									txtSobrenome.setBorder(bordaPreta);
								}

								if (!txtNascimento.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {

									JOptionPane.showMessageDialog(null, "A data de nascimento deve estar no formato dd/MM/yyyy.");
									txtNascimento.setBorder(bordaVermelha);
									return;

								}else{
									txtNascimento.setBorder(bordaPreta);
								}

								SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

								String email = txtEmail.getText();
								String emailformat = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
								if(!email.matches(emailformat)) {
									JOptionPane.showMessageDialog(null, "Insira um endereço de email válido");
									return;
								}
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

									if (id != 0) {
										hospede.setIdHospede(id);
										TelaCadastroRealizado abrir = new TelaCadastroRealizado();
										Reserva reserva = new Reserva();
										TelaHome c = new TelaHome(hospede,reserva);
										c.setVisible(true);
										abrir.setVisible(true);
										dispose();
									} else {
										TelaLoginNaoRealizado abrir = new TelaLoginNaoRealizado();
										abrir.setVisible(true);
									}

								} catch (Exception e2) {
									JOptionPane.showMessageDialog(null, "Erro ao inserir informações");
								}

							}
						});
						
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

				                    PainelCadastro.remove(txtSenha);
				                    txtSenha = txtSenhaVisivel;
				                    PainelCadastro.add(txtSenha, "cell 0 12,grow");
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

				                    PainelCadastro.remove(txtSenha);
				                    txtSenha = txtSenhaEscondida;
				                    PainelCadastro.add(txtSenha, "cell 0 12,grow");
				                    lblMostrar.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/iconeVerSenha.png")));

				                    revalidate();
				                    repaint();
				                }
				            }
				        });
						lblMostrar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/visao/Icones/iconeVerSenha.png")));
						PainelCadastro.add(lblMostrar, "cell 1 12");
						BTNRegistrar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/visao/Botões/BTN Registrar.png")));
						PainelCadastro.add(BTNRegistrar, "cell 0 13");
				
						JLabel lblJapossui = new JLabel("Já possui registro? Faça o Login");
						lblJapossui.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								dispose();
								TelaLogin frame = new TelaLogin();
								frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximizado
								frame.setVisible(true);
							}
						});
						lblJapossui.setFont(new Font("Arial", Font.PLAIN, 20));
						PainelCadastro.add(lblJapossui, "cell 0 14,alignx center,aligny top");
	}

}
