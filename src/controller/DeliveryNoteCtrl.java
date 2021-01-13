package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.DbHandler;
import database.DeliveryNote;

public class DeliveryNoteCtrl {
	private DbHandler db;
	private static List<DeliveryNote> deliveryNoteList = new ArrayList<DeliveryNote>();
	
	public DeliveryNoteCtrl() {
		db = new DbHandler();
		deliveryNoteList = db.getAllDeliveryNote();
	}
	
	public void addDeliveryNote(String deliveryNoteNumber, String customerName, String customerEmail, String requestedItem,
								String invoiceNumber, Date orderDate) {
		
		DeliveryNote temp = new DeliveryNote(deliveryNoteNumber, customerName, customerEmail, requestedItem,"new", invoiceNumber,
												orderDate, null, null);
		
		db.addDeliveryNote(temp);
		DeliveryNoteCtrl.deliveryNoteList.add(temp);
	}
	
	public Object[][] getAllDeliveryNote() {
		Object[][] array = new Object[deliveryNoteList.size()][];
        for (int i = 0; i < deliveryNoteList.size(); i++) {
        	array[i] = deliveryNoteList.get(i).toObject();
        }
		return array;
	}
	
	public Object[][] getDNShort() {
		Object[][] array = new Object[deliveryNoteList.size()][];
        for (int i = 0; i < deliveryNoteList.size(); i++) {
        	array[i] = deliveryNoteList.get(i).toObjectShort();
        }
		return array;
	}
	
	public void editStatusDN(String DeliveryNoteNumber, String status){
		for(int i=0; i<DeliveryNoteCtrl.deliveryNoteList.size(); i++) {
			if(DeliveryNoteCtrl.deliveryNoteList.get(i).getDeliveryNoteNumber().contains(DeliveryNoteNumber)) {
				DeliveryNoteCtrl.deliveryNoteList.get(i).setStatus(status);
				db.EditDeliveryNote(DeliveryNoteCtrl.deliveryNoteList.get(i));
				return;
			}
		}
	}
	
	// sign status
	public void completeDN(String DeliveryNoteNumber, String sign){
		for(int i=0; i<DeliveryNoteCtrl.deliveryNoteList.size(); i++) {
			if(DeliveryNoteCtrl.deliveryNoteList.get(i).getDeliveryNoteNumber().contains(DeliveryNoteNumber)) {
				
				DeliveryNoteCtrl.deliveryNoteList.get(i).setSign(sign);
				DeliveryNoteCtrl.deliveryNoteList.get(i).setStatus("completed");
				DeliveryNoteCtrl.deliveryNoteList.get(i).setDeliveryDate(new Date());
				
				db.EditDeliveryNote(DeliveryNoteCtrl.deliveryNoteList.get(i));
				return;
			}
		}
	}
	
	public Object[][] searchDeliveryNote(String keyword) {
		keyword = keyword.toLowerCase();
		Object[][] array = new Object[deliveryNoteList.size()][];
		int j = 0;
		
		for(int i=0; i<DeliveryNoteCtrl.deliveryNoteList.size(); i++){
        	DeliveryNote temp = DeliveryNoteCtrl.deliveryNoteList.get(i);
            if(temp.getDeliveryNoteNumber().toLowerCase().contains(keyword) ||
                    temp.getCustomerName().toLowerCase().contains(keyword) ||
                    temp.getCustomerEmail().toLowerCase().contains(keyword) ||
                    temp.getRequestedItem().toLowerCase().contains(keyword) ||
                    temp.getStatus().toLowerCase().contains(keyword) ||
                    temp.getInvoiceNumber().toLowerCase().contains(keyword) )
            	array[j++] = temp.toObject();
        }
        return array;
	}
	
}