package controller;

import java.util.Date;

public class CreateDNCtrl {
	
	private DeliveryNoteCtrl dnCtrl;
	private InvoiceCtrl invoiceCtrl;
	
	public CreateDNCtrl() {
		dnCtrl = new DeliveryNoteCtrl();
		invoiceCtrl = new InvoiceCtrl();
	}
	
	public void CreateDN(String deliveryNoteNumber, String customerName, String customerEmail, String requestedItem,
						String invoiceNumber) {
		
		Date orderDate = new Date();
		dnCtrl.addDeliveryNote(deliveryNoteNumber, customerName, customerEmail, requestedItem, invoiceNumber, orderDate);
		invoiceCtrl.addInvoice(invoiceNumber, orderDate);
	}
	
	public Object[][] getDeliveryNote(){
		return dnCtrl.getAllDeliveryNote();
	}
	
	public Object[][] getInvoice(){
		return invoiceCtrl.getAllInvoice();
	}
}
