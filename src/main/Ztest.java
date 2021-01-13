package main;


import java.text.SimpleDateFormat;
import java.util.Date;

import controller.*;
import database.*;

public class Ztest {
	public static void main(String[] args) throws Exception {
		 
		InvoiceCtrl invoiceCtrl = new InvoiceCtrl();
	
		/* add */
//		Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2009");
//		Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2009");
//		invoiceCtrl.addInvoice("IN4", "empat", "empat", "empat", date1, date2);
		
//		/* edit */
		invoiceCtrl.editInvoice("IN3", "Success");
			
		/* search */
		for (Invoice i :invoiceCtrl.searchInvoice("CC")) {
			System.out.println(i.toString());
		}
		
//		for (Invoice i :invoiceCtrl.getAllInvoice()) {
//			System.out.println(i.toString());
//		}
		
		    
	 }
}
