package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.DbHandler;
import database.Invoice;

public class InvoiceCtrl {
	private DbHandler db;
	private static List<Invoice> invoiceList = new ArrayList<Invoice>();
	
	public InvoiceCtrl() {
		db = new DbHandler();
		invoiceList = db.getAllInvoice();
	}
	
	public void addInvoice(String invoiceNumber, String poNumber, String supplierName, Date orderDate, Date deliveryDate) {
		Invoice temp = new Invoice(invoiceNumber, poNumber, supplierName, "new", orderDate, deliveryDate); 
		db.addInvoice(temp);
		InvoiceCtrl.invoiceList.add(temp);
	}
	
	public Invoice[] getAllInvoice() {
		Invoice[] invoiceArr = new Invoice[InvoiceCtrl.invoiceList.size()]; 
		invoiceArr = InvoiceCtrl.invoiceList.toArray(invoiceArr);
		
		return invoiceArr;
	}
	
	public void editStatusInvoice(String invoiceNumber, String edited){
		for(int i=0; i<InvoiceCtrl.invoiceList.size(); i++) {
			if(InvoiceCtrl.invoiceList.get(i).getInvoiceNumber().contains(invoiceNumber)) {
				InvoiceCtrl.invoiceList.get(i).setStatus(edited);
				db.EditInvoice(InvoiceCtrl.invoiceList.get(i));
				return;
			}
		}
	}
	
	public Invoice[] searchInvoice(String keyword) {
		keyword = keyword.toLowerCase();
		List<Invoice> matchedInvoice = new ArrayList<Invoice>();
		
        for(int i=0; i<InvoiceCtrl.invoiceList.size(); i++){
        	Invoice temp = InvoiceCtrl.invoiceList.get(i);
            if(temp.getInvoiceNumber().toLowerCase().contains(keyword) ||
                    temp.getPoNumber().toLowerCase().contains(keyword) ||
                    temp.getSupplierName().toLowerCase().contains(keyword) ||
                    temp.getStatus().toLowerCase().contains(keyword) )
                matchedInvoice.add(temp);
        }
        
        Invoice[] matchedInvoiceList = new Invoice[matchedInvoice.size()]; 
        matchedInvoiceList = matchedInvoice.toArray(matchedInvoiceList);
        return matchedInvoiceList;
	}
	
}