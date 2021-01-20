package entity;

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
		if (orderDate == null)
			return "";
		else
			return "" + orderDate;
	}

	public String getDeliveryDateStr() {
		if (deliveryDate == null)
			return "";
		else
			return "" + deliveryDate;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
}
