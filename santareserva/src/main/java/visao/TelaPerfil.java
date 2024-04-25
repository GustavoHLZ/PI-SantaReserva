package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.HospedesDAO;
import controle.InfologinDAO;
import modelo.Hospedes;
import modelo.Infologin;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPerfil extends JFrame {

	private JPanel PainelGeral;
	private JTextField txtRua;
	private JTextField txtUsuario;
	private JTextField txtCep;
	private JTextField txtBairro;
	private JTextField txtSenha;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private JTextField txtVerSenha;
	private JTextField txtConfSenha;
	private JTextField txtConfirmDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPerfil frame = new TelaPerfil();
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
	public TelaPerfil() {
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
		PainelAlteracao.setLayout(new MigLayout("", "[grow][178.00][142.00][::200.00px][69.00][][173.00][46px,grow]", "[66px][][][][40][][40][][40][46.00][][40][][40][130.00,grow][20][5px:n][40][15][][5px:n][40][100.00][28.00]"));
		
		JLabel lblPerfil = new JLabel("");
		PainelAlteracao.add(lblPerfil, "cell 3 0,alignx center,aligny center");
		lblPerfil.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Icones/IconeUser.png")));
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblUser, "cell 3 1,alignx center");
		
		JLabel lblAltRua = new JLabel("Alterar Rua");
		lblAltRua.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltRua, "cell 1 3,alignx left,aligny center");
		
		JLabel lblAltusuario = new JLabel("Alterar Nome de Usuário");
		lblAltusuario.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltusuario, "cell 4 3 3 1");
		
		txtRua = new JTextField();
		txtRua.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtRua, "cell 1 4 2 1,grow");
		txtRua.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtUsuario, "cell 4 4 3 1,grow");
		txtUsuario.setColumns(10);
		
		JLabel lblAltBairro = new JLabel("Alterar Bairro");
		lblAltBairro.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltBairro, "cell 1 5");
		
		JLabel lblAltSenha = new JLabel("Alterar Senha");
		lblAltSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltSenha, "cell 4 5 3 1");
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtBairro, "cell 1 6 2 1,grow");
		txtBairro.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtSenha, "cell 4 6 3 1,grow");
		txtSenha.setColumns(10);
		
		JLabel lblAltCidade = new JLabel("Alterar Cidade");
		lblAltCidade.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltCidade, "cell 1 7");
		
		JLabel lblAltEmail = new JLabel("Alterar Email");
		lblAltEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblAltEmail, "cell 4 7 3 1");
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtCidade, "cell 1 8 2 1,grow");
		txtCidade.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtEmail, "cell 4 8 3 1,grow");
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Alterar CEP");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblNewLabel_6, "cell 2 12 3 1,growy");
		
		JLabel lblExcluir = new JLabel("Exclusão de Perfil");
		lblExcluir.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblExcluir, "cell 6 12,alignx center");
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtCep, "cell 2 13 3 1,grow");
		txtCep.setColumns(10);
		
		txtConfirmDelete = new JTextField();
		PainelAlteracao.add(txtConfirmDelete, "cell 6 13,grow");
		txtConfirmDelete.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = txtConfirmDelete.getText();
				
				InfologinDAO dao = InfologinDAO.getInstancia();
				
				Infologin delete = dao.removerInfologin(email);
				
			}
		});
		PainelAlteracao.add(btnExcluir, "cell 6 14,alignx center");
		
		JLabel lblNewLabel_7 = new JLabel("Senha");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblNewLabel_7, "cell 2 15 3 1,alignx left");
		
		txtVerSenha = new JTextField();
		txtVerSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtVerSenha, "cell 2 17 3 1,grow");
		txtVerSenha.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Confirmar Senha");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 18));
		PainelAlteracao.add(lblNewLabel_8, "cell 2 19 3 1,alignx left");
		
		txtConfSenha = new JTextField();
		txtConfSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		PainelAlteracao.add(txtConfSenha, "cell 2 21 3 1,grow");
		txtConfSenha.setColumns(10);
		
		JLabel BtnAtualizarInfo = new JLabel("");
		BtnAtualizarInfo.setIcon(new ImageIcon(TelaPerfil.class.getResource("/visao/Botões/BTN Aplicar Atualizações.png")));
		PainelAlteracao.add(BtnAtualizarInfo, "cell 2 22 3 1,alignx center,aligny center");
		
		JPanel ColunaIcones = new JPanel();
		ColunaIcones.setBackground(new Color(238, 238, 238));
		PainelGeral.add(ColunaIcones, "cell 1 2 2 20,grow");
	}

}
