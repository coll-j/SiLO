package database;

import java.sql.*;
import java.util.List; 
import java.util.ArrayList;

public class DbHandler {
	
	/* add item */
	public void addItem(Item item) {
		try {
			Connection conn = new DbConnection().getConn();
			    
			String sql = "INSERT INTO Item(`id`,`barcode`, `title`,`description`, `manufacturer`, `url`, `stocks`)"
						+ "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, item.getId());
			ps.setString(2, item.getBarcode());
			ps.setString(3, item.getTitle());
			ps.setString(4, item.getDescription());
			ps.setString(5, item.getManufacturer());
			ps.setString(6, item.getUrl());
			ps.setInt(7, item.getStocks());
			
			ps.executeUpdate();
			conn.close();
						
		} catch(Exception e) {
			 System.out.println(e);	}
	}
	
	/* Get All Item */
	public List<Item> getAllItem() {
		List<Item> items = new ArrayList<Item>();
		try {
			Connection conn = new DbConnection().getConn();
			    
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from item");
			
			while(rs.next()){
				Item temp = new Item(rs.getString("id"), rs.getString("barcode"), rs.getString("title"), rs.getString("description"),
						rs.getString("manufacturer"), rs.getString("url"), rs.getInt("stocks") ); 
				items.add(temp);
			}
			conn.close();
			
		} catch(Exception e) {
			 System.out.println(e);	}
			    
	    return items;
	}
	
	/* Edit Item */
	public void EditItem(Item item) {
		try {
			Connection conn = new DbConnection().getConn();
			
			String sql = "UPDATE ITEM SET barcode = ?, title = ?, description = ?, manufacturer = ?, url = ?, stocks = ?  WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(7, item.getId());
			ps.setString(1, item.getBarcode());
			ps.setString(2, item.getTitle());
			ps.setString(3, item.getDescription());
			ps.setString(4, item.getManufacturer());
			ps.setString(5, item.getUrl());
			ps.setInt(6, item.getStocks());
			
			ps.executeUpdate();
			conn.close();
			
		}	catch(Exception e) {
			 System.out.println(e);	}
		
	}
	
	
	/* add Invoice */
	public void addInvoice(Invoice invoice) {		
		try {
			Connection conn = new DbConnection().getConn();
			  
			String sql = "INSERT INTO invoice(`invoiceNumber`, `poNumber`, `supplierName`, `status`, `orderDate`, `deliveryDate`)"
						+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			java.sql.Date sqlOrderDate=new java.sql.Date(invoice.getOrderDate().getTime());
			java.sql.Date sqlDeliveryDate=new java.sql.Date(invoice.getDeliveryDate().getTime());
			
			ps.setString(1, invoice.getInvoiceNumber());
			ps.setString(2, invoice.getPoNumber());
			ps.setString(3, invoice.getSupplierName());
			ps.setString(4, invoice.getStatus());
			ps.setDate(5, (java.sql.Date) sqlOrderDate);
			ps.setDate(6, (java.sql.Date) sqlDeliveryDate);
			
			ps.executeUpdate();
			conn.close();
						
		} catch(Exception e) {
			 System.out.println(e);	}
	}
	
	/* Get All Invoice */
	public List<Invoice> getAllInvoice() {
		List<Invoice> invoices = new ArrayList<Invoice>();
		try {
			Connection conn = new DbConnection().getConn();
			    
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from invoice");
			
			while(rs.next()){
				Invoice temp = new Invoice(rs.getString("invoiceNumber"), rs.getString("poNumber"), rs.getString("supplierName"), rs.getString("status"),
						rs.getDate("orderDate"), rs.getDate("deliveryDate") ); 
				invoices.add(temp);
			}
			conn.close();
			
		} catch(Exception e) {
			 System.out.println(e);	}
		
		return invoices;
	}
	
	/* Edit Invoice */
	public void EditInvoice(Invoice invoice) {
		try {
			Connection conn = new DbConnection().getConn();
			
			String sql = "UPDATE invoice SET PoNumber = ?, SupplierName = ?, Status = ?, OrderDate = ?, DeliveryDate = ?  WHERE InvoiceNumber = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			java.sql.Date sqlOrderDate=new java.sql.Date(invoice.getOrderDate().getTime());
			java.sql.Date sqlDeliveryDate=new java.sql.Date(invoice.getDeliveryDate().getTime());
			
			ps.setString(6, invoice.getInvoiceNumber());
			ps.setString(1, invoice.getPoNumber());
			ps.setString(2, invoice.getSupplierName());
			ps.setString(3, invoice.getStatus());
			ps.setDate(4, (java.sql.Date) sqlOrderDate);
			ps.setDate(5, (java.sql.Date) sqlDeliveryDate);
			
			ps.executeUpdate();
			conn.close();
			
		}	catch(Exception e) {
			 System.out.println(e);	}
		
	}
	
	
	/* add DeliveryNote */
	public void addDeliveryNote(DeliveryNote deliveryNote) {
		try {
			Connection conn = new DbConnection().getConn();
			  
			String sql = "INSERT INTO deliverynote(`deliveryNoteNumber`, `customerName`, `status`, `invoiceNumber`, `orderDate`, `deliveryDate`)"
						+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			java.sql.Date sqlOrderDate=new java.sql.Date(deliveryNote.getOrderDate().getTime());
			java.sql.Date sqlDeliveryDate=new java.sql.Date(deliveryNote.getDeliveryDate().getTime());
			
			ps.setString(1, deliveryNote.getDeliveryNoteNumber());
			ps.setString(2, deliveryNote.getCustomerName());
			ps.setString(3, deliveryNote.getStatus());
			ps.setString(4, deliveryNote.getInvoiceNumber());
			ps.setDate(5, (java.sql.Date) sqlOrderDate);
			ps.setDate(6, (java.sql.Date) sqlDeliveryDate);
			
			ps.executeUpdate();
			conn.close();
			
		} catch(Exception e) {
			 System.out.println(e);	}
	}
	
	/* Get All DeliveryNote */
	public List<DeliveryNote> getAllDeliveryNote() {
		List<DeliveryNote> deliveryNotes = new ArrayList<DeliveryNote>();
		try {
			Connection conn = new DbConnection().getConn();
			    
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from deliverynote");
			
			while(rs.next()){
				DeliveryNote temp = new DeliveryNote(rs.getString("deliveryNoteNumber"), rs.getString("customerName"), rs.getString("status"), rs.getString("invoiceNumber"),
						rs.getDate("orderDate"), rs.getDate("deliveryDate") ); 
				deliveryNotes.add(temp);
			}
			conn.close();
			
		} catch(Exception e) {
			 System.out.println(e);	}
		
		return deliveryNotes;
	}
	
	/* Edit DeliveryNote */
	public void EditDeliveryNote(DeliveryNote deliveryNote) {
		try {
			Connection conn = new DbConnection().getConn();
			
			String sql = "UPDATE invoice SET CustomerName = ?, Status = ?, InvoiceNumber = ?, OrderDate = ?, DeliveryDate = ?  WHERE DeliveryNoteNumber = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			java.sql.Date sqlOrderDate=new java.sql.Date(deliveryNote.getOrderDate().getTime());
			java.sql.Date sqlDeliveryDate=new java.sql.Date(deliveryNote.getDeliveryDate().getTime());
			
			ps.setString(6, deliveryNote.getDeliveryNoteNumber());
			ps.setString(1, deliveryNote.getCustomerName());
			ps.setString(2, deliveryNote.getStatus());
			ps.setString(3, deliveryNote.getInvoiceNumber());
			ps.setDate(4, (java.sql.Date) sqlOrderDate);
			ps.setDate(5, (java.sql.Date) sqlDeliveryDate);
			
			
			ps.executeUpdate();
			conn.close();
			
		}	catch(Exception e) {
			 System.out.println(e);	}
		
	}
	
	
}
