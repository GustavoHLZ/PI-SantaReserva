package visao;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaNaoRealizado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Tela;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaNaoRealizado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1920, 1080);
		Tela = new JPanel();
		Tela.setBorder(null);

		setContentPane(Tela);
		Tela.setLayout(new MigLayout("", "[100px,grow]", "[grow]"));
		
		JPanel Icone = new JPanel();
		Tela.add(Icone, "flowx,cell 0 0,alignx center,growy");
		Icone.setLayout(new MigLayout("", "[grow][grow]", "[grow][][][grow][]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaNaoRealizado.class.getResource("/visao/Icones/NaorealizadoM.png")));
		Icone.add(lblNewLabel, "cell 0 0,alignx center,aligny bottom");
		
		JLabel lblNoRealizado = new JLabel("Ocorreu um erro durante a transação!");
		lblNoRealizado.setFont(new Font("Arial", Font.PLAIN, 20));
		Icone.add(lblNoRealizado, "cell 0 1,alignx center,aligny center");
		
		JLabel lblNewLabel_2 = new JLabel("(Verifique se os dados foram inseridos corretamente)");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		Icone.add(lblNewLabel_2, "cell 0 2,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(TelaRealizado.class.getResource("/visao/Icones/BtnFechar.png")));
		Icone.add(lblNewLabel_1, "cell 0 3,alignx center,aligny bottom");
	}

}
