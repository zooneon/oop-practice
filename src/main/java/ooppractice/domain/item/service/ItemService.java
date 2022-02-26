package ooppractice.domain.item.service;

import ooppractice.domain.item.domain.Item;
import ooppractice.domain.item.dto.ItemListResponse;
import ooppractice.domain.item.dto.ItemResponse;

import java.util.List;

public interface ItemService {

    Item getItemByItemName(String itemName);

    List<Item> getItemListByCategory(String categoryName);
}
