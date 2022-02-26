package ooppractice.domain.item.service;

import ooppractice.domain.category.service.CategoryService;
import ooppractice.domain.item.domain.Item;
import ooppractice.domain.item.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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
        given(itemRepository.findByItemName(itemName)).willReturn(Optional.of(item));
        //when
        Item foundItem = itemService.getItemByItemName(itemName);
        //then
        assertThat(foundItem).isEqualTo(item);
    }

    //TODO: 카테고리 도메인 작성 후 테스트 추가
    @Test
    void getItemListByCategory() {
        //given

        //when

        //then

    }
}
