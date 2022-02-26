package ooppractice.domain.item.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void reduceStockQuantity() {
        //given
        String itemName = "itemName";
        int stockQuantity = 10;
        int reduction = 5;
        Item item = Item.builder().itemName(itemName).stockQuantity(stockQuantity).build();
        //when
        item.reduceStockQuantity(reduction);
        //then
        assertThat(item.getStockQuantity()).isEqualTo(stockQuantity - reduction);
    }
}