package ooppractice.domain.item.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ooppractice.domain.category.domain.Category;
import ooppractice.global.common.repository.Entity;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends Entity {

    private Long id;
    private String itemName;
    private SalesStatus salesStatus;
    private int stockQuantity;
    private List<Category> categoryList;

    protected void setId(Long id) {
        this.id = id;
    }

    @Builder
    public Item(String itemName, int stockQuantity) {
        this.itemName = itemName;
        this.salesStatus = SalesStatus.ON_SALE;
        this.stockQuantity = stockQuantity;
        this.categoryList = new ArrayList<>();
    }

    public void reduceStockQuantity(int stockQuantity) {
        this.stockQuantity -= stockQuantity;
        if (this.stockQuantity <= 0) {
            this.salesStatus = SalesStatus.SOLD_OUT;
        }
    }

    public void addCategory(Category category) {
        this.categoryList.add(category);
    }
}
