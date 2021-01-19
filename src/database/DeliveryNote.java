package database;

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
		return "" + orderDate;
	}

	public String getDeliveryDateStr() {
		return "" + deliveryDate;
	}

}
