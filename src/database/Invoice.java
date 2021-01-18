package database;

import java.util.Date;

public class Invoice {
	private String invoiceNumber,
					poNumber,
					supplierName,
					status;
    private Date orderDate,
    				deliveryDate;

	public Invoice(String invoiceNumber, String poNumber, String supplierName, String status, Date orderDate,
			Date deliveryDate) {
		this.invoiceNumber = invoiceNumber;
		this.poNumber = poNumber;
		this.supplierName = supplierName;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public String getStatus() {
		return status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}
	
	
	public String getOrderDateStr() {
		return "" + orderDate;
	}

	public String getDeliveryDateStr() {
		return "" + deliveryDate;
	}
	
}
