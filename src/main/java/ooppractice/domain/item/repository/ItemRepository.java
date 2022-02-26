package ooppractice.domain.item.repository;

import ooppractice.domain.item.domain.Item;
import ooppractice.global.common.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class ItemRepository extends CrudRepository<Item, Long> {

    public Optional<Item> findByItemName(String itemName) {
        List<Item> itemList = findAll();
        Optional<Item> itemOptional = itemList.stream().filter(item -> item.getItemName().equals(itemName)).findFirst();
        return itemOptional;
    }
}
