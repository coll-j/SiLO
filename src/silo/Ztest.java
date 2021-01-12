package silo;

import data.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ztest {
	public static void main(String[] args) throws Exception {
		 
		DbHandler db = new DbHandler();
		
//		db.addItem("IT3", "tiga", "tiga", "tiga", 3);
		
//		Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2009");
//		Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2009");
//		db.addInvoice("IN3", "PN3", "supname3", "status3", date1, date2);
		
//		Date date3 =new SimpleDateFormat("dd/MM/yyyy").parse("07/01/2009");
//		Date date4 =new SimpleDateFormat("dd/MM/yyyy").parse("08/01/2009");
//		db.addDeliveryNote("DN2", "Cusname2", "status2", "IN2", date3, date4);
		
		for (Item i : db.itemList) {
			System.out.println(i.toString());
		}
		System.out.println();
		
		for (Invoice i : db.invoiceList) {
			System.out.println(i.toString());
		}
		System.out.println();
		
		for (DeliveryNote i : db.deliveryNoteList) {
			System.out.println(i.toString());
		}
		System.out.println();
		    
	 }
}
