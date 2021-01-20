package entity;

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

	public String getBarcode() {
		return barcode;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getUrl() {
		return url;
	}

	public int getStocks() {
		return stocks;
	}
	
	public String getStocksStr() {
		return "" + stocks;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
    
}
