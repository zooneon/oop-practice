package ooppractice.domain.category.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ooppractice.domain.item.domain.Item;
import ooppractice.global.common.repository.Entity;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends Entity {

    private Long id;
    private String categoryName;
    private List<Item> itemList;

    protected void setId(Long id) {
        this.id = id;
    }

    @Builder
    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.itemList = new ArrayList<>();
    }
}
