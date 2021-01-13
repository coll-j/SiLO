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
	
	public void addDeliveryNote(String DeliveryNoteNumber, String poNumber, String supplierName, String status, Date orderDate, Date deliveryDate) {
		DeliveryNote temp = new DeliveryNote(DeliveryNoteNumber, poNumber, supplierName, status, orderDate, deliveryDate); 
		db.addDeliveryNote(temp);
		DeliveryNoteCtrl.deliveryNoteList.add(temp);
	}
	
	public DeliveryNote[] getAllDeliveryNote() {
		DeliveryNote[] deliveryNoteArr = new DeliveryNote[DeliveryNoteCtrl.deliveryNoteList.size()]; 
		deliveryNoteArr = DeliveryNoteCtrl.deliveryNoteList.toArray(deliveryNoteArr);
		
		return deliveryNoteArr;
	}
	
	// misal status ntar edit
	public void editDeliveryNote(String DeliveryNoteNumber, String edited){
		for(int i=0; i<DeliveryNoteCtrl.deliveryNoteList.size(); i++) {
			if(DeliveryNoteCtrl.deliveryNoteList.get(i).getDeliveryNoteNumber().contains(DeliveryNoteNumber)) {
				DeliveryNoteCtrl.deliveryNoteList.get(i).setStatus(edited);
				db.EditDeliveryNote(DeliveryNoteCtrl.deliveryNoteList.get(i));
				return;
			}
		}
	}
	
	public DeliveryNote[] searchDeliveryNote(String keyword) {
		keyword = keyword.toLowerCase();
		List<DeliveryNote> matchedDeliveryNote = new ArrayList<DeliveryNote>();
		
        for(int i=0; i<DeliveryNoteCtrl.deliveryNoteList.size(); i++){
        	DeliveryNote temp = DeliveryNoteCtrl.deliveryNoteList.get(i);
            if(temp.getDeliveryNoteNumber().toLowerCase().contains(keyword) ||
                    temp.getCustomerName().toLowerCase().contains(keyword) ||
                    temp.getStatus().toLowerCase().contains(keyword) ||
                    temp.getInvoiceNumber().toLowerCase().contains(keyword) )
                matchedDeliveryNote.add(temp);
        }
        
        DeliveryNote[] matchedDeliveryNoteList = new DeliveryNote[matchedDeliveryNote.size()]; 
        matchedDeliveryNoteList = matchedDeliveryNote.toArray(matchedDeliveryNoteList);
        return matchedDeliveryNoteList;
	}
	
}