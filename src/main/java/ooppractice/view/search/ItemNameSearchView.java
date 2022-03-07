package ooppractice.view.search;

import ooppractice.domain.item.domain.Item;
import ooppractice.domain.item.exception.ItemNotFoundException;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.exception.ErrorResponse;

import java.util.Scanner;

public class ItemNameSearchView extends AbstractView implements SearchView {

    private static final String ITEM_NAME_INPUT_MESSAGE = "[검색할 상품의 이름을 입력하세요]";

    public ItemNameSearchView(Scanner scanner) {
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
            String itemName = scanner.next();
            Item foundItem = itemService.getItemByItemName(itemName);
            setItemInfo(foundItem, sb);
            System.out.println(sb);
            clearSb();
        } catch (ItemNotFoundException e) {
            System.out.println(ErrorResponse.of(e.getErrorCode()));
        }
    }

    @Override
    protected void selectOption() {
    }

    @Override
    protected void showMessage() {
        System.out.println(ITEM_NAME_INPUT_MESSAGE);
    }
}
