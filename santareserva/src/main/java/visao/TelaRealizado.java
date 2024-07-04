package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class TelaRealizado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Tela;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaRealizado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1920, 1080);
		Tela = new JPanel();
		Tela.setBorder(null);

		setContentPane(Tela);
		Tela.setLayout(new MigLayout("", "[100px,grow]", "[grow]"));
		
		JPanel Icone = new JPanel();
		Tela.add(Icone, "flowx,cell 0 0,alignx center,growy");
		Icone.setLayout(new MigLayout("", "[grow][grow]", "[grow][][grow][]10px"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaRealizado.class.getResource("/visao/Icones/NaorealizadoM.png")));
		Icone.add(lblNewLabel, "cell 0 0,alignx center,aligny bottom");
		
		JLabel lblNoRealizado = new JLabel("Não Realizado!");
		lblNoRealizado.setFont(new Font("Arial", Font.PLAIN, 20));
		Icone.add(lblNoRealizado, "cell 0 1,alignx center,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaRealizado.class.getResource("/visao/Icones/BtnFechar.png")));
		Icone.add(lblNewLabel_1, "cell 0 2,alignx center,aligny bottom");
	}

}
