package ooppractice.view.search;

import ooppractice.domain.item.domain.Item;

import static ooppractice.global.util.Constant.*;

public interface ISearchView {

    String ITEM_NAME = "상품 이름";
    String SALES_STATUS = "판매 상태";
    String PRICE = "가격";
    String STOCK_QUANTITY = "재고 수량";
    String CATEGORY = "카테고리";

    default void printItemInfo(Item item, StringBuilder sb) {
        sb.append(ITEM_NAME).append(SEMICOLON).append(BLANK).append(item.getItemName()).append(NEXT_LINE)
                .append(SALES_STATUS).append(SEMICOLON).append(BLANK).append(item.getSalesStatus().getMessage()).append(NEXT_LINE)
                .append(PRICE).append(SEMICOLON).append(BLANK).append(item.getPrice()).append(WON).append(NEXT_LINE)
                .append(STOCK_QUANTITY).append(SEMICOLON).append(BLANK).append(item.getStockQuantity()).append(NEXT_LINE)
                .append(CATEGORY).append(SEMICOLON).append(BLANK).append(getCategoryNames(item.getCategoryList()));
        System.out.println(sb);
    }
}
