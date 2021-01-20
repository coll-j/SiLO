package database;

import java.sql.*;
import java.util.Vector;

import entity.DeliveryNote;
import entity.Invoice;
import entity.Item;

public class DbHandler {
	
	private static String itemCol,
						  invoiceCol,
						  delivNoteCol;	
	
	public DbHandler( String item, String invoice, String delivNote) {
		itemCol = item;
		invoiceCol = invoice;
		delivNoteCol = delivNote;
	}
	
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
			ResultSet rs=stmt.executeQuery("select " + itemCol + " from item");
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
			
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery( "select " + itemCol + " from item where "
											+ "id LIKE '%" + keyword + "%' or "
											+ "title LIKE '%" + keyword + "%' or "
											+ "manufacturer LIKE '%" + keyword + "%'"
											);
			
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
			ResultSet rs=stmt.executeQuery("select " + invoiceCol + " from invoice");
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                vector.add("  View   ");
                data.add(vector);
            }
			
			conn.close();
			return data;
			
		} catch(Exception e) {
			 System.out.println(e);	}
		
		return null;
	}
	
	public Vector<Vector<Object>> searchInvoices(String keyword) {
		try {
			Connection conn = new DbConnection().getConn();
			
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select " + invoiceCol + " from invoice where "
											+ "invoiceNumber LIKE '%" + keyword + "%' or "
											+ "poNumber LIKE '%" + keyword + "%' or "
											+ "supplierName LIKE '%" + keyword + "%' or "
											+ "status LIKE '%" + keyword + "%' "
											);
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                vector.add("  View   ");
                data.add(vector);
            }
			
			conn.close();
			return data;
			
		} catch(Exception e) {
			 System.out.println(e);	}
			    
	    return null;
	}
	
	public Invoice getInvoice(String keyword) {
		try {
			Connection conn = new DbConnection().getConn();
			
			String sql = "select * from invoice where invoiceNumber = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ResultSet rs = ps.executeQuery();
			rs.next();
            
            Invoice invoice = new Invoice( rs.getString("invoiceNumber"),
            					  rs.getString("poNumber"),
            					  rs.getString("supplierName"),
            					  rs.getString("status"),
            					  rs.getDate("orderDate"),
            					  rs.getDate("deliveryDate")
            					  );
			
			conn.close();
			return invoice;
			
		} catch(Exception e) {
			 System.out.println(e);	}
			    
	    return null;
	}
	
	public void editInvoice(Invoice invoice) {
		try {
			Connection conn = new DbConnection().getConn();
			
			String sql = "UPDATE invoice SET poNumber = ?, supplierName = ?, status = ?, orderDate = ?, deliveryDate = ? WHERE InvoiceNumber = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			Date sqlOrderDate = null,
					sqlDeliveryDate = null;
			
			if(invoice.getOrderDate() != null)
				sqlOrderDate = new Date(invoice.getOrderDate().getTime());
			if(invoice.getDeliveryDate() != null)
				sqlDeliveryDate = new Date(invoice.getDeliveryDate().getTime());				
			
			ps.setString(1, invoice.getPoNumber());
			ps.setString(2, invoice.getSupplierName());
			ps.setString(3, invoice.getStatus());
			ps.setDate(4, sqlOrderDate);
			ps.setDate(5, sqlDeliveryDate);
			ps.setString(6, invoice.getInvoiceNumber());
			
			ps.executeUpdate();
			conn.close();
			
		}	catch(Exception e) {
			 System.out.println(e);	}
		
	}
		
	
	
	public void addDeliveryNote(DeliveryNote deliveryNote) {
		try {
			Connection conn = new DbConnection().getConn();
			  
			String sql = "INSERT INTO deliverynote(`deliveryNoteNumber`, `customerName`, `requestedItem`,`status`, `invoiceNumber`, `orderDate`)"
						+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			java.sql.Date sqlOrderDate=new java.sql.Date(deliveryNote.getOrderDate().getTime());
			
			ps.setString(1, deliveryNote.getDeliveryNoteNumber());
			ps.setString(2, deliveryNote.getCustomerName());
			ps.setString(3, deliveryNote.getRequestedItem());
			ps.setString(4, deliveryNote.getStatus());
			ps.setString(5, deliveryNote.getInvoiceNumber());
			ps.setDate(6, (java.sql.Date) sqlOrderDate);
			
			ps.executeUpdate();
			conn.close();
			
		} catch(Exception e) {
			 System.out.println(e);	}
	}
	
	public Vector<Vector<Object>> getDelivNotes() {
		try {
			Connection conn = new DbConnection().getConn();
			    
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select " + delivNoteCol + " from deliverynote");
			
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
	
	public Vector<Vector<Object>> searchDelivNotes(String keyword) {
		try {
			Connection conn = new DbConnection().getConn();
			    
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery( "select " + delivNoteCol + " from deliverynote where "
											+ "invoiceNumber LIKE '%" + keyword + "%' or "
											+ "deliveryNoteNumber LIKE '%" + keyword + "%' or "
											+ "customerName LIKE '%" + keyword + "%' or "
											+ "status LIKE '%" + keyword + "%' "
											);
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
	
	public DeliveryNote getDelivNote(String keyword) {
		try {
			Connection conn = new DbConnection().getConn();
			
			String sql = "select * from deliveryNote where deliveryNoteNumber = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
            DeliveryNote deliveryNote = new DeliveryNote( rs.getString("deliveryNoteNumber"),
						            					  rs.getString("customerName"),
						            					  rs.getString("requestedItem"),
						            					  rs.getString("status"),
						            					  rs.getString("invoiceNumber"),
						            					  rs.getDate("orderDate"),
						            					  rs.getDate("deliveryDate"),
						            					  rs.getString("sign")
						            					  );
			
			conn.close();
			return deliveryNote;
			
		} catch(Exception e) {
			 System.out.println(e);	}
			    
	    return null;
	}
	
	
	public void editDelivNote(DeliveryNote dn) {
		try {
			Connection conn = new DbConnection().getConn();
			
			String sql = "UPDATE DeliveryNote SET customerName = ?, requestedItem = ?, status = ?, "
					+ "invoiceNumber = ?, orderDate = ?, deliveryDate = ?, sign = ? WHERE deliveryNoteNumber = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			Date sqlOrderDate = null,
					sqlDeliveryDate = null;
			
			if(dn.getDeliveryDate() != null) 				
				sqlDeliveryDate = new Date(dn.getDeliveryDate().getTime());
			if(dn.getOrderDate() != null)
				sqlOrderDate = new Date(dn.getOrderDate().getTime());
			
			ps.setString(1, dn.getCustomerName());
			ps.setString(2, dn.getRequestedItem());
			ps.setString(3, dn.getStatus());
			ps.setString(4, dn.getInvoiceNumber());
			ps.setDate(5, sqlOrderDate);
			ps.setDate(6, sqlDeliveryDate);
			ps.setString(7, dn.getSign());
			ps.setString(8, dn.getDeliveryNoteNumber());
						
			ps.executeUpdate();
			conn.close();
			
		}	catch(Exception e) {
			 System.out.println(e);	}
	}
}