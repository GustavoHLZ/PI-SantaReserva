package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.HospedesDAO;
import controle.InfologinDAO;
import modelo.Hospedes;
import modelo.Infologin;

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
		Tela.setBackground(new Color(238, 238, 238));
		Tela.setBorder(null);

		setContentPane(Tela);
		Tela.setLayout(new MigLayout("", "[960px][960px]", "[grow]"));
		
		JPanel PainelHotel = new JPanel();
		Tela.add(PainelHotel, "cell 0 0, grow");
		
		JLabel ImgHotel = new JLabel("");
		ImgHotel.setIcon(new ImageIcon(TelaLogin.class.getResource("/visao/Fotos/Hotel.png")));
		PainelHotel.add(ImgHotel, "cell 0 0,alignx left,aligny top");

		JPanel PainelLogin = new JPanel();
		Tela.add(PainelLogin, "flowx,cell 1 0 1 6,alignx center,growy");
		PainelLogin.setLayout(new MigLayout("", "[grow]", "[200px][70px][][][][][100px][500px]"));

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
																txtLogin.setFont(new Font("Arial", Font.PLAIN, 32));
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
																		PainelLogin.add(txtLogin, "cell 0 2,aligny top");
																		txtLogin.setColumns(10);
												
														lblNewLabel_2 = new JLabel("Senha");
														lblNewLabel_2.setBounds(309, 402, 123, 40);
														PainelLogin.add(lblNewLabel_2, "cell 0 3");
														lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 40));
														
																txtSenha = new JTextField();
																txtSenha.setFont(new Font("Arial", Font.PLAIN, 32));
																txtSenha.setBounds(309, 453, 335, 30);
																PainelLogin.add(txtSenha, "cell 0 4,aligny top");
																txtSenha.setColumns(10);
												
														JLabel lblNewLabel_3 = new JLabel("Esqueceu a senha?");
														lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
														lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
														lblNewLabel_3.setBounds(515, 494, 129, 14);
														PainelLogin.add(lblNewLabel_3, "cell 0 5,aligny top");
												
														JButton JButton = new JButton("Login");
														JButton.setForeground(new Color(255, 255, 255));
														
																JButton.setFont(new Font("Arial", Font.PLAIN, 16));
																JButton.addActionListener(new ActionListener() {

																	public void actionPerformed(ActionEvent e) {

																		if (txtLogin.getText().equals("")) {

																			JOptionPane.showMessageDialog(null, "Preencha o campo Login.");

																			return;

																		}

																		if (txtSenha.getText().equals("")) {

																			JOptionPane.showMessageDialog(null, "Preencha o campo Senha.");

																			return;

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
																			JOptionPane.showMessageDialog(null, "Usuário Cadastrado");
																			HospedesDAO daohosp = HospedesDAO.getInstancia();
																			hospede.setLogin(login);
																			hospede = daohosp.buscarHospedes(usuarioLogado);
																			TelaHome c = new TelaHome(hospede);
																			c.setVisible(true);
																			dispose();
																		} else {
																			JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
																		}

																	}
																});
																JButton.setBackground(new Color(119, 165, 175));
																JButton.setBounds(359, 546, 243, 40);
																PainelLogin.add(JButton, "cell 0 6,alignx center");
												
														JLabel lblNewLabel_4 = new JLabel("Não possui conta? Registre-se");
														lblNewLabel_4.addMouseListener(new MouseAdapter() {
															@Override
															public void mouseClicked(MouseEvent e) {
																TelaCadastro cadastro = new TelaCadastro();
																cadastro.setVisible(true);
																dispose();
															}
														});
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
