package ooppractice.view;

import ooppractice.domain.category.domain.Category;
import ooppractice.domain.category.exception.CategoryNotFoundException;
import ooppractice.domain.item.domain.Item;
import ooppractice.domain.item.exception.ItemNotFoundException;
import ooppractice.domain.item.service.ItemService;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.view.exception.SelectionException;

import java.util.List;
import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class SearchView extends AbstractView {

    private static final String SEARCH_OPTION_INPUT_MESSAGE = "[검색 방법을 선택하세요]";
    private static final String CATEGORY_NAME_INPUT_MESSAGE = "[검색할 카테고리 이름을 입력하세요]";
    private static final String ITEM_NAME_INPUT_MESSAGE = "[검색할 상품의 이름을 입력하세요]";
    private static final String QUIT = "나가기";
    private static final String ITEM_NAME = "상품 이름";
    private static final String CATEGORY_NAME = "카테고리 이름";
    private static final String SALES_STATUS = "판매 상태";
    private static final String PRICE = "가격";
    private static final String STOCK_QUANTITY = "재고 수량";
    private static final String CATEGORY = "카테고리";

    private ItemService itemService = AppConfig.getItemService();

    public SearchView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start() {
        search();
    }

    private void search() {
        while (true) {
            showMessage();
            try {
                int userInput = scanner.nextInt();
                if (userInput == OPTION_ONE) {
                    searchByItemName();
                } else if (userInput == OPTION_TWO) {
                    searchByCategoryName();
                } else if (userInput == OPTION_THREE) {
                    break;
                } else {
                    throw new SelectionException(ErrorCode.INVALID_INPUT_VALUE);
                }
            } catch (SelectionException e) {
                System.out.println(ErrorResponse.of(e.getErrorCode()));
            }
        }
    }

    private void searchByCategoryName() {
        while (true) {
            System.out.println(CATEGORY_NAME_INPUT_MESSAGE);
            try {
                String categoryName = scanner.next();
                List<Item> foundItemList = itemService.getItemListByCategory(categoryName);
                foundItemList.forEach(item -> printItemInfo(item));
                break;
            } catch (CategoryNotFoundException e) {
                System.out.println(ErrorResponse.of(e.getErrorCode()));
            }
        }
    }

    private void searchByItemName() {
        while (true) {
            System.out.println(ITEM_NAME_INPUT_MESSAGE);
            try {
                String itemName = scanner.next();
                Item foundItem = itemService.getItemByItemName(itemName);
                printItemInfo(foundItem);
                break;
            } catch (ItemNotFoundException e) {
                System.out.println(ErrorResponse.of(e.getErrorCode()));
            }
        }
    }

    private void printItemInfo(Item item) {
        sb.append(ITEM_NAME).append(SEMICOLON).append(BLANK).append(item.getItemName()).append(NEXT_LINE)
                .append(SALES_STATUS).append(SEMICOLON).append(BLANK).append(item.getSalesStatus().getMessage()).append(NEXT_LINE)
                .append(PRICE).append(SEMICOLON).append(BLANK).append(item.getPrice()).append(WON).append(NEXT_LINE)
                .append(STOCK_QUANTITY).append(SEMICOLON).append(BLANK).append(item.getStockQuantity()).append(NEXT_LINE)
                .append(CATEGORY).append(SEMICOLON).append(BLANK).append(getCategoryNames(item.getCategoryList()));
        System.out.println(sb);
        clearSb();
    }

    private String getCategoryNames(List<Category> categoryList) {
        StringBuilder categorySb = new StringBuilder();
        categoryList.forEach(category -> categorySb.append(category.getCategoryName()).append(BLANK));
        String categoryNames = categorySb.toString();
        categorySb.delete(SB_START_INDEX, categorySb.length());
        return categoryNames;
    }

    @Override
    protected void showMessage() {
        sb.append(SEARCH_OPTION_INPUT_MESSAGE).append(NEXT_LINE)
                .append(OPTION_ONE).append(DOT).append(ITEM_NAME).append(BLANK)
                .append(OPTION_TWO).append(DOT).append(CATEGORY_NAME).append(BLANK)
                .append(OPTION_THREE).append(DOT).append(QUIT).append(BLANK);
        System.out.println(sb);
        clearSb();
    }
}
