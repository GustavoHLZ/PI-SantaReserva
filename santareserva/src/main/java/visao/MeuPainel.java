package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MeuPainel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MeuPainel() {
		setLayout(new MigLayout("", "[][750px][200px][200px][][100px]", "[][][][]"));
		setBounds(0, 0, 1500, 200);
		
		JLabel lblImagemSolteiro = new JLabel("");
		lblImagemSolteiro.setIcon(new ImageIcon(MeuPainel.class.getResource("/img/Solteiro.png")));
		add(lblImagemSolteiro, "cell 0 0");
		
		JLabel lblQuartoSolteiro = new JLabel("Quarto Solteiro");
		lblQuartoSolteiro.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblQuartoSolteiro, "cell 1 0");
		
		JLabel lblTextPreco = new JLabel("Preço Diária");
		lblTextPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblTextPreco, "cell 2 0,alignx center");
		
		JLabel lblTxtQuantidade = new JLabel("Quantidade");
		lblTxtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblTxtQuantidade, "cell 3 0,alignx center");
		
		JLabel lblDescSolteiro = new JLabel("Detalhes: 1 cama de solteiro, wifi disponpível, ar condicionado, banheira e televisão.");
		lblDescSolteiro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDescSolteiro, "cell 1 2");
		
		JLabel lblPreco = new JLabel("R$ 250,00");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblPreco, "cell 2 2,alignx center");
		
		JLabel lblReservarSolteiro = new JLabel("");
		lblReservarSolteiro.setIcon(new ImageIcon(MeuPainel.class.getResource("/img/BTN Reserva.png")));
		add(lblReservarSolteiro, "cell 5 2");

	}

	public void setText(String string) {
		// TODO Auto-generated method stub
		
	}

}
