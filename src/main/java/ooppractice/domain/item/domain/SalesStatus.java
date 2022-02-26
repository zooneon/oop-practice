package ooppractice.domain.item.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SalesStatus {
    ON_SALE("판매중"),
    SOLD_OUT("매진");

    private final String message;
}
