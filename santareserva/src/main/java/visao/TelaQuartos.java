package visao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;

public class TelaQuartos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PainelGeral;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaQuartos frame = new TelaQuartos();
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
	public TelaQuartos() {
		setTitle("Quartos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		PainelGeral = new JPanel();
		PainelGeral.setBackground(new Color(255, 255, 255));
		PainelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PainelGeral);
		PainelGeral.setLayout(new MigLayout("", "[][grow][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[][][][][][grow][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		JPanel PainelTopo = new JPanel();
		PainelTopo.setBackground(new Color(119, 165, 175));
		PainelGeral.add(PainelTopo, "cell 0 0 66 5,grow");
		
		JPanel PainelIcones = new JPanel();
		PainelIcones.setBackground(new Color(239, 239, 239));
		PainelGeral.add(PainelIcones, "cell 1 5 9 31,grow");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(239, 239, 239));
		PainelGeral.add(panel, "cell 11 6 55 30,grow");
		
		
	}

}
