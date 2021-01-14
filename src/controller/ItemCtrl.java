package controller;

import java.util.ArrayList;
import java.util.List;

import database.DbHandler;
import database.Item;

public class ItemCtrl {
	private DbHandler db;
	private static List<Item> itemList = new ArrayList<Item>();
	
	public ItemCtrl() {
		db = new DbHandler();
		itemList = db.getAllItem();
	}
	
	public void addItem(String id, String barcode, String title, String description, String manufacturer, String url, int stocks) {
		Item temp = new Item(id, barcode, title, description, manufacturer, url, stocks); 
		db.addItem(temp);
		ItemCtrl.itemList.add(temp);
	}
	
	public Object[][] getAllItem() {
		Object[][] array = new Object[itemList.size()][];
        for (int i = 0; i < itemList.size(); i++) {
        	array[i] = itemList.get(i).toObject();
        }
		return array;
	}
	
	public String[] getItem(String itemId) {
		String[] array = new String[itemList.size()];
        for (int i = 0; i < itemList.size(); i++) {
        	if(ItemCtrl.itemList.get(i).getId().contains(itemId)) {
        		array = itemList.get(i).toArray();
            	return array;
        	}
        	
        }
		return array;
	}
	
	public void editItem(String id, String barcode, String title, String description, String manufacturer, String url, String stocks){
		for(int i=0; i<ItemCtrl.itemList.size(); i++) {
			if(ItemCtrl.itemList.get(i).getId().contains(id)) {
				ItemCtrl.itemList.get(i).setBarcode(barcode);
				ItemCtrl.itemList.get(i).setTitle(title);
				ItemCtrl.itemList.get(i).setDescription(description);
				ItemCtrl.itemList.get(i).setManufacturer(manufacturer);
				ItemCtrl.itemList.get(i).setUrl(url);
				ItemCtrl.itemList.get(i).setStocks(Integer.parseInt(stocks));
				db.EditItem(ItemCtrl.itemList.get(i));
				return;
			}
		}
	}
	
	public Object[][] searchItem(String keyword) {
		keyword = keyword.toLowerCase();
		Object[][] array = new Object[itemList.size()][];
		int j = 0;
		
        for(int i=0; i<ItemCtrl.itemList.size(); i++){
            Item temp = ItemCtrl.itemList.get(i);
            if(temp.getId().toLowerCase().contains(keyword) ||
                    temp.getTitle().toLowerCase().contains(keyword) ||
                    temp.getManufacturer().toLowerCase().contains(keyword))
            	array[j++] = temp.toObject();
        }
        return array;
	}
	
}