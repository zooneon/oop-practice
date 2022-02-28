package ooppractice.domain.item.service;

import ooppractice.domain.item.domain.Item;

import java.util.List;

public interface ItemService {

    Item getItemByItemName(String itemName);

    List<Item> getItemListByCategory(String categoryName);
}
