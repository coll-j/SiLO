package database;

import java.sql.*;
import java.util.List;
import java.util.Vector;

import java.util.ArrayList;

public class DbHandler {
	
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
	
	public Vector<Vector<Object>> getItems() {
		try {
			Connection conn = new DbConnection().getConn();
			    
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select id, title, manufacturer, stocks from item");
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                vector.add("  Edit  ");
                data.add(vector);
            }
			
			conn.close();
			return data;
			
		} catch(Exception e) {
			 System.out.println(e);	}
			    
	    return null;
	}
	
	public Vector<Vector<Object>> searchItems(String keyword) {
		try {
			Connection conn = new DbConnection().getConn();
			    
			String sql = "select id, title, manufacturer, stocks from item where "
					+ "id LIKE concat('%',? , '%')"
					+ "title LIKE concat('%',? , '%')"
					+ "manufacturer LIKE concat('%',? , '%')" ;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int j = 0;
			ps.setString(++j, keyword);
			ps.setString(++j, keyword);
			ps.setString(++j, keyword);
			
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                vector.add("  Edit  ");
                data.add(vector);
            }
			
			conn.close();
			return data;
			
		} catch(Exception e) {
			 System.out.println(e);	}
			    
	    return null;
	}
	
	public Item getItem(String keyword) {
		try {
			Connection conn = new DbConnection().getConn();
			
			String sql = "select * from item where id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ResultSet rs = ps.executeQuery();
			rs.next();
            
            Item item = new Item( rs.getString("id"),
            					  rs.getString("barcode"),
            					  rs.getString("title"),
            					  rs.getString("description"),
            					  rs.getString("manufacturer"),
            					  rs.getString("url"),
            					  rs.getInt("stocks")
            					  );
			
			conn.close();
			return item;
			
		} catch(Exception e) {
			 System.out.println(e);	}
			    
	    return null;
	}
	
	public void EditItem(Item item) {
		try {
			Connection conn = new DbConnection().getConn();
			
			String sql = "UPDATE ITEM SET barcode = ?, title = ?, description = ?, manufacturer = ?, url = ?, stocks = ?  WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, item.getBarcode());
			ps.setString(2, item.getTitle());
			ps.setString(3, item.getDescription());
			ps.setString(4, item.getManufacturer());
			ps.setString(5, item.getUrl());
			ps.setInt(6, item.getStocks());
			ps.setString(7, item.getId());
			
			ps.executeUpdate();
			conn.close();
			
		}	catch(Exception e) {
			 System.out.println(e);	}
		
	}
	
	
	
	public void addInvoice(Invoice invoice) {		
		try {
			Connection conn = new DbConnection().getConn();
			  
			String sql = "INSERT INTO invoice(`invoiceNumber`, `poNumber`, `supplierName`, `status`, `orderDate`)"
						+ "VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			java.sql.Date sqlOrderDate=new java.sql.Date(invoice.getOrderDate().getTime());
			
			ps.setString(1, invoice.getInvoiceNumber());
			ps.setString(2, invoice.getPoNumber());
			ps.setString(3, invoice.getSupplierName());
			ps.setString(4, invoice.getStatus());
			ps.setDate(5, (java.sql.Date) sqlOrderDate);
			
			ps.executeUpdate();
			conn.close();
						
		} catch(Exception e) {
			 System.out.println(e);	}
	}
	
	public Vector<Vector<Object>> getInvoices() {
		try {
			Connection conn = new DbConnection().getConn();
			    
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select invoiceNumber, poNumber, supplierName, status, orderDate, deliveryDate  from invoice");
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                vector.add("  View  ");
                data.add(vector);
            }
			
			conn.close();
			return data;
			
		} catch(Exception e) {
			 System.out.println(e);	}
		
		return null;
	}
	
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
	
	
	
	public void addDeliveryNote(DeliveryNote deliveryNote) {
		try {
			Connection conn = new DbConnection().getConn();
			  
			String sql = "INSERT INTO deliverynote(`deliveryNoteNumber`, `customerName`, `customerEmail`, `requestedItem`,`status`, `invoiceNumber`, `orderDate`)"
						+ "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			java.sql.Date sqlOrderDate=new java.sql.Date(deliveryNote.getOrderDate().getTime());
			
			ps.setString(1, deliveryNote.getDeliveryNoteNumber());
			ps.setString(2, deliveryNote.getCustomerName());
			ps.setString(3, deliveryNote.getCustomerEmail());
			ps.setString(4, deliveryNote.getRequestedItem());
			ps.setString(5, deliveryNote.getStatus());
			ps.setString(6, deliveryNote.getInvoiceNumber());
			ps.setDate(7, (java.sql.Date) sqlOrderDate);
			
			ps.executeUpdate();
			conn.close();
			
		} catch(Exception e) {
			 System.out.println(e);	}
	}
	
	public Vector<Vector<Object>> getDelivNotes() {
		try {
			Connection conn = new DbConnection().getConn();
			    
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select invoiceNumber, deliveryNoteNumber, customerName, status, orderDate, deliveryDate from deliverynote");
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                vector.add("  View  ");
                data.add(vector);
            }
			
			conn.close();
			return data;
			
		} catch(Exception e) {
			 System.out.println(e);	}
		
		return null;
	}
	
	public void EditDeliveryNote(DeliveryNote deliveryNote) {
		try {
			Connection conn = new DbConnection().getConn();
			
			String sql = "UPDATE DeliveryNote SET Status = ?, DeliveryDate = ?, Sign = ?   WHERE deliveryNoteNumber = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			java.sql.Date sqlDeliveryDate=new java.sql.Date(deliveryNote.getDeliveryDate().getTime());
			
			ps.setString(1, deliveryNote.getStatus());
			ps.setDate(2, (java.sql.Date) sqlDeliveryDate);
			ps.setString(3, deliveryNote.getSign());
			ps.setString(4, deliveryNote.getDeliveryNoteNumber());
						
			ps.executeUpdate();
			conn.close();
			
		}	catch(Exception e) {
			 System.out.println(e);	}
		
	}
	
	
}
