package ooppractice;

import ooppractice.domain.user.domain.User;

public class UserStorage {

    private static User user;

    private UserStorage() {
    }

    private void setUser(User user) {
        this.user = user;
    }

    public static void save(User user) {
        UserStorage userStorage = new UserStorage();
        userStorage.setUser(user);
    }

    public static User get() {
        return user;
    }
}
