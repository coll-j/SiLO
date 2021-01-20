package entity;

import java.util.Date;

public class DeliveryNote {
	private String deliveryNoteNumber,
					customerName,
					requestedItem,
					status,
					invoiceNumber,
					sign;
    private Date orderDate,
    				deliveryDate;
	
	public DeliveryNote(String deliveryNoteNumber, String customerName, String requestedItem,
			String status, String invoiceNumber, Date orderDate, Date deliveryDate, String sign) {
		this.deliveryNoteNumber = deliveryNoteNumber;
		this.customerName = customerName;
		this.requestedItem = requestedItem;
		this.status = status;
		this.invoiceNumber = invoiceNumber;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.sign = sign;
	}

	public String getDeliveryNoteNumber() {
		return deliveryNoteNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getRequestedItem() {
		return requestedItem;
	}

	public String getStatus() {
		return status;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public String getSign() {
		return sign;
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

	public void setDeliveryNoteNumber(String deliveryNoteNumber) {
		this.deliveryNoteNumber = deliveryNoteNumber;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setRequestedItem(String requestedItem) {
		this.requestedItem = requestedItem;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}
