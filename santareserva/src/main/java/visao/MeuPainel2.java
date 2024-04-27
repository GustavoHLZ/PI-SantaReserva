package visao;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.Quarto;
import net.miginfocom.swing.MigLayout;
import controle.Quarto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MeuPainel2 extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblTipoQuarto;

	/**
	 * Create the frame.
	 * @param quarto 
	 */
	public MeuPainel2(Quarto quarto) {
		setLayout(new MigLayout("", "[][750px][200px][200px][][100px]", "[][][][]"));
		setBounds(0, 0, 1500, 200);
		
		JLabel lblImagemCasal = new JLabel("");
		lblImagemCasal.setIcon(new ImageIcon(visao.MeuPainel2.class.getResource("/visao/Fotos/Suite.png")));
		add(lblImagemCasal, "cell 0 0");
		
		lblTipoQuarto = new JLabel(quarto.getTipo());
		lblTipoQuarto.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblTipoQuarto, "cell 1 0");
		
		JLabel lblTextPrecoCasal = new JLabel("Preço Diária");
		lblTextPrecoCasal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblTextPrecoCasal, "cell 2 0,alignx center");
		
		JLabel lblTextQuantidadeCasal = new JLabel(quarto.getQuantidade());
		lblTextQuantidadeCasal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblTextQuantidadeCasal, "cell 3 0,alignx center");
		
		JLabel lblDescCasal = new JLabel("Detalhes: 1 cama de casal, wifi disponpível, ar condicionado, banheira e televisão.");
		lblDescCasal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDescCasal, "cell 1 2");
		
		JLabel lblPrecoCasal = new JLabel(quarto.getPreco());
		lblPrecoCasal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblPrecoCasal, "cell 2 2,alignx center");
		
		JLabel lblReservarCasal = new JLabel("");
		lblReservarCasal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("clicou no quarto tipo "+quarto.getTipo());
			}
		});
		lblReservarCasal.setIcon(new ImageIcon(MeuPainel2.class.getResource("/visao/Botões/BTN Reserva.png")));
		add(lblReservarCasal, "cell 5 2");
	}
	


	public void setdados(String string) {
		// TODO Auto-generated method stub
		
	}

}
