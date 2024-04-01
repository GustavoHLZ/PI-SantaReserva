package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.HospedesDAO;
import controle.Info_LoginDAO;
import modelo.Hospedes;
import modelo.Info_Login;

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

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JLabel lblNewLabel_2;
	private Info_Login endSelecionado;
	ArrayList<Info_Login> listarInfo_Login;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	
	
	public TelaLogin() {
		
		listarInfo_Login = new ArrayList<Info_Login>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(229, 236, 238));
		panel.setBounds(951, 10, 934, 1019);
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
				
				//int linhaSelecionada = table.getSelectedRow();

				//endSelecionado = listarInfo_Login.get(linhaSelecionada);


				//txtLogin.setText(endSelecionado.getLogin());
				//txtSenha.setText(endSelecionado.getSenha());
				
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
				
				String Login = txtLogin.getText();
				String Senha = txtSenha.getText();
				
					
				HospedesDAO dao = HospedesDAO.getInstancia();
				
				Hospedes logins = dao.buscarHospedes(Login, Senha);
				
				if(logins != null) {
					JOptionPane.showMessageDialog(null,"Usuário Cadastro");
					TelaHome c = new TelaHome();
					c.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null,"Usuário não cadastrado");
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
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(372, 631, 210, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblFotoHotel = new JLabel("");
		lblFotoHotel.setBounds(-23, 50, 256, 256);
		panel.add(lblFotoHotel);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaLogin.class.getResource("/visao/Fotos/Hotel.png")));
		lblNewLabel_5.setBounds(0, 0, 960, 1080);
		contentPane.add(lblNewLabel_5);
	}
	
	protected void atualizarJTable() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Login", "Senha" });

		Info_LoginDAO endDAO = Info_LoginDAO.getInstancia();
		listarInfo_Login = endDAO.listarInfo_Login();
		
		for (int i = 0; i < listarInfo_Login.size(); i++) {
			Info_Login p = listarInfo_Login.get(i);
			modelo.addRow(new Object[] { p.getLogin(), p.getSenha() });
		}

		table.setModel(modelo);
	}

}
