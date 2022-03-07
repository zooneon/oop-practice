package ooppractice.view.mypage;

import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.domain.user.service.UserService;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.util.UserIdStorage;

import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class MyInfoView extends AbstractView {

    private static final String MY_GRADE = "내 등급";
    private static final String DEPOSITED_MONEY = "보유 금액";

    private UserService userService = AppConfig.getUserService();

    public MyInfoView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start() {
        showMessage();
    }

    @Override
    protected void selectOption() {
    }

    @Override
    protected void showMessage() {
        User loginUser = getLoginUser();
        printUserInfo(loginUser);
    }

    private void printUserInfo(User user) {
        sb.append(MY_GRADE).append(SEMICOLON).append(BLANK).append(user.getUserGrade().getGrade()).append(NEXT_LINE)
                .append(DEPOSITED_MONEY).append(SEMICOLON).append(BLANK).append(user.getDepositedMoney()).append(WON).append(NEXT_LINE)
                .append(BOUNDARY).append(NEXT_LINE);
        System.out.println(sb);
        clearSb();
    }

    private User getLoginUser() {
        Long userId = UserIdStorage.getId();
        try {
            return userService.getUserById(userId);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException(ErrorCode.LOGIN_USER_NOT_FOUND);
        }
    }
}
