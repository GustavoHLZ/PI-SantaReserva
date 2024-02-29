package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;

public class TelaPerfil extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][210.00,grow 25][][39.00][21.00][1487.00,grow 25][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[][][40.00][grow][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PI-SantaReserva\\santareserva\\src\\main\\resources\\BackgroundsPI\\Rectangle 3 barra s home.png"));
		contentPane.add(lblLogo, "cell 0 0 8 1");
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PI-SantaReserva\\santareserva\\src\\main\\resources\\BackgroundsPI\\Line 1.png"));
		contentPane.add(lblNewLabel_10, "cell 0 1 8 1,aligny top");
		
		JLabel lblNewLabel_11 = new JLabel("");
		contentPane.add(lblNewLabel_11, "cell 7 2");
		
		JLabel lblNewLabel_12 = new JLabel("");
		contentPane.add(lblNewLabel_12, "flowx,cell 2 5");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 238, 238));
		contentPane.add(panel, "cell 6 3 1 6,grow");
		panel.setLayout(new MigLayout("", "[grow][178.00][142.00][::200.00px][69.00][173.00][46px,grow]", "[66px][][][][40][][40][][40][46.00][][40][][40][169.00][20][5px:n][40][15][][5px:n][40][131.00][28.00]"));
		
		JLabel lblPerfil = new JLabel("");
		panel.add(lblPerfil, "cell 3 0,alignx center,aligny center");
		lblPerfil.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PI-SantaReserva\\santareserva\\src\\main\\resources\\Icones\\IconeUser.png"));
		
		JLabel lblNewLabel_14 = new JLabel("User");
		lblNewLabel_14.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(lblNewLabel_14, "cell 3 1,alignx center");
		
		JLabel lblNewLabel = new JLabel("Alterar Rua");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(lblNewLabel, "cell 1 3,alignx left,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Alterar Nome de Usuário");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(lblNewLabel_1, "cell 4 3 2 1");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 4 2 1,grow");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 4 4 2 1,grow");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Alterar Bairro");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(lblNewLabel_2, "cell 1 5");
		
		JLabel lblNewLabel_3 = new JLabel("Alterar Senha");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(lblNewLabel_3, "cell 4 5 2 1");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "cell 1 6 2 1,grow");
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		panel.add(textField_4, "cell 4 6 2 1,grow");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Alterar Cidade");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(lblNewLabel_4, "cell 1 7");
		
		JLabel lblNewLabel_5 = new JLabel("Alterar Email");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(lblNewLabel_5, "cell 4 7 2 1");
		
		textField_5 = new JTextField();
		panel.add(textField_5, "cell 1 8 2 1,grow");
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		panel.add(textField_6, "cell 4 8 2 1,grow");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Alterar CEP");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(lblNewLabel_6, "cell 2 12 3 1,growy");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "cell 2 13 3 1,grow");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Senha");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(lblNewLabel_7, "cell 2 15 3 1,alignx left");
		
		textField_7 = new JTextField();
		panel.add(textField_7, "cell 2 17 3 1,grow");
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Confirmar Senha");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(lblNewLabel_8, "cell 2 19 3 1,alignx left");
		
		textField_8 = new JTextField();
		panel.add(textField_8, "cell 2 21 3 1,grow");
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PI-SantaReserva\\santareserva\\src\\main\\resources\\Botões\\BTN Aplicar Atualizações.png"));
		panel.add(lblNewLabel_13, "cell 2 22 3 1,alignx center,aligny bottom");
		
		JLabel lblNewLabel_9 = new JLabel("");
		contentPane.add(lblNewLabel_9, "cell 0 9");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 238, 238));
		contentPane.add(panel_1, "cell 1 2 2 20,grow");
	}

}
