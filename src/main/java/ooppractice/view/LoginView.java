package ooppractice.view;

import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.domain.user.exception.WrongPasswordException;
import ooppractice.domain.user.service.UserService;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.global.util.UserIdStorage;

import java.util.Scanner;

public class LoginView extends AbstractView {

    private static final String LOGIN_INPUT_MESSAGE = "[아이디와 비밀번호를 순서대로 입력하세요]";
    private static final String LOGIN_SUCCESS_MESSAGE = "[로그인 성공]";

    private final UserService userService;

    public LoginView(Scanner scanner, UserService userService) {
        super(scanner);
        this.userService = userService;
    }

    @Override
    public void start() {
        login();
    }

    private void login() {
        while (true) {
            showMessage();
            try {
                String username = scanner.next();
                String password = scanner.next();
                User loginUser = userService.login(username, password);
                System.out.println(LOGIN_SUCCESS_MESSAGE);
                UserIdStorage.saveId(loginUser.getId());
                break;
            } catch (UserNotFoundException | WrongPasswordException e) {
                System.out.println(ErrorResponse.of(e.getErrorCode()));
            }
        }
        AppConfig.getMainView().start();
    }

    @Override
    protected void selectOption() {
    }

    @Override
    protected void showMessage() {
        System.out.println(LOGIN_INPUT_MESSAGE);
    }
}
