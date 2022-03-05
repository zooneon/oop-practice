package ooppractice.view;

import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.service.UserService;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.global.util.UserStorage;
import ooppractice.view.exception.SelectionException;

import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class MypageView extends AbstractView {

    private static final String MY_GRADE = "내 등급";
    private static final String DEPOSITED_MONEY = "입금액";

    private UserService userService = AppConfig.getUserService();

    public MypageView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start() {
        showMessage();
    }

    @Override
    protected void showMessage() {
        User loginUser = getLoginUser();
        printUserInfo(loginUser);
    }

    private void printUserInfo(User user) {
        sb.append(MY_GRADE).append(SEMICOLON).append(BLANK).append(user.getUserGrade().getGrade()).append(NEXT_LINE)
                .append(DEPOSITED_MONEY).append(SEMICOLON).append(BLANK).append(user.getDepositedMoney());
        System.out.println(sb);
        clearSb();
    }

    private User getLoginUser() {
        User user = UserStorage.get();
        return userService.getUserById(user.getId());
    }
}
