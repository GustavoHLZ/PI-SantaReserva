package test;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class DynamicExpndablePanelCellEditor extends AbstractCellEditor implements TableCellEditor {
    Object value;
    ArrayList<Quarto> dados;
    public DynamicExpndablePanelCellEditor(ArrayList<Quarto> dados) {
		// TODO Auto-generated constructor stub
    	this.dados = dados;
	}

	@Override
    public Object getCellEditorValue() {
        return value; // not changing
    }

    //private final MeuPainel2 expandablePanel = new MeuPainel2("2");
   

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.value = value;
       // expandablePanel.setValue(value);
        
        MeuPainel2 expandablePanel = new MeuPainel2(dados.get(row));
        return expandablePanel;
    }

}
