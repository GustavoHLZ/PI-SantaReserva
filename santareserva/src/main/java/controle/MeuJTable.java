package controle;

import javax.swing.JTable;
public class MeuJTable extends JTable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MeuJTable(MeuTableModel meuTableModel) {
		super(meuTableModel);
		setBorder(null);
		 
	}

	@Override
    public void doLayout() {
        super.doLayout();
        adjustRowHeights();
    }

    private void adjustRowHeights() {
        for (int row = 0; row < getRowCount(); row++) {
            int rowHeight = getRowHeight();

            for (int column = 0; column < getColumnCount(); column++) {
                var editorComponent = getEditorComponent();
                if (getEditingRow() == row && getEditingColumn() == column && editorComponent != null) {
                    editorComponent.setSize(getColumnModel().getColumn(column).getWidth(), 0);
                    rowHeight = Math.max(rowHeight, editorComponent.getPreferredSize().height);
                } else {
                    var comp = prepareRenderer(getCellRenderer(row, column), row, column);
                    rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                }
            }

            setRowHeight(row, rowHeight);
        }
    }

}
