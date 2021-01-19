package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import database.DbHandler;
import database.DeliveryNote;
import database.Invoice;
import database.Item;

public class InvoiceCtrl {
	private DbHandler db;
	
	public InvoiceCtrl(DbHandler db) {
		this.db = db;
	}
	
	public void addInvoice(String invoiceNumber, Date orderDate) {
		db.addInvoice(new Invoice(invoiceNumber, null, null, "completed", orderDate, null));
	}
	
	public Vector<Vector<Object>> getInvoices() {
		return db.getInvoices();
	}
		
	public Vector<Vector<Object>> searchInvoices(String keyword) {
		return db.searchInvoices(keyword);
	}
	
	public String[] getInvoice(String id) {
		Invoice data = db.getInvoice(id);
		
		return new String [] { data.getInvoiceNumber(),
								data.getPoNumber(),
								data.getSupplierName(),
								data.getOrderDateStr(),
								data.getDeliveryDateStr(),
								data.getStatus()
            };
	}
	
	public void editStatusInvoice(String invoiceNumber) {
		db.editStatusInvoice( invoiceNumber, "pending");
	}
	
	public void completeInvoice(String invoiceNumber) {
		db.completeInvoice( invoiceNumber, "completed");
	}
}