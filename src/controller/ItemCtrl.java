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
		db.addItem(new Item(id, barcode, title, description, manufacturer, url, Integer.parseInt(stocks)));
	}
	
	public Vector<Vector<Object>> getItems() {
		return db.getItems();
	}
	
	public Vector<Vector<Object>> searchItems(String keyword) {
		return db.searchItems(keyword);
	}
	
	public String[] getItem(String id) {
		Item data = db.getItem(id);
		
		return new String [] { data.getId(),
							   data.getBarcode(),
							   data.getTitle(),
							   data.getDescription(),
							   data.getManufacturer(),
							   data.getUrl(),
							   data.getStocksStr()
            };
	}
	
	public void editItem(String id, String barcode, String title, String description, String manufacturer, String url, String stocks){
		db.EditItem( new Item( id, barcode, title, description, manufacturer, url, Integer.parseInt(stocks) ) );
	}
	
}