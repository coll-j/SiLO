package main;


import java.text.SimpleDateFormat;
import java.util.Date;

import controller.*;
import database.*;

public class Ztest {
	public static void main(String[] args) throws Exception {
		 
		ItemCtrl itemCtrl = new ItemCtrl();
		
//		add
//		itemCtrl.addItem("IT4", "empat", "empat", "empat", "empat", "empat", 4);
		
//		edit
//		itemCtrl.editItem("IT3", "3 edit");
			
//		search
//		for (Item i :itemCtrl.searchItem("edit")) {
//			System.out.println(i.toString());
//		}
		
		for (Item i :itemCtrl.getAllItem()) {
			System.out.println(i.toString());
		}
		System.out.println();
		
		
		InvoiceCtrl invoiceCtrl = new InvoiceCtrl();
		
		/* add */
//		Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2009");
//		Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2009");
//		invoiceCtrl.addInvoice("IN4", "empat", "empat", "empat", date1, date2);
		
//		/* edit */
//		invoiceCtrl.editInvoice("IN3", "Success");
			
		/* search */
//		for (Invoice i :invoiceCtrl.searchInvoice("CC")) {
//			System.out.println(i.toString());
//		}
		
		for (Invoice i :invoiceCtrl.getAllInvoice()) {
			System.out.println(i.toString());
		}
		System.out.println();
		
		
		DeliveryNoteCtrl deliveryNoteCtrl = new DeliveryNoteCtrl();
	
		/* add */
//		Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2009");
//		Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2009");
//		deliveryNoteCtrl.addDeliveryNote("DN3", "tiga", "tiga", "tiga", date1, date2);
		
//		/* edit */
//		deliveryNoteCtrl.editDeliveryNote("DN3", "berhasil");
			
		/* search */
//		for (DeliveryNote i :deliveryNoteCtrl.searchDeliveryNote("ha")) {
//			System.out.println(i.toString());
//		}
		
		for (DeliveryNote i :deliveryNoteCtrl.getAllDeliveryNote()) {
			System.out.println(i.toString());
		}
		
		    
	 }
}
