package ooppractice.domain.item.service;

import ooppractice.domain.category.domain.Category;
import ooppractice.domain.category.service.CategoryService;
import ooppractice.domain.item.domain.Item;
import ooppractice.domain.item.exception.ItemNotFoundException;
import ooppractice.domain.item.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;
    @Mock
    private CategoryService categoryService;
    @InjectMocks
    private ItemServiceImpl itemService;

    private Item item = Item.builder().itemName("itemName").build();

    @Test
    void getItemByItemName() {
        //given
        String itemName = "itemName";
        String wrongName = "wrongName";
        given(itemRepository.findByItemName(itemName)).willReturn(Optional.of(item));
        //when
        Item foundItem = itemService.getItemByItemName(itemName);
        //then
        assertThat(foundItem).isEqualTo(item);
        assertThrows(ItemNotFoundException.class, () -> itemService.getItemByItemName(wrongName));
    }

    @Test
    void getItemListByCategory() {
        //given
        String categoryName = "categoryName";
        Category category = Category.builder().categoryName(categoryName).build();
        category.addItem(item);
        given(categoryService.getCategoryByName(categoryName)).willReturn(category);
        //when
        List<Item> itemList = itemService.getItemListByCategory(categoryName);
        //then
        assertThat(itemList.get(0)).isEqualTo(item);
    }
}
