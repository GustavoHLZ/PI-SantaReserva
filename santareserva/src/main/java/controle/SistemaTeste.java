package test;


import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class SistemaTeste {
    public static void main(String[] args) {

        var contentPane = new JPanel(new BorderLayout());
        ArrayList<Quarto> dados = new ArrayList<Quarto>();

        Quarto q1 = new Quarto();
        q1.preco = "1111";
        q1.quantidade="222";
        q1.tipo = "Solteiro";
        dados.add(q1);
        
        Quarto q2 = new Quarto();
        q2.preco = "56456456";
        q2.quantidade="quantidade 5555";
        q2.tipo = "Casal";
        dados.add(q2);
        
        
        JTable tabela =  new MeuJTable(new MeuTableModel(dados) );
        var richColumn = tabela.getColumnModel().getColumn(0);
        richColumn.setCellRenderer(new ExpandablePanelCellRenderer(dados));
        richColumn.setCellEditor(new DynamicExpndablePanelCellEditor(dados));
        
        contentPane.add(new JScrollPane(tabela));

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("DynamicCellRow");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(contentPane);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}