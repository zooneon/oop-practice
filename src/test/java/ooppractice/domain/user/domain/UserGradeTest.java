package ooppractice.domain.user.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserGradeTest {

    @Test
    void calculateBenefit() {
        //given
        int amount = 10000;
        //when
        int ofSilver = UserGrade.SILVER.calculateBenefit(amount);
        int ofGold = UserGrade.GOLD.calculateBenefit(amount);
        int ofPlatinum = UserGrade.PLATINUM.calculateBenefit(amount);
        //then
        assertThat(ofSilver).isEqualTo(10300);  //SILVER 등급은 3%의 적립 혜택이 있다.
        assertThat(ofGold).isEqualTo(10500);  //GOLD 등급은 5%의 적립 혜택이 있다.
        assertThat(ofPlatinum).isEqualTo(11000);  //PLATINUM 등급은 10%의 적립 혜택이 있다.
    }
}