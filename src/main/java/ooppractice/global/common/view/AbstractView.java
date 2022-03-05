package ooppractice.global.common.view;

import ooppractice.global.util.Constant;

import java.util.Scanner;

public abstract class AbstractView {

    protected final Scanner scanner;
    protected StringBuilder sb = new StringBuilder();

    public AbstractView(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void start();

    protected abstract void showMessage();

    protected void clearSb() {
        sb.delete(Constant.SB_START_INDEX, sb.length());
    }
}


