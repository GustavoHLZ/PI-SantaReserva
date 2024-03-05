package visao;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.TipoHoras;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class teste_combo_box extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtExemplo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teste_combo_box frame = new teste_combo_box();
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
	public teste_combo_box() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


/*
 * Criacao do combobox a partir do enum
 */
		JComboBox<String> cbHora = new JComboBox<>();
		for (TipoHoras tipo : TipoHoras.values()) {
			cbHora.addItem(tipo.getDesc());
		}

		cbHora.setBounds(115, 11, 92, 22);
		contentPane.add(cbHora);

		JLabel lblNewLabel = new JLabel("Quantidade horas:");
		lblNewLabel.setBounds(10, 15, 95, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnPegaSelecaoCb = new JButton("Exemplo");
		btnPegaSelecaoCb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selecionado = (String) cbHora.getSelectedItem();
				
				TipoHoras tipo = TipoHoras.converteEnumPorValor(selecionado);
				
				int qtdHoras = tipo.getValorNumerico();
			}
		});
		btnPegaSelecaoCb.setBounds(10, 55, 89, 23);
		contentPane.add(btnPegaSelecaoCb);
		
		txtExemplo = new JTextField();
		txtExemplo.setBounds(10, 89, 86, 20);
		contentPane.add(txtExemplo);
		txtExemplo.setColumns(10);
	}
}
