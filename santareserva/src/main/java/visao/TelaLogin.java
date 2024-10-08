package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.HospedesDAO;
import controle.InfologinDAO;
import controle.RoundedBorder;
import modelo.Hospedes;
import modelo.Infologin;
import modelo.Reserva;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLogin extends JFrame {

	protected static final Hospedes Hospedes = null;
	private JPanel Tela;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JLabel lblNewLabel_2;
	private Infologin endSelecionado;
	ArrayList<Infologin> listarInfo_Login;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * 
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {

		listarInfo_Login = new ArrayList<Infologin>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		Tela = new JPanel();
		Tela.setBackground(new Color(229, 236, 238));
		Tela.setBorder(null);
		RoundedBorder bordaVermelha = new RoundedBorder(Color.red, 10);
		RoundedBorder bordaPreta = new RoundedBorder(Color.black, 10);

		setContentPane(Tela);
		Tela.setLayout(new MigLayout("", "[960px][960px]", "[grow]"));

		JPanel PainelHotel = new JPanel();
		Tela.add(PainelHotel, "cell 0 0, grow");

		JLabel ImgHotel = new JLabel("");
		ImgHotel.setIcon(new ImageIcon(TelaLogin.class.getResource("/visao/Fotos/Hotel.png")));
		PainelHotel.add(ImgHotel, "cell 0 0,alignx left,aligny top");

		JPanel PainelLogin = new JPanel();
		PainelLogin.setBackground(new Color(229, 236, 238));
		Tela.add(PainelLogin, "flowx,cell 1 0 1 6,alignx center,growy");
		PainelLogin.setLayout(new MigLayout("", "[grow][]", "[200px][70px][][][][20px][100px][500px]"));

		table = new JTable();

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(397, 61, 158, 74);
		PainelLogin.add(lblNewLabel, "cell 0 0,alignx center");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 64));

		lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(309, 281, 123, 47);
		PainelLogin.add(lblNewLabel_1, "cell 0 1");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 40));

		txtLogin = new JTextField();
		txtLogin.setBorder(bordaPreta);
		txtLogin.setFont(new Font("Arial", Font.PLAIN, 25));
		txtLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				// int linhaSelecionada = table.getSelectedRow();

				// endSelecionado = listarInfo_Login.get(linhaSelecionada);

				// txtLogin.setText(endSelecionado.getLogin());
				// txtSenha.setText(endSelecionado.getSenha());

			}
		});

		txtLogin.setBounds(309, 339, 335, 30);
		PainelLogin.add(txtLogin, "cell 0 2,growx,aligny top");
		txtLogin.setColumns(10);

		lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(309, 402, 123, 40);
		PainelLogin.add(lblNewLabel_2, "cell 0 3");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 40));

		txtSenha = new JPasswordField();
		txtSenha.setBorder(bordaPreta);
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 25));
		txtSenha.setBounds(309, 453, 335, 30);
		PainelLogin.add(txtSenha, "cell 0 4,growx,aligny top");
		txtSenha.setColumns(10);
		
		JLabel lblMostrar = new JLabel("");
		lblMostrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/visao/Icones/iconeVerSenha.png")));
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

                    PainelLogin.remove(txtSenha);
                    txtSenha = txtSenhaVisivel;
                    PainelLogin.add(txtSenha, "cell 0 4,growx,aligny top");
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

                    PainelLogin.remove(txtSenha);
                    txtSenha = txtSenhaEscondida;
                    PainelLogin.add(txtSenha, "cell 0 4,growx,aligny top");
                    lblMostrar.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/iconeVerSenha.png")));

                    revalidate();
                    repaint();
                }
            }
        });
		PainelLogin.add(lblMostrar, "cell 1 4");

		JLabel lblNewLabel_3 = new JLabel("Esqueceu a senha?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(515, 494, 129, 14);
		PainelLogin.add(lblNewLabel_3, "cell 0 5,aligny top");

		JLabel lblNewLabel_4 = new JLabel("Não possui conta? Registre-se");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastro cadastro = new TelaCadastro();
				cadastro.setVisible(true);
				dispose();
			}
		});

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtLogin.getText().isEmpty() && txtSenha.getText().isEmpty()) {
					txtLogin.setBorder(bordaVermelha);
					txtSenha.setBorder(bordaVermelha);
					TelaLoginNaoRealizado abrir = new TelaLoginNaoRealizado();
					return;
				}

				else if (txtLogin.getText().isEmpty()) {
					txtLogin.setBorder(bordaVermelha);
					TelaLoginNaoRealizado abrir = new TelaLoginNaoRealizado();
					return;
				} else {
					txtLogin.setBorder(bordaPreta);
				}

				if (txtSenha.getText().isEmpty()) {
					txtSenha.setBorder(bordaVermelha);
					TelaLoginNaoRealizado abrir = new TelaLoginNaoRealizado();
					return;

				} else {
					txtSenha.setBorder(bordaPreta);
				}

				String email = txtLogin.getText();

				String senha = txtSenha.getText();

				Infologin login = new Infologin();

				login.setLogin(email);
				login.setSenha(senha);

				Hospedes hospede = new Hospedes();

				InfologinDAO dao = InfologinDAO.getInstancia();

				Infologin usuarioLogado = dao.buscarInfologin(login);

				if (usuarioLogado != null) {
					TelaLoginRealizado abrir = new TelaLoginRealizado();
					HospedesDAO daohosp = HospedesDAO.getInstancia();
					hospede.setLogin(login);
					hospede = daohosp.buscarHospedes(usuarioLogado);
					Reserva reserva = new Reserva();
					TelaHome c = new TelaHome(hospede, reserva);
					abrir.setVisible(true);
					c.setVisible(true);
					dispose();
					abrir.setVisible(true);
				} else {
					TelaLoginNaoRealizado abrir = new TelaLoginNaoRealizado();
					abrir.setVisible(true);				
					}
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(TelaLogin.class.getResource("/visao/Botões/BTN Login.png")));
		PainelLogin.add(lblNewLabel_5, "cell 0 6,aligny center");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(372, 631, 210, 14);
		PainelLogin.add(lblNewLabel_4, "cell 0 7,alignx center,aligny top");
	}

	protected void atualizarJTable() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Login", "Senha" });

		InfologinDAO endDAO = InfologinDAO.getInstancia();
		listarInfo_Login = endDAO.listarInfologin();

		for (int i = 0; i < listarInfo_Login.size(); i++) {
			Infologin p = listarInfo_Login.get(i);
			modelo.addRow(new Object[] { p.getLogin(), p.getSenha() });
		}

		table.setModel(modelo);
	}
}
