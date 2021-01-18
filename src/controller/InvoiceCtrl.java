package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import database.DbHandler;
import database.DeliveryNote;
import database.Invoice;

public class InvoiceCtrl {
	private DbHandler db;
	private static Invoice invoice;
	
	public InvoiceCtrl(DbHandler db) {
		this.db = db;
	}
	
	public void addInvoice(String invoiceNumber, Date orderDate) {
		invoice = new Invoice(invoiceNumber, null, null, "new", orderDate, null); 
		db.addInvoice(temp);
		InvoiceCtrl.invoiceList.add(temp);
	}
	
	public Vector<Vector<Object>> getInvoices() {
		return db.getInvoices();
	}
	
	public String[] getInvoice(String invoiceNumber) {
		String[] array = new String[invoiceList.size()];
        for (int i = 0; i < invoiceList.size(); i++) {
        	if(InvoiceCtrl.invoiceList.get(i).getInvoiceNumber().contains(invoiceNumber)) {
        		array = InvoiceCtrl.invoiceList.get(i).toArray();
        		return array;
        	}
        	
        }
		return array;
	}
	
	public void editStatusInvoice(String invoiceNumber, String status){
		for(int i=0; i<InvoiceCtrl.invoiceList.size(); i++) {
			if(InvoiceCtrl.invoiceList.get(i).getInvoiceNumber().contains(invoiceNumber)) {
				InvoiceCtrl.invoiceList.get(i).setStatus(status);
				db.EditInvoice(InvoiceCtrl.invoiceList.get(i));
				return;
			}
		}
	}
	
	public void completeInvoice(String invoiceNumber, String status){
		for(int i=0; i<InvoiceCtrl.invoiceList.size(); i++) {
			if(InvoiceCtrl.invoiceList.get(i).getInvoiceNumber().contains(invoiceNumber)) {
				
				InvoiceCtrl.invoiceList.get(i).setStatus("completed");
				InvoiceCtrl.invoiceList.get(i).setDeliveryDate(new Date());
				
				db.EditInvoice(InvoiceCtrl.invoiceList.get(i));
				return;
			}
		}
	}
		
	public Object[][] searchInvoice(String keyword) {
		keyword = keyword.toLowerCase();
		Object[][] array = new Object[invoiceList.size()][];
		int j = 0;
		
		for(int i=0; i<InvoiceCtrl.invoiceList.size(); i++){
			Invoice temp = InvoiceCtrl.invoiceList.get(i);
			if(temp.getInvoiceNumber().toLowerCase().contains(keyword) ||
                    temp.getStatus().toLowerCase().contains(keyword) )
            	array[j++] = temp.toObject();
			else if(temp.getPoNumber() != null) {
				if( temp.getPoNumber().toLowerCase().contains(keyword) ||
                    temp.getSupplierName().toLowerCase().contains(keyword))
					array[j++] = temp.toObject();
			}
        }
        return array;
	}
	
}