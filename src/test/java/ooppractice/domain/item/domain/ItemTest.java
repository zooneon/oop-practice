package ooppractice.domain.item.domain;

import ooppractice.domain.category.domain.Category;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void reduceStockQuantity() {
        //given
        String itemName = "itemName";
        int stockQuantity = 10;
        int reduction = 10;
        Item item = Item.builder().itemName(itemName).stockQuantity(stockQuantity).build();
        //when
        item.reduceStockQuantity(reduction);
        //then
        assertThat(item.getStockQuantity()).isEqualTo(stockQuantity - reduction);
        assertThat(item.getSalesStatus()).isEqualTo(SalesStatus.SOLD_OUT);
    }

    @Test
    void addCategory() {
        //given
        Item item = Item.builder().build();
        Category category = Category.builder().build();
        //when
        item.addCategory(category);
        //then
        assertThat(item.getCategoryList().get(0)).isEqualTo(category);
    }
}