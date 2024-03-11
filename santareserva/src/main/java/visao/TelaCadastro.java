package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class TelaCadastro extends JFrame {

	private JPanel Tela;
	private JTextField txtUser;
	private JTextField txtSobrenome;
	private JTextField txtNascimento;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
		setTitle("Bem-vindo à Santa Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		Tela = new JPanel();
		Tela.setBackground(new Color(238, 238, 238));
		Tela.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Tela);
		Tela.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][grow]", "[grow][][][][][60px]"));
		
		JPanel PainelCadastro = new JPanel();
		Tela.add(PainelCadastro, "cell 14 0 1 6,alignx center,growy");
		PainelCadastro.setLayout(new MigLayout("", "[195px,grow]", "[42px][][][40px][][40px][][40px][][40px][][40px][][40px][][40px][][][][][][grow][]"));
		
		JLabel lblRegistro = new JLabel("Registrar-se");
		lblRegistro.setFont(new Font("Arial", Font.PLAIN, 36));
		PainelCadastro.add(lblRegistro, "cell 0 0,alignx center,aligny top");
		
		JLabel lblUser = new JLabel("Nome de Usuário");
		lblUser.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblUser, "cell 0 2");
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(txtUser, "cell 0 3,grow");
		txtUser.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblNome, "cell 0 4");
		
		txtNome = new JTextField();
		PainelCadastro.add(txtNome, "cell 0 5,grow");
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblSobrenome, "cell 0 6");
		
		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(txtSobrenome, "cell 0 7,grow");
		txtSobrenome.setColumns(10);
		
		JLabel lblNascimento = new JLabel("Data de nascimento");
		lblNascimento.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblNascimento, "cell 0 8");
		
		txtNascimento = new JTextField();
		PainelCadastro.add(txtNascimento, "cell 0 9,grow");
		txtNascimento.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblTelefone, "cell 0 10");
		
		txtTelefone = new JTextField();
		PainelCadastro.add(txtTelefone, "cell 0 11,grow");
		txtTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblEmail, "cell 0 12");
		
		txtEmail = new JTextField();
		PainelCadastro.add(txtEmail, "cell 0 13,grow");
		txtEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblSenha, "cell 0 14");
		
		txtSenha = new JTextField();
		PainelCadastro.add(txtSenha, "cell 0 15,grow");
		txtSenha.setColumns(10);
		
		JLabel BTNRegistrar = new JLabel("");
		BTNRegistrar.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PI-SantaReserva\\santareserva\\src\\main\\resources\\Botões\\BTN Registrar.png"));
		PainelCadastro.add(BTNRegistrar, "cell 0 18");
		
		JLabel lblJapossui = new JLabel("Já possui registro? Faça o Login");
		lblJapossui.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelCadastro.add(lblJapossui, "cell 0 22,alignx center,aligny bottom");
	}

}
