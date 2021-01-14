package main;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {
	
	private MainPage parent;
	private JScrollPane scrPane;
    private JTable table;
	
	public Table(MainPage main) {
		scrPane = new javax.swing.JScrollPane();
	    table = new javax.swing.JTable();
	    parent = main;
	}
	
	
	public void setTable(Object[][] tableData, String[] columns) {
    	table.setModel(new javax.swing.table.DefaultTableModel(tableData, columns ));
            scrPane.setViewportView(table);
    }
	
	public JScrollPane getScrPane() {
		return scrPane;
	}

	public void setScrPane(JScrollPane scrPane) {
		this.scrPane = scrPane;
	}

	public JTable getTable() {
		return table;
	}
	
	public void setTable(JTable table) {
		this.table = table;
	}
	
}
