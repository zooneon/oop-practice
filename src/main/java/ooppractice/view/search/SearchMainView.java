package ooppractice.view.search;

import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.view.exception.SelectionException;

import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class SearchMainView extends AbstractView {

    private static final String SEARCH_OPTION_INPUT_MESSAGE = "[검색 방법을 선택하세요]";
    private static final String ITEM_NAME = "상품 이름";
    private static final String CATEGORY_NAME = "카테고리 이름";
    private static final String QUIT = "나가기";

    public SearchMainView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start() {
        selectOption();
    }

    @Override
    protected void selectOption() {
        while (true) {
            showMessage();
            try {
                int userInput = scanner.nextInt();
                if (userInput == OPTION_ONE) {
                    AppConfig.getItemNameSearchView().start();
                } else if (userInput == OPTION_TWO) {
                    AppConfig.getCategoryNameSearchView().start();
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
