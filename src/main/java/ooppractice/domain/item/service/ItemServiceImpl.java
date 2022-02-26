package ooppractice.domain.item.service;

import lombok.RequiredArgsConstructor;
import ooppractice.domain.category.domain.Category;
import ooppractice.domain.category.exception.CategoryNotFoundException;
import ooppractice.domain.category.service.CategoryService;
import ooppractice.domain.item.domain.Item;
import ooppractice.domain.item.exception.ItemNotFoundException;
import ooppractice.domain.item.repository.ItemRepository;
import ooppractice.global.common.exception.ErrorCode;

import java.util.List;

@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryService categoryService;

    @Override
    public Item getItemByItemName(String itemName) {
        Item foundItem = itemRepository.findByItemName(itemName).orElseThrow(() -> new ItemNotFoundException(ErrorCode.ITEM_NOT_FOUND));
        return foundItem;
    }

    @Override
    public List<Item> getItemListByCategory(String categoryName) throws CategoryNotFoundException {
        Category foundCategory = categoryService.getCategoryByName(categoryName);
        return foundCategory.getItemList();
    }
}
