package ooppractice.global.util;

public class UserIdStorage {

    private static Long userId;

    private UserIdStorage() {
    }

    private void setUserId(Long userId) {
        this.userId = userId;
    }

    public static void saveId(Long userId) {
        UserIdStorage userStorage = new UserIdStorage();
        userStorage.setUserId(userId);
    }

    public static Long getId() {
        return userId;
    }
}
