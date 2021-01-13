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

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceNumber=" + invoiceNumber + ", poNumber=" + poNumber + ", supplierName=" + supplierName
				+ ", status=" + status + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + "]";
	}
	
	public Object[] toObject() {
		int i = 0;
		Object[] obj = new Object[7];
		
		obj[i++] = this.invoiceNumber;
		obj[i++] = this.poNumber;
		obj[i++] = this.supplierName;
		obj[i++] = this.status;
		obj[i++] = this.orderDate;
		obj[i++] = this.deliveryDate;	
		
		return obj;
	}
	
}
