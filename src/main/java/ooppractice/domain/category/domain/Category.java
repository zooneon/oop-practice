package ooppractice.domain.category.domain;

import lombok.Getter;
import ooppractice.domain.item.domain.Item;

import java.util.List;

@Getter
public class Category {

    private Long id;
    private String categoryName;
    private List<Item> itemList;

}
