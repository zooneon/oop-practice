package ooppractice.domain.category.domain;

import lombok.Getter;
import ooppractice.domain.item.domain.Item;
import ooppractice.global.common.repository.Entity;

import java.util.List;

@Getter
public class Category extends Entity {

    private Long id;
    private String categoryName;
    private List<Item> itemList;
    
}
