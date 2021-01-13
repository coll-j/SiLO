package main;


import java.text.SimpleDateFormat;
import java.util.Date;

import controller.*;
import database.*;

public class Ztest {
	public static void main(String[] args) throws Exception {
		 
		DeliveryNoteCtrl invoiceCtrl = new DeliveryNoteCtrl();
	
		/* add */
//		Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2009");
//		Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2009");
//		invoiceCtrl.addDeliveryNote("DN3", "tiga", "tiga", "tiga", date1, date2);
		
//		/* edit */
//		invoiceCtrl.editDeliveryNote("DN3", "berhasil");
			
		/* search */
		for (DeliveryNote i :invoiceCtrl.searchDeliveryNote("ha")) {
			System.out.println(i.toString());
		}
		
//		for (DeliveryNote i :invoiceCtrl.getAllDeliveryNote()) {
//			System.out.println(i.toString());
//		}
		
		    
	 }
}
