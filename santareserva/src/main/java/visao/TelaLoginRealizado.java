package visao;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class TelaLoginRealizado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel Tela;

    /**
     * Create the frame.
     */
    public TelaLoginRealizado() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new Dimension(500, 500)); // Define o tamanho preferido do JFrame
        pack(); // Ajusta o tamanho automaticamente
        setLocationRelativeTo(null); // Centraliza o JFrame na tela

        Tela = new JPanel();
        Tela.setBackground(new Color(255, 255, 255));
        Tela.setBorder(new LineBorder(new Color(75, 75, 75)));

        setContentPane(Tela);
        Tela.setLayout(new MigLayout("", "[100px,grow]", "[grow]"));

        JPanel Icone = new JPanel();
        Icone.setBackground(new Color(255, 255, 255));
        Tela.add(Icone, "flowx,cell 0 0,alignx center,growy");
        Icone.setLayout(new MigLayout("", "[grow][grow]", "[grow][][grow][]10px"));

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(TelaLoginRealizado.class.getResource("/visao/Icones/RealizadoM.png")));
        Icone.add(lblNewLabel, "cell 0 0,alignx center,aligny bottom");

        JLabel lblNoRealizado = new JLabel("Login Realizado Com Sucesso!");
        lblNoRealizado.setFont(new Font("Arial", Font.PLAIN, 20));
        Icone.add(lblNoRealizado, "cell 0 1,alignx center,aligny center");

        // Chama o método para exibir o popup e fechar após 2 segundos
        exibirPopupAnimado();
    }

    private void exibirPopupAnimado() {
        setVisible(true); // Torna o JFrame visível

        // Timer para fechar o popup após 2 segundos
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha o popup
            }
        });
        timer.setRepeats(false); // Executa apenas uma vez
        timer.start();
    }

 
}