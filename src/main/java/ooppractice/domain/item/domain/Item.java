package ooppractice.domain.item.domain;

import lombok.Getter;
import ooppractice.domain.category.domain.Category;

import java.util.List;

@Getter
public class Item {

    private Long id;
    private String itemName;
    private SalesStatus salesStatus;
    private int stockQuantity;
    private List<Category> categoryList;

}
