package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
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

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	
	
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(229, 236, 238));
		panel.setBounds(576, 0, 794, 749);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(351, 68, 158, 74);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 64));
		
		txtLogin = new JTextField();
		txtLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				
				
			}
		});
		txtLogin.setBounds(264, 339, 335, 30);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setBounds(264, 292, 123, 47);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 40));
		
		txtSenha = new JTextField();
		txtSenha.setBounds(264, 453, 335, 30);
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(264, 402, 123, 40);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JButton JButton = new JButton("Login");
		JButton.setForeground(new Color(255, 255, 255));
		
		JButton.setFont(new Font("Arial", Font.PLAIN, 16));
		JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JButton.setBackground(new Color(119, 165, 175));
		JButton.setBounds(304, 537, 243, 40);
		panel.add(JButton);
		
		JLabel lblNewLabel_3 = new JLabel("Esqueceu a senha?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(483, 494, 129, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Não possui conta? Registre-se");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(314, 588, 210, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblFotoHotel = new JLabel("");
		lblFotoHotel.setBounds(214, 31, 256, 256);
		contentPane.add(lblFotoHotel);
	}
}
