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
	
	public void addDeliveryNote(String deliveryNoteNumber, String customerName, String requestedItem, String invoiceNumber, Date orderDate) {
		
		db.addDeliveryNote(new DeliveryNote(deliveryNoteNumber, customerName, requestedItem,"new", invoiceNumber,
				orderDate, null, null));
	}
	
	public Vector<Vector<Object>> getDelivNotes() {
		return db.getDelivNotes();
	}
		
	public Vector<Vector<Object>> searchDelivNotes(String keyword) {
		return db.searchDelivNotes(keyword);
	}
	
	public String[] getDelivNote(String id) {
		DeliveryNote data = db.getDelivNote(id);
		
		return new String [] { data.getDeliveryNoteNumber(),
							   data.getCustomerName(),
							   data.getInvoiceNumber(),
							   data.getOrderDateStr(),
							   data.getDeliveryDateStr(),
							   data.getStatus(),
							   data.getRequestedItem(),
							   data.getSign()
            };
	}
	
	
	

	public void editStatusDN(String DeliveryNoteNumber, String status) {
		db.editStatusDN( DeliveryNoteNumber, status);
	}
	
	public void completeDN(String DeliveryNoteNumber, String sign){
		db.completeDN( DeliveryNoteNumber, "completed", sign);
	}
}