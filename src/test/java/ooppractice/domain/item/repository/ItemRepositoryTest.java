package ooppractice.domain.item.repository;

import ooppractice.domain.item.domain.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    private ItemRepository itemRepository = new ItemRepository();
    private Item item = Item.builder().itemName("itemName").build();

    @BeforeEach
    void setUp() {
        itemRepository.save(item);
    }

    @AfterEach
    void tearDown() {
        itemRepository.deleteAll();
    }

    @Test
    void setId() {
        //given
        //when
        //then
        assertThat(item.getId()).isEqualTo(1L);
    }

    @Test
    void findByItemName() {
        //given
        String itemName = "itemName";
        String wrongName = "wrongName";
        //when
        Optional<Item> validItem = itemRepository.findByItemName(itemName);
        Optional<Item> invalidItem = itemRepository.findByItemName(wrongName);
        //then
        assertThat(validItem.get()).isEqualTo(item);
        assertThat(invalidItem).isEmpty();
    }
}
