package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.DbHandler;
import database.DeliveryNote;
import database.Item;

public class DeliveryNoteCtrl {
	private DbHandler db;
	private static List<DeliveryNote> deliveryNoteList = new ArrayList<DeliveryNote>();
	
	public DeliveryNoteCtrl() {
		db = new DbHandler();
		deliveryNoteList = db.getAllDeliveryNote();
	}
	
	public void addDeliveryNote(String DeliveryNoteNumber, String poNumber, String supplierName, Date orderDate, Date deliveryDate) {
		DeliveryNote temp = new DeliveryNote(DeliveryNoteNumber, poNumber, supplierName, "new", orderDate, deliveryDate); 
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
	
	// edit status
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
		public void signStatusDN(String DeliveryNoteNumber, String sign){
			for(int i=0; i<DeliveryNoteCtrl.deliveryNoteList.size(); i++) {
				if(DeliveryNoteCtrl.deliveryNoteList.get(i).getDeliveryNoteNumber().contains(DeliveryNoteNumber)) {
					DeliveryNoteCtrl.deliveryNoteList.get(i).setSign(sign);
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
                    temp.getStatus().toLowerCase().contains(keyword) ||
                    temp.getInvoiceNumber().toLowerCase().contains(keyword) )
            	array[j++] = temp.toObject();
        }
        return array;
	}
	
}