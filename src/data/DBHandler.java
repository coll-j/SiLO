package data;

import java.sql.*;
import java.util.List; 
import java.util.ArrayList;
import java.util.Date;

public class DbHandler {
	
	public List<Item> itemList = new ArrayList<Item>();
	public List<Invoice> invoiceList = new ArrayList<Invoice>();
	public List<DeliveryNote> deliveryNoteList = new ArrayList<DeliveryNote>();
	
//	public Item itemList[];
//	public Invoice invoiceList[];
//	public DeliveryNote deliveryNoteList[];
	
	
	public DbHandler() {
		getAllItem();
		getAllInvoice();
		getAllDeliveryNote();
	}

	/* add item */
	public void addItem(String id, String barcode, String title, String description, String manufacturer, String url, int stocks) {
		try {
			Connection conn = new DbConnection().getConn();
			    
			String sql = "INSERT INTO Item(`id`,`barcode`, `title`,`description`, `manufacturer`, `url`, `stocks`)"
						+ "VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, barcode);
			ps.setString(3, title);
			ps.setString(4, description);
			ps.setString(5, manufacturer);
			ps.setString(6, url);
			ps.setInt(7, stocks);
			
			ps.executeUpdate();
			conn.close();
			
			Item temp = new Item(id, barcode, title, description, manufacturer, url, stocks); 
			this.itemList.add(temp);
			
		} catch(Exception e) {
			 System.out.println(e);	}
	}
	
	/* Get All Item */
	public void getAllItem() {
//		List<Item> items = new ArrayList<Item>();
		try {
			Connection conn = new DbConnection().getConn();
			    
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from item");
			
			while(rs.next()){
				Item temp = new Item(rs.getString("id"), rs.getString("barcode"), rs.getString("title"), rs.getString("description"),
						rs.getString("manufacturer"), rs.getString("url"), rs.getInt("stocks") ); 
				this.itemList.add(temp);
			}
			conn.close();
			
		} catch(Exception e) {
			 System.out.println(e);	}
		
//		this.itemList = new Item[items.size()]; 
//	    this.itemList = items.toArray(itemList);
	}
	
	/* Edit Item */
	public void EditItem(String id, String title) {
		try {
			Connection conn = new DbConnection().getConn();
			
			// option 1
			String sql = "UPDATE ITEM SET title = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(2, id);
			ps.setString(1, title);
			
			/*  // option 2
			String sql = "UPDATE ITEM SET title=?, description=?, manufacturer=?, stocks=? WHERE carid = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(5, id);
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setString(3, manufacturer);
			ps.setInt(4, stocks);
			*/
			
			ps.executeUpdate();
			conn.close();
			
		}	catch(Exception e) {
			 System.out.println(e);	}
		
	}
	
	
	/* add Invoice */
	public void addInvoice(String invoiceNumber, String poNumber, String supplierName, String status
			,java.util.Date orderDate, java.util.Date deliveryDate) {		
		try {
			Connection conn = new DbConnection().getConn();
			  
			String sql = "INSERT INTO invoice(`invoiceNumber`, `poNumber`, `supplierName`, `status`, `orderDate`, `deliveryDate`)"
						+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			java.sql.Date sqlOrderDate=new java.sql.Date(orderDate.getTime());
			java.sql.Date sqlDeliveryDate=new java.sql.Date(deliveryDate.getTime());
			
			ps.setString(1, invoiceNumber);
			ps.setString(2, poNumber);
			ps.setString(3, supplierName);
			ps.setString(4, status);
			ps.setDate(5, (java.sql.Date) sqlOrderDate);
			ps.setDate(6, (java.sql.Date) sqlDeliveryDate);
			
			ps.executeUpdate();
			conn.close();
			
			Invoice temp = new Invoice(invoiceNumber, poNumber, supplierName, status, orderDate, deliveryDate ); 
			this.invoiceList.add(temp);
			
		} catch(Exception e) {
			 System.out.println(e);	}
	}
	
	/* Get All Invoice */
	public void getAllInvoice() {
//		List<Invoice> invoices = new ArrayList<Invoice>();
		try {
			Connection conn = new DbConnection().getConn();
			    
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from invoice");
			
			while(rs.next()){
				Invoice temp = new Invoice(rs.getString("invoiceNumber"), rs.getString("poNumber"), rs.getString("supplierName"), rs.getString("status"),
						rs.getDate("orderDate"), rs.getDate("deliveryDate") ); 
				this.invoiceList.add(temp);
			}
			conn.close();
			
		} catch(Exception e) {
			 System.out.println(e);	}
		
//		this.invoiceList = new Invoice[invoices.size()]; 
//		this.invoiceList = invoices.toArray(this.invoiceList);
	}
	
	
	/* add DeliveryNote */
	public void addDeliveryNote(String deliveryNoteNumber, String customerName, String status, String invoiceNumber,
			Date orderDate, Date deliveryDate) {
		try {
			Connection conn = new DbConnection().getConn();
			  
			String sql = "INSERT INTO deliverynote(`deliveryNoteNumber`, `customerName`, `status`, `invoiceNumber`, `orderDate`, `deliveryDate`)"
						+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			java.sql.Date sqlOrderDate=new java.sql.Date(orderDate.getTime());
			java.sql.Date sqlDeliveryDate=new java.sql.Date(deliveryDate.getTime());
			
			ps.setString(1, deliveryNoteNumber);
			ps.setString(2, customerName);
			ps.setString(3, status);
			ps.setString(4, invoiceNumber);
			ps.setDate(5, (java.sql.Date) sqlOrderDate);
			ps.setDate(6, (java.sql.Date) sqlDeliveryDate);
			
			ps.executeUpdate();
			conn.close();
			
			DeliveryNote temp = new DeliveryNote(deliveryNoteNumber, customerName, status, invoiceNumber, orderDate, deliveryDate); 
			this.deliveryNoteList.add(temp);
			
		} catch(Exception e) {
			 System.out.println(e);	}
	}
	
	/* Get All DeliveryNote */
	public void getAllDeliveryNote() {
//		List<DeliveryNote> deliveryNotes = new ArrayList<DeliveryNote>();
		try {
			Connection conn = new DbConnection().getConn();
			    
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from deliverynote");
			
			while(rs.next()){
				DeliveryNote temp = new DeliveryNote(rs.getString("deliveryNoteNumber"), rs.getString("customerName"), rs.getString("status"), rs.getString("invoiceNumber"),
						rs.getDate("orderDate"), rs.getDate("deliveryDate") ); 
				this.deliveryNoteList.add(temp);
			}
			conn.close();
			
		} catch(Exception e) {
			 System.out.println(e);	}
		
//		this.deliveryNoteList = new DeliveryNote[deliveryNotes.size()]; 
//		this.deliveryNoteList = deliveryNotes.toArray(this.deliveryNoteList);
	}
	
	
}
