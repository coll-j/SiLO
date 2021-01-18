package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import database.DbHandler;
import database.DeliveryNote;
import database.Item;

public class DeliveryNoteCtrl {
	private DbHandler db;
	
	public DeliveryNoteCtrl(DbHandler db) {
		this.db = db;
	}
	
	public void addDeliveryNote(String deliveryNoteNumber, String customerName, String customerEmail, String requestedItem, String invoiceNumber, Date orderDate) {
		
		db.addDeliveryNote(new DeliveryNote(deliveryNoteNumber, customerName, customerEmail, requestedItem,"new", invoiceNumber,
				orderDate, null, null));
	}
	
	public Vector<Vector<Object>> getDelivNotes() {
		return db.getDelivNotes();
	}
		
	public Vector<Vector<Object>> searchDelivNotes(String keyword) {
		return db.searchDelivNotes(keyword);
	}
	
	public String[] getdelivNote(String id) {
		DeliveryNote data = db.getDelivNote(id);
		
		return new String [] { data.getInvoiceNumber(),
							   data.getDeliveryNoteNumber(),
							   data.getCustomerName(),
							   data.getCustomerEmail(),
							   data.getRequestedItem(),
							   data.getStatus(),
							   data.getOrderDateStr(),
							   data.getDeliveryDateStr(),
							   data.getSign()
            };
	}
	
	
	

	public void editStatusDN(String DeliveryNoteNumber, String status) {
		db.editStatusDN( DeliveryNoteNumber, status);
	}
	
	public void completeDN(String DeliveryNoteNumber, String sign){
		db.completeDN( DeliveryNoteNumber, "completed",  (java.sql.Date) new Date(), sign);
	}
}