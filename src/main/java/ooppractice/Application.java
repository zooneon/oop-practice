package ooppractice;

import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.exception.ErrorResponse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE));
    }
}