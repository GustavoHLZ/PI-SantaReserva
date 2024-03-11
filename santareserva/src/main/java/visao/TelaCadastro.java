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
import java.awt.Toolkit;

public class TelaCadastro extends JFrame {

	private JPanel Tela;
	private JTextField txtEmail;
	private JTextField txtSobrenome;
	private JTextField txtNascimento;
	private JTextField txtTelefone;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aluno\\Desktop\\PI-SantaReserva\\santareserva\\src\\main\\resources\\Icones\\LogoAPP.png"));
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
		ImgHotel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PI-SantaReserva\\santareserva\\src\\main\\resources\\Fotos\\Hotel.png"));
		PainelHotel.add(ImgHotel, "cell 0 0,alignx left,aligny top");
		
		JPanel PainelCadastro = new JPanel();
		Tela.add(PainelCadastro, "cell 15 0 1 6,alignx center,growy");
		PainelCadastro.setLayout(new MigLayout("", "[195px,grow]", "[][40px][][40px][][40px][][40px][][40px][][40px][][40px][][40px][180px][][]"));
		
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
		
		txtNascimento = new JTextField();
		PainelCadastro.add(txtNascimento, "cell 0 11,grow");
		txtNascimento.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblTelefone, "cell 0 12");
		
		txtTelefone = new JTextField();
		PainelCadastro.add(txtTelefone, "cell 0 13,grow");
		txtTelefone.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 32));
		PainelCadastro.add(lblSenha, "cell 0 14");
		
		txtSenha = new JTextField();
		PainelCadastro.add(txtSenha, "cell 0 15,grow");
		txtSenha.setColumns(10);
		
		JLabel BTNRegistrar = new JLabel("");
		BTNRegistrar.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PI-SantaReserva\\santareserva\\src\\main\\resources\\Botões\\BTN Registrar.png"));
		PainelCadastro.add(BTNRegistrar, "cell 0 21");
		
		JLabel lblJapossui = new JLabel("Já possui registro? Faça o Login");
		lblJapossui.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelCadastro.add(lblJapossui, "cell 0 22,alignx center,aligny bottom");
	}

}
