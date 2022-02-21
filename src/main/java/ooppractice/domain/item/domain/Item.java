package ooppractice.domain.item.domain;

import lombok.Getter;
import ooppractice.domain.category.domain.Category;
import ooppractice.global.common.repository.Entity;

import java.util.List;

@Getter
public class Item extends Entity {

    private Long id;
    private String itemName;
    private SalesStatus salesStatus;
    private int stockQuantity;
    private List<Category> categoryList;

}
