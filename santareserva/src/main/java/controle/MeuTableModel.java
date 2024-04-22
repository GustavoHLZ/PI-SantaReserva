package test;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MeuTableModel implements TableModel {

	ArrayList dados;
	public MeuTableModel(ArrayList dados) {
		this.dados = dados;
	}
	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		//MeuPainel painel = new MeuPainel();
		//painel.setDados("dasdsa");
		//MeuPainel2 painel2 = new MeuPainel2("sa");
		//painel2.setText("lblImagemCasal");
		//painel2.setText("lblPrecoCasal");
		//painel2.setText("lblReservarCasal");
		//painel2.setText("lblQuartoCasal");
		//painel2.setText("lblDescCasal");
		return null;//painel2;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
