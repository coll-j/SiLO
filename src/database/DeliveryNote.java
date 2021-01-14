package database;

import java.util.Date;

public class DeliveryNote {
	private String deliveryNoteNumber,
					customerName,
					customerEmail,
					requestedItem,
					status,
					invoiceNumber,
					sign;
    private Date orderDate,
    				deliveryDate;
	
	public DeliveryNote(String deliveryNoteNumber, String customerName, String customerEmail, String requestedItem,
			String status, String invoiceNumber, Date orderDate, Date deliveryDate, String sign) {
		this.deliveryNoteNumber = deliveryNoteNumber;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.requestedItem = requestedItem;
		this.status = status;
		this.invoiceNumber = invoiceNumber;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.sign = sign;
	}

	public String getRequestedItem() {
		return requestedItem;
	}

	public void setRequestedItem(String requestedItem) {
		this.requestedItem = requestedItem;
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

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}


	@Override
	public String toString() {
		return "DeliveryNote [deliveryNoteNumber=" + deliveryNoteNumber + ", customerName=" + customerName
				+ ", customerEmail=" + customerEmail + ", requestedItem=" + requestedItem + ", status=" + status
				+ ", invoiceNumber=" + invoiceNumber + ", sign=" + sign + ", orderDate=" + orderDate + ", deliveryDate="
				+ deliveryDate + "]";
	}

	public Object[] toObject() {
		int i = 0;
		Object[] obj = new Object[10];
		
		obj[i++] = this.deliveryNoteNumber;
		obj[i++] = this.customerName;
		obj[i++] = this.customerEmail;
		obj[i++] = this.requestedItem;
		obj[i++] = this.status;
		obj[i++] = this.invoiceNumber;
		obj[i++] = this.sign;
		obj[i++] = this.orderDate;
		obj[i++] = this.deliveryDate;
		
		return obj;
	}
	
	public Object[] toObjectShort() {
		int i = 0;
		Object[] obj = new Object[7];
		
		obj[i++] = this.invoiceNumber;
		obj[i++] = this.deliveryNoteNumber;
		obj[i++] = this.customerName;
		obj[i++] = this.orderDate;
		obj[i++] = this.deliveryDate;
		obj[i++] = this.status;
		obj[i++] = "  View  ";
		
		return obj;
	}
}
