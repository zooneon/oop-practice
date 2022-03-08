package ooppractice;

import ooppractice.global.config.AppConfig;
import ooppractice.global.util.DataInit;

public class Application {
    public static void main(String[] args) {
        AppConfig.configure();
        DataInit.init();
        AppConfig.getLoginView().start();
    }
}