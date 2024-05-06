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
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JLabel lblNewLabel_2;
	private Infologin endSelecionado;
	ArrayList<Infologin> listarInfo_Login;
	private JTextField testelogin;
	private JTextField testesenha;
	private JTextField testeid;
	private JTextField txtdelete;

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
					frame.setLocationRelativeTo(null);
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
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(229, 236, 238));
		panel.setBounds(960, 0, 944, 1041);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(397, 61, 158, 74);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 64));

		table = new JTable();

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
		panel.add(txtLogin);
		txtLogin.setColumns(10);

		lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(309, 281, 123, 47);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 40));

		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 32));
		txtSenha.setBounds(309, 453, 335, 30);
		panel.add(txtSenha);
		txtSenha.setColumns(10);

		lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(309, 402, 123, 40);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 40));

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
		panel.add(JButton);

		JLabel lblNewLabel_3 = new JLabel("Esqueceu a senha?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(515, 494, 129, 14);
		panel.add(lblNewLabel_3);

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
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(372, 631, 210, 14);
		panel.add(lblNewLabel_4);

		testeid = new JTextField();
		testeid.setFont(new Font("Arial", Font.PLAIN, 32));
		testeid.setColumns(10);
		testeid.setBounds(319, 687, 335, 30);
		panel.add(testeid);

		testelogin = new JTextField();
		testelogin.setFont(new Font("Arial", Font.PLAIN, 32));
		testelogin.setColumns(10);
		testelogin.setBounds(319, 728, 335, 30);
		panel.add(testelogin);

		testesenha = new JTextField();
		testesenha.setFont(new Font("Arial", Font.PLAIN, 32));
		testesenha.setColumns(10);
		testesenha.setBounds(319, 769, 335, 30);
		panel.add(testesenha);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Integer id = Integer.valueOf(testeid.getText());
				String email = testelogin.getText();
				String senha = testesenha.getText();

				InfologinDAO dao = InfologinDAO.getInstancia();

				Infologin update = dao.atualizarInfologin(email, senha, id);

			}
		});
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnAlterar.setBackground(new Color(119, 165, 175));
		btnAlterar.setBounds(359, 810, 243, 40);
		panel.add(btnAlterar);

		txtdelete = new JTextField();
		txtdelete.setFont(new Font("Arial", Font.PLAIN, 32));
		txtdelete.setColumns(10);
		txtdelete.setBounds(319, 925, 335, 30);
		panel.add(txtdelete);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String email = txtdelete.getText();

				InfologinDAO dao = InfologinDAO.getInstancia();

				Infologin deletelog = dao.removerInfologin(email);

			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 16));
		btnExcluir.setBackground(new Color(119, 165, 175));
		btnExcluir.setBounds(359, 875, 243, 40);
		panel.add(btnExcluir);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaLogin.class.getResource("/visao/Fotos/Hotel.png")));
		lblNewLabel_5.setBounds(0, 0, 960, 1080);
		contentPane.add(lblNewLabel_5);
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
