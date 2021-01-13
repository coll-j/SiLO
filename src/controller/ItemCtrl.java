package controller;

import java.util.ArrayList;
import java.util.List;

import database.DbHandler;
import database.DeliveryNote;
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
	
	public Item[] getAllItem() {
		Item[] itemArr = new Item[ItemCtrl.itemList.size()]; 
		itemArr = ItemCtrl.itemList.toArray(itemArr);
		
		return itemArr;
	}
	
	// misal title ntar edit
	public void editItem(String id, String edited){
		for(int i=0; i<ItemCtrl.itemList.size(); i++) {
			if(ItemCtrl.itemList.get(i).getId().contains(id)) {
				ItemCtrl.itemList.get(i).setTitle(edited);
				db.EditItem(ItemCtrl.itemList.get(i));
				return;
			}
		}
	}
	
	public Item[] searchItem(String keyword) {
		keyword = keyword.toLowerCase();
		List<Item> matchedItem = new ArrayList<Item>();
		
        for(int i=0; i<ItemCtrl.itemList.size(); i++){
            Item temp = ItemCtrl.itemList.get(i);
            if(temp.getId().toLowerCase().contains(keyword) ||
                    temp.getTitle().toLowerCase().contains(keyword) ||
                    temp.getManufacturer().toLowerCase().contains(keyword))
                matchedItem.add(temp);
        }
        
        Item[] matchedItemList = new Item[matchedItem.size()]; 
        matchedItemList = matchedItem.toArray(matchedItemList);
        return matchedItemList;
	}
	
}