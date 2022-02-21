package ooppractice.domain.item.service;

import ooppractice.domain.item.dto.ItemListResponse;
import ooppractice.domain.item.dto.ItemResponse;

public interface ItemService {

    ItemResponse getItemByName(String itemName);

    ItemListResponse getItemListByCategory(String categoryName);
}
