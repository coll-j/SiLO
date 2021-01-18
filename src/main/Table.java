package main;

import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table {
	
	private MainPage parent;
	private JScrollPane scrPane;
    private JTable table;
	
	public Table(MainPage main) {
		scrPane = new JScrollPane();  
	    table = new JTable();
	    parent = main;
	    
	    table.addMouseListener(new java.awt.event.MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
				  int row=table.rowAtPoint(e.getPoint());
				  int col= table.columnAtPoint(e.getPoint());
				  
				  if(table.getValueAt(row,col).toString().equals("  Edit  ")) {
					  parent.showEditItemPopUp(table.getValueAt(row,0).toString());
				  }
				  else if(table.getValueAt(row,col).toString().equals("  View  ")) {
					  parent.showDNPopUp(table.getValueAt(row,0).toString());
				  }
		} } );
	}
	public void setTable(Vector<Vector<Object>> data, Vector<String> str) {
    	table.setModel(new DefaultTableModel(data, str));
        scrPane.setViewportView(table);
    }
	
	public JScrollPane getScrPane() {
		return scrPane;
	}

	public void getScrPane(JScrollPane scrPane) {
		this.scrPane = scrPane;
	}
	
}
