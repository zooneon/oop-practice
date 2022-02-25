package ooppractice.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.domain.UserGrade;

@Getter
public class UserResponse {

    private int depositedMoney;
    private UserGrade userGrade;

    @Builder
    public UserResponse(int depositedMoney, UserGrade userGrade) {
        this.depositedMoney = depositedMoney;
        this.userGrade = userGrade;
    }

    public static UserResponse of(final User user) {
        return UserResponse.builder()
                .depositedMoney(user.getDepositedMoney())
                .userGrade(user.getUserGrade())
                .build();
    }
}
