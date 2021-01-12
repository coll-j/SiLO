package data;

import java.util.Date;

public class DeliveryNote {
	private String deliveryNoteNumber,
					customerName,
					status,
					invoiceNumber;
    private Date orderDate,
    				deliveryDate;
    
	public DeliveryNote(String deliveryNoteNumber, String customerName, String status, String invoiceNumber,
			Date orderDate, Date deliveryDate) {
		super();
		this.deliveryNoteNumber = deliveryNoteNumber;
		this.customerName = customerName;
		this.status = status;
		this.invoiceNumber = invoiceNumber;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryNoteNumber() {
		return deliveryNoteNumber;
	}

	public void setDeliveryNoteNumber(String deliveryNoteNumber) {
		this.deliveryNoteNumber = deliveryNoteNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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
		return "DeliveryNote [deliveryNoteNumber=" + deliveryNoteNumber + ", customerName=" + customerName + ", status="
				+ status + ", invoiceNumber=" + invoiceNumber + ", orderDate=" + orderDate + ", deliveryDate="
				+ deliveryDate + "]";
	}
	

}
