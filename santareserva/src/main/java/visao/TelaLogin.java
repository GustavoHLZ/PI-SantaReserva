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

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[10px][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][342px][][]", "[40px][][][][][][][][][][][40px][][][][][][40px][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 64));
		contentPane.add(lblNewLabel, "cell 50 2,alignx center,aligny top");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 23 9,alignx left,aligny top");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 50 11,grow");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 50 17,grow");
		textField_1.setColumns(10);
	}
}
