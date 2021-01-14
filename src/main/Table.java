package main;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Table {
	
	private MainPage parent;
	private JScrollPane scrPane;
    private JTable table;
    private ListSelectionModel model;
	
	public Table(MainPage main) {
		scrPane = new javax.swing.JScrollPane();
	    table = new javax.swing.JTable();	    
	    parent = main;
	    
	    table.addMouseListener(new java.awt.event.MouseAdapter() {
			  public void mouseClicked(java.awt.event.MouseEvent e) {
				  int row=table.rowAtPoint(e.getPoint());
				  int col= table.columnAtPoint(e.getPoint());
				  
				  if(table.getValueAt(row,col).toString().equals("  Edit  ")) {
					  parent.showEditPopUp(table.getValueAt(row,0).toString());
				  }
				  else if(table.getValueAt(row,col).toString().equals("  View  ")) {
					  parent.showDNPopUp(table.getValueAt(row,0).toString());
				  }
		} } );
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
