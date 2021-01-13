package database;

public class Item {
	private String id,
					barcode,
					title,
					description,
					manufacturer,
					url;
    private int stocks;
    
	public Item(String id, String barcode, String title, String description, String manufacturer, String url, int stocks) {
		this.id = id;
		this.barcode = barcode;
		this.title = title;
		this.description = description;
		this.manufacturer = manufacturer;
		this.url = url;
		this.stocks = stocks;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getStocks() {
		return stocks;
	}
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", barcode=" + barcode + ", title=" + title + ", description=" + description
				+ ", manufacturer=" + manufacturer + ", url=" + url + ", stocks=" + stocks + "]";
	}
	
	
	
    
}
