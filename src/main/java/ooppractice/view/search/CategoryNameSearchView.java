package ooppractice.view.search;

import ooppractice.domain.category.exception.CategoryNotFoundException;
import ooppractice.domain.item.domain.Item;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.exception.ErrorResponse;

import java.util.List;
import java.util.Scanner;

public class CategoryNameSearchView extends AbstractView implements SearchView {

    private static final String CATEGORY_NAME_INPUT_MESSAGE = "[검색할 카테고리 이름을 입력하세요]";

    public CategoryNameSearchView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start() {
        search();
    }

    @Override
    public void search() {
        showMessage();
        try {
            String categoryName = scanner.next();
            List<Item> foundItemList = itemService.getItemListByCategory(categoryName);
            foundItemList.forEach(item -> {
                setItemInfo(item, sb);
            });
            System.out.println(sb);
            clearSb();
        } catch (CategoryNotFoundException e) {
            System.out.println(ErrorResponse.of(e.getErrorCode()));
        }
    }

    @Override
    protected void selectOption() {
    }

    @Override
    protected void showMessage() {
        System.out.println(CATEGORY_NAME_INPUT_MESSAGE);
    }
}
