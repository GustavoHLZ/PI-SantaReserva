package test;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ExpandablePanelCellRenderer implements TableCellRenderer {
   // private final MeuPainel2 expandablePanelRenderComponent = new MeuPainel2("1");
	ArrayList<Quarto> dados;
    public ExpandablePanelCellRenderer(ArrayList<Quarto> dados) {
		// TODO Auto-generated constructor stub
    	this.dados = dados;
	}

	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //expandablePanelRenderComponent.setValue(value);
    	//System.out.println(row);
    	MeuPainel2 expandablePanelRenderComponent = new MeuPainel2(dados.get(row));
        return expandablePanelRenderComponent;
    }
}
