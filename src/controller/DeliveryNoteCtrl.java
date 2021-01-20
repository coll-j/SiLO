package controller;

import java.util.Date;
import java.util.Vector;

import database.DbHandler;
import entity.DeliveryNote;

public class DeliveryNoteCtrl {
	private DbHandler db;
	private DeliveryNote dn;
	
	public DeliveryNoteCtrl(DbHandler db) {
		this.db = db;
	}
	
	public String[] getDelivNote(String id) {
		dn = db.getDelivNote(id);
		
		return new String [] { dn.getDeliveryNoteNumber(),
							   dn.getCustomerName(),
							   dn.getInvoiceNumber(),
							   dn.getOrderDateStr(),
							   dn.getDeliveryDateStr(),
							   dn.getStatus(),
							   dn.getRequestedItem(),
							   dn.getSign()
            };
	}
	
	public void addDeliveryNote(String deliveryNoteNumber, String customerName, String requestedItem, String invoiceNumber, Date orderDate) {
		dn = new DeliveryNote(deliveryNoteNumber, customerName, requestedItem,"new", invoiceNumber,
				orderDate, null, null);
		db.addDeliveryNote(dn);
	}
	
	public Vector<Vector<Object>> getDelivNotes() {
		return db.getDelivNotes();
	}
		
	public Vector<Vector<Object>> searchDelivNotes(String keyword) {
		return db.searchDelivNotes(keyword);
	}

	public void pendingDN() {
		dn.setStatus("pending");
		db.editDelivNote( dn);
	}
	
	public void preparingDN() {
		dn.setStatus("preparing");
		db.editDelivNote( dn);
	}
	
	public void completeDN(String sign){
		dn.setStatus("completed");
		dn.setSign(sign);
		dn.setDeliveryDate(new Date());
		db.editDelivNote(dn);
	}
}