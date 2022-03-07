package ooppractice.domain.category.domain;

import ooppractice.domain.item.domain.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryTest {

    private String categoryName = "categoryName";
    private Category category = Category.builder().categoryName(categoryName).build();


    @Test
    void addItem() {
        //given
        Item item = Item.builder().build();
        //when
        category.addItem(item);
        //then
        assertThat(category.getItemList().get(0)).isEqualTo(item);
    }
}