package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import database.DbHandler;
import entity.DeliveryNote;
import entity.Invoice;
import entity.Item;

public class InvoiceCtrl {
	private DbHandler db;
	private Invoice invoice;
	
	public InvoiceCtrl(DbHandler db) {
		this.db = db;
	}
	
	public String[] getInvoice(String id) {
		invoice = db.getInvoice(id);
		
		return new String [] { invoice.getInvoiceNumber(),
								invoice.getPoNumber(),
								invoice.getSupplierName(),
								invoice.getOrderDateStr(),
								invoice.getDeliveryDateStr(),
								invoice.getStatus()
            };
	}
	
	public void addInvoice(String invoiceNumber, Date orderDate) {
		invoice = new Invoice(invoiceNumber, null, null, "completed", orderDate, null);
		db.addInvoice(invoice);
	}
	
	public Vector<Vector<Object>> getInvoices() {
		return db.getInvoices();
	}
		
	public Vector<Vector<Object>> searchInvoices(String keyword) {
		return db.searchInvoices(keyword);
	}
	
	public void pendingInvoice() {
		invoice.setStatus("pending");
		db.editInvoice(invoice);
	}
	
	public void completeInvoice() {
		invoice.setStatus("completed");
		invoice.setDeliveryDate(new Date());
		db.editInvoice( invoice);
	}
}