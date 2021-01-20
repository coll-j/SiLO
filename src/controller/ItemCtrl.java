package controller;

import java.util.Vector;

import database.DbHandler;
import entity.Item;

public class ItemCtrl {
	private DbHandler db;
	private Item item;
	
	public ItemCtrl(DbHandler db) {
		this.db = db;
	}
	
	public String[] getItem(String id) {
		item = db.getItem(id);
		
		return new String [] { item.getId(),
							   item.getBarcode(),
							   item.getTitle(),
							   item.getDescription(),
							   item.getManufacturer(),
							   item.getUrl(),
							   item.getStocksStr()
            };
	}
	
	public void addItem(String id, String barcode, String title, String description, String manufacturer, String url, String stocks) {
		item = new Item(id, barcode, title, description, manufacturer, url, Integer.parseInt(stocks));
		db.addItem(item);
	}
	
	public Vector<Vector<Object>> getItems() {
		return db.getItems();
	}
	
	public Vector<Vector<Object>> searchItems(String keyword) {
		return db.searchItems(keyword);
	}
	
	public void editItem(String barcode, String title, String description, String manufacturer, String url, String stocks){
		item.setBarcode(barcode);
		item.setTitle(title);
		item.setDescription(description);
		item.setManufacturer(manufacturer);
		item.setUrl(url);
		item.setStocks(Integer.parseInt(stocks));
		db.EditItem( item );
	}
	
}