package controller;

import java.util.Vector;

import database.DbHandler;
import database.Item;

public class ItemCtrl {
	private DbHandler db;
	
	public ItemCtrl(DbHandler db) {
		this.db = db;
	}
	
	public void addItem(String id, String barcode, String title, String description, String manufacturer, String url, String stocks) {
		Item item = new Item(id, barcode, title, description, manufacturer, url, Integer.parseInt(stocks));
		db.addItem(item);
	}
	
	public Vector<Vector<Object>> getItems() {
		return db.getItems();
	}
	
	public Vector<Vector<Object>> searchItems(String keyword) {
		return db.searchItems(keyword);
	}
	
	public String[] getItem(String itemId) {
		Item item = db.getItem(itemId);
		
		return new String [] { item.getId(),
							   item.getBarcode(),
							   item.getTitle(),
							   item.getDescription(),
							   item.getManufacturer(),
							   item.getUrl(),
							   item.getStocksStr()
            };
	}
	
	public void editItem(String id, String barcode, String title, String description, String manufacturer, String url, String stocks){
		db.EditItem( new Item( id, barcode, title, description, manufacturer, url, Integer.parseInt(stocks) ) );
	}
	
}